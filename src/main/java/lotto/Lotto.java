package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private final static int RANGE_MIN = 1;
    private final static int RANGE_MAX = 45;

    private final static int FIRST_PLACE_MATCHES = 6;
    private final static int SECOND_THIRD_PLACE_MATCHES = 5;
    private final static int FOURTH_PLACE_MATCHES = 4;
    private final static int FIFTH_PLACE_MATCHES = 3;

    private final static int FIRST_PRIZE = 2000000000;
    private final static int SECOND_PRIZE = 30000000;
    private final static int THIRD_PRIZE = 1500000;
    private final static int FOURTH_PRIZE = 50000;
    private final static int FIFTH_PRIZE = 5000;

    private final static int PRICE_PER_LOTTERY = 1000;

    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private final static String EXCEPTION_ONE = "로또 번호는 1부터 45사이의 숫자여야 합니다.";
    private final static String EXCETPION_THREE = "당첨 번호는 쉼표로 구분된 서로 다른 6개의 숫자들이여야 합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateRedundancy(numbers);

    }

    private static void validateNumberRange(List<Integer> numbers) { // 예외 사항 1-1: 입력된 당첨 번호가 로또 번호 범위 바깥의 값일 경우
        for (Integer number: numbers) {
            if (number < RANGE_MIN || number > RANGE_MAX) {
                throw new IllegalArgumentException(EXCEPTION_HEADER + EXCEPTION_ONE);
            }
        }
    }

    /* This belongs to Application layer
    private final static String EXCEPTION_TWO = "구입금액은 1000으로 나누어 떨어지는 숫자여야 합니다.";
    private static void validateBudget(List<Integer> numbers) { // 예외 사항 2: 입력된 구입 금액이 1000으로 나누어 떨어지지 않을 경우
        int budget = numbers.get(0);

        if (budget % PRICE_PER_LOTTERY != 0) {
            throw new IllegalArgumentException(EXCEPTION_HEADER + EXCEPTION_TWO);
        }
    }
    */

    private static void validateSize(List<Integer> numbers) { // 예외 사항 3-1: 입력된 당첨 번호의 개수가 6개 아닐 경우
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(EXCEPTION_HEADER + EXCETPION_THREE);
        }
    }

    private static void validateRedundancy(List<Integer> numbers) { // 예외 사항 3-2: 입력된 당첨 번호가 중복 됐을 경우
        for (int i=0; i<numbers.size()-1; i++) {
            if (numbers.get(i) == numbers.get(i+1)) {
                throw new IllegalArgumentException(EXCEPTION_HEADER + EXCETPION_THREE);
            }
        }
    }
}
