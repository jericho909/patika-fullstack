public class CalculatorException extends Exception{
    public CalculatorException(String message) {
        super(message);
        System.out.println("A calculator error has occurred:");
    }
}
