
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

        int n = X.length;
        double sum_X = 0, sum_Y = 0, sum_XY = 0;
        double squareSum_X = 0, squareSum_Y = 0;

        for (int i = 0; i < n; i++) {
            // sum of elements of array X.
            sum_X = sum_X + X[i];

            // sum of elements of array Y.
            sum_Y = sum_Y + Y[i];

            // sum of X[i] * Y[i].
            sum_XY = sum_XY + X[i] * Y[i];

            // sum of square of array elements.
            squareSum_X = squareSum_X + X[i] * X[i];
            squareSum_Y = squareSum_Y + Y[i] * Y[i];
        }

        // use formula for calculating correlation coefficient.
        double corr = (double) (n * sum_XY - sum_X * sum_Y) /
                (double) (Math.sqrt((n * squareSum_X - sum_X * sum_X) * (n * squareSum_Y - sum_Y * sum_Y)));

        return corr;
    }
}
