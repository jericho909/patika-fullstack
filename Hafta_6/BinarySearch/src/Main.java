public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 9));
    }

    private static int binarySearch(int[] array, int numberToSearch){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int middlePoint = (low + high) / 2;
            int middleNumber = array[middlePoint];

            if (middleNumber == numberToSearch){
                return middlePoint;
            }
            if (numberToSearch < middleNumber){
                high = middlePoint - 1;
            } else {
                low = middlePoint + 1;
            }
        }

        return -1;
    }
}