package HomeWork06;

public class StopHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "stop";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        System.exit(0);
    
}
}