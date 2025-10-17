package calculator;

public class InputValidator {

    public void validateInputWithStartCustom(String input) {
        validateCustomForm(input);
        validateTypeOfNumber(input.substring(5), extractCustomDelimiter(input));
        validateDelimiterCount(input.substring(5), extractCustomDelimiter(input));
    }

    public void validateInputNotStartCustom(String input) {
        validateTypeOfNumber(input, null);
        validateDelimiterCount(input, null);
    }

    public String extractCustomDelimiter(String input) {
        return input.substring(2, 3);
    }

    public void validateCustomForm(String input) {
        if (input.length() < 5) {
            throw new IllegalArgumentException();    // 커스텀 구분자를 표시하는 문자열이 5보다 작다면 에러 발생
        }

        String delimiterInclude = input.substring(0, 5);
        String customDelimiter = input.substring(2, 3);

        if (!delimiterInclude.startsWith("//")) {
            throw new IllegalArgumentException();
        }

        if (!delimiterInclude.endsWith("\\n")) {
            throw new IllegalArgumentException();
        }

        if (customDelimiter.matches("[0-9a-zA-Z]")) {    //숫자 혹은 문자가 온다면 에러 발생
            throw new IllegalArgumentException();
        }

    }

    public void validateTypeOfNumber(String input, String customDelimiter) {
        String baseDelimiter = "[,:]";

        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            baseDelimiter = baseDelimiter.substring(0, baseDelimiter.length() - 1) + customDelimiter + "]";
        }

        String[] numbers = input.split(baseDelimiter);

        if (numbers[0].isEmpty()) {
            throw new IllegalArgumentException(); // 만약 숫자 부분 문자열이 숫자가 아닌 구분자로 바로 시작한다면 에러 발생(구분자로 시작하면 numbers 첫번째 값이 비어있기 때문)
        }

        try {
            for (String number : numbers) {
                int parsingNumber = Integer.parseInt(number); // 구분자로 분리했을 때 해당 문자열이 숫자가 아니라면 에러 발생
                if (parsingNumber < 0) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    public void validateDelimiterCount(String input, String customDelimiter) {
        String baseDelimiter = "[,:]";
        long customCount = 0;
        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            baseDelimiter = baseDelimiter.substring(0, baseDelimiter.length() - 1) + customDelimiter + "]";
        }
        String[] numbers = input.split(baseDelimiter);
        long commaCount = input.chars().filter(ch -> ch == ',').count();
        long colonCount = input.chars().filter(ch -> ch == ':').count();
        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            customCount = input.chars().filter(ch -> ch == customDelimiter.charAt(0)).count();
        }

        if (numbers[0].isEmpty()) {
            throw new IllegalArgumentException(); // 만약 숫자 부분 문자열이 숫자가 아닌 구분자로 바로 시작한다면 에러 발생(구분자로 시작하면 numbers 첫번째 값이 비어있기 때문)
        }

        if (numbers.length != (colonCount + commaCount + customCount + 1)) {        // 구분자가 동시에 2개이상 왔을 때 에러 발생
            throw new IllegalArgumentException();
        }
    }

}
