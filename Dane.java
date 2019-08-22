package MojProgram;

import java.util.Scanner;

public class Dane {

    private Scanner scanner;

    public Dane() {
    }

    public String miasto(){
        scanner = new Scanner(System.in);
        System.out.println("Podaj miasto z którego chcesz pobrać pogodę");
        return scanner.next();
    }

    public int liczbaDni() {
        scanner.nextLine();
        System.out.println("Podaj liczbe dni");
        String liczba = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : liczba.toCharArray()) {
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        }
        if (stringBuilder.length() != 0) {
            return Integer.parseInt(stringBuilder.toString());
        } else {
            return  liczbaDni();
        }

    }
}
