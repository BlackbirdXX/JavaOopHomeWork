package HomeWork06;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RobotMap {

    private final int n;
    private final int m;

    private final Map<UUID, Robot> robots;

    public RobotMap(int n, int m) {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException("Недопустимые значения размера карты!");
        }
        this.n = n;
        this.m = m;
        this.robots = new HashMap<>();
    }

    public Robot createRobot(Point position) {
        if (checkPosition(position)) {
            Robot robot = new Robot(position);
            robots.put(robot.id, robot);
            return robot;
        } else {
            Robot robot = new Robot(searchFreePosition());
            robots.put(robot.id, robot);
            System.out.println(
                    "Была указана не корректная точка. Робот был установлен в первую своботную точку в пределах карты.");
            return robot;
        }
    }
    public Robot findRobotById(UUID id) {
        return robots.get(id);
    }

    private boolean checkPosition(Point position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > n || position.getY() > m) {
            return false;
        }
        if (!isFree(position)) {
            return false;
        } else
            return true;
    }

    private boolean isFree(Point position) {
        return robots.values().stream()
                .map(Robot::getPosition)
                .noneMatch(position::equals);
    }

    private Point searchFreePosition() {
        Point freePosition = new Point(0, 0);
        int count = 0;
        while (!isFree(freePosition)) {
            freePosition.setX(count++);
        }
        return freePosition;
    }

    public class Robot {

        private final UUID id;
        private Point position;
        private Direction direction;

        public Robot(Point position) {
            this.id = UUID.randomUUID();
            this.position = position;
            this.direction = Direction.TOP;
        }

        public UUID getId() {
            return id;
        }

        public Point getPosition() {
            return position;
        }

        public void move() throws PositionException {
            Point newPosition = switch (direction) {
                case TOP -> new Point(position.getX() - 1, position.getY());
                case RIGHT -> new Point(position.getX(), position.getY() + 1);
                case BOTTOM -> new Point(position.getX() + 1, position.getY());
                case LEFT -> new Point(position.getX(), position.getY() - 1);
            };
            if (checkPosition(newPosition)) {
                position = newPosition;
            } else {
                System.out.println("Ход не возможен. Робот упираеется в стену или другого робота");
            }
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        @Override
        public String toString() {
            return String.format("[%s] Позиция : %s Направление : %s", id.toString(), position.toString(),
                    direction.toString());
        }
    }

    public enum Direction {
        TOP, RIGHT, BOTTOM, LEFT
    }
}