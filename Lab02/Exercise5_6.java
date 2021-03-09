import java.util.*;
public class Exercise5_6 {
    public static void main(String[] args){
        int i, n, sum = 0;
        float ave;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Nhap so phan tu cua mang: ");
        n = input.nextInt();
        int a[] = new int[n];

        for(i = 0; i< n; i++) {
            input.nextLine();
            if(input.hasNextInt()) 
                a[i] = input.nextInt();
            else
                a[i] = random.nextInt(999);
            sum += a[i];
        }

        ave = (float) sum / n;

        System.out.println("Mang nhap vao: ");
        System.out.printf("%s", Arrays.toString(a));
        System.out.println("\nMang sap xep: ");
        Arrays.sort(a);
        System.out.printf("%s", Arrays.toString(a));
        System.out.println("\nSum = " + sum);
        System.out.println("Average = " + ave);

        input.close();
    }
}
