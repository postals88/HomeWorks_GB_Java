package lesson3;

import java.util.Random;
import java.util.Scanner;

public class homeWork_3_Game_XO {
  
    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static int fieldSyzeX;
    public static int fieldSyzeY;
    public static char[][] field;



    private static void initMap() {
        fieldSyzeX = 5;
        fieldSyzeY = 5;
        field = new char[fieldSyzeY][fieldSyzeX];
        for (int y = 0; y < fieldSyzeY; y++) {
            for (int x = 0; x < fieldSyzeX; x++) {
                field[y][x] = EMPTY_DOT;

            }

        }
    }
    public static void printMap() {
        for (int y = 0; y < fieldSyzeY; y++) {
            for (int x = 0; x < fieldSyzeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }
    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Ход человека. Введите координаты через Enter: ");


            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        field[y][x] = HUMAN_DOT;
    }
    public static void pcTurn() {
        System.out.println("Ход компуКтера: ");
        int x;
        int y;

        do {
            x = RANDOM.nextInt(fieldSyzeX);
            y = RANDOM.nextInt(fieldSyzeY);

        } while (!isEmptyCell(y, x));

        field[y][x] = PC_DOT;
    }
    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSyzeX && y >= 0 && y < fieldSyzeY;
    }
    public static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }
    public static boolean chekWin(char c) {
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == c) {
                    count ++;
                }
            }
            if (count == 4) {
                return true;
            }
            count = 0;
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] == c) {
                    count ++;
                }
            }
            if (count == 4) {
                return true;
            }
            count = 0;
        }
        for (int j = 0; j < field.length; j++) {
            if (field[j][j] == c) {
                count ++;
            }
        }
        if (count == 4) {
            return true;
        }
        return false;
    }

    //   public static boolean chekWin(char c){
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c && field [0][3] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c && field [1][3] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c && field [2][3] == c) return true;
//        if (field[3][0] == c && field[3][1] == c && field[3][2] == c && field [3][3] == c) return true;
//        if (field[4][0] == c && field[4][1] == c && field[4][2] == c && field [4][3] == c) return true;
//
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c && field [3][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c && field [3][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c && field [3][2] == c) return true;
//        if (field[0][3] == c && field[1][3] == c && field[2][3] == c && field [3][3] == c) return true;
//        if (field[0][4] == c && field[1][4] == c && field[2][4] == c && field [3][4] == c) return true;
//
//        if (field[4][0] == c && field[3][1] == c && field[2][2] == c && field[1][3] == c && field[0][4] == c) return true;
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c && field[3][3] == c && field[4][4] == c) return true;
//
//        if (field[3][0] == c && field[2][1] == c && field[1][2] == c && field[0][3] == c ) return true;
//        if (field[4][1] == c && field[3][2] == c && field[2][3] == c && field[1][4] == c ) return true;
//
//        if (field[0][1] == c && field[1][2] == c && field[2][3] == c && field[3][4] == c ) return true;
//        if (field[0][0] == c && field[1][1] == c && field[2][3] == c && field[3][4] == c ) return true;
//        if (field[1][0] == c && field[2][1] == c && field[3][2] == c && field[4][3] == c ) return true;

    //        return false;
//    }
    public static boolean isFullMap() {
        for (int y = 0; y < fieldSyzeY; y++) {
            for (int x = 0; x < fieldSyzeX; x++) {
                if (field[x][y] == EMPTY_DOT)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (chekWin(HUMAN_DOT)) {
                System.out.println("Человек победил! ");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья! ");
                break;
            }
            pcTurn();
            printMap();
            if (chekWin(PC_DOT)) {
                System.out.println("КомпуКтер выйграл! ");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья! ");
                break;
            }
        }
    }
}






  

