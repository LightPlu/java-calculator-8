package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Separator {

    private static final String customSeparatorPrefix = "//";
    private static final String customSeparatorSuffix = "\n";
    ArrayList<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

    public void splitSeparatorAndNumber(UserInputDto userInputDto) {
        String input = userInputDto.getInput();
        if (input.startsWith(customSeparatorPrefix)) {
            userInputDto.setInputSeparator(input.substring(0, 5));
            userInputDto.setInputNumber(input.substring(5));
        }

        if (!input.startsWith(customSeparatorPrefix)) {
            userInputDto.setInputNumber(input);
        }

    }

    public ArrayList<String> getSeparators(String inputSeparator) {
        separators.add(inputSeparator.substring(2, 3));
        return separators;
    }

}
