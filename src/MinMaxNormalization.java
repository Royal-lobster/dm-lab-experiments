/**
 * Min Max Normalization is a normalization technique that normalizes the data
 * to have a new minimum value and a new maximum value and scales data linearly
 *
 * @author Srujan Gurram
 * @version 1.0
 * @license MIT
 */

public class MinMaxNormalization {
    public static void main(String[] args) {
        MinMaxNormalization m = new MinMaxNormalization();
        double[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] normalizedData = m.Normalize(data, 0, 1);
        for (double d : normalizedData) {
            System.out.printf("%.2f ", d);
        }
    }

    private double[] Normalize(double numArray[], double new_min, double new_max) {
        double[] normalizedData = new double[numArray.length];
        double min = Min(numArray);
        double max = Max(numArray);
        for (int i = 0; i < numArray.length; i++) {
            double v = (numArray[i] - min) / (max - min) * (new_max - new_min) + new_min;
            normalizedData[i] = v;
        }
        return normalizedData;
    }

    private double Min(double numArray[]) {
        double min = numArray[0];
        for (double num : numArray)
            if (num < min)
                min = num;
        return min;
    }

    private double Max(double numArray[]) {
        double max = numArray[0];
        for (double num : numArray)
            if (num > max)
                max = num;
        return max;
    }
}
