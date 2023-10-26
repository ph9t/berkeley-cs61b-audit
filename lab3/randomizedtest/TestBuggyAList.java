package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> AL = new AListNoResizing<>();
        BuggyAList<Integer> ALBuggy = new BuggyAList<>();

        for (int x = 0; x < 3; x++) {
            AL.addLast(x);
            ALBuggy.addLast(x);
        }

        for (int x = 0; x < 3; x++) {
            assertEquals(AL.removeLast(), ALBuggy.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> AL = new AListNoResizing<>();
        BuggyAList<Integer> ALBuggy = new BuggyAList<>();

        // int N = 400;
        int N = 5000;

        for (int i = 0; i < N; i++) {
            // int operationNumber = StdRandom.uniform(0, 2);
            int operationNumber = StdRandom.uniform(0, 4);

            int correctReturn = 0;
            int buggyReturn = 0;

            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                AL.addLast(randVal);
                ALBuggy.addLast(randVal);
                // System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1 && AL.size() != 0) {
                correctReturn = AL.getLast();
                buggyReturn = ALBuggy.getLast();
                // System.out.println("getLast()");
            } else if (operationNumber == 2 && AL.size() != 0) {
                correctReturn = AL.removeLast();
                buggyReturn = ALBuggy.removeLast();
                // System.out.println("removeLast()");
            } else {
                int size = AL.size();
                // System.out.println("size: " + size);
            }

            assertEquals(correctReturn, buggyReturn);
        }
    }
}
