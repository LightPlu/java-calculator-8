package calculator;

import java.util.ArrayList;

public class Separator {
    String baseDelimiter = "[.,]";
    ArrayList<Integer> result = new ArrayList<>();
    InputValidate inputValidate = new InputValidate();
    Calculator calculator = new Calculator();

    public int separateNumberWithCustom(String input) {
        inputValidate.validateInputWithStartCustom(input);

        String numberInclude = input.substring(5);
        String customDelimiter = input.substring(2, 3);

        baseDelimiter = baseDelimiter.substring(0, baseDelimiter.length() - 1) + customDelimiter + "]";
        String[] numbers = numberInclude.split(baseDelimiter);

        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }

        return calculator.sum(result);
    }

    public int separateNumberNoCustom(String input) {
        inputValidate.validateInputNotStartCustom(input);
        String[] numbers = input.split(baseDelimiter);

        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }

        return calculator.sum(result);
    }

}
