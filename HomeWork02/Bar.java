package HomeWork02;

import java.util.Random;

public interface Bar {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_ORANGE = "\033[38;2;255;165;0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    default void StatusBar(int hp, int maxHp) {

        float maxHpf = maxHp;
        float percentage = hp / (maxHpf / 100);
        int percentageInt = (int) percentage;
        int points = percentageInt / 5;
        if (75 < percentageInt & percentageInt <= 100) {
            for (int i = 0; i < points; i++) {
                System.out.print(ANSI_GREEN + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - points; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        } else if (50 < percentageInt & percentageInt <= 75) {
            for (int i = 0; i < points; i++) {
                System.out.print(ANSI_YELLOW + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - points; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        } else if (25 < percentageInt & percentageInt <= 50) {
            for (int i = 0; i < points; i++) {
                System.out.print(ANSI_ORANGE + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - points; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        } else if (5 <= percentageInt & percentageInt <= 25) {
            for (int i = 0; i < points; i++) {
                System.out.print(ANSI_RED + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - points; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        } else if (0 < percentageInt & percentageInt < 5) {
            for (int i = 0; i < points + 1; i++) {
                System.out.print(ANSI_RED + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - points - 1; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        } else {
            for (int i = 0; i < 20; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        }
        System.out.println();
    }

    default void ResursBar(int resurs, int maxResurs) {
        float maxResursf = maxResurs;
        float resPercentage = resurs / (maxResursf / 100);
        int ResPercentageInt = (int) resPercentage;
        int resPoints = ResPercentageInt / 5;

        if (15 < ResPercentageInt & ResPercentageInt <= 100) {
            for (int i = 0; i < resPoints; i++) {
                System.out.print(ANSI_BLUE + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - resPoints; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        } else if (5 < ResPercentageInt & ResPercentageInt <= 15) {
            for (int i = 0; i < resPoints; i++) {
                System.out.print(ANSI_RED + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - resPoints; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        } else if (0 < ResPercentageInt & ResPercentageInt < 5) {
            for (int i = 0; i < resPoints + 1; i++) {
                System.out.print(ANSI_RED + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - resPoints - 1; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        } else {
            for (int i = 0; i < 20; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        }
        System.out.println();
    }

    default void ShieldBar(int shield, int maxShield) {
        float maxResursf = maxShield;
        float resPercentage = shield / (maxResursf / 100);
        int ResPercentageInt = (int) resPercentage;
        int shieldPoints = ResPercentageInt / 5;

        if (shield > 0){
            for (int i = 0; i < shieldPoints; i++) {
                System.out.print(ANSI_CYAN + (char) 4 + ANSI_RESET);
            }
            for (int i = 0; i < 20 - shieldPoints; i++) {
                System.out.print(ANSI_BLACK + (char) 4 + ANSI_RESET);
            }
        System.out.println();
        }
        else System.out.println(ANSI_RED_BACKGROUND + "Щиты Темной башни рассеяны." + ANSI_RESET);
    }

    default int GenerateDamage(int min, int max) {
        int damage;
        Random d = new Random();
        damage = d.nextInt(min, max);
        return damage;
    }

    void Flask();
}