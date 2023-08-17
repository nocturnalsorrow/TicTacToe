import java.sql.SQLOutput;

class Board {
    public int ROWS = 3;
    public int COLUMNS = 3;

    //Create a 3x3 array that represents our tic tac toe board
    char[][] boardArray = new char[ROWS][COLUMNS];

    //Initialize our board with dashes (empty positions)
    public void fillBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                boardArray[i][j] = '-';
            }
        }
    }

    //Make a function to draw the tic tac toe board
    public void drawBoard(char[][] board) {
        System.out.println("Board:");
        for(int i = 0; i < 3; i++) {
            //The inner for loop prints out each row of the board
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            //This print statement makes a new line so that each row is on a separate line
            System.out.println();
        }
    }

    public static char playerHasWon(char[][] board) {

        //Check each row
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        //Check each column
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        //Check the diagonals
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }

        //Otherwise nobody has not won yet
        return ' ';
    }

    //Make a function to check if all of the positions on the board have been filled
    public static boolean boardIsFull(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
