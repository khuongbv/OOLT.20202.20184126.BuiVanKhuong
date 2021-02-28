import java.util.Scanner;
public class LinearSystem {
    public static void main(String[] args){
        double a11, a12, a21, a22, b1, b2, D, D1, D2;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a11, a12, a21, a22, b1, b2: ");
        a11 = input.nextDouble();
        a12 = input.nextDouble();
        a21 = input.nextDouble();
        a22 = input.nextDouble();
        b1 = input.nextDouble();
        b2 = input.nextDouble();
        D = a11 * a22 - a21 * a12;
        D1 = b1 * a22 - b2 * a12;
        D2 = a11 * b2 - a21 * b1;
        if(D != 0){
            System.out.println("The system has a unique solution (x1, x2) = (" + D1/D + ", " + D2/D + ")" );
        } else{
            if(D == 0 && D1 == 0 && D2 == 0){
                System.out.println("The system has infinitely many solution");
            } else{
                System.out.println("The system has no solution");
            }
        }
        input.close();
    }
}
