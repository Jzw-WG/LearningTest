public class ExtendsTest {
    /**
    * Father
    */
    public static class Father {
        public void A() {
                System.out.println("BaBa!_A");
        }
        
    }

    /**
     * Son
     */
    public static class Son extends Father{
        @Override
        public void A() {
            System.out.println("ErZi!_A");
        }

        public void B() {
            System.out.println("ErZi!_B");
        }
        
    }

    /**
     * Daughter extends Father
     */
    public class Daughter extends Father {
        @Override
        public void A() {
            System.out.println("NvEr!_A");
        }

        public void C() {
            System.out.println("Nver!_C");
        }
        
    }

    /***
     * Name
     * @param f
     */
    public static void Name(Father f) {
        f.A();
    }
    public static void main(String[] args) {
        ExtendsTest.Son f = new ExtendsTest.Son();
        f.A();
        Name(f);
        // f = (Father) f;
        f.A();
    }
}

