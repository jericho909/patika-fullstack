public class MyCalculator {
    public static long power(int n, int p) throws CalculatorException{
        if (n < 0 || p < 0){
            throw new CalculatorException("n or p should not be negative");
        } else if (n == 0 && p == 0) {
            throw new CalculatorException("n and p should not be zero");
        } else {
            return (long) Math.pow(n,p);
        }
    }
}
