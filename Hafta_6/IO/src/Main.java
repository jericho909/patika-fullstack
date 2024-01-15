import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the file name: ");
        String fileName = input.nextLine();
        File file = new File(fileName);
        /*File directory = new File("folder1");
        directory.mkdir(); //--> creates new folder*/

        try {
            if (file.createNewFile()){
                System.out.println("File created. Name: " + file.getName() + "\nDirectory: " + file.getPath());
            } else {
                System.out.println(file.getName() + " already exists.");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        String text = "I am a string!";


        try {
            FileOutputStream outputStream = new FileOutputStream(fileName, true);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            FileInputStream fileInput = new FileInputStream("test.txt");
            int i = fileInput.read();

            while(i != -1){
                System.out.print((char) i);
                i = fileInput.read();
            }

            fileInput.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        byte[] byteArr = {1,2,3,4,5,6,7};
        ByteArrayInputStream byteArrayInput = new ByteArrayInputStream(byteArr);

        for (int i = 0; i < byteArr.length; i++){
            int j = byteArrayInput.read();
            System.out.print(j + ", ");
        }

        String newData = "HELLO! HELLO! HELLO!";
        byte[] newArr = newData.getBytes();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(newArr);
            String streamData = newArr.toString();
            System.out.println("Output stream: " + streamData);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
        //file.delete() --> deletes the file

}
