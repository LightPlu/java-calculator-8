package calculator.domain;

import java.util.ArrayList;

public class Calculator {

    public long sum(ArrayList<Long> numbers) {
        long result = 0;

        for (Long number : numbers) {
            result += number;
        }

        if (result < 0) {
            throw new IllegalArgumentException("오버플로우가 발생하였습니다.");
        }

        return result;
    }
}
