package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderMaker {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

    public List<Line> make(int personCount, int height) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount, booleanGenerator));
        }
        return Collections.unmodifiableList(lines);
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }
}