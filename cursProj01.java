
import java.util.Scanner;


public class cursProj01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            drawMainMenu();
            System.out.print(getShift() + "Make you choice: ");
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
                case "4":
                    calcSumDate();
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

        System.out.printf("%n");
        promptExit();
        System.out.printf("%n%n");
    }

    private static void calcSumDigits() {
        Scanner scanner = new Scanner(System.in);
        String command, promt = getShift() + "Enter an integer number ";
        clearConsol();
        promptExit();

        do {
            System.out.print(promt);
            command = scanner.nextLine();
            command = command.trim();
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
                    promptWrongInput(command);
                    //System.out.println(promt);
                }
            }

        } while (!command.equals("q"));

    }
    private static void inverseDigits() {
        Scanner scanner = new Scanner(System.in);
        String command, promt = getShift() + "Enter an integer number ";
        clearConsol();
        promptExit();

        do {
            System.out.print(promt);
            command = scanner.next();
            command = command.trim();
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
                    promptWrongInput(command);
                    //System.out.println(promt);
                }
            }
        } while (!command.equals("q"));

    }
    private static void calcNameDigit() {
        Scanner scanner = new Scanner(System.in);
        String command, promt = getShift() + "Enter a name. (english only, letters only)  ";
        clearConsol();
        promptExit();


        do {
            System.out.print(promt);
            command = scanner.next();
            command = command.trim();
            if (!command.equals("q") || isAlfabet(command)) {
                int sum = 0;
                for (int i = 0; i < command.length(); i++) {
                    sum += returnNumberOfLettter(command.charAt(i));
                }
                System.out.println(getShift() + "the name number = " + sum);
            } else {
                if (!command.equals("q")) {
                    clearConsol();
                    promptExit();
                    promptWrongInput(command);
                    //System.out.println(promt);
                }
            }

        } while (!command.equals("q"));

    }
    private static void calcSumDate() {
        Scanner scanner = new Scanner(System.in);
        String command, promt = getShift() + "Enter an date, format dd/mm/yyyy   ";
        clearConsol();
        promptExit();

        do {
            System.out.print(promt);
            command = scanner.nextLine();
            command = command.trim();
            if (isDate(command)) {
                int sum = 0;
                for (int i = 0; i < command.length(); i++) {
                    if (command.charAt(i)=='/') continue;
                    sum += Integer.parseInt(String.valueOf(command.charAt(i)));
                }
                System.out.println(getShift() + "the sum of the digits of a date = " + sum);

            } else {
                if (!command.equals("q")) {
                    clearConsol();
                    promptExit();
                    promptWrongInput(command);
                    //System.out.println(promt);
                }
            }

        } while (!command.equals("q"));

    }



    private static int returnNumberOfLettter(char letter) {
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

    private static boolean isAlfabet(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                return false;
            }
        }
        return true;
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

    private static boolean isDate(String str) {
        if (str.length() > 10) return false;

        int posSl1 = -1, posSl2 = -1;
        for (int i = 0; i < str.length(); i++) {
            if (!(Character.isDigit(str.charAt(i)) || str.charAt(i) == '/')) {
                return false;
            }
            if (str.charAt(i) == '/') {
                if (posSl2 > 0) return false;
                if (posSl1 > 0) posSl2 = i;
                else posSl1 = i;
            } ;
        }
        if (posSl1<0 || posSl2 < 0) return false;
        String strD=str.substring(0,posSl1);
        String strM=str.substring(posSl1+1,posSl2);
        String strY=str.substring(posSl2+1);

//        System.out.println(strD);
//        System.out.println(strM);
//        System.out.println(strY);

        if (strY.isEmpty()) return false;

        if ((Integer.parseInt(strD) > 31)) return false;
        if ((Integer.parseInt(strM) > 12)) return false;

        switch (strM) {
            case "04", "06", "09", "4", "6", "9", "11" -> {
                if (!(Integer.parseInt(strD) <= 30)) return false;
            }
            case "2", "02" -> {
                if (!(Integer.parseInt(strD) <= 29)) return false;
                if (Integer.parseInt(strD) == 29 && Integer.parseInt(strY) % 4 != 0) return false;
            }
        }
        return true;
    }


    private static void clearConsol() {
        System.out.print("\033[H\033[J");
    }
    private static void promptExit() {
        System.out.println(getShift() + "q.  Exit ");
    }
    private static void promptWrongInput(String str) {
        System.out.println(getShift()+"  " +str+ " is wrong input! ");
    }
    private static String getShift() {
        return "    ";
    }
}
