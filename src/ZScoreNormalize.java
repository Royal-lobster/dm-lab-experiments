public class ZScoreNormalize {
    public static void main(String[] args) {
        ZScoreNormalize z = new ZScoreNormalize();
        double[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] normalizedData = z.Normalize(data);
        for (double d : normalizedData) {
            System.out.printf("%.2f ", d);
        }
    }

    private double[] Normalize(double numArray[]) {
        double[] normalizedData = new double[numArray.length];
        double mean = Mean(numArray);
        double stdDev = StandardDeviation(numArray);
        for (int i = 0; i < numArray.length; i++) {
            double v = (numArray[i] - mean) / stdDev;
            normalizedData[i] = v;
        }
        return normalizedData;
    }

    private double StandardDeviation(double numArray[]) {
        double sd = 0.0, mean = Mean(numArray);
        for (double num : numArray)
            sd += Math.pow(num - mean, 2);
        return Math.sqrt(sd / numArray.length);
    }

    private double Mean(double numArray[]) {
        double sum = 0.0;
        for (double num : numArray)
            sum += num;
        return sum / numArray.length;
    }
}
