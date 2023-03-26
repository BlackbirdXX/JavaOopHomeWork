package HomeWork06;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws PositionException {
        System.out.print("\033[H\033[2J");
        Ui.startCommand(); // Подсказки для создания карты и роботов
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите команду для создания карты:");
            RobotMap map = null;
            RobotMap.Robot robot1 = null;
            RobotMap.Robot robot2 = null;
            // Создаем карту
            while (true) {
                String command = sc.nextLine();
                if (command.startsWith("create-map")) {
                    String[] split = command.split(" ");
                    String[] arguments = Arrays.copyOfRange(split, 1, split.length);

                    try {
                        map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                                " Попробуйте еще раз");
                    }
                } else {
                    System.out.println("Команда не найдена. Попробуйте еще раз");
                }
            }
            // Создаем первого робота
            System.out.println("Введите команду для создания Первого робота:");
            while (true) {
                String command = sc.nextLine();
                if (command.startsWith("create-robot")) {
                    String[] split = command.split(" ");
                    String[] arguments = Arrays.copyOfRange(split, 1, split.length);

                    try {
                        robot1 = map.createRobot(new Point(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("При создании робота возникло исключение: " + e.getMessage() + "." +
                                " Попробуйте еще раз");
                    }
                } else {
                    System.out.println("Команда не найдена. Попробуйте еще раз");
                }
            }
            // Создаем второго робота
            System.out.println("Введите команду для создания Второго робота:");
            while (true) {
                String command = sc.nextLine();
                if (command.startsWith("create-robot")) {
                    String[] split = command.split(" ");
                    String[] arguments = Arrays.copyOfRange(split, 1, split.length);

                    try {
                        robot2 = map.createRobot(new Point(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("При создании робота возникло исключение: " + e.getMessage() + "." +
                                " Попробуйте еще раз");
                    }
                } else {
                    System.out.println("Команда не найдена. Попробуйте еще раз");
                }
            }
            System.out.println(robot1.toString());
            System.out.println(robot2.toString());
            System.out.println("ИГРАЕМ...");
            
            Ui.help(); // Запихиваем подсказки в отдельный метод

            List<CommandHandler> handlers = List.of(
                    new ChangeDirectionCommandHandler(), new MoveHandler(), new HelpHandler(), new StopHandler()
            );
            CommandManager commandManager = new CommandManager(map, handlers);

            while (true) {
                String command = sc.nextLine();
                
                commandManager.handleCommand(command);
            }
        }
        
    }
}