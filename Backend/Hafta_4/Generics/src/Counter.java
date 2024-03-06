public class Counter <T extends Number>{
    private T value;

    public Counter(T value){
        this.value = value;
    }

    public void run(){
        System.out.println("I am a number! " + this.value );
    }
}
