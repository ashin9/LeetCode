package LCGo;

public class convertTemperature {
    public static void main(String[] args) {

    }

    public double[] convertTemperature(double celsius) {
        /*double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] = celsius * 1.80 + 32.00;
        return ans;*/
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
