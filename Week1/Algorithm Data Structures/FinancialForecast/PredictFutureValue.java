public class PredictFutureValue {
    public static double futureValue(double principal, double rate, int periods) {
        if (periods == 0) {
            return principal;
        } else {
            return (1 + rate) * futureValue(principal, rate, periods - 1);
        }
    }

    public static void main(String[] args) {
        double principal = 1000.0;
        double rate = 0.05;
        int periods = 5;

        double forecast = futureValue(principal, rate, periods);

        System.out.println(String.format("Future Value after %d periods: %.2f", periods, forecast));
    }
}
