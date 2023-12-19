public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        double harmonicMean = 0;

        for (int i: numbers) {
            harmonicMean += 1.0 / i;
        }
        System.out.println(numbers.length / harmonicMean);
    }


}