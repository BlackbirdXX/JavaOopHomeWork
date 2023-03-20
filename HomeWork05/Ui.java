package HomeWork05;


public class Ui {
    public static void help(){
        System.out.println(""" 
        Команды для игры
        stop          : завершение игры.
        robot-1-move  : ход робота 1
        robot-2-move  : ход робота 2
        robot-1-turn (top,right,left,bottom)  : повернуть робота 1 в скобках указаны варианты.
        robot-2-turn (top,right,left,bottom)  : повернуть робота 2 в скобках указаны варианты.\n""");
    }

    public static void startCommand() {
        System.out.println(""" 
        Команды для старта игры
        create-map x y   : Создание поля карты, где x и y необходимо наменить на числа.
        create-robot x y : Создание робота, x и y это координаты точки на которой появится робот. Их необходимо заменить на числа.\n""");
    }
}
