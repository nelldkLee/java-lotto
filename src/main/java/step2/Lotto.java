package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final String VALID_LOTTO_COUNT_MSG = "당첨 번호 6개를 입력해주세요.";
    private static final String COMMA = ",";
    private static final int LOTTO_COUNT = 6;
    private List<Ball> balls = new ArrayList<>();

    public Lotto(List<Ball> numbers) {
        for (Ball number : numbers) {
            balls.add(new Ball(number));
        }
    }

    public Lotto(String numbers) {
        String[] values = numbers.split(COMMA);
        if (values.length != LOTTO_COUNT) {
            throw new IllegalArgumentException(VALID_LOTTO_COUNT_MSG);
        }
        for (String value : values) {
            balls.add(new Ball(value));
        }
    }

    public int getMatchCount(Lotto targetLotto) {
        int matchCount = 0;
        for (Ball ball : targetLotto.balls) {
            matchCount = calcMatchCount(matchCount, ball);
        }
        return matchCount;
    }

    private int calcMatchCount(int matchCount, Ball ball) {
        if (balls.contains(ball)) {
            matchCount++;
        }
        return matchCount;
    }

    @Override
    public String toString() {
        Collections.sort(balls);
        return balls.toString();
    }
}
