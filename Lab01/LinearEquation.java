import java.util.Scanner;
public class LinearEquation {
    public static void main(String[] args){
        double num_a, num_b;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        num_a = input.nextDouble();
        System.out.println("Enter b number: ");
        num_b = input.nextDouble();
        if(num_a == 0){
            System.out.println("a cannot be 0");
        } else{
            System.out.println("Solution x = " + (-num_b/num_a));
        }
        input.close();
    }
}
