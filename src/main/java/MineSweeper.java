package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    public static final int HEIGHT = 10;
    public static final int WIDTH = 10;
    public static final int MINES_COUNT = 10;
    public static final int MINE = 1000;
    public static final int EMPTY = 0;


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
        printBoard(board);
        return true;
    }

    private static void printBoard(int[][] board) {
        for (char i = 'A'; i < 'A' + WIDTH ; i++) {
            System.out.print(i == 'A' ? "    A" : " " + i); // Добавил... сразу делаем сдвиг при i == A
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < WIDTH; j++) {
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
            System.out.println();
        }

    }

    private static int[][] generateBoard() {
        int[][] board = new int[HEIGHT][WIDTH];
        placeMines(board);
        calculateMines(board);
        return board;
    }

    private static void placeMines(int[][] board) {
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
    }

    private static void calculateMines(int[][] board) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == MINE) {
                    continue;
                }
                board[i][j] = calculateMinesAroundCell(board, i, j);
            }
            
        }
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
