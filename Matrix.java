import java.util.Scanner;
public class Matrix{
	public static void main(String[] args)
	{
		Scanner sc  = new Scanner(System.in);
		
		 System.out.print("nhap so hang: ");
	        int rows = sc.nextInt();
	     System.out.print("nhap so cot: ");
	        int cols = sc.nextInt();
		
		int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];
        
        System.out.println("Ma trận A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) 
                matrixA[i][j] = sc.nextInt();
        }
        System.out.println("Ma trận B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) 
                matrixB[i][j] = sc.nextInt();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        System.out.println("Ma trận A:");
        printMatrix(matrixA);
        System.out.println("Ma trận B:");
        printMatrix(matrixB);
        System.out.println("Ma trận tổng A + B:");
        printMatrix(sumMatrix);
	}
	public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}