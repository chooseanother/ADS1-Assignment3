public class nQueens {
    static char[][]matrix;


    public static void main(String[] args) {
        matrixConstructor(5);
        tryToPlaceQueen(0);

    }

    //empty space is marked with O, queen is X
    private static void matrixConstructor(int n){
        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    private static void printStructure(){
        for (int j = 0; j < matrix.length; j++) {
            System.out.print(" _");
        }

        for (int i = 0; i < matrix.length; i++) {

            System.out.print("\n|");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"|");
            }
            System.out.print("\n");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" _");
            }
        }
        System.out.println("\n=====================");
    }

    private static void tryToPlaceQueen(int column){
        //if(column == matrix.length){
        if(done()){
            printStructure();
            return;
        }
        else{
            for (int row = 0; row < matrix.length; row++) {
                if (OK(column,row)){
                    matrix[row][column] = 'Q';
                    tryToPlaceQueen(column+1);
                    // got try to start from 1,0
                    matrix[row][column] = ' ';
                }
            }
        }
    }
    private static boolean OK(int column, int row){
        //check if queen can be place in column, row
        // if yes then return true else return false

        for (int i = 0; i < matrix.length; i++) {
            //check row
            if(matrix[row][i] != ' '){
                return false;
            }
            //check column
            if(matrix[i][column] != ' '){
                return false;
            }

        }
        //check diagonal
        //right down
        int i = column;
        for (int j = row; j < matrix.length-1; j++) {
            if(i > matrix.length-2){
                break;
            }
            if(matrix[j+1][i+1] == 'Q'){
                return false;
            }
            i++;
        }
        //right up
        i = column;
        for (int j = row; j > 0; j--) {
            if(i > matrix.length-2){
                break;
            }
            if(matrix[j-1][i+1] == 'Q'){
                return false;
            }
            i++;
        }

        //left down
        i = column;
        for (int j = row; j < matrix.length-1; j++) {
            if(i < 1) {
                break;
            }
            if(matrix[j+1][i-1] == 'Q'){
                return false;
            }
            i--;
        }

        //left up
        i = column;
        for (int j = row; j > 0; j--) {
            if(i < 1){
                break;
            }
            if(matrix[j-1][i-1] == 'Q'){
                return false;
            }
            i--;
        }
      return true;
    }

    static boolean done(){
        int numberOfQueens = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 'Q'){
                    numberOfQueens++;
                }
            }
        }
        if(numberOfQueens == matrix.length){
            return true;
        }
        return false;
    }
}


