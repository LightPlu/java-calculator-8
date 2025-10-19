package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.UserInputDto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        CalculatorController CalculatorController = new CalculatorController();
        UserInputDto userinputDto = new UserInputDto();
        long result;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        userinputDto.setInput(Console.readLine());
        result = CalculatorController.CalculatorControl(userinputDto.getInput());

        System.out.println("결과 : " + result);
    }
}
