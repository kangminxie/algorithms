package main.java.com.kangmin.csce.game;

import java.util.Random;
import java.util.Scanner;

public final class MineWalker {

    private static final int BOARD_SIZE = 10;
    private static final int MINE_NUMBER = BOARD_SIZE * BOARD_SIZE / 10;
    private static final int INITIAL_POSITION_X = 0;
    private static final int INITIAL_POSITION_Y = 0;
    private static final Spaces[][] board = new Spaces[BOARD_SIZE][BOARD_SIZE];

    enum Spaces {

        EMPTY("EMPTY"),
        PLAYER("PLAYER"),
        MINE("MINE"),
        ICE_CREAM("ICE_CREAM"),
        WALKED_PATH("WALKED_PATH");

        private final String name;

        Spaces(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    private int pX;  // x position of player
    private int pY;  // y position of player
    private int goalX;  // x position of ice cream
    private int goalY;  // y position of ice cream

    void play() {
        boolean isPlayAgain;
        do {
            promptUserWelcomeMessage();

            cleanTheBoard();
            placePlayer();
            placeIceCream();
            placeMines();

            playBoardGame();

            promptUserIfPlayAgainMessage();
            final Scanner keyboard = new Scanner(System.in);
            try {
                isPlayAgain = keyboard.nextBoolean();
            } catch (Exception e) {
                e.printStackTrace();
                isPlayAgain = false;
            }
        } while (isPlayAgain);
        System.out.println("\nThanks for play this Game! Have a great one!\n");
    }

    private void promptUserWelcomeMessage() {
        System.out.println("Welcome to Mine Walker.\n"
                + "Get the ice cream cone and avoid the mines!");
    }

    private void promptUserIfPlayAgainMessage() {
        System.out.println("Would you like to play again?\n"
                + "Please input true or false");
    }

    // initialize the board
    // ----------->  X
    // | (pX, pY)
    // |
    // |
    // |         (gX, gY)
    // Y
    private static void cleanTheBoard() {
        // clean Spaces, put all positions as Empty
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                board[x][y] = Spaces.EMPTY;
            }
        }
    }

    // fill the player in the board
    private void placePlayer() {
        setPlayerInitialPosition();
        board[pX][pY] = Spaces.PLAYER; // place player sign
    }

    // initial the position of player
    private void setPlayerInitialPosition() {
        pX = INITIAL_POSITION_X;
        pY = INITIAL_POSITION_Y;
    }

    // fill the ice cream in the board
    private void placeIceCream() {
        setIceCreamPosition();
        board[goalX][goalY] = Spaces.ICE_CREAM; // place iceCream sign
    }

    // initial the position of ice Cream
    // board size must > 1
    private void setIceCreamPosition() {
        Random r = new Random();
        goalX = r.nextInt(board.length);
        goalY = r.nextInt(board.length);  // for position of ice Cream
        if (goalX == pX && goalY == pY) {
            // if put the ice Cream at the player's position initially, re-set
            setIceCreamPosition();
        }
    }

    // place the mines randomly
    private static void placeMines() {
        int remainNumOfMines = MINE_NUMBER;
        while (remainNumOfMines > 0) {
            final Random m = new Random();
            int mX = m.nextInt(board.length);
            int mY = m.nextInt(board.length);
            if (board[mX][mY] == Spaces.EMPTY) {
                board[mX][mY] = Spaces.MINE;
                remainNumOfMines--;
            }
        }
    }

    //Draw the board
    private static void DrawTheBoard() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                switch (board[x][y]) {
                    case MINE:
//                        System.out.print("%"); // debug
//                        break;
                    case EMPTY:
                        System.out.print("_");
                        break;
                    case PLAYER:
                        System.out.print("x");
                        break;
                    case ICE_CREAM:
                        System.out.print("^");
                        break;
                    case WALKED_PATH:
                        System.out.print("@");
                        break;
                    default:
                        System.out.print("?");
                        break;
                }
            }
            System.out.println();
        }
    }


    // Game to be played
    private void playBoardGame() {
        boolean isGameOver = false;
        while (!isGameOver) {
            DrawTheBoard(); //Draws the board to get started

            System.out.println("Either -1, 0 or 1 to move X");
            System.out.println("Input 9 to quit");

            Scanner keyboard = new Scanner(System.in);
            int dX = keyboard.nextInt();

            if (dX == 9) {
                System.out.println("Quit game option - Bye!");
                break;
            }

            //check input,and notify the player
            if (dX < -1 || dX > 1) {
                System.out.println("Invalid X, regard input X as 0");
                dX = 0;
            }

            System.out.println("Either -1, 0 or 1 to move Y");
            int dY = keyboard.nextInt();
            if (dY < -1 || dY > 1) {
                System.out.println("Invalid Y, regard input Y as 0");
                dY = 0;
            }

            board[pX][pY] = Spaces.WALKED_PATH;
            pX += dX;
            pY += dY;

            //check boundaries, make sure everything inside the board
            if (pX < 0) {
                pX = 0;
            } else if (pX > BOARD_SIZE - 1) {
                pX = BOARD_SIZE - 1;
            }

            if (pY < 0) {
                pY = 0;
            } else if (pY > BOARD_SIZE - 1) {
                pY = BOARD_SIZE - 1;
            }

            // Winning conditions
            if (board[pX][pY] == Spaces.ICE_CREAM) {
                System.out.println("You WIN, congratulations!!!");
                isGameOver = true;
            }

            // Fail conditions
            if (board[pX][pY] == Spaces.MINE) {
                System.out.println("Boom! Dead!");
                isGameOver = true;
            }

            board[pX][pY] = Spaces.PLAYER; // continue the loop
        }
    }

    public static void main(final String[] args) {
        new MineWalker().play();
    }
}
