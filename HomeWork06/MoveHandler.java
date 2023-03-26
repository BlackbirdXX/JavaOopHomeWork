package HomeWork06;

import java.util.UUID;

public class MoveHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "robot-move";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        UUID robotId = UUID.fromString(args[0]);

        RobotMap.Robot robotById = map.findRobotById(robotId);
        if (robotById != null) {
            try {
                robotById.move();
            } catch (PositionException e) {
                System.out.println("Робот уперся в стену или другого робота");
                e.printStackTrace();
            }
            System.out.println(robotById.toString()); 
        } else {
            System.out.println("Робот с идентификаторо " + robotId + " не найден");
        }
    }
    
}
