import java.util.Arrays;

public class Binning {

    public static void main(String[] args) {
        Binning b = new Binning();
        double[] data = { 5, 10, 11, 13, 15, 35, 50, 55, 72, 92, 204, 215, 256 };

        double[] binnedDataByMean = b.BinData(data, 3, BinningType.Mean);
        System.out.println("Binned data by mean:");
        for (double d : binnedDataByMean) {
            System.out.printf("%.2f ", d);
        }

        double[] binnedDataByMedian = b.BinData(data, 3, BinningType.Median);
        System.out.println("\nBinned data by median:");
        for (double d : binnedDataByMedian) {
            System.out.printf("%.2f ", d);
        }

    }

    private enum BinningType {
        Mean, Median
    }

    private double[] BinData(double numArray[], int binSize, BinningType method) {
        Arrays.sort(numArray);
        double[] smoothenedData = new double[numArray.length];
        for (int i = 0; i < numArray.length; i += binSize) {

            // select current bin
            double[] bin = BinSelect(numArray, binSize, i);

            // get replacement value
            double replacement = 0.0;
            if (method == BinningType.Mean)
                replacement = Mean(bin);
            if (method == BinningType.Median)
                replacement = Median(bin);

            // replace values in current bin
            for (int j = 0; j < binSize; j++) {
                smoothenedData[i + j] += replacement;
            }
        }
        return smoothenedData;
    }

    private double[] BinSelect(double numArray[], int binSize, int i) {
        if (i + binSize < numArray.length) {
            return Arrays.copyOfRange(numArray, i, i + binSize);
        } else {
            return Arrays.copyOfRange(numArray, i, numArray.length);
        }
    }

    private double Mean(double numArray[]) {
        double sum = 0.0;
        for (double num : numArray)
            sum += num;
        return sum / numArray.length;
    }

    private double Median(double numArray[]) {
        Arrays.sort(numArray);
        if (numArray.length % 2 == 0) {
            return (numArray[numArray.length / 2 - 1] + numArray[numArray.length / 2]) / 2;
        } else {
            return numArray[numArray.length / 2];
        }
    }
}
