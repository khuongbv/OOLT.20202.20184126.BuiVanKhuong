import java.util.Scanner;
public class Exercise5_4 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int k = 2 * n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if((j >= n-1-i) && (j <= n-1+i)) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
