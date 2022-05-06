
/**
 * Decimal Scaling Normalization is a normalization technique that takes in data
 * and j and returns a normalized data by shifting the decimal point to the left
 * j places.
 *
 * @author Srujan Gurram
 * @version 1.0
 * @license MIT
 */

public class DecimalScalingNormalization {
    public static void main(String[] args) {
        DecimalScalingNormalization ds = new DecimalScalingNormalization();
        double[] data = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };
        double[] normalizedData = ds.Normalize(data, 3);
        for (double d : normalizedData) {
            System.out.printf("%.2f ", d);
        }
    }

    private double[] Normalize(double numArray[], int j) {
        double[] normalizedData = new double[numArray.length];
        for (int i = 0; i < numArray.length; i++) {
            double v = numArray[i] / Math.pow(10, j);
            normalizedData[i] = v;
        }
        return normalizedData;
    }
}
