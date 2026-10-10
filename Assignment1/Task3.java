package Assignment1;
import java.util.Scanner; 
// 3	Write a program to perform addition, subtraction, multiplication, transpose, to check 
// square matrix, to check matrix is diagonal, and to check matrix is identity.

public class Task3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter 1 for addition");
            System.out.println("Enter 2 for subtraction");
            System.out.println("Enter 3 for multiplication");
            System.out.println("Enter 4 for transpose");
            System.out.println("Enter 5 to check Square Matrix");
            System.out.println("Enter 6 to check Diagonal Matrix");
            System.out.println("Enter 7 to check Identity matrix");
            System.out.println("Enter 8 to exit");
            System.out.println("Enter your choice");
            int ch = sc.nextInt();
            if(ch==8) return;
            if(ch >=1 && ch<=3){
                
                
                System.out.println("Enter the no. of rows of first matrix");
                int rows1 = sc.nextInt();
                System.out.println("Enter the no. of columns of first matrix");
                int cols1 = sc.nextInt();
                int[][] matrix1 = new int[rows1][cols1];
                System.out.println("Enter the elements of first matrix");
                for(int i=0; i<rows1; i++){
                    for(int j=0; j<cols1; j++){
                         
                        matrix1[i][j] = sc.nextInt();
                    }
                }   
                System.out.println("Enter the no. of rows of second matrix");
                int rows2 = sc.nextInt();   
                System.out.println("Enter the no. of columns of second matrix");
                int cols2 = sc.nextInt();
                int[][] matrix2 = new int[rows2][cols2];
                System.out.println("Enter the elements of second matrix");
                for(int i=0; i<rows2; i++){
                    for(int j=0; j<cols2; j++){
                         
                        matrix2[i][j] = sc.nextInt();
                    }
                }
                switch(ch){
                    case 1:
                        int[][] resultAdd = addition(matrix1, matrix2);
                        System.out.println("Result of addition:");
                        printMatrix(resultAdd);
                        break;
                    case 2:
                        int[][] resultSub = subtraction(matrix1, matrix2);
                        System.out.println("Result of subtraction:");
                        printMatrix(resultSub);
                        break;
                    case 3:
                        int[][] resultMul = multiplication(matrix1, matrix2);
                        System.out.println("Result of multiplication:");
                        printMatrix(resultMul);
                        break;
                }
            }
            else{
                
                System.out.println("Enter the no. of rows of matrix");
                int rows = sc.nextInt();
                System.out.println("Enter the no. of columns of matrix");
                int cols = sc.nextInt();
                int[][] matrix = new int[rows][cols];
                System.out.println("Enter the elements of the matrix");
                for(int i=0; i<rows; i++){
                    for(int j=0; j<cols; j++){
                        
                        matrix[i][j] = sc.nextInt();
                    }
                }
                switch(ch){
                    case 4:
                        int[][] resultTrans = transpose(matrix);
                        System.out.println("Result of transpose:");
                        printMatrix(resultTrans);
                        break;
                    case 5:
                        boolean isSquare = isSquareMatrix(matrix);
                        if(isSquare){
                            System.out.println("The matrix is a square matrix.");
                        }else{
                            System.out.println("The matrix is not a square matrix.");
                        }
                        break;
                    case 6:
                        boolean isDiagonal = isDiagonalMatrix(matrix);
                        if(isDiagonal){
                            System.out.println("The matrix is a diagonal matrix.");
                        }else{
                            System.out.println("The matrix is not a diagonal matrix.");
                        }
                        break;
                    case 7:
                        boolean isIdentity = isIdentityMatrix(matrix);
                        if(isIdentity){
                            System.out.println("The matrix is an identity matrix.");
                        }else{
                            System.out.println("The matrix is not an identity matrix.");
                        }
                        break;
                     
                         
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                         
                }
            }
        }while(true);
    }
    public static void printMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] addition(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] subtraction(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplication(int[][] matrix1, int[][] matrix2){
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        if(cols1 != rows2){
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }
        int[][] result = new int[rows1][cols2];
        for(int i=0; i<rows1; i++){
            for(int j=0; j<cols2; j++){
                for(int k=0; k<cols1; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    public static int[][] transpose(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    public static boolean isSquareMatrix(int[][] matrix){
        return matrix.length == matrix[0].length;
    }
    public static boolean isDiagonalMatrix(int[][] matrix){
        if(!isSquareMatrix(matrix)){
            return false;
        }
        int rows = matrix.length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                if(i != j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isIdentityMatrix(int[][] matrix){
        if(!isSquareMatrix(matrix)){
            return false;
        }
        int rows = matrix.length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                if(i == j && matrix[i][j] != 1){
                    return false;
                }
                if(i != j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }


}
