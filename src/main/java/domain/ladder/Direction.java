package domain.ladder;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    STRAIGHT(0);

    private final int movement;

    Direction(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }
}
