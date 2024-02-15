import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String fileName = "notInClass.txt";
        File fileDirectory = new File(fileName);
        List<Integer> keysToRemove = new ArrayList<>();



        try {
            BufferedReader reader = null;
            if (fileDirectory.exists()){
                reader = openReader("notInClass.txt");
                if (reader.readLine() == null){
                    reader = openReader("ogrencilistesi.txt");
                }
            } else {
                reader = openReader("ogrencilistesi.txt");
            }


            BufferedWriter writer = new BufferedWriter(new FileWriter("inclass.txt", true));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("notInClass.txt", true));

            HashMap<Integer, String> ogrenciList = new HashMap<>();

            String line;
            int currentNumber = 0;
            String currentStudent = null;

            while ((line = reader.readLine()) != null) {
                if (Character.isDigit(line.charAt(0))) {
                    currentNumber = Integer.parseInt(line);
                    currentNumber++; // Increment here
                } else {
                    currentStudent = line;
                    ogrenciList.put(currentNumber, currentStudent);
                }
            }

            reader.close();
            System.out.println(ogrenciList);

            Random random = new Random();
            int c = 0;
            int i = ogrenciList.size();
            boolean isValid = false;

            while(!ogrenciList.isEmpty() && !isValid){
                int randomNumber = random.nextInt(1,61);

                while (!ogrenciList.containsKey(randomNumber)){
                    randomNumber = random.nextInt(1,61);
                }

                System.out.println(randomNumber);
                System.out.println(ogrenciList.get(randomNumber));

                System.out.println("Öğrenci derste mi?");
                System.out.println("1 -> Evet");
                System.out.println("2 -> Hayır");
                System.out.println("3 -> Çıkış Yap");
                System.out.print("Seçiniz: ");

                int selection = input.nextInt();

                switch (selection){
                    case 1:
                        keysToRemove.add(randomNumber);
                        writer.write(String.valueOf(randomNumber));
                        writer.write("\n");
                        writer.write(ogrenciList.get(randomNumber));
                        writer.write("\n");
                        c++;
                        break;
                    case 2:
                        System.out.println("Öğrenci derste değil. Tekrardan seçiyoruz.");
                        break;
                    case 3:
                        isValid =true;
                        break;
                    default:
            }


            }

            for (int key : keysToRemove) {
                ogrenciList.remove(key);
            }

            for (Integer integer: ogrenciList.keySet()){
                writer2.write(String.valueOf(integer));
                writer2.write("\n");
                writer2.write(ogrenciList.get(integer));
                writer2.write("\n");
                writer2.flush(); // Flush the writer

            }
            writer.close();
            writer2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedReader openReader(String fileName) throws FileNotFoundException {

        return new BufferedReader(new FileReader(fileName));
    }
}
