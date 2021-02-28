import java.util.Scanner;
public class QuadraticEquation {
    public static void main(String[] args){
        double a, b, c, Delta;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a, b, c: ");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        if(a == 0){
            System.out.println("a cannot be 0");
            a = input.nextDouble();
        } else{
            Delta = b*b - 4*a*c;
            if(Delta == 0){
                System.out.println("The equation has double root: " + (-b/(2*a)));
            } else if(Delta > 0){
                System.out.println("The equation has two distinct roots: " + ((-b + Math.sqrt(Delta))/(2*a)) + ", " + ((-b - Math.sqrt(Delta))/(2*a)));
            } else{
                System.out.println("The equation has no solution!");
            }
        }
    }
}
