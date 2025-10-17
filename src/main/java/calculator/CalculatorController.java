package calculator;

public class CalculatorController {

    Separator separator;

    public void CalculatorControl(String input) {
        separator = new Separator();
        if (input.startsWith("/")) {
            separator.separateNumberWithCustom(input);
        }
        if (!input.startsWith("/")) {
            separator.separateNumberNoCustom(input);
        }
    }

}
