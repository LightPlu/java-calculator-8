package calculator.validator;

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
        // 커스텀 구분자를 표시하는 문자열이 5보다 작다면 에러 발생
        if (input.length() < 5) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String delimiterInclude = input.substring(0, 5);
        String customDelimiter = input.substring(2, 3);

        if (!delimiterInclude.startsWith("//")) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        if (!delimiterInclude.endsWith("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        // 숫자 혹은 문자가 온다면 에러 발생
        if (customDelimiter.matches("[0-9a-zA-Z]")) {
            throw new IllegalArgumentException("커스텀 구분자에는 숫자 혹은 문자가 올 수 없습니다");
        }

    }

    public void validateTypeOfNumber(String input, String customDelimiter) {
        String baseDelimiter = "[,:]";

        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            baseDelimiter = baseDelimiter.substring(0, baseDelimiter.length() - 1) + customDelimiter + "]";
        }

        if (input.isEmpty()) {
            return;
        }

        String[] numbers = input.split(baseDelimiter);

        // 만약 숫자 부분 문자열이 숫자가 아닌 구분자로 바로 시작한다면 에러 발생
        // (구분자로 시작하면 numbers 첫번째 값이 비어있기 때문)
        if (numbers[0].isEmpty()) {
            throw new IllegalArgumentException("숫자 부분에는 구분자가 먼저 올 수 없습니다.");
        }

        try {
            for (String number : numbers) {
                // 구분자로 분리했을 때 해당 문자열이 숫자가 아니라면 에러 발생
                long parsingNumber = Long.parseLong(number);
                if (parsingNumber < 0) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 부분에는 숫자를 제외한 값이 올 수 없습니다.");
        }

    }

    public void validateDelimiterCount(String input, String customDelimiter) {
        String baseDelimiter = "[,:]";
        long customCount = 0;

        if (input == null || input.isEmpty()) {
            return;
        }

        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            baseDelimiter = baseDelimiter.substring(0, baseDelimiter.length() - 1) + customDelimiter + "]";
        }

        String[] numbers = input.split(baseDelimiter);

        long commaCount = input.chars().filter(ch -> ch == ',').count();
        long colonCount = input.chars().filter(ch -> ch == ':').count();
        if (customDelimiter != null && !customDelimiter.isEmpty() && !customDelimiter.equals(",")
                && !customDelimiter.equals(":")) {
            customCount = input.chars().filter(ch -> ch == customDelimiter.charAt(0)).count();
        }

        // 만약 숫자 부분 문자열이 숫자가 아닌 구분자로 바로 시작한다면 에러 발생
        // (구분자로 시작하면 numbers 첫번째 값이 비어있기 때문)
        if (numbers[0].isEmpty()) {
            throw new IllegalArgumentException("숫자 부분에는 구분자가 먼저 올 수 없습니다.");
        }

        // 구분자가 동시에 2개이상 왔을 때 에러 발생
        if (numbers.length != (colonCount + commaCount + customCount + 1)) {
            throw new IllegalArgumentException("구분자를 1개씩 사용하여 숫자를 구분해주십시오.");
        }
    }

}
