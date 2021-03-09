import java.util.Scanner;
public class Exercise5_7 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int l, w;

        System.out.println("Nhap kich thuoc cua ma tran: ");
        l = keyboard.nextInt();
        w = keyboard.nextInt();
        int a[][] = new int[l][w];
        int b[][] = new int[l][w];
        int result[][] = new int[l][w];

        for(int i = 0; i < l; i++) {
            for(int j = 0; j < w; j++) {
                System.out.println("Nhap vao phan tu a[" + i + "][" + j + "]");
                a[i][j] = keyboard.nextInt();
            }
        }

        for(int i = 0; i < l; i++) {
            for(int j = 0; j < w; j++) {
                System.out.println("Nhap vao phan tu b[" + i + "][" + j + "]");
                b[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("\nMa tran a + b: \n");
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < w; j++) {
                result[i][j] = a[i][j] + b[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        keyboard.close();
    }
}
