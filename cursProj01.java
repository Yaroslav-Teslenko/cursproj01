import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class cursProj01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            drawMainMenu();
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    calcSumDigits();
                    break;
                case "2":
                    inverseDigits();
                    break;
                case "3":
                    calcNameDigit();
                    break;
            }
            ;

        } while (!command.equals("q"));
    }

    public static void drawMainMenu() {
        clearConsol();
        //String shift="    ";
        System.out.printf("%n%n");
        System.out.printf("%n%n");
        System.out.println(getShift() + "1. Calculate the sum of the digits of a number");
        System.out.println(getShift() + "2. Write the digits of a number in reverse order");
        System.out.println(getShift() + "3. Calculate the name number");
        System.out.println(getShift() + "4. Calculate the number of digits of a date");

        System.out.printf("%n%n");
        promptExit();
        System.out.printf("%n%n");
    }

    private static void clearConsol() {
        System.out.print("\033[H\033[J");
    }

    ;

    private static void calcSumDigits() {
        Scanner scanner = new Scanner(System.in);
        String command, promt = getShift() + "Enter an integer number";
        clearConsol();
        promptExit();

        do {
            System.out.println(promt);
            command = scanner.nextLine();
            command=command.trim();
            if (isInteger(command)) {
                int z = Integer.parseInt(command);
                z = z > 0 ? z : -1 * z;
                int sum = 0;
                while (z != 0) {
                    sum += z % 10;
                    z = z / 10;
                }
                System.out.println(getShift() + "the sum of the digits of a number = " + sum);

            } else {
                if (!command.equals("q")) {
                clearConsol();
                promptExit();
                System.out.println(promt);
                }
            }

        } while (!command.equals("q"));

    }

    private static void inverseDigits() {
        Scanner scanner = new Scanner(System.in);
        String command, promt = getShift() + "Enter an integer number ";
        clearConsol();
        promptExit();
        System.out.println(promt);
        do {
            command = scanner.next();
            command=command.trim();
            if (isInteger(command)) {
                int z = Integer.parseInt(command);
                z = z > 0 ? z : -1 * z;
                int inv = 0;
                while (z > 0) {
                    int digit = z % 10;
                    z = z / 10;
                    inv = inv * 10 + digit;
                }
                System.out.println(getShift() + "the digits of a number in reverse order =" + inv);
            } else {
                if (!command.equals("q")) {
                    clearConsol();
                    promptExit();
                    System.out.println(promt);
                }
            }
        } while (!command.equals("q"));

    }


    private static void calcNameDigit() {
        Scanner scanner = new Scanner(System.in);
        String command, promt = getShift() + "Enter a name. (english only)";
        clearConsol();
        promptExit();
        System.out.println(promt);

        do {
            command = scanner.next();
            command=command.trim();
            if (!command.equals("q") || isAlfabet(command)) {
                int sum = 0;
                for (int i = 0; i < command.length(); i++) {
                    sum += calcNameDigit(command.charAt(i));
                }
                System.out.println(getShift() + "the name number = " + sum);
            } else {
                if (!command.equals("q")) {
                    clearConsol();
                    promptExit();
                    System.out.println(promt);
                }
            }

        } while (!command.equals("q"));

    }
    private static boolean isInteger(String s) {
        if (s == null || s.isEmpty()) return false;
        //проверяем на минус (s.charAt(0) == '-') ? 1 : 0
        for (int i = (s.charAt(0) == '-') ? 1 : 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAlfabet(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void promptExit() {
        System.out.println(getShift() + "q.  Exit ");
    }

    private static int calcNameDigit(char letter) {
        char[] arrLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int number = 0;
        letter = Character.toLowerCase(letter);
        for (int i = 0; i < arrLetters.length; i++) {
            if (letter == arrLetters[i]) {
                number = i + 1;
                //System.out.println(arrLetters[i]+" = "+number);
                break;
            }
        }
        return number;
    }

    private static String getShift() {
        return "    ";
    }

    public static void tm() {
        for (int i = 0; i < 3; i++) {
            // Ваш код
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
