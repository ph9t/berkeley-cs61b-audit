/** Class that prints the Collatz sequence starting from a given number.
 *  @author Dachen Gao
 */
public class Collatz {
    /** Buggy implementation of nextNumber! */
    /*
    public static int nextNumber(int n) {
        return n % 2 == 0 ? n/2 : 3*n + 1;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
    */

    /** Identifies next number in a Collatz sequence, given N
     * @param number the nth number
     * */
    public static int nextNumber(int number) {
        boolean isEven = (number % 2 == 0);
        return  isEven ? (number / 2) : (3 * number + 1);
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.print(n + " ");

        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }

        System.out.println();
    }

}

