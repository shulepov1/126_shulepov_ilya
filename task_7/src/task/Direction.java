package task;

public enum Direction {
    North(0, -1) ,
    West(-1, 0),
    South(0, 1),
    East(1, 0);

    private int xPoints;
    private int yPoints;

    Direction(int xPoints, int yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public Vector2 move(Vector2 start, double distance) {
        return new Vector2(start.getX() + (distance * xPoints), start.getY() + (distance * yPoints));
    }
}
