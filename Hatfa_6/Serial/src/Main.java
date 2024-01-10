import java.io.*;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("M5", "BMW");
        try {
            FileOutputStream fileOutput = new FileOutputStream("car.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput);
            objectOutputStream.writeObject(car1);
            fileOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileInput = new FileInputStream("car.txt");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            Car car2 = (Car) objectInput.readObject();
            System.out.println("Car name: " + car2.getName() + "\nCar Brand: " + car2.getBrand());
            objectInput.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}