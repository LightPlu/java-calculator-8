package calculator.domain;

import calculator.validator.InputValidator;
import java.util.ArrayList;

public class Separator {
    String baseDelimiter = "[,:]";
    ArrayList<Long> result = new ArrayList<>();
    InputValidator inputValidator = new InputValidator();
    Calculator calculator = new Calculator();

    public long separateNumberWithCustom(String input) {
        inputValidator.validateInputWithStartCustom(input);

        String numberInclude = input.substring(5);
        String customDelimiter = input.substring(2, 3);

        baseDelimiter = baseDelimiter.substring(0, baseDelimiter.length() - 1) + customDelimiter + "]";
        String[] numbers = numberInclude.split(baseDelimiter);

        if (numbers[0].isEmpty()) { // 입력값에 구분자는 존재하지만 숫자 부분이 ""로 들어왔을때 calculator.sum의 반환을 0으로 강제
            return 0;
        }

        for (String number : numbers) {
            result.add(Long.parseLong(number));
        }

        return calculator.sum(result);
    }

    public long separateNumberNoCustom(String input) {
        inputValidator.validateInputNotStartCustom(input);
        String[] numbers = input.split(baseDelimiter);

        if (numbers[0].isEmpty()) { // 입력값이 ""로 들어왔을때 calculator.sum의 반환을 0으로 강제
            return 0;
        }

        for (String number : numbers) {
            result.add(Long.parseLong(number));
        }

        return calculator.sum(result);
    }

}
