package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInputDto {

    private final String input;
    private String inputSeparator;
    private String inputNumber;

    UserInputDto() {
        this.input = Console.readLine();
    }

    public String getInput() {
        return input;
    }

    public String getInputSeparator() {
        return inputSeparator;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public void setInputSeparator(String inputSeparator) {
        this.inputSeparator = inputSeparator;
    }

}
