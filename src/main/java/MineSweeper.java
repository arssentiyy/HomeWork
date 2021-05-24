package ru.geekbrains;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static final int HEIGHT = 5;
    public static final int WIDTH = 5;
    public static final int MINES_COUNT = 4;
    public static final int MINE = 1000;
    public static final int EMPTY = 0;
    private static final int CELL_OPEN = 1;
    private static final int CELL_CLOSE = 0;
    private static final int CELL_FLAG = -1;


    public static void main(String[] args) {
        boolean win = play();
        if (win) {
            System.out.println("Вы отрыли все мины! Поздравляю!");
        } else {
            System.out.println("Сапер ошибается 1 раз! Но вы можете больше! А пока вы проиграли!");
        }
    }

    private static boolean play() {
        int[][] board = generateBoard();
        int[][] moves = new int [HEIGHT][WIDTH];
        boolean isPassMove;
        boolean win;
        do {
            isPassMove = makeMove(board, moves);
            win = isWin(moves);
        } while (isPassMove && !win);
            return isPassMove;
        }
    private static boolean isWin(int[][] moves){
        int openCell = 0;
        for (int[] lines : moves) {
            for (int cell : lines) {
                if (cell == CELL_OPEN) {
                    openCell++;
                }
            }
        }

        return openCell + MINES_COUNT == HEIGHT * WIDTH;
    }
    private static boolean makeMove(int[][] board, int[][] moves) {
       printBoard(board, moves);
       Scanner scanner = new Scanner(System.in);
       int row, line;
       boolean flag = false;
       while (true) {
           System.out.print("Ваш ход:");
           String move = scanner.nextLine().trim().toUpperCase();
           if (move.length() == 2 || move.length() == 3) {
               row = move.charAt(0) - 'A'; // 1 символ и преобразуем вычитанием
               line = move.charAt(1) - '0'; // 2 символ и преобразуем вычитанием
               if (move.length() == 3) {
                   flag = move.charAt(2) == '*';
               }
               if (row < WIDTH && row >= 0 && line < HEIGHT && line>=0) {
                   break;
               }

           }

           System.out.println("Неправильный ход!");
       }
       if (flag) {
           moves[line][row] = CELL_FLAG;
           return true;
       }

       if (board[line][row] != MINE) {
           moves[line][row] = CELL_OPEN;
       }

        //System.out.printf("row = %d; line = %d; flag = %b" , row, line, flag);
        return false;
    }

    private static void printBoard(int[][] board, int[][] moves) {
        for (char i = 'A'; i < 'A' + WIDTH ; i++) {
            System.out.print(i == 'A' ? "    A" : " " + i); // Добавил... сразу делаем сдвиг при i == A
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < WIDTH; j++) {
                if (moves[i][j] == CELL_CLOSE) {
                    System.out.print("[]");
                    continue;
                }

                if (moves[i][j] == CELL_FLAG) {
                    System.out.print(" \uD83D\uDEA9");
                    continue;
                }

                OpenField(board, i, j);
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
    }

    private static void OpenField(int[][] board, int i, int j) {
        System.out.print(getColorCode(board[i][j]));
        switch (board[i][j]) {
            case EMPTY:
                System.out.print(" .");
                break;
            case MINE:
                System.out.print(" *");
                break;
            default:
                System.out.printf("%2d", board[i][j]);
        }
    }

    private static String getColorCode(final int i) {
        switch (i) {
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            case 5:
                return ANSI_YELLOW;
        }
        return null;
    }



    private static int[][] generateBoard() {
        int[][] board = placeMines();
        return calculateMines(board);
    }

    private static int[][] placeMines() {
        int[][] board = new int[HEIGHT][WIDTH];
        Random random = new Random();
        int mines = MINES_COUNT;
        if (mines >= HEIGHT * WIDTH) mines = HEIGHT * WIDTH; // Добавил... если кол - во мин не вмещается в поле, кол-во мин ограничивается полем
        while (mines > 0) {
            int x, y;
            do {
                x = random.nextInt(HEIGHT); // От 0 до HEIGHT
                y = random.nextInt(WIDTH); // От 0 до WIDTH
            } while (board[x][y] == MINE); // для проверки чтоб не положить МИНУ дважды в одну и ту же координату
                board[x][y] = MINE;
                mines--; // кол во мин уменьшаем на 1 каждый раз
        }
        return board;
    }

    private static int[][] calculateMines(int[][] board) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == MINE) {
                    continue;
                }
                board[i][j] = calculateMinesAroundCell(board, i, j);
            }
        }
        return board;
    }

    private static int calculateMinesAroundCell(int[][] board, int i, int j) {
        int mCount = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k < 0 || k >= HEIGHT || l < 0 || l >= WIDTH) {
                    continue;
                }
                if (board[k][l] == MINE) {
                    mCount++;
                }
            }
        }
        return mCount;
    }


}
