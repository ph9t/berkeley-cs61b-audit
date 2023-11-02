package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        int n = 1000;

        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> OpCounts = new AList<>();

        // while (n <= 128000) {
        while (n <= 10000000) {
            Ns.addLast(n);

            Stopwatch sw = new Stopwatch();
            int count = 0;

            AList<Integer> AListTest = new AList<>();

            for (int i = 0; i < n; i++) {
                AListTest.addLast(69);
                count = count + 1;
            }

            OpCounts.addLast(count);
            times.addLast(sw.elapsedTime());

            n = n * 2;
        }
        printTimingTable(Ns, times, OpCounts);
    }
}
