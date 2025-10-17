package calculator;

public class CalculatorController {

    Separator separator;

    public int CalculatorControl(String input) {
        separator = new Separator();
        if (input.startsWith("/")) {
            return separator.separateNumberWithCustom(input);
        }
        return separator.separateNumberNoCustom(input);
    }

}
