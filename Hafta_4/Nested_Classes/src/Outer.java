public class Outer {
    public int a = 5;

    public static class Inner {
        public int a = 10;

        public static void run(){
            int a = 1;
            System.out.println("I am printed from an inner class!");
            System.out.println("This is the value of a in this method: " + a);
            //System.out.println("This the value of a in the Inner class: " + this.a);
            //System.out.println("This is the value of a in the Outer class: " + Outer.this.a);
            //Inner_2 inner2 = new Inner_2();
            //int inner2a = inner2.getA();
        }

        public class Inner_2 {
            public int a = 25;

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }
        }
    }

    public void run(){
        System.out.println("I am creating an inner class object and calling the inner class method," +
                " even though I am a method of the Outer class!");

        Inner.run();
    }
}
