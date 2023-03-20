package HomeWork05;
// Карта с каким-то размером nxm.

// На ней можно создать робов, указывая начальное положение.
// Если начальное положение некорректное ИЛИ эта позиция занята другим робом, то
// кидаем исключение.
// Робот имеет направление (вверх, вправо, вниз, влево). У роботов можно менять
// направление и передвигать их на 1 шаг вперед
// 2.
// Написать контроллер к этому коду, который будет выступать посредником между
// консолью (пользователем) и этой игрой.
// (0,0) ------------------ (0, m)
// ...
// (n, 0) ----------------------- (n, m)

// Robot, Map, Point

// Домашнее задание:
// Реализовать чтение команд с консоли и выполнить их в main методе
// Список команд:
// create-map 3 5 -- РЕАЛИЗОВАНО!
// create-robot 2 7
// move-robot id
// change-direction id LEFT
import java.util.Arrays;
import java.util.Scanner;

import HomeWork05.RobotMap.Direction;

public class Main {

    public static void main(String[] args) throws PositionException {
        System.out.print("\033[H\033[2J");
        Ui.startCommand(); // Подсказки для создания карты и роботов
        Scanner sc = new Scanner(System.in);
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
        // Команды для игры
        // stop : завершение игры.
        // robot-1-move : ход робота 1
        // robot-2-move : ход робота 2
        // robot-1-turn (top,right,left,bottom) : повернуть робота 1 в скобках указаны
        // варианты.
        // robot-2-turn (top,right,left,bottom) : повернуть робота 2 в скобках указаны
        // варианты.
        Ui.help(); // Запихиваем подсказки в отдельный метод

        while (true) {
            String command = sc.nextLine();
            if (command.startsWith("stop")) {
                sc.close();
                break;
            } else if (command.startsWith("robot-1-move")) {
                robot1.move();
                System.out.println(robot1.toString());
            } else if (command.startsWith("robot-1-turn")) {
                String[] split = command.split(" ");
                switch (split[1]) {
                    case "top":
                        robot1.changeDirection(Direction.TOP);
                        break;
                    case "right":
                        robot1.changeDirection(Direction.RIGHT);
                        break;
                    case "left":
                        robot1.changeDirection(Direction.LEFT);
                        break;
                    case "bottom":
                        robot1.changeDirection(Direction.BOTTOM);
                        break;
                    default:
                        System.out.println("Неправильно введено направление!");
                        break;
                }
                System.out.println(robot1.toString());
            } else if (command.startsWith("robot-2-move")) {
                robot2.move();
                System.out.println(robot2.toString());
            } else if (command.startsWith("robot-2-turn")) {
                String[] split = command.split(" ");
                switch (split[1]) {
                    case "top":
                        robot2.changeDirection(Direction.TOP);
                        break;
                    case "right":
                        robot2.changeDirection(Direction.RIGHT);
                        break;
                    case "left":
                        robot2.changeDirection(Direction.LEFT);
                        break;
                    case "bottom":
                        robot2.changeDirection(Direction.BOTTOM);
                        break;
                    default:
                        System.out.println("Неправильно введено направление!");
                        break;
                }
                System.out.println(robot2.toString());
            }

            else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
        }
    }
}