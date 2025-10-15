package calculator;

import java.util.Scanner;

public class UserInputDto {

    private final String input;
    private String inputSeparator;
    private String inputNumber;

    Scanner scanner = new Scanner(System.in);

    UserInputDto() {
        this.input = scanner.nextLine();
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
