import java.util.Scanner;

public class Game {
    static Scanner in = new Scanner(System.in);
    static Board board = new Board();
    //Create a player1 boolean that is true if it is player 1's turn and false if it is player 2's turn
    static boolean isPlayer1 = true;
    //Create a gameEnded boolean and use it as the condition in the while loop
    static boolean gameEnded = false;
    //player 1 name
    static String p1;
    //player 2 name
    static String p2;
    //default player's symbol (will change in checkPlayersTurn() method)
    static char playerSymbol = '-';

    public static void startGame() {

        System.out.println("Let's play Tic Tac Toe!");
        System.out.print("Player 1, what is your name? ");
        p1 = in.nextLine();
        System.out.print("Player 2, what is your name? ");
        p2 = in.nextLine();

        board.fillBoard();

        while(!gameEnded) {

            board.drawBoard(board.boardArray);

            checkPlayersTurn();

            //Create row and col variables which represent indexes that correspond to a position on our board
            int row = 0;
            int col = 0;

            //Only break out of the while loop once the user enters a valid position
            while(true) {

                //Ask the user for what position they want to place their x or o
                System.out.print("Enter a row number (0, 1, or 2): ");
                row = in.nextInt();
                System.out.print("Enter a column number (0, 1, or 2): ");
                col = in.nextInt();

                //Check if the row and col are 0, 1, or 2
                if(row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the bounds of the board! Try again.");

                    //Check if the position on the board the user entered is empty (has a -) or not
                } else if(board.boardArray[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");

                    //Otherwise, the position is valid so break out of the while loop
                } else {
                    break;
                }

            }

            //Set the position on the board at row, col to playerSymbol
            board.boardArray[row][col] = playerSymbol;

            //Check to see if either player has won
            if(Board.playerHasWon(board.boardArray) == 'X') {
                System.out.println(p1 + " has won!");
                gameEnded = true;
            } else if(Board.playerHasWon(board.boardArray) == 'O') {
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else {

                //If neither player has won, check to see if there has been a tie (if the board is full)
                if(Board.boardIsFull(board.boardArray)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    //If player1 is true, make it false, and vice versa; this way, the players alternate each turn
                    isPlayer1 = !isPlayer1;
                }
            }
        }

        board.drawBoard(board.boardArray);

    }

    public static void checkPlayersTurn() {
        //Print whose turn it is
        if(isPlayer1) {
            System.out.println(p1 + "'s Turn (X):");
        } else {
            System.out.println(p2 + "'s Turn (O):");
        }

        //Create a char variable that stores either 'x' or 'o' based on what player's turn it is
        if(isPlayer1) {
            playerSymbol = 'X';
        } else {
            playerSymbol = 'O';
        }
    }

}

