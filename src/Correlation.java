
/**
 * Correlation is a measure of the extent to which two variables are related.
 * 1 is a perfect positive correlation, -1 is a perfect negative correlation,
 * and 0 is no correlation between the two set of variables.
 * 
 * If the two data attributes are strongly correlated, then one of the data
 * attributes can be removed from the analysis.
 *
 * @author Srujan Gurram
 * @version 1.0
 * @license MIT
 */

public class Correlation {
    public static void main(String[] args) {
        Correlation c = new Correlation();
        double[] data1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] data2 = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };

        double correlation = c.correlationCoefficient(data1, data2);
        System.out.println("Correlation: " + correlation);
    }

    private double correlationCoefficient(double X[], double Y[]) {

        if (X.length != Y.length) {
            throw new IllegalArgumentException("X and Y must be the same length");
        }
        int N = X.length;
        double ΣX = 0, ΣY = 0, ΣXY = 0;
        double ΣXˆ2 = 0, ΣYˆ2 = 0;

        for (int i = 0; i < N; i++) {
            ΣX += X[i];
            ΣY += Y[i];
            ΣXY += X[i] * Y[i];
            ΣXˆ2 += X[i] * X[i];
            ΣYˆ2 += Y[i] * Y[i];
        }

        // use formula for calculating correlation coefficient.
        return (N * ΣXY - ΣX * ΣY)
                / (Math.sqrt((N * ΣXˆ2 - ΣX * ΣX) * (N * ΣYˆ2 - ΣY * ΣY)));

    }
}
