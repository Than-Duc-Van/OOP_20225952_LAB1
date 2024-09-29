import java.util.Scanner;
public class Nstars {

    public static void main(String[] args) {
    	
        Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter the number n: ");
            int n = keyboard.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = n; j > i + 1; j--) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= i * 2; j++) {
                    System.out.print("*");
                }
                for (int j = n; j > i + 1; j--) {
                    System.out.print(" ");
                }
                System.out.print("\n");
            }
     
    }

}