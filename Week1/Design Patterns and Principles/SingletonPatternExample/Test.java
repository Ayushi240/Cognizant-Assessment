public class Test {
    public static void main(String[] arg){
        Logger lg1 = Logger.getInstance();
        lg1.printMessage("First Message");

        Logger lg2 = Logger.getInstance();
        lg2.printMessage("Second Message");

        if(lg1 == lg2){
            System.out.println("Only one instance exist.");
        }
        else{
            System.out.println("Multiple instance detected.");
        }
    }
}
