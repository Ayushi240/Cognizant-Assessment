public class Logger {
//   creating static instance of a class
    private static Logger instance;
    private Logger() {
        System.out.println("Logger initialized!");
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void printMessage(String msg){
        System.out.println(msg);
    }
}
