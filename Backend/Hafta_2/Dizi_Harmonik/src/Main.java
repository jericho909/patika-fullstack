public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        harmonicMean(numbers);
    }

    public static void harmonicMean(int[] arr){
        double harmonicMean = 0;

        for (int i: arr) {
            harmonicMean += 1.0 / i;
        }
        System.out.println("Dizinin harmonik ortalaması: " + arr.length / harmonicMean);
    }

}