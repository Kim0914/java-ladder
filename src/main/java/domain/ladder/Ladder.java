package domain.ladder;

import domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final String HEIGHT_ERROR_MESSAGE = "사다리 높이는 1이상 100이하의 자연수만 가능합니다.";
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final List<Line> lines;

    public Ladder(int personCount, int height, BooleanGenerator booleanGenerator) {
        this.lines = createLadder(personCount, height, booleanGenerator);
    }

    private List<Line> createLadder(int personCount, int height, BooleanGenerator booleanGenerator) {
        validateHeight(height);
        List<Line> createdLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            createdLines.add(new Line(personCount, booleanGenerator));
        }
        return createdLines;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
