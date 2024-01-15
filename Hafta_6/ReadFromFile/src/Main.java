import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
            String line;
            while ((line = reader.readLine())!= null){
                sum += Integer.parseInt(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(sum);
    }
}