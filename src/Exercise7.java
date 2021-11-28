import java.util.Scanner;

public class Exercise7 {
    final static int BOARD_SIZE = 10;
    public static void main(String[] args) {
        char [] board = new char[BOARD_SIZE];
        int indexPlayer1;
        int indexPlayer2;
        boolean winner;

        do {
            System.out.println("Player 1: ");
            indexPlayer1 = getPositionFromUser(board);
            winner = placeSymbolOnBoard(board,indexPlayer1 -1,'X');
            if (winner){
                break;
            }
            System.out.println("  ");
            System.out.println("Player 2: ");
            indexPlayer2 = getPositionFromUser(board);
            winner = placeSymbolOnBoard(board,indexPlayer2 -1,'0');


        }while (!winner);


    }
    public static void printBoard (char [] gameBoard){
        for (int i = 0; i < 9; i++) {
            if (i == 2|| i ==5){
                System.out.println (gameBoard[i] + " ");
            } else{
                System.out.print(gameBoard[i] + " ");
            }
        }

    }
    public static boolean isAvailable (char[] gameBoard, int index){
        boolean isAvailable = true;
        if (gameBoard[index] == 'X' || gameBoard[index] == '0'){
            isAvailable = false;

        }
        return isAvailable;

    }
    public static int getPositionFromUser (char [] gameBoard) {
        Scanner scanner = new Scanner(System.in);
        int position;
        int newPosition;
        do {
            System.out.println("Please enter position (1-9): ");
            position = scanner.nextInt();
        } while (position < 1 || position > 9);

        if (!isAvailable(gameBoard, position-1)){
           do {
               System.out.println("Try again. this position is already taken...");
               newPosition = scanner.nextInt();
           }while (!isAvailable(gameBoard, newPosition-1));
        }
        return position;
    }

    public static char checkWinner (char[] gameBoard){
        char winner = '-';
//        if (charsBoard[0]== charsBoard[3] && charsBoard[3]==charsBoard[6]){
//            winner = charsBoard[0];

        if (gameBoard[0] != 0){
            if (gameBoard[0] == gameBoard[1] && gameBoard[0]== gameBoard[2]) {
                winner = gameBoard[0];
            }

            if (gameBoard[0] == gameBoard[3] && gameBoard[0] == gameBoard[6]) {
                winner = gameBoard[0];
            }

            if (gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]) {
                winner = gameBoard[0];
            }

        }

        if (gameBoard[2] != 0){
            if (gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8]) {
                winner = gameBoard[2];
            }
            if (gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6]) {
                winner = gameBoard[2];
            }

        }


        if (gameBoard[3] == gameBoard[4] && gameBoard[3] == gameBoard[5]) {
            if (gameBoard[3] != 0){
                winner = gameBoard[3];
            }
        }


        if (gameBoard[6] == gameBoard[7]  && gameBoard[6] == gameBoard[8]) {
            if (gameBoard[6] != 0){
                winner = gameBoard[6];
            }
        }

        if (gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7]) {
            if (gameBoard[1] != 0){
                winner = gameBoard[1];
            }
        }
        return winner;


    }
    public static boolean placeSymbolOnBoard (char[] gameBoard ,int index, char player){
        boolean winner = false;
        gameBoard[index] = player;
        printBoard(gameBoard);
        char winnerCheck = checkWinner(gameBoard);
        if (winnerCheck == 'X'){
            winner =true;
            System.out.println("Congrats player 1 is the winner!! ");
        }else if (winnerCheck == '0'){
            winner =true;
            System.out.println("Congrats player 2 is the winner!! ");
        }
        return winner;

    }










}









