import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the file name: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        Path filepath = Path.of(fileName);
        boolean exists = Files.exists(filepath);
        
        if (exists){
            System.out.println("File already exists. Opening in write mode.");
            System.out.println("=========" + fileName + "=========" );
            openFile(fileName);
            System.out.println("Do you want to write to the file? (y/n) ");
            String selection = input.nextLine().toLowerCase();
            if (selection.equals("y")){
                writeToFile(fileName);
            }
        } else {
            try {
                System.out.println("File not found. Creating " + fileName + " in root directory.");
                Files.createFile(filepath);
                writeToFile(fileName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        
        
    }
    
    public static void openFile(String filename){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String filename){
        Scanner input = new Scanner(System.in);
        System.out.println("Please type the text you want to append to the file: ");
        String data = input.nextLine();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write("\n" + data);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}