package HomeWork06;


public class Ui {
    public static void help(){
        System.out.println(""" 
        Команды для игры
        stop          : завершение игры.
        help          : список команд.
        robot-move id(робота) : ход робота 
        robot-turn id(робота) (TOP, RIGHT, LEFT, BOTTOM)  : повернуть робота в скобках указаны варианты.\n""");
    }

    public static void startCommand() {
        System.out.println(""" 
        Команды для старта игры
        create-map x y   : Создание поля карты, где x и y необходимо наменить на числа.
        create-robot x y : Создание робота, x и y это координаты точки на которой появится робот. Их необходимо заменить на числа.\n""");
    }
}
