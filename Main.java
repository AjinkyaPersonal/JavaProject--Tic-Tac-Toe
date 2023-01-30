import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        char [][] board = {
                {' ', ' ' , ' '},
                {' ', ' ' , ' '},
                {' ', ' ' , ' '}
             };


        printBoard(board);

        while(true) {
            playerTurn(board , sc);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
            computerTurn(board);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
        }

//        sc.close();
    }

    private static boolean isGameWon(char[][] board , char symbol){
        for(int i=0 ; i<3 ; i++){
//            horizontal check
            int j=0;
            while(j<3){
                if(board[i][j]!=symbol){
                    break;
                }
                j++;
            }
            if(j==3){
                return true;
            }

//            vertical check
            j=0;
            while(j<3){
                if(board[j][i]!=symbol){
                    break;
                }
                j++;
            }
            if(j==3){
                return true;
            }
        }

//      Diagonal
        int i = 0;
        int j=0;
        while(i<3 && j<3){
            if(board[i][j]!=symbol){
                break;
            }
            i++;
            j++;
        }
        if(i==3 && j==3){
            return true;
        }

        i=0;
        j=2;
        while(i<3 && j>=0){
            if(board[i][j]!=symbol){
                break;
            }
            i++;
            j--;
        }
        if(i==3 && j==-1){
            return true;
        }

        return false;
    }

    private static boolean isGameFinished(char[][] board) {

        if(isGameWon(board , 'X')){
            printBoard(board);
            System.out.println("Player Won ! ");
            return true;
        }

        if(isGameWon(board , 'O')){
            printBoard(board);
            System.out.println("Computer Won ! ");
            return true;
        }

        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The Game Ended in a Tie !!!");
        return true;
    }
    private static void computerTurn(char[][] board) {
        // Random rand = new Random();
        int computerMove;
        while(true){
            // int computerMove = rand.nextInt(9) + 1;
            computerMove = (int)(Math.random()*10);
            if(isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove) , 'O');
    }
    private static boolean isValidMove(char[][] board , String position){
        switch(position){
            case "1" :
                return (board[0][0]==' ');
            case "2" :
                return (board[0][1]==' ');
            case "3" :
                return (board[0][2]==' ');
            case "4" :
                return (board[1][0]==' ');
            case "5" :
                return (board[1][1]==' ');
            case "6" :
                return (board[1][2]==' ');
            case "7" :
                return (board[2][0]==' ');
            case "8" :
                return (board[2][1]==' ');
            case "9" :
                return (board[2][2]==' ');
            default :
                return false;
        }
    }
    private static void playerTurn(char[][] board , Scanner sc) {
        String userInput;
        while(true) {
            System.out.println();
            System.out.println("Where would you like to play : ? Enter (1 - 9) ");
            userInput = sc.nextLine();
            if(isValidMove(board , userInput)){
                break;
            }else{
                System.out.println(userInput + " is not a valid move .");
            }
        }
        placeMove(board, userInput , 'X');
    }
    private static void placeMove(char[][] board, String position , char symbol) {
        switch(position){
            case "1" :
                board[0][0] = symbol;
                break;
            case "2" :
                board[0][1] = symbol;
                break;
            case "3" :
                board[0][2] = symbol;
                break;
            case "4" :
                board[1][0] = symbol;
                break;
            case "5" :
                board[1][1] = symbol;
                break;
            case "6" :
                board[1][2] = symbol;
                break;
            case "7" :
                board[2][0] = symbol;
                break;
            case "8" :
                board[2][1] = symbol;
                break;
            case "9" :
                board[2][2] = symbol;
                break;
            default :
                System.out.println(":( -> Wrong input");
        }
    }
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2] );
    }
}
