public class Local {
    public void run(){

        class LocalOfLocal{
            private int a;
            public LocalOfLocal(int a) {
                this.a = a;
            }

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }
        }
        LocalOfLocal localoflocal = new LocalOfLocal(15);
        System.out.println("Local class of the local method has been created with the value of: " + localoflocal.getA());
        System.out.println("Local method has been run.");
    }
}
