package ch.jobs;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    ArrayList<Integer> teamX = new ArrayList<>();
    ArrayList<Integer> teamO = new ArrayList<>();
    ArrayList<String> positions = new ArrayList<>();
    int gesetztePositionen = 0;



    public TicTacToe() {

        convert(2);
        System.out.println("O beginnt");
        System.out.println("Gebe eine Zahl von 1-9 ein!");
        checkInput(0);

    }


    public void checkInput(int team) {
        Scanner scanner = new Scanner(System.in);
        int possibleInput = isInteger(scanner);
        if (possibleInput == -1) {
            System.out.println("FALSCHES FORMAT");
            checkInput(team);
            return;
        }

        int input = possibleInput;

        if (input <= 0 || input > 9) {
            System.out.println("Falsche Zahlen! 1-9");
            checkInput(team);
        }
        if (team == 0) {
            if (teamX.contains(input)) {
                System.out.println("FEHLER! Nochmals Zahl eingeben!");
                checkInput(0);
                return;
            }
            teamO.add(input);
            gesetztePositionen++;
            convert(team);

        }
        if (team == 1) {
            if (teamO.contains(input)) {
                System.out.println("FEHLER! Nochmals Zahl eingeben!");
                checkInput(1);
                return;
            }
            teamX.add(input);
            gesetztePositionen++;
            convert(team);

        }


    }

    public void convert(int team) {
        for (int i = 1; i <= 10; i++) {
            if (!teamX.contains(i) && !teamO.contains(i)) {
                positions.add("-");
            }
            if (teamX.contains(i)) {
                positions.add("X");
            }
            if (teamO.contains(i)) {
                positions.add("O");
            }
        }
        sendMessage();
        check();
        positions.clear();
        if (team == 0) {
            checkInput(1);
        }
        if (team == 1) {
            checkInput(0);
        }
    }

    public void check() {
        if (teamO.contains(1) && teamO.contains(2) && teamO.contains(3)) {
            System.out.println("Team 0 hat gewonnen!");
            replay();
        }
        if (teamO.contains(4) && teamO.contains(5) && teamO.contains(6)) {
            System.out.println("Team 0 hat gewonnen!");
            replay();
        }
        if (teamO.contains(7) && teamO.contains(8) && teamO.contains(9)) {
            System.out.println("Team 0 hat gewonnen!");
            replay();
        }
        if (teamO.contains(1) && teamO.contains(4) && teamO.contains(7)) {
            System.out.println("Team 0 hat gewonnen!");
            replay();
        }
        if (teamO.contains(2) && teamO.contains(5) && teamO.contains(8)) {
            System.out.println("Team 0 hat gewonnen!");
            replay();
        }
        if (teamO.contains(3) && teamO.contains(6) && teamO.contains(9)) {
            System.out.println("Team 0 hat gewonnen!");
            replay();
        }
        if (teamO.contains(1) && teamO.contains(5) && teamO.contains(9)) {
            System.out.println("Team 0 hat gewonnen!");
            replay();
        }
        if (teamO.contains(3) && teamO.contains(5) && teamO.contains(7)) {
            System.out.println("Team 0 hat gewonnen!");
            replay();
        }


        if (teamX.contains(1) && teamX.contains(2) && teamX.contains(3)) {
            System.out.println("Team X hat gewonnen!");
            replay();
        }
        if (teamX.contains(4) && teamX.contains(5) && teamX.contains(6)) {
            System.out.println("Team X hat gewonnen!");
            replay();
        }
        if (teamX.contains(7) && teamX.contains(8) && teamX.contains(9)) {
            System.out.println("Team X hat gewonnen!");
            replay();
        }
        if (teamX.contains(1) && teamX.contains(4) && teamX.contains(7)) {
            System.out.println("Team X hat gewonnen!");
            replay();
        }
        if (teamX.contains(2) && teamX.contains(5) && teamX.contains(8)) {
            System.out.println("Team X hat gewonnen!");
            replay();
        }
        if (teamX.contains(3) && teamX.contains(6) && teamX.contains(9)) {
            System.out.println("Team X hat gewonnen!");
            replay();
        }
        if (teamX.contains(1) && teamX.contains(5) && teamX.contains(9)) {
            System.out.println("Team X hat gewonnen!");
            replay();
        }
        if (teamX.contains(3) && teamX.contains(5) && teamX.contains(7)) {
            System.out.println("Team X hat gewonnen!");
            replay();
        }
        if (gesetztePositionen == 9) {
            System.out.println("UNENTSCHIEDEN!");
            positions.clear();
            gesetztePositionen = 0;
            replay();
        }
    }


    public int isInteger(Scanner scanner) {
        int input;
        try {
            input = scanner.nextInt();
        } catch (NumberFormatException | InputMismatchException | NullPointerException e) {
            return -1;
        }
        return input;
    }

    public void sendMessage() {
        System.out.println(positions.get(0) + " " + positions.get(1) + " " + positions.get(2));
        System.out.println(positions.get(3) + " " + positions.get(4) + " " + positions.get(5));
        System.out.println(positions.get(6) + " " + positions.get(7) + " " + positions.get(8));
    }

    public void replay() {
        System.out.println("Willst du nochmals Spielen?");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            for (int i = 1; i <= 50; i++) {
                System.out.println(" ");
            }
            System.out.println("Neues Spiel!");
            teamO.clear();
            teamX.clear();
            positions.clear();
            convert(2);
            System.out.println("O beginnt");
            System.out.println("Gebe eine Zahl von 1-9 ein!");
            checkInput(0);
        } else {
            System.out.println("BYE!");
        }
    }

}



