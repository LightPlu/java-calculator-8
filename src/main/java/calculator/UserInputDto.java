package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInputDto {

    private final String input;

    UserInputDto() {
        this.input = Console.readLine();
    }

    public String getInput() {
        return input;
    }
}
