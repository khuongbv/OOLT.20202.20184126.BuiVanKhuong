package hust.soict.hedspi.garbage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
    public static void main(String[] args){
        try {
            File data = new File("file/test.txt");
            long start = System.currentTimeMillis();
            Scanner input = new Scanner(data);
            String content = "";
            while(input.hasNextLine()) {
                content += input.nextLine() + "\n";
            }
            System.out.println(System.currentTimeMillis() - start);
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
