import javax.swing.JOptionPane;
public class Calculate2Numbers {
    public static void main(String[] args){
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ",
        "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ",
        "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        
        double Num1 = Double.parseDouble(strNum1);
        double Num2 = Double.parseDouble(strNum2);
        System.out.println("Sum: " + (Num1 + Num2) + "\n");
        System.out.println("Difference: " + (Num1 - Num2) + "\n");
        System.out.println("Product: " + (Num1 * Num2) + "\n");
        if(Num2 != 0){
            System.out.println("Quotient: " + (Num1 / Num2) + "\n");
        }
        else{
            System.out.println("Num2 cannot be 0");
        }
        System.exit(0);

    }
}
