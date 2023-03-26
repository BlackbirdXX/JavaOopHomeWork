package HomeWork06;

public class HelpHandler implements CommandHandler {
    @Override
    public String commandName() {
        return "help";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        System.out.println("""
                Команды для игры
                stop          : завершение игры.
                help          : список команд.
                robot-move id(робота) : ход робота
                robot-turn id(робота) (TOP, RIGHT, LEFT, BOTTOM)  : повернуть робота в скобках указаны варианты.\n""");
    }
}
