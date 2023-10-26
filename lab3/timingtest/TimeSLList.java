package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;
import sun.tools.tree.DoubleExpression;

import javax.naming.ldap.StartTlsRequest;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int n = 1000;
        while (n <= 64000) {
            Ns.addLast(n);
            SLList<Integer> SLListTest = new SLList<>();

            for (int x = 0; x < n; x++) {
                SLListTest.addLast(69);
            }

            Stopwatch sw = new Stopwatch();
            for (int x = 0; x < 10000; x++) {
                SLListTest.getLast();
            }
            times.addLast(sw.elapsedTime());
            opCounts.addLast(10000);

            n = n * 2;
        }

        printTimingTable(Ns, times, opCounts);
    }
}
