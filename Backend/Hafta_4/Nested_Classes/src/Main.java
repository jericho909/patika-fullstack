public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();

        //Outer.Inner inner = outer.new Inner();
        //inner.run();

        Outer.Inner.run();
        Local local = new Local();
        local.run();

        Anonymous anonymous = new Anonymous(){
            @Override
            public void run(){
                System.out.println("This is the anonymously written run method.");
                print();
            }

            public void print(){
                System.out.println("I am a run method created anonymously and can be only accessed from the anonymous" +
                        " code block. I cannot be called from the main block.");
            }
        };
        anonymous.run();
    }
}