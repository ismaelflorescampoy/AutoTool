package utilities;

import java.util.*;
/**
 *
 * @author ismael.flores
 */
public class CodeChef {

    private static boolean isValid(int d, int m, int y) {
        if (d < 1 || d > 31 || m < 1 || m > 12 || y > 2099)
            return false;
        if (m == 2) {
            if (d > 29)
                return false;
            if (d == 29 && !isLeapYear(y))
                return false;
        }
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            if (d > 30)
                return false;
        }
        return true;
    }

    private static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    /*
     * Tonmoy has a special torch. The torch has 4 levels numbered 1 to 4 and 2 states ("On" and "Off"). 
     * Levels 1, 2, and 3 correspond to the "On" state while level 4 corresponds to the "Off" state.
     * The levels of the torch can be changed as:
     * 
     * Level 1 changes to level 2.
     * Level 2 changes to level 3.
     * Level 3 changes to level 4.
     * Level 4 changes to level 1.
     * 
     * Given the initial state as KK and the number of changes made in the levels as N, find the final state of the torch. 
     * If the final state cannot be determined, print "Ambiguous" instead.
     * 
     * Input Format:
     * First line will contain T, the number of test cases. Then the test cases follow.
     * Each test case contains of a single line of input, two integers N, K - the number of changes made in the levels and initial state of the torch. 
     * Here, K = 0 denotes "Off" state while K = 1 denotes "On" state.
     * 
     * Output Format:
     * For each test case, output in a single line, the final state of the torch, i.e. "On" or "Off". 
     * If the final state cannot be determined, print "Ambiguous" instead.
     * You may print each character of the string in uppercase or lowercase (for example, the strings "On", "ON", "on" and "oN" will all be treated as identical).
     * 
     * Constraints
     * 1 <= T <= 10^5 
     * 0 <= N <= 10^9
     * 0 <= K <= 1
     */
    public static void solveCodeChefDARLIG() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            int K = scn.nextInt();
            if (K == 0)
                K = (N % 4 == 0) ? 0 : 1;
            else
                K = (N % 4 == 0) ? 1 : -1;
            switch (K) {
                case 0:
                    System.out.println("Off");
                    break;
                case 1:
                    System.out.println("On");
                    break;
                default:
                    System.out.println("Ambiguous");
                    break;
            }
        }
        scn.close();
    }

    public static void solveCodeChefDDMMORMMDD() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            int D = Integer.parseInt(S.substring(0, 2));
            int M = Integer.parseInt(S.substring(3, 5));
            int Y = Integer.parseInt(S.substring(6, 10));
            boolean validDDMMYYY = isValid(D, M, Y);
            boolean validMMDDYYY = isValid(M, D, Y);
            if (validDDMMYYY && validMMDDYYY)
                System.out.println("BOTH");
            else if (validDDMMYYY)
                System.out.println("DD/MM/YYYY");
            else if (validMMDDYYY)
                System.out.println("MM/DD/YYYY");
        }
        scn.close();
    }

    public static void solveCodeChefONP() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            Stack<String> val = new Stack<>();
            Stack<Character> op = new Stack<>();
            for (char c : S.toCharArray()) {
                switch (c) {
                    case '(':
                        break;
                    case '*':
                    case '-':
                    case '+':
                    case '/':
                    case '^':
                        op.push(c);
                        break;
                    case ')':
                        String polish = val.pop();
                        polish = val.pop() + polish + op.pop();
                        val.push(polish);
                        break;
                    default:
                        val.push(Character.toString(c));
                        break;
                }
            }
            System.out.println(val.pop());
        }
        scn.close();
    }
    
    public static void solveCodeChefXOREQUAL() {
        Scanner scn = new Scanner(System.in);

        // Precalculate all 2^N [0 <= N < 100000]
        long[] p = new long [100000];
        p[0] = 1;
        for (int i = 1; i < 100000; i++)
            p[i] = (p[i - 1] * 2) % 1000000007;

        long T = scn.nextLong(); 
        while (T-- > 0) {
            int N = scn.nextInt();
            System.out.println(p[N - 1]);
        }
        scn.close();
    }

    public static void solveCodeChefLUCKYFR() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            long count4s = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '4')
                    count4s++;
            }
            System.out.println(count4s);
        }
        scn.close();
    }

    public static void solveCodeChefAVG() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long V = scn.nextLong();
            long sum = 0;
            for (long i = 0; i < N; i++)
                sum += scn.nextLong();
            // (sum + K * n) / (K + N) = V
            long remain = V * (K + N) - sum;
            System.out.println(((remain % K) != 0 || remain <= 0) ? -1 : remain / K);
        }
        scn.close();
    }

    public static void solveCodeChefMAXFUN() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong() - 3;
            long Ax = scn.nextLong();
            long Ay = scn.nextLong();
            long Az = scn.nextLong();
            long actual = Math.abs(Ax - Ay) + Math.abs(Ax - Az) + Math.abs(Ay - Az);
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                long nActual = Math.abs(Ai - Ay) + Math.abs(Ai - Az) + Math.abs(Ay - Az);
                if (nActual > actual) {
                    actual = nActual;
                    Ax = Ai;
                }
                nActual = Math.abs(Ax - Ai) + Math.abs(Ax - Az) + Math.abs(Ai - Az);
                if (nActual > actual) {
                    actual = nActual;
                    Ay = Ai;
                }
                nActual = Math.abs(Ax - Ay) + Math.abs(Ax - Ai) + Math.abs(Ay - Ai);
                if (nActual > actual) {
                    actual = nActual;
                    Az = Ai;
                }
            }
            System.out.println(actual);
        }
        scn.close();
    }
    
    public static void solveCodeChefMXENVSUB() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long sum = (N * (N + 1)) / 2;
            if (sum % 2 == 1)
                N--;
            System.out.println(N);
        }
        scn.close();
    }
    
    public static void solveCodeChefPOPCORN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A1 = scn.nextLong();
            long A2 = scn.nextLong();
            long B1 = scn.nextLong();
            long B2 = scn.nextLong();
            long C1 = scn.nextLong();
            long C2 = scn.nextLong();
            System.out.println(Math.max(C1 + C2, Math.max(A1 + A2, B1 + B2)));
        }
        scn.close();
    }

    public static void solveCodeChefFRGAME() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long C = scn.nextLong();
            long D = scn.nextLong();
            if (A < B)
                A = A + C;
            else
                B = B + C;
            if (A < B)
                A = A + D;
            else
                B = B + D;
            System.out.println(A >= B ? "N" : "S");
        }
        scn.close();
    }    
    
    public static void solveCodeChefBALLBOX() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long min = K * (K + 1) / 2;
            System.out.println(N >= min ? "YES" : "NO");
        }        
        scn.close();
    }
    
    public static void solveCodeChefKEPLERSLAW() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long T1 = scn.nextLong();
            long T2 = scn.nextLong();
            long R1 = scn.nextLong();
            long R2 = scn.nextLong();
            boolean keplerok = (R2 * R2 * R2) * (T1 * T1) == (R1 * R1 * R1) * (T2 * T2);
            System.out.println(keplerok ? "YES" : "NO");
        }        
        scn.close();
    }    
}
