package utilities;

import java.util.*;
import java.lang.reflect.*;

/**
 * @class CodeChef 
 * @brief A library of solutions for CodeChef problems. All function names must start with 'solveCodeChef'
 * @author ismael.flores
 */
public class CodeChef {

    /**
    * Problem:
    * CodeChef offers a feature called streak count. A streak is maintained if you solve at least one problem daily.
    * Om and Addy actively maintain their streaks on CodeChef. Over a span of N consecutive days, 
    * you have observed the count of problems solved by each of them.
    * Your task is to determine the maximum streak achieved by Om and Addy and find who had the longer maximum streak.
    
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of multiple lines of input.
    * The first line of each test case contains an integer N denoting the number of days.
    * The second line of each test case contains N space-separated integers, 
    * the ith of which is Ai, representing the problems solved by Om on the ith day.
    * The third line of each test case contains N space-separated integers, 
    * the ith of which is Bi, representing the problems solved by Addy on the ith day.
    * 
    * Output Format:
    * For each test case, output:
    * OM, if Om has longer maximum streak than Addy;
    * ADDY, if Addy has longer maximum streak than Om;
    * DRAW, if both have equal maximum streak.
    *
    * You may print each character in uppercase or lowercase. For example, OM, om, Om, and oM, are all considered the same.
    * 
    * Constraints:
    * 1 <= T <= 10^5
    * 1 <= N <= 10^5
    * 0 <= Ai, Bi <= 10^9
    * 
    * The sum of N over all test cases won't exceed 6*10^5
    */
    public static void solveCodeChefCS2023_STK() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            int streakA = 0;
            int streakB = 0;
            int maxStreakA = 0;
            int maxStreakB = 0;
            for (long i = 0; i < N; i++) {
                if (scn.nextLong() > 0)
                    streakA++;
                else
                    streakA = 0;
                maxStreakA = Math.max(maxStreakA, streakA);
            }
            for (long i = 0; i < N; i++) {
                if (scn.nextLong() > 0)
                    streakB++;
                else
                    streakB = 0;
                maxStreakB = Math.max(maxStreakB, streakB);
            }
            if (maxStreakA > maxStreakB)
                System.out.println("OM");
            else if (maxStreakA < maxStreakB)
                System.out.println("ADDY");
            else
                System.out.println("DRAW");
        }
        scn.close();
    }

    /**
     * Problem:
     * Chef is going on a road trip and needs to apply for inter-district and inter-state travel e-passes. 
     * It takes A minutes to fill each inter-district e-pass application and B minutes for each inter-state e-pass application.
     * His journey is given to you as a binary string S of length N where 0 denotes crossing from one district to another district 
     * (which needs an inter-district e-pass), and a 1 denotes crossing from one state to another (which needs an inter-state e-pass).
     * Find the total time Chef has to spend on filling the various forms.
     * 
     * Input Format:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * Each test case contains two lines of input. First line contains three space separated integers N, A and B.
     * Second line contains the string S.
     * 
     * Output Format:
     * For each testcase, output in a single line the total time Chef has to spend on filling the various forms for his journey.
     * 
     * Constraints:
     * 1 <= T <= 10^2
     * 1 <= N, A, B <= 10^2
     * Si is '0' or '1'
     */
    public static void solveCodeChefTRAVELPS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            scn.nextLong();
            long A = scn.nextLong();
            long B = scn.nextLong();
            String S = scn.next();
            long count = 0;
            for (char c : S.toCharArray())
                count += (c == '0') ? A : B;
            System.out.println(count);
        }
        scn.close();
    }

    /** 
     * Problem:
     * Chef is playing Need For Speed. Currently, 
     * his car is running on a straight road with a velocity U metres per second and approaching a 90 degrees turn which is S metres away from him.
     * To successfully cross the turn, velocity of the car when entering the turn must not exceed V metres per second.
     * The brakes of Chef's car allow him to slow down with a deceleration (negative acceleration) not exceeding A metres per squared second. 
     * Tell him whether he can cross the turn successfully. 
     * The velocity v when entering the turn can be determined from Newton's 2nd law to be 
     * v^2 = U^2 + 2 . a . S if the car is moving with a uniform acceleration a.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains four space-separated integers U, V, A and S.
     * 
     * Output:
     * For each test case, print a single line containing the string "Yes" if Chef can cross the turn successfully or "No" if he cannot (without quotes).
     * You may print each character of each string in uppercase or lowercase (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= U, V, A, S <= 10^4
     */
    public static void solveCodeChefNFS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long U = scn.nextLong();
            long V = scn.nextLong();
            long A = scn.nextLong();
            long S = scn.nextLong();
            System.out.println((U * U - 2 * A * S <= V * V) ? "Yes" : "No");
        }
        scn.close();
    }

    /**
     * Problem:
     * Tonmoy has a special torch. The torch has 4 levels numbered 1 to 4 and 2 states ("On" and "Off"). 
     * Levels 1, 2, and 3 correspond to the "On" state while level 4 corresponds to the "Off" state.
     * The levels of the torch can be changed as:
     * 
     * Level 1 changes to level 2.
     * Level 2 changes to level 3.
     * Level 3 changes to level 4.
     * Level 4 changes to level 1.
     * 
     * Given the initial state as K and the number of changes made in the levels as N, find the final state of the torch. 
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

    /**
     * Problem:
     * Chef is confused by all the different formats dates can be written in. 
     * Here's a simple problem Chef wants you to solve.
     * You are given a date string S. 
     * The date follows the Gregorian calendar, the one used in most parts of the world.
     * Identify whether it is of the form DD/MM/YYYY or MM/DD/YYYY, or if it can be of both forms.
     * Here D denotes the 2-digit day, MM denotes the 2-digit month and YYYY denotes the 4-digit year.
     * It is guaranteed that S is a valid date taking at least one of these forms.
     * 
     * For example,
     * 
     * 21/05/2001 is of the form DD/MM/YYYY and not MM/DD/YYYY.
     * 10/15/2069 is of the form MM/DD/YYYY and not DD/MM/YYYY.
     * 05/11/1999 can be of both forms.
     * 
     * Input Format:
     * The first line contains a single integer T — the number of test cases. Then the test cases follow.
     * Each test case consists of a single line containing a string of 10 characters S — the date string S, 
     * which is of the form DD/MM/YYYY or MM/DD/YYYY. 
     * It is guaranteed that S is a valid date taking at least one of these forms.
     * 
     * Output Format:
     * For each test case, output "BOTH" if the date string satisfies both forms.
     * Otherwise output "DD/MM/YYYY" if it is of the form DD/MM/YYYY, else "MM/DD/YYYY".
     * Note that the output may be case-insensitive. So "DD/MM/YYYY", "dd/mm/yyyy" and so on will be considered the same.
     * 
     * Constraints:
     * 1 <= T <= 2023
     * S is of the form DD/MM/YYYY or MM/DD/YYYY
     */
    public static void solveCodeChefDDMMORMMDD() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            int D = Integer.parseInt(S.substring(0, 2));
            int M = Integer.parseInt(S.substring(3, 5));
            int Y = Integer.parseInt(S.substring(6, 10));
            boolean validDDMMYYY = CodeChefLibrary.isValid(D, M, Y);
            boolean validMMDDYYY = CodeChefLibrary.isValid(M, D, Y);
            if (validDDMMYYY && validMMDDYYY)
                System.out.println("BOTH");
            else if (validDDMMYYY)
                System.out.println("DD/MM/YYYY");
            else if (validMMDDYYY)
                System.out.println("MM/DD/YYYY");
        }
        scn.close();
    }

    /**
     * Problem:
     * Reverse Polish Notation (RPN) is a mathematical notation where every operator follows all of its operands.
     * For instance, to add three and four, one would write "3 4 +" rather than "3 + 4".
     * If there are multiple operations, the operator is given immediately after its second operand; 
     * so the expression written "3 − 4 + 5" would be written "3 4 − 5 +" first subtract 4 from 3, then add 5 to that.
     * Transform the algebraic expression with brackets into RPN form.
     * You can assume that for the test cases below only single letters will be used,
     * brackets [] will not be used and each expression has only one RPN form (no expressions like a*b*c)
     * 
     * Input Format:
     * The first line contains t, the number of test cases (less then 100).
     * Followed by t lines, containing an expression to be translated to RPN form, 
     * where the length of the expression is less then 400.
     * 
     * Output Format:
     * The expressions in RPN form, one per line.
     */
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
    
    /**
     * Problem:
     * Read problem statements in Bengali, Mandarin Chinese, Russian, and Vietnamese as well.
     * For a given N, find the number of ways to choose an integer x from the range [0, 2^N - 1] 
     * such that x⊕(x+1) = (x+2)⊕(x+3), where ⊕ denotes the bitwise XOR operator.
     * Since the number of valid x can be large, output it modulo 10^9+7
     * 
     * Input:
     * The first line contains an integer T, the number of test cases. Then the test cases follow.
     * The only line of each test case contains a single integer N.
     * 
     * Output: 
     * For each test case, output in a single line the answer to the problem modulo 10^9+7
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 10^5
     */
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

    /*
     * Problem:
     * Karan likes the number 4 very much.
     * Impressed by the power of this number, Karan has begun to look for occurrences of four anywhere. 
     * He has a list of T integers, for each of them he wants to calculate the number of occurrences of
     * the digit 4 in the decimal representation. He is too busy now, so please help him.
     * 
     * Input Format:
     * The first line of input consists of a single integer T, denoting the number of integers in Karan's list.
     * Then, there are T lines, each of them contain a single integer from the list.
     * 
     * Output Format:
     * Output T lines. Each of these lines should contain the number of occurrences of the digit 4 
     * in the respective integer from Karan's list.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     */
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

    /*
     * Problem:
     * Chef had a sequence of positive integers with length N + K. 
     * He managed to calculate the arithmetic average of all elements of this sequence (let's denote it by V), 
     * but then, his little brother deleted K elements from it. All deleted elements had the same value.
     * Chef still knows the remaining N elements — a sequence A1, A2, ..., AN. 
     * Help him with restoring the original sequence by finding the value of the deleted elements 
     * or deciding that there is some mistake and the described scenario is impossible.
     * Note that the if it is possible for the deleted elements to have the same value, 
     * then it can be proven that it is unique. Also note that this value must be a positive integer.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains three space-separated integers N, K and V.
     * The second line contains N space-separated integers A1, A2, ..., AN.
     * 
     * Output:
     * For each test case, print a single line containing one integer — 
     * the value of the deleted elements, or -1 if there is a mistake.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N, K <= 100
     * 1 <= V <= 10^5
     * 1 <= Ai <= 10^5 for each valid i
     */
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

    /*
     * Problem:
     * You are given a sequence A1, A2, ..., AN. 
     * Find the maximum value of the expression |Ax - Ay| + |Ay - Az| + |Az - Ax|
     * over all triples of pairwise distinct valid indices (x, y, z).
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains a single integer N.
     * The second line contains N space-separated integers A1, A2, ..., AN.
     * 
     * Output:
     * For each test case, print a single line containing one integer ― 
     * the maximum value of |Ax - Ay| + |Ay - Az| + |Az - Ax|.
     * 
     * Constraints:
     * 1 <= T <= 5
     * 3 <= N <= 10^5
     * |Ai| <= 10^9 for each valid i
     */
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
    
    /*
     * Problem:
     * Vishesh has gone to watch the new Spider-Man movie, 
     * but he is having troubles choosing which Popcorn-and-Coke combo to buy.
     * There are three combos A, B, and C available at the counter. 
     * You are given the time (in minute) for which each Popcorn bucket and Coke cup lasts. 
     * Given that Vishesh's satisfaction from a combo is defined as the total lasting time (in minute) 
     * of the Popcorn bucket and the Coke cup, 
     * find the maximum satisfaction he can get by buying a single combo.
     * 
     * Input Format:
     * The first line of each input contains T - the number of test cases. 
     * The test cases then follow.
     * The first line of each test case contains two space-separated integers A1 and A2, 
     * meaning that for combo A, the Popcorn bucket lasts A1 minutes and the Coke cup lasts A2 minutes.
     * The second line of each test case contains two space-separated integers B1 and B2, 
     * meaning that for combo B, the Popcorn bucket lasts B1 minutes and the Coke cup lasts B2 minutes.
     * The third line of each test case contains two space-separated integers C1 and C2, 
     * meaning that for combo C, the Popcorn bucket lasts C1 minutes and the Coke cup lasts C2 minutes.
     * 
     * Output Format:
     * For each test case, output on a single line the maximum satisfaction Vishesh can get.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= A1, A2, B1, B2, C1, C2 <= 10^9
     */
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

    /*
     * Problem:
     * Nitin and Sobhagya were playing a game with coins. 
     * If Sobhagya has more coins then he is winning, otherwise Nitin is winning. 
     * Note that this means if both Nitin and Sobhagya have the same number of coins, then Nitin is winning.
     * Initially Nitin has A coins while Sobhagya has B coins. 
     * Then Ritik came and gave his C coins to the player who is not winning currently, 
     * after which Satyarth came and repeated the same process 
     * (gave his D coins to the player who is not winning currently).
     * Find the final winner of the game.
     * 
     * Input Format:
     * The first line of the input contains an integer T - 
     * the number of test cases. The test cases then follow.
     * The only line of each test case contains four space-separated integers A, B, C, and D.
     * 
     * Output Format:
     * For each test case, output on a single line N if Nitin is the final winner of the game, 
     * or S if Sobhagya is the final winner of the game.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 0 <= A, B, C, D <= 10^6
     */
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
    
    /*
     * Problem:
     * You have N balls and K boxes. You want to divide the N balls into K boxes such that:
     * Each box contains >= 1 balls.
     * No two boxes contain the same number of balls.
     * Determine if it is possible to do so.
     * 
     * Input Format:
     * The first line contains a single integer T — the number of test cases. 
     * Then the test cases follow.
     * The first and only line of each test case contains two space-separated integers N and K — 
     * the number of balls and the number of boxes respectively.
     * 
     * Output Format:
     * For each test case, output YES if it is possible to divide the N balls into K boxes 
     * such that the conditions are satisfied. Otherwise, output NO.
     * You may print each character of YES and NO in uppercase or lowercase 
     * (for example, yes, yEs, Yes will be considered identical).
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 10^9
     * 1 <= K <= 10^4
     */
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
    
    /*
     * Problem:
     * Kepler’s Law states that the planets move around the sun in elliptical orbits with the sun at one focus.
     * Kepler's 3rd law is The Law of Periods, according to which:
     * The square of the time period of the planet is directly proportional 
     * to the cube of the semimajor axis of its orbit.
     * You are given the Time periods (T1, T2) and Semimajor Axes (R1, R2) of two planets orbiting the same star.
     * Please determine if the Law of Periods is satisfied or not, 
     * i.e, if the constant of proportionality of both planets is the same.
     * Print "Yes" (without quotes) if the law is satisfied, else print "No".
     * 
     * Input Format:
     * The first line of input contains a single integer T, denoting the number of test cases.
     * The description of T test cases follows.
     * Each test case consists a single line of input, containing four space-separated integers T1, T2, R1, R2.
     * 
     * Output Format:
     * For each test case, output a single line containing one string — "Yes" or "No" (without quotes); 
     * the answer to the problem.
     * You may print each character of the answer in uppercase or lowercase 
     * (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= T1, T2 <= 10
     * 1 <= R1, R2 <= 10
     */
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

    /*
     * Problem:
     * Finally, a COVID vaccine is out on the market and the Chefland government has asked you to form a plan to distribute it to the public as soon as possible. 
     * There are a total of N people with ages a1, a2, ..., aN.
     * There is only one hospital where vaccination is done and it is only possible to vaccinate up to D people per day. 
     * Anyone whose age is >= 80 or <= 9 is considered to be at risk. 
     * On each day, you may not vaccinate both a person who is at risk and a person who is not at risk. 
     * Find the smallest number of days needed to vaccinate everyone.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first line of each test case contains two space-separated integers N and D.
     * The second line contains N space-separated integers a1, a2, ..., aN.
     * 
     * Output:
     * For each test case, print a single line containing one integer ― the smallest required number of days.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 10^4
     * 1 <= D <= 10^5
     * 1 <= ai <= 100 for each valid i
     */
    public static void solveCodeChefVACCINE2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long D = scn.nextLong();
            long atRisk = 0;
            for (long i = 0; i < N; i++) {
                long A = scn.nextLong();
                if (A >= 80 || A <= 9)
                    atRisk++;
            }
            long atNoRisk = N - atRisk;
            long daysAtRisk = atRisk / D + (atRisk % D == 0 ? 0 : 1);
            long daysAtNoRisk = atNoRisk / D + (atNoRisk % D == 0 ? 0 : 1);
            System.out.println(daysAtRisk + daysAtNoRisk);
        }        
        scn.close();
    }
    
    /*
     * Problem:
     * CodeChef has just finished migrating to a new judging system.
     * Chef would like to test the performance of the new judging system.
     * Chef has some code for an older task, which he knows ran in X milliseconds on the old judging server.
     * On resubmitting the code to the new judging server, it ran in Y milliseconds.
     * Which judging system is faster?
     * 
     * Input Format:
     * The only line of input will contain two space-separated integers X and Y — 
     * the runtime on the old judging system, and the runtime on the new judging system.
     * 
     * Output Format:
     * Print:
     * Old, if the older judging system is faster
     * New, if the new judging system is faster
     * Same, if they're equally fast
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings Old, OlD, old, oLD will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= X, Y <= 3000
     */
    public static void solveCodeChefNEWCC() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        if (X < Y)             
            System.out.println("Old");
        else if (X > Y)
            System.out.println("New");
        else
            System.out.println("Same");
        scn.close();
    }

    /*
     * Problem:
     * Chef has a special ability: he can use both his left and right hands equally well, and at the same time!
     * To put this ability into practice, Chef decides that he's going to write a novel with his left hand, 
     * while writing code with his right.
     * Chef needs L minutes to write a page with his left hand, 
     * and R minutes to write a line of code with his right.
     * Chef defines his satisfaction to be the number of pages he's started writing, 
     * plus the number of lines of code he's finished writing.
     * What will Chef's satisfaction be after M minutes?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case will contain three space-separated integers L, R, and M — 
     * Chef writing speed, coding speed, and the number of minutes he has.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: Chef's satisfaction after M minutes.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= L, R, M <= 10^6
     */
    public static void solveCodeChefAMBIDEXTROUS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long L = scn.nextLong();
            long R = scn.nextLong();
            long M = scn.nextLong();
            long satisfaction = M / L + (M % L != 0 ? 1 : 0) + M / R;
            System.out.println(satisfaction);
        }        
        scn.close();
    }

    /*
     * Problem:
     * A new patisserie has opened up to rave reviews. 
     * You, in your quest for deliciousness, are going to visit it.
     * The patisserie has N pastries. With your trained eye, 
     * you judge that the ii-th of them has deliciousness Ai.
     * Of course, you want to eat pastries whose total deliciousness is as high as possible. 
     * Unfortunately, you can't just buy everything out.
     * There are K customers in the store, including you. 
     * They form a queue to order pastries, of which you're the L-th person.
     * Each customer, including you, will do the following:
     * Among the remaining pastries, buy the one with the highest deliciousness.
     * Then, move to the back of the queue.
     * This will repeat till all the pastries are sold out.
     * What's the total deliciousness of the pastries you buy?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains three space-separated integers N, K, and L — 
     * the number of pastries, the number of people, and your initial position in the queue.
     * The second line contains N space-separated integers A1, A2, ..., AN — the deliciousness of the pastries.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: the total deliciousness of the pastries you buy.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= L <= K <= N <= 2*10^5
     * 1 <= Ai <= 10^9
     * The sum of N across all tests won't exceed 2*10^5
     */
    public static void solveCodeChefKDELI() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            ArrayList<Long> deliciouness = new ArrayList<>();
            long N = scn.nextLong();
            long K = scn.nextLong();
            long L = scn.nextLong();
            for (int i = 0; i < N; i++)
                deliciouness.add(scn.nextLong());
            Collections.sort(deliciouness);
            Collections.reverse(deliciouness);
            long buy = 0;
            for (int i = 0; i < N; i++) {
                if (i % K == L - 1)
                    buy += deliciouness.get(i);
            }
            System.out.println(buy);            
        }
        scn.close();
    }
  
    /**
     * Problem:
     * You want to create an Online Judge like Codechef - in fact, you decide to just copy Codechef as a whole!
     * Just like Codechef, you give your judge a name of length 88, given by the string S.
     * However, you're worried that people will find out that your judge is a copy — 
     * in particular, you think that if S and the string "codechef" have the same character at some position, 
     * people will find out.
     * For example, "rolldown" has "o" in the second position (just like "codechef"), 
     * and so wouldn't be a valid name. 
     * However, "fehcedoc" doesn't match with "codechef" at any position, and so is valid.
     * To avoid this happening, you'd like to instead rename your judge to an anagram of S.
     * Find any anagram of S that satisfies the condition, or say that none exist.
     * Note: An anagram of a string S is formed by simply rearranging the characters of S.
     * For example, "chefcode" and "occfedeh" are anagrams of "codechef", while "codeche" and "coderchef" are not.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains a single string S, of length 8.
     * 
     * Output Format:
     * For each test case, output on a new line the anagram you made.
     * If no valid anagram exists, print -1 instead.
     * If there are multiple possible answers, any of them will be accepted.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * |S| = 8
     * The string S contains only lowercase English letters, i.e, the characters 'a' to 'z'.
     */
    public static void solveCodeChefCC_COPY() {
        String codechef = "codechef";
        ArrayList<HashMap<Character, Integer>> fMapsCodechef = new ArrayList<>();
        for (int k = 0; k < codechef.length(); k++)
            fMapsCodechef.add(CodeChefLibrary.getFrequencyMap(codechef.substring(k)));
        fMapsCodechef.add(new HashMap<>());
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            String anagram = "";
            HashMap<String, HashMap<Character, Integer>> fMapsS = new HashMap<>();
            for (int i = 0; i < codechef.length(); i++) {
                for (int j = 0; j < S.length(); j++) {
                    if (codechef.charAt(i) != S.charAt(j)) {
                        String S1 = S.substring(j + 1);
                        HashMap<Character, Integer> f2 = null;
                        if (fMapsS.containsKey(S1))
                            f2 = fMapsS.get(S1);
                        else {
                            f2 = CodeChefLibrary.getFrequencyMap(S1);
                            fMapsS.put(S1, f2);
                        }
                        if (CodeChefLibrary.fits(codechef.length() - i - 1, fMapsCodechef.get(i + 1), f2)) {
                            anagram += S.charAt(j);
                            S = S.substring(0, j) + S.substring(j + 1);
                            j = S.length();
                        }
                    }
                }
            }
            System.out.println(anagram.length() == codechef.length() ? anagram : -1);
        }
        scn.close();        
    }
  
    /*
     * Problem:
     * Chef is judging a game called "Broken telephone". 
     * There are total N players taking part in the game. 
     * They are all sitting in a line. In the start of the game, 
     * first player is given a secret message written on a sheet of paper. 
     * Then they keep sending the message by whispering it to the player sitting immediate right to one 
     * and so on until it reaches the last person.
     * Finally, the message received by the last player is compared with the message said by first player.
     * If these messages aren't equal, there is someone who has misheard the message 
     * or whispered it wrongly to the next player. 
     * If messages is equal, then the players win and receive a tasty chocolate.
     * Note that first player receives the message on a sheet of paper, thus he cannot mishear it.
     * As Chef wants to be sure that every player has fulfilled his/ her role in the game, 
     * so he asks everyone to state their received messages after the end of the game. 
     * You are given an array A of N integers denoting messages received by each person.
     * Please help Chef to find the number of players that could mishear the message or whisper it wrongly.
     * 
     * Input:
     * The first line of the input contains an integer T denoting the number of test cases.
     * The first line of each test case contains a single integer N denoting the number of players
     * The second line contains N space-separated integers A1, A2, ..., AN denoting the messages of players.
     *
     * Output:
     * For each test case, output a single line containing an integer 
     * corresponding to the number of players that could mishear the message or whisper it wrongly.
     * 
     * Constraints and Subtasks:
     * 1 <= T <= 5
     * 1 <= Ai <= 10
     * Subtask 1: 40 points
     * 2 <= N <= 10^3
     * Subtask 2: 60 points
     * 2 <= N <= 10^5
     */
    public static void solveCodeChefBROKPHON() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long first = Long.MIN_VALUE;
            long second = Long.MIN_VALUE;
            long third = Long.MIN_VALUE;
            long count = 0;
            for (long i = 0; i < N; i++) {
                first = second;
                second = third;
                third = scn.nextLong();
                if (CodeChefLibrary.posibleMishear(first, second, third))
                    count++;
            }
            first = second;
            second = third;
            third = Long.MIN_VALUE;
            if (CodeChefLibrary.posibleMishear(first, second, third))
                count++;
            System.out.println(count);
        }        
        scn.close();
    }

    /*
     * Problem:
     * Chef considers the number 7 lucky. 
     * As a result, he believes that the 7-th letter he sees on a day is his lucky letter of the day.
     * 
     * You are given a string S of length 10, denoting the first 10 letters Chef saw today.
     * What is Chef's lucky letter?
     * 
     * Input Format:
     * The only line of input contains a string S, of length 10.
     * 
     * Output Format:
     * Print a single character: Chef's lucky letter.
     * 
     * Constraints:
     * S has a length of 10
     * S contains only lowercase Latin letters (i.e, the characters 'a' to 'z')
     */
    public static void solveCodeChefLUCKYSEVEN() {
        Scanner scn = new Scanner(System.in);
        String S = scn.next();
        System.out.println(S.charAt(6));
        scn.close();
    }

    /*
     * Problem:
     * Chef is playing a certain video game that requires him to collect Monsters, and use them to fight against other Monsters.
     * Chef's favorite Monster has an attack stat of X, and is fighting against another monster whose health stat is H.
     * The fight proceeds in turns: each turn, Chef's Monster does X damage to its opponent.
     * However, Chef's Monster has the ability Slow Start, which halves its attack for the first five turns.
     * That is, for the first five turns, the damage done to the opponent is X/2 and not X.
     * How many turns will Chef's Monster take to defeat the opponent (i.e, do at least H damage to it)?
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single line of input, containing two space-separated integers X and H, that is, 
     * Chef's Monster's attack, and the opponent's health.
     *
     * Output Format:
     * For each test case, output on a new line the number of turns required for the opponent to be defeated.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= X, H <= 1000
     * X is even
     */
    public static void solveCodeChefSLOWSTART() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long H = scn.nextLong();
            long X2 = X / 2;
            long halves = 5 * X2;
            if (H <= halves)
                System.out.println(H / X2 + (H % X2 == 0 ? 0 : 1));
            else {
                H -= halves;
                System.out.println(5 + H / X + (H % X == 0 ? 0 : 1));
            }
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef is playing a card game with his friend Rick Sanchez. He recently won against Rick's grandson Morty; 
     * however, Rick is not as easy to beat. The rules of this game are as follows:
     * - The power of a positive integer is the sum of digits of that integer. For example, the power of 13 is 1 + 3 = 4.
     * - Chef and Rick receive randomly generated positive integers. For each player, let's call the integer he received final power.
     * - The goal of each player is to generate a positive integer such that its power (defined above) is equal to his final power.
     * - The player who generated the integer with fewer digits wins the game. If both have the same number of digits, then Rick cheats and wins the game.
     *
     * You are given the final power of Chef Pc and the final power of Rick Pr. 
     * Assuming that both players play optimally, find the winner of the game and the number of digits of the integer he generates.
     *
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first and only line of each test case contains two space-separated integers Pc and Pr.
     *
     * Output:
     * For each test case, print a single line containing two space-separated integers. 
     * The first of these integers should be either 0 if Chef wins or 1 if Rick wins. 
     * The second integer should be the number of digits of the integer generated by the winner.
     * 
     * Constraints:
     *
     * 1 <= T <= 10^5
     * 1 <= Pc, Pr <= 10^6
     */
    public static void solveCodeChefCRDGAME3() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long Pc = scn.nextLong();
            long Pr = scn.nextLong();
            long Pcd = Pc / 9 + (Pc % 9 == 0 ? 0 : 1);
            long Prd = Pr / 9 + (Pr % 9 == 0 ? 0 : 1);
            System.out.println((Pcd < Prd ? 0 : 1) + " " + Math.min(Pcd, Prd));
        }
        scn.close();
    }
    
    /*
     * Problem:
     * In the light of G-20 summit, 
     * government has decided to keep the average air quality index (AQI) strictly below 100.
     * On some random day, Chef measures the AQI and found the value to be X.
     * Find whether the government was able to keep the AQI within limits.
     * 
     * Input Format:
     * The input consists of an integer X — the AQI Chef measured.
     * 
     * Output Format:
     * Output YES, if the government was able to keep the AQI within limits and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 150
     */
    public static void solveCodeChefAIRINDEX() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        scn.close();
        System.out.println(X < 100 ? "YES" : "NO");
    }
    
    /*
     * Problem:
     * Chefland consists of three countries named A, B and C.
     * Country A exports goods worth A1 units and imports goods worth A2 units.
     * Country B exports goods worth B1 units and imports goods worth B2 units.
     * A trade surplus occurs when a country exports strictly more than it imports.
     * Find whether country C is in trade surplus.
     * Note that the countries A,B,C trade only between themselves.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of four space-separated integers A1, A2, B1 and B2 — 
     * denoting the exports and imports of countries A and B respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, if country C is in trade surplus and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= A1, A2, B1, B2 <= 100
     */
    public static void solveCodeChefSURPLUS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A1 = scn.nextLong();
            long A2 = scn.nextLong();
            long B1 = scn.nextLong();
            long B2 = scn.nextLong();
            long C = (A2 - A1) + (B2 - B1);
            System.out.println(C > 0 ? "YES" : "NO");
        }
        scn.close();
    }

    /**
     * Problem:
     * Farmer Feb has three fields with potatoes planted in them. 
     * He harvested x potatoes from the first field, y potatoes from the second field and is yet to harvest potatoes from the third field. 
     * Feb is very superstitious and believes that if the sum of potatoes he harvests from the three fields is a prime number 
     * (http://en.wikipedia.org/wiki/Prime_number), he'll make a huge profit. 
     * Please help him by calculating for him the minimum number of potatoes that if harvested from the third field will make the sum of potatoes prime. 
     * At least one potato should be harvested from the third field.
     * 
     * Input:
     * The first line of the input contains an integer T denoting the number of test cases. 
     * Each of the next T lines contain 2 integers separated by single space: x and y.
     * 
     * Output:
     * For each test case, output a single line containing the answer.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= x <= 1000
     * 1 <= y <= 1000
     */
    public static void solveCodeChefPOTATOES() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long x = scn.nextLong();
            long y = scn.nextLong();
            boolean found = false;
            long j = 1;
            while (!found) {
                if (CodeChefLibrary.isPrime(x + y + j)) {
                    System.out.println(j);
                    found = true;
                }
                j++;
            }
        }
        scn.close();
    }

    /*
     * Problem:
     * Rushitote went to a programming contest to distribute apples and oranges to the contestants.
     * He has N apples and M oranges, which need to be divided equally amongst the contestants.
     * Find the maximum possible number of contestants such that:
     * 
     * Every contestant gets an equal number of apples;
     * and Every contestant gets an equal number of oranges.
     * 
     * Note that every fruit with Rushitote must be distributed, there cannot be any left over.
     * 
     * For example, 2 apples and 4 oranges can be distributed equally to two contestants, 
     * where each one receives 1 apple and 2 oranges.
     * However, 2 apples and 5 oranges can only be distributed equally to one contestant.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains two space-separated integers N and M — 
     * the number of apples and oranges, respectively.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: 
     * the maximum number of contestants such that everyone receives an equal number of apples and 
     * an equal number of oranges.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N, M <= 10^9
     */
    public static void solveCodeChefAPPLEORANGE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            System.out.println(CodeChefLibrary.mcd(N, M));
        }
        scn.close();
    }
    
    /*
    * Problem:
    * Chef owns an icecream shop in Chefland named scoORZ. There are only three types of coins in Chefland: 
    * Rs. 5, Rs. 10 and Rs. 15. An icecream costs Rs. 5.
    * There are N people (numbered 1 through N) standing in a queue to buy icecream from scoORZ. 
    * Each person wants to buy exactly one icecream. 
    * For each valid i, the i-th person has one coin with value ai. 
    * It is only possible for someone to buy an icecream when Chef can give them back their change exactly ― 
    * for example, if someone pays with a Rs. 10 coin, Chef needs to have a Rs. 5 coin that he gives to this person as change.
    * Initially, Chef has no money. He wants to know if he can sell icecream to everyone in the queue, in the given order. 
    * Since he is busy eating his own icecream, can you tell him if he can serve all these people?
    *
    * Input:
    * The first line of the input contains a single integer T denoting the number of test cases. 
    * The description of T test cases follows.
    * The first line of each test case contains a single integer N. 
    * The second line contains N space-separated integers a1, a2, ..., aN.
    *
    * Output:
    * For each test case, print a single line containing the string "YES" if all people can be served or "NO" otherwise (without quotes).
    *
    * Constraints:
    * 1 <= T <= 100
    * 1 <= N <= 10^3
    * ai ∈ {5,10,15} for each valid i
    */
    public static void solveCodeChefCHFICRM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long rs5 = 0;
            long rs10 = 0;
            long imposible = 0;
            long N = scn.nextLong();
            for (long i = 0; i < N; i++) {
                long ai = scn.nextLong();
                if (ai == 5)
                    rs5++;
                else if (ai == 10 && rs5 > 0) {
                    rs5--;
                    rs10++;
                }
                else if (ai == 15 && rs10 > 0)
                    rs10--;
                else if (ai == 15 && rs5 > 1)
                    rs5 -= 2;
                else
                    imposible++;
            }
            System.out.println(imposible == 0 ? "YES" : "NO");
        }
        scn.close();        
    }

    /*
    * Problem:
    * You just bought a new calculator, but it seems to have a small problem: 
    * all its results have an extra 1 appended to the end.
    * For example, if you ask it for 3 + 5, it'll print 81, and 4 + 12 will result in 161.
    * Given A and B, can you predict what the calculator will print when you ask it for A+B?
    * 
    * Input Format:
    * The first and only line of input will contain two space-separated integers A and B.
    *
    * Output Format:
    * Print a single integer: the calculator's output when you enter A+B into it.
    *
    * Constraints:
    * 1 <= A,B <= 50
    */
    public static void solveCodeChefOFFBY1() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong(); 
        long B = scn.nextLong(); 
        System.out.println((A + B) * 10 + 1);
        scn.close();        
    }
    
    /*
    * Problem:
    * The tortoise and the hare decide to run a race, yet again.
    * This time around however, the hare has gotten a bit smarter!
    * The racetrack is a straight line, L meters long.
    * The tortoise moves at V1 meters per second, while the hare moves at V2 meters per second. 
    * It is known that V1 < V2, that is, the hare is strictly faster.
    * The hare still wants to be a bit lazy, so it decides to give the tortoise a headstart - 
    * the hare will wait for an integer number of seconds before starting to run.
    * Unfortunately, the animals' measuring devices aren't up to par - 
    * they can only measure in integer seconds, and will round up — so for example:
    * If the hare takes 1.57 seconds to finish, the reported time will be 2 seconds.
    * If the hare takes 3 seconds to finish, the reported time will be 3 seconds.
    * If the hare takes 3.01 seconds to finish, the reported time will be 4 seconds.
    * What's the longest time the hare can wait, while still being able to win the race?
    * Note that to win the race, the hare's reported time must be strictly less than the tortoise's.
    * If the hare cannot win no matter what, print −1.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and only line of each test case contains three space-separated integers L1, V1 and V2 -
    * the length of the racetrack, the tortoise's speed, and the hare's speed.
    *
    * Output Format:
    * For each test case, output on a new line the longest time the hare can wait, 
    * while still being able to win the race.
    *
    * Constraints:
    * 1 <= T <= 10^4
    * 1 <= L <= 1000
    * 1 <= V1 < V2 <= 1000
    */
    public static void solveCodeChefSMARTER() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long L = scn.nextLong();
            long V1 = scn.nextLong();
            long V2 = scn.nextLong();
            long T1 = L / V1 + (L % V1 != 0 ? 1 : 0);
            long T2 = L / V2 + (L % V2 != 0 ? 1 : 0);
            System.out.println((T2 == T1) ? -1 : T1 - T2 - 1);
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * Chef bought a new digital lock, 
    * but is quite suspicious of its actual strength in keeping out pesky thieves. 
    * So, he wants to find out how quickly he can open the lock.
    * The digital lock works as follows:
    * On its screen, there is a string of digits S of length N.
    * There is also a secret code K of length M (1 <= M <= 10), which acts as the key to the lock.
    * The lock will open if K is present anywhere in S as a contiguous substring.
    * Operating the lock is simple: Chef can choose an index i, 
    * and either increment Si by 1, or decrement it by 1.
    * Here, the digits are cyclic, following the order 0 → 1 → 2 → 3 → ... → 8 → 9 → 0 → ...
    * In particular, incrementing 9 will turn it into 0 
    * and decrementing 0 will turn it into 9.
    * You are given S and K. What's the minimum number of moves Chef needs to open the lock?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of three lines of input.
    * The first line of each test case contains two space-separated integers N and M - 
    * the lengths of the string and the secret code, respectively.
    * The second line contains a string S of length N, containing only the digits 0-9.
    * The third line contains a string K of length M, also containing only the digits 0-9.
    *
    * Output Format:
    * For each test case, output on a new line the minimum number of moves Chef needs to open the lock.
    *
    * Constraints:
    * 1 <= T <= 10^4
    * 1 <= N <= 10^5 
    * 1 <= M <= min(N,10)
    * The sum of N across all tests won't exceed 10^5.
    * Strings S and K will only contain the digits 0-9.
    */
    public static void solveCodeChefLPC() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            String S = scn.next();
            String K = scn.next();
            int min_movements = Integer.MAX_VALUE;
            for (int i = 0; i <= N - M; i++) {
                int i_movements = 0;
                for (int j = 0; j < M; j++) {
                    int dS = Integer.parseInt(S.substring(i + j, i + j + 1));
                    int dK = Integer.parseInt(K.substring(j, j + 1));
                    int up_movements = Math.abs(dS - dK);
                    int down_movements = Math.abs(Math.min(dS, dK) + 10 - Math.max(dS, dK));
                    i_movements += Math.min(up_movements, down_movements);
                }
                if (i_movements < min_movements)
                    min_movements = i_movements;
            }
            System.out.println(min_movements);
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * Chef is on a solo mission in Chefland, facing N enemies. 
    * The strength of the ith enemy is denoted by Ai.
    * Chef starts with an initial strength of H and a resistance level of X.
    * Here are the rules of the fight:
    * If an enemy's strength is less than or equal to Chef's resistance (X), 
    * Chef wins without losing any strength.
    * If an enemy's strength exceeds Chef's resistance, 
    * Chef can still win, but only if his strength is strictly greater than the enemy's.
    * In this case, Chef's strength decreases by the enemy's strength after the battle.
    * Your task is to find the minimum resistance value (X) that Chef needs to defeat all N enemies 
    * while ensuring he maintains a positive strength after the last battle.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of two lines of input.
    * The first line of each test case contains two space-separated integers N and H - 
    * the number of enemies and Chef's initial strength, respectively.
    * The next line contains N space-separated integers A1, A2, ..., AN - 
    * the strengths of the N enemies.
    *
    * Output Format:
    * For each test case, output on a new line, the minimum resistance value (X) that Chef needs to defeat 
    * all N enemies while ensuring he maintains a positive strength after the last battle.
    *
    * Constraints:
    * 1 <= T <= 1000
    * 1 <= N,H,Ai <= 10^5 
    * The sum of N over all test cases won't exceed 10^6.
    */
    public static void solveCodeChefWARRIORCHEF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long H = scn.nextLong();
            long max_strength = 1;
            TreeSet<Long> ordered_strengths = new TreeSet<>();
            HashMap<Long, Long> strengths = new HashMap<>();
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                max_strength += Ai;
                if (!strengths.containsKey(Ai)) {
                    strengths.put(Ai, 1L);
                    ordered_strengths.add(Ai);
                }                    
                else
                    strengths.put(Ai, strengths.get(Ai) + 1);
            }
            if (max_strength <= H)
                System.out.println(0);
            else {
                for (Long Ai : ordered_strengths) {
                    max_strength -= strengths.get(Ai) * Ai;
                    if (max_strength <= H) {
                        System.out.println(Ai);
                        break;
                    }
                }
            }
        }
        scn.close();
    }
    
    /*
    * Problem:
    * Chef is planning a heist in the reserve bank of Chefland. 
    * They are planning to hijack the bank for D days and print the money. 
    * The initial rate of printing the currency is P dollars per day and they 
    * increase the production by Q dollars after every interval of d days.
    * For example, after d days the rate is P+Q dollars per day, 
    * and after 2d days the rate is P+2Q dollars per day, and so on. 
    * Output the amount of money they will be able to print in the given period.
    *
    * Input:
    * The first line contains an integer T, the number of test cases. Then the test cases follow.
    * Each test case contains a single line of input, four integers D,d,P,Q.
    *
    * Output:
    * For each test case, output in a single line the answer to the problem.
    *
    * Constraints:
    * 1 <= T <= 10^5 
    * 1 <= d <= D <= 10^6
    * 1 <= P,Q <= 10^6 
    */
    public static void solveCodeChefCHFHEIST() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long D = scn.nextLong();
            long d = scn.nextLong();
            long P = scn.nextLong();
            long Q = scn.nextLong();
            long n = D / d;
            long Pbox = P * n * d + P * (D % d);
            long Qstairs = d * Q * ((n - 1) * n) / 2;
            long Qremain = Q * (D% d) * n;
            System.out.println(Pbox + Qstairs + Qremain);
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * Chef has started a new job as an insurance agent. 
    * Each insurance costs X dollars and Chef gets a 20% commission on selling each insurance.
    * Find the minimum number of insurances Chef needs to sell to earn at least 100 dollars.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of a single integer X, the cost of an insurance.
    * 
    * Output Format:
    * For each test case, output on a new line, 
    * the minimum number of insurances Chef needs to sell to earn at least 100 dollars.
    *
    * Constraints:
    * 1 <= T <= 100
    * 1 <= X <= 100
    */
    public static void solveCodeChefAGENTCHEF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long N = 10000 / (X * 20) + (((10000 % (X * 20)) != 0) ? 1 : 0);
            System.out.println(N);
        }
        scn.close();        
    }

    /*
    * Problem:
    * Chef has started learning about the stock market and has already selected a favourite stock.
    * He traded the stock for N consecutive days. 
    * Let Ai denotes the profit earned by Chef on the ith day. 
    * Note that Ai < 0 indicates that Chef had a loss on the ith day.
    * Chef wants to find the maximum amount of of profit he would have earned, 
    * if he skipped trading for exactly one day.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of multiple lines of input.
    * The first line of each test case contains N — the number of days.
    * The next line denotes N space-separated integers, denoting the profit earned by Chef on the ith day.
    *
    * Output Format:
    * For each test case, output on a new line, the maximum amount of of profit he would have earned, 
    * if he skipped trading for exactly one day.
    *
    * Constraints:
    * 1 <= T <= 1000
    * 1 <= N <= 10^5
    * −100 <= Ai <= 100
    * The sum of N over all test cases won't exceed 10^6.
    */
    public static void solveCodeChefSTOCKMARKET() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long minAi = Long.MAX_VALUE;
            long sumAi = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                sumAi += Ai;
                if (Ai < minAi)
                    minAi = Ai;
            }
            System.out.println(sumAi - minAi);
        }
        scn.close();        
    }
   
    /*
     * Problem:
     * The newspaper in Chefland consists of 10 pages numbered 1 to 10.
     * The last 3 pages of the newspaper are always dedicated to the sports section.
     * Given a random page number X, determine whether that page is dedicated to the sports section.
     * 
     * Input Format:
     * The first and only line of input consists of a single integer X, denoting the page number.
     * 
     * Output Format:
     * Output on a new line, YES, if the given page number is dedicated to the sports section, and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 10
     */
    public static void solveCodeChefNEWSPAPER() {
        Scanner scn = new Scanner(System.in);
        int X = scn.nextInt();
        System.out.println(X >= 8 ? "YES" : "NO");
        scn.close();
    }    
    
    /*
    * Problem:
    * You are given a string S with length N. You may perform the following operation any number of times: 
    * choose a non-empty substring of S (possibly the whole string S) 
    * such that each character occurs an even number of times in this substring and erase this substring from S. 
    * (The parts of S before and after the erased substring are concatenated and the next operation is performed on this shorter string.)
    * For example, from the string "acabbad", we can erase the highlighted substring "abba", 
    * since each character occurs an even number of times in this substring. After this operation, the remaining string is "acd".
    * Is it possible to erase the whole string using one or more operations?
    * Note: A string B is a substring of a string A if B can be obtained from A by deleting several (possibly none or all) 
    * characters from the beginning and several (possibly none or all) characters from the end.
    *
    * Input:
    * The first line of the input contains a single integer T denoting the number of test cases. 
    * The description of T test cases follows.
    * The first line of each test case contains a single integer N.
    * The second line contains a single string S with length N.
    *
    * Output:
    * For each test case, print a single line containing the string "YES" if it is possible to erase the whole string 
    * or "NO" otherwise (without quotes).
    *
    * Constraints:
    * 1 <= T <= 200
    * 1 <= N <= 1000
    * S contains only lowercase English letters
    */
    public static void solveCodeChefEVENTUAL() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            String S = scn.next();
            if (N % 2 == 1)
                System.out.println("NO");
            else {
                boolean pairs = true;
                HashMap<Character, Integer> map = CodeChefLibrary.getFrequencyMap(S);
                for (Character c : map.keySet()) {
                    int chars = map.get(c);
                    if (chars % 2 == 1) {
                        pairs = false;
                        break;
                    }
                }
                System.out.println(pairs ? "YES" : "NO");
            }
        }
        scn.close();        
    }

    /*
     * Problem:
     * Read problem statements in Bengali, Mandarin Chinese, Russian, and Vietnamese as well.
     * There are N seats in a row. You are given a string S with length N; 
     * for each valid ii, the ii-th character of S is '0' if the ii-th seat is empty or '1' if there is someone sitting in that seat.
     * 
     * Two people are friends if they are sitting next to each other. 
     * Two friends are always part of the same group of friends. Can you find the total number of groups?
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains a single string S.
     * 
     * Output:
     * For each test case, print a single line containing one integer ― the number of groups.
     * 
     * Constraints:
     * 1 <= T <= 50
     * 1 <= N <= 10^5
     */
    public static void solveCodeChefGROUPS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            String S = scn.next();
            long groups = 0;
            long friends = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '0') {
                    if (friends > 0)
                        groups++;
                    friends = 0;
                }
                else
                    friends++;
            }
            if (friends > 0)
                groups++;
            System.out.println(groups);
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef usually likes to play cricket, but now, he is bored of playing it too much, 
     * so he is trying new games with strings. Chef's friend Dustin gave him binary strings S and R, 
     * each with length N, and told him to make them identical. 
     * However, unlike Dustin, Chef does not have any superpower and Dustin lets Chef perform only operations of one type: 
     * choose any pair of integers (i,j) such that 1 <= i,j <= N and swap the i-th and j-th character of S. 
     * He may perform any number of operations (including zero).
     * For Chef, this is much harder than cricket and he is asking for your help. 
     * Tell him whether it is possible to change the string S to the target string R only using operations of the given type.
     *
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains a single integer N.
     * The second line contains a binary string S.
     * The third line contains a binary string R.
     *
     * Output:
     * For each test case, print a single line containing the string "YES" if it is possible to change S to R 
     * or "NO" if it is impossible (without quotes).
     * 
     * Constraints:
     * 1 <= T <= 400
     * 1 <= N <= 100
     * |S| = |R| = N
     * S and R will consist of only '1' and '0'
     */
    public static void solveCodeChefPLAYSTR() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            String S = scn.next();
            String R = scn.next();
            long ones = 0;
            long zeros = 0;
            for (long i = 0; i < N; i++) {
                char Sc = S.charAt((int)i);
                char Rc = R.charAt((int)i);
                if (Sc != Rc) {
                    if (Sc == '1')
                        ones++;
                    else
                        zeros++;
                }
            }
            System.out.println(zeros == ones ? "YES" : "NO");
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * Chef likes problems involving arrays. Unfortunately, 
    * the last one he tried to solve didn't quite get solved.
    * Chef has an array A of N positive numbers. 
    * He wants to find the number of subarrays for which the sum and product of elements are equal.
    * Please help Chef find this number.
    *
    * Input:
    * The first line of input contains an integer T denoting the number of test cases. 
    * T test cases follow. The first line of each test contains the integer N. 
    * The next line contains N integers - A1, A2, ..., AN - denoting the array.
    *
    * Output:
    * For each test case, output a single line with the answer for the instance.
    *
    * Constraints:
    * 1 <= T <= 50
    * 1 <= n <= 50
    * 1 <= Ai <= 10^9
    * A1 * A2 * ... * An <= 10^9
    */
    public static void solveCodeChefCHEFARRP() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long total = 0;
            long N = scn.nextLong();
            ArrayList<Long> A = new ArrayList<>();
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                A.add(Ai);
                long suma = 0;
                long producto = 1;
                for (long j = i; j >= 0; j--) {
                    suma += A.get((int)j);
                    producto *= A.get((int)j);
                    if (suma == producto)
                        total++;
                }
            }
            System.out.println(total);
        }
        scn.close();
    }

    /*
     * Problem:
     * Given an integer N, determine the number of pairs (A, B)(A,B) such that:
     * 1 <= A,B <= N
     * A + B is odd.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer N.
     * 
     * Output Format:
     * For each test case, output the number of required pairs.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 10^9
     */
    public static void solveCodeChefODDPAIRS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long pairs = N / 2;
            long odds = (N % 2 == 0) ? pairs : pairs + 1;
            System.out.println(pairs * odds * 2);
        }
        scn.close();
    }

    /*
     * Problem:
     * You are given an even integer N and an integer K.
     * Generate an array A of size N such that:
     * 1 <= Ai <= 10^5 for all 1 <= i <= N;
     * The number of odd elements in the array is same as the number of even elements.
     * The sum of all elements of the array is K.
     * If multiple such arrays exist, print any. If no such array exists, print -1 instead.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers N and K - the size of the array and the required sum.
     * 
     * Output Format:
     * For each test case, output on a new line, N space-separated integers, 
     * denoting the array A satisfying the given conditions.
     * If multiple such arrays exist, print any. If no such array exists, print -1 instead.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 2 <= N <= 10^5, N is even
     * 1 <= K <= 10^9 The sum of N over all test cases won't exceed 10^6
     */
    public static void solveCodeChefSUMARRAY() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            if ((N / 2) % 2 != K % 2)
                System.out.println(-1);
            else if (K < ((3 * N) / 2))
                System.out.println(-1);
            else if ((K / (N / 2)) > 199999)
                System.out.println(-1);
            else {
                String S = "";
                long sum = 3 * (N / 2 - 1);
                long v1 = (K - sum) / 2;
                long v2 = K - sum - v1;
                while (v1 + v2 > 199999) {
                    S +="99999 100000 ";
                    N -= 2;
                    K -= 199999;
                    sum = 3 * (N / 2 - 1);
                    v1 = (K - sum) / 2;
                    v2 = K - sum - v1;
                }
                if (v1 < 1 || v2 < 1 || N < 2)
                    System.out.println(-1);
                else {
                    System.out.print(S);
                    for (long i = 1; i < N / 2; i++)
                        System.out.print("1 2 ");
                    System.out.println(v1 + " " + v2);
                }
            }
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef organised a 30 kilometres marathon in Chefland.
     * The participants receive medals on completing the marathon as following:
     * If the total time taken is less than 3 hours, they receive a GOLD medal.
     * If the total time taken is greater than equal to 3 hours but less than 6 hours, they receive a SILVER medal.
     * If the total time taken is greater than equal to 6 hours, they receive a BRONZE medal.
     * Chefina participated in the marathon and completed it in X hours. Which medal would she receive?
     *
     * Input Format:
     * The input consists of a single integer X - the number of hours Chefina took to complete the marathon.
     * 
     * Output Format:
     * Output the medal Chefina would recieve.
     * Note that you may print each character in uppercase or lowercase. 
     * For example, the strings GOLD, gold, Gold, and gOlD are considered the same.
     * 
     * Constraints:
     * 1 <= X <= 10.
     */
    public static void solveCodeChefOCTATHON() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        if (X < 3)
            System.out.println("GOLD");
        else if (X < 6)
            System.out.println("SILVER");
        else
            System.out.println("BRONZE");
        scn.close();        
    }
    
    /*
     * Problem:
     * On a sunny Sunday afternoon, Chef prepared a brunch for his 20 neighbours.
     * Chef prepared a total of X plates. 
     * However, the meal was so good that the neighbours started taking Y plates each.
     * Find the maximum number of neighbours Chef can feed completely.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers X and Y - 
     * the number of plates Chef prepared and the number of plates each person takes respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum number of neighbours Chef can feed completely.
     *
     * Constraints:
     * 1 <= T <= 405
     * 20 <= X <= 100
     * 1 <= Y <= 5
     */
    public static void solveCodeChefBRUNCH() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long total = X / Y;
            System.out.println(total > 20 ? 20 : total);
        }
        scn.close();
    }
    
    /*
     * Problem:
     * Alice and Bob are playing a game. Each player rolls a regular six faced dice 3 times.
     * The score of a player is the maximum number that can be formed using the rolls.
     * The player with the highest score wins, and the game ends in a tie if both players have the same score.
     * Find the winner of the game or determine whether it is a tie.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case contains six space-separated integers A1,A2,A3,B1,B2 and B3 -
     * the values Alice gets in her 3 dice rolls, followed by the values which Bob gets in his 3 dice rolls.
     * 
     * Output Format:
     * For each test case, output on a new line Alice if Alice wins, Bob if Bob wins and Tie in case of a tie.
     * Note that you may print each character in uppercase or lowercase. 
     * For example, the strings tie, TIE, Tie, and tIe are considered identical.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= A1,A2,A3,B1,B2,B3 <= 6
     */
    public static void solveCodeChefDICENUM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            ArrayList<Long> A = new ArrayList<>();
            ArrayList<Long> B = new ArrayList<>();
            A.add(scn.nextLong());
            A.add(scn.nextLong());
            A.add(scn.nextLong());
            B.add(scn.nextLong());
            B.add(scn.nextLong());
            B.add(scn.nextLong());
            Collections.sort(A);
            Collections.sort(B);
            long MaxA = 0;
            long MaxB = 0;
            long pow = 1;
            for (int i = 0; i < 3; i++) {
                MaxA = MaxA + A.get(i) * pow;
                MaxB = MaxB + B.get(i) * pow;
                pow *= 10;
            }
            if (MaxA > MaxB)
                System.out.println("Alice");
            else if (MaxB > MaxA)
                System.out.println("Bob");
            else
                System.out.println("Tie");
        }
        scn.close();
    }

    /*
     * Problem:
     * You are given a binary string S of length N. 
     * You are allowed to perform the following types of operations on string S:
     * Delete any one character from S, and concatenate the remaining parts of the string. 
     * For example, if we delete the third character of S=1101, it becomes S=111.
     * Flip all the characters of S. 
     * For example, if we flip all character of S=1101, it becomes S=0010.
     * Given that you can use either type of operation any number of times, 
     * find the minimum number of operations required to make all characters of the string S equal to 0.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains an integer N - the length of the string.
     * The next line contains a binary string S of length N.
     *
     * Output Format:
     * For each test case, output on a new line, 
     * the minimum number of operations required to make all characters of the string S equal to 0.
     * 
     * Constraints:
     * 1 <= T <= 2000
     * 1 <= N <= 10^5
     * S contains 0 and 1 only.
     * The sum of N over all test cases won't exceed 2*10^5
     */
    public static void solveCodeChefZEROSTRING() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            scn.nextLong();
            String S = scn.next();
            long ones = 0;
            long zeros = 0;
            for (char c : S.toCharArray()) {
                if (c == '1')
                    ones++;
                else
                    zeros++;
            }
            if (ones > zeros)
                System.out.println(zeros + 1);
            else
                System.out.println(ones);
        }
        scn.close();

    }

    /*
     * Problem:
     * Chefina decided to move into Chef's apartment.
     * Chef was initially paying a rent of X rupees. 
     * Since Chefina is moving in, the owner decided to double the rent.
     * Find the final rent Chef needs to pay.
     * 
     * Input Format:
     * The input consists of a single integer X, denoting the rent Chef was initially paying.
     * 
     * Output Format:
     * Output on a new line, the final rent Chef needs to pay.
     * 
     * Constraints:
     * 1 <= X <= 10
     */
    public static void solveCodeChefDOUBLERENT() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X * 2);
        scn.close();
    }
    
    /*
     * Problem:
     * Chef has a circular pizza and a knife to cut that into pieces. 
     * He can only cut the pizza in a way such that the knife starts from the boundary of the pizza, 
     * passes the centre, and ends at the boundary.
     * Find whether Chef an divide the pizza into N pieces using any (possibly zero) number of cuts.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer N - denoting the desired number of cuts.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, 
     * if Chef can divide the pizza into N pieces using any (possibly zero) number of cuts, 
     * and NO otherwise.
     * Note that you may print each character in uppercase or lowercase. 
     * For example, the strings NO, no, No, and nO are considered the same.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     */
    public static void solveCodeChefPIZZAC() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextInt();
        while (T-- > 0) {
            long N = scn.nextInt();
            boolean posible = (N % 2 == 0 || N == 1);
            System.out.println(posible ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem:
     * Read problem statements in Bengali, Russian, Mandarin and Vietnamese as well.
     * Chef has X coins worth 1 rupee each and Y coins worth 2 rupees each. 
     * He wants to distribute all of these X+Y coins to his two sons so that the total value of coins received by each of them is the same. 
     * Find out whether Chef will be able to do so.
     * 
     * Input Format:
     * The first line of input contains a single integer T, denoting the number of testcases. 
     * The description of T test cases follows.
     * Each test case consists of a single line of input containing two space-separated integers X and Y.
     * 
     * Output Format:
     * For each test case, print "YES" (without quotes) if Chef can distribute all the coins equally and "NO" otherwise. 
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^3
     * 0 <= X,Y <= 10^8
     * X + Y > 0
     */
    public static void solveCodeChefEQUALCOIN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            if (X % 2 == 1)
                System.out.println("NO");
            else if (X >= 2 && X % 2 == 0)
                System.out.println("YES");
            else if (Y % 2 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        scn.close();
    }

    /*
     * Problem:
     * Read problems statements in Mandarin Chinese, Russian and Vietnamese as well.
     * Chef is instructor of the famous course "Introduction to Algorithms" in a famous univerisity. 
     * There are n students in his class. 
     * There is not enough space in the class room, so students sit in a long hallway in a linear fashion.
     * One day Chef was late to class. 
     * As a result, some of the students have formed pairs and are talking to each other, while the others are busy studying. 
     * This information is given to you by a string s of length n, consisting of characters '*', <' and '>', 
     * where '*' denotes that the student is studying, 
     * '>' denotes that the corresponding student is talking to the student to the right, 
     * and '<' denotes that the corresponding student is talking to the student to the left.
     * For example, consider a sample configuration of students - *><*. 
     * Here students numbered 1 and 4 are busy studying, while the student 2 and 3 are talking to each other. 
     * In this example, ><><, student 1 and 2 are talking to each other, and 3 and 4 are also talking to each other.
     * You are guaranteed that the given input is a valid configuration, i.e. <> can not be a valid string s, 
     * as here student 1 is shown to be talking to left, but there is no student to the left. 
     * Same is the case for right. Similarly, >><< is also not a valid configuration, as students 2 and 3 are talking to each other, 
     * so student 1 won't be able to talk to student 2.
     * When the students see their teacher coming, those who were talking get afraid and immediately turn around, 
     * i.e. students talking to left have now turned to the right, and the one talking to right have turned to the left. 
     * When Chef sees two students facing each other, he will assume that they were talking. 
     * A student who is busy studying will continue doing so. 
     * Chef will call each pair of students who were talking and punish them. 
     * Can you find out how many pairs of students will get punished?
     * For example, in case *><*, when students see Chef, their new configuration will be *<>*. 
     * Chef sees that no students are talking to each other. 
     * So no one is punished. While in case ><><, the new configuration of students will be <><>, 
     * Chef sees that student 2 and 3 are talking to each other and they will be punished.
     * 
     * Input:
     * The first line of the input contains an integer T denoting the number of the test cases.
     * Each test case contains a string s denoting the activities of students before students see Chef entering the class.
     * 
     * Output:
     * For each test case, output a single integer denoting the number of pairs of students that will be punished.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= |s| <= 10^5
     * 
     * Subtasks:
     * 
     * Subtask #1: (30 points)
     * 1 <= T <= 10
     * 1 <= |s| <= 10^5
     * No student is studying.
     * 
     * Subtask #2: (70 points)
     * Original Constraints.
     */
    public static void solveCodeChefCHEFSTUD() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        int ST_NONE = 0;
        int ST_WATING_RIGHT = 1;
        while (T-- > 0) {
            String S = scn.next();
            int state = ST_NONE;
            long punished = 0;
            for (char c : S.toCharArray()) {
                switch(c) {
                    case '*':
                        state = ST_NONE;
                        break;
                    case '<':
                        if (state == ST_NONE)
                            state = ST_WATING_RIGHT;
                        else if (state == ST_WATING_RIGHT)
                            state = ST_NONE;
                        break;
                    case '>':
                        if (state == ST_WATING_RIGHT) {
                            punished++;
                            state = ST_NONE;
                        }
                        break;
                }
            }
            System.out.println(punished);
        }
        scn.close();
    }

    /*
     * Problem:
     * Trick or treat, bags of sweets, ghosts are walking down the street.
     * It's Halloween and Suri Bhai is out to get his treats.
     * There are two sectors in his neighborhood, "Bones" and "Blood". 
     * They have N and M people, respectively.
     * Each person in "Bones" will hand out X treats, and each person in "Blood" will hand out Y treats.
     * How many treats does Suri Bhai get from visiting everyone in his neighborhood in total?
     * 
     * Input Format:
     * The first line of input contains two space-separated integers N and M - 
     * the number of people in "Bones" and "Blood", respectively.
     * The second line of input contains two space-separated integers X and Y - 
     * the number of treats handed out by each person in "Bones" and "Blood", respectively.
     * 
     * Output Format:
     * For each test case output a single integer: the total number of treats Suri Bhai will receive.
     * 
     * Constraints:
     * 0 <= N,M <= 100
     * 0 <= X,Y <= 1000
     */
    public static void solveCodeChefBNE_APT() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        long M = scn.nextLong();
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(N * X + M * Y);
        scn.close();
    }

    /*
     * Problem:
     * Eat, drink, and be scary.
     * There are N spooky days left until Halloween.
     * Dracula dines at a mysterious restaurant that changes its spooky menu daily.
     * He particularly enjoys what they serve on Tuesday.
     * Today is Monday, so he wishes to calculate how many times he can indulge 
     * in his favourite menu in the next N days (including today) before Halloween.
     * Note that Dracula follows the standard 7-day calendar, with Tuesday immediately following Monday.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The only line of each test case contains a single integer N, denoting the number of spooky days.
     * 
     * Output Format:
     * For each test case, output on a new line the number of times Dracula would have had his favorite meal after N days.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 1000
     */
    public static void solveCodeChefCHEAT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println((N + 5) / 7);
        }
        scn.close();
    }

    /*
     * Problem:
     * Read problem statements in Russian and Mandarin Chinese.
     * A great deal of energy is lost as metabolic heat 
     * when the organisms from one trophic level are consumed by the next level.
     * Suppose in Chefland the energy reduces by a factor of K, i.e, if initially, the energy is X, 
     * then the transfer of energy to the next tropic level is ⌊X/K⌋.
     * This limits the length of foodchain which is defined to be the highest level receiving non-zero energy.
     * E is the energy at the lowest tropic level. Given E and K for an ecosystem, find the maximum length of foodchain.
     * Note: ⌊x⌋ denoted the floor function, and it returns the greatest integer that is less than or equal to x 
     * (i.e rounds down to the nearest integer). For example, ⌊1.4⌋ = 1, ⌊5⌋ = 5, ⌊−1.5⌋ = −2, ⌊−3⌋ = −3 , ⌊0⌋ = 0.
     * 
     * Input Format:
     * First line will contain T, number of testcases. Then the testcases follow.
     * Each testcase contains a single line of input, two integers E,K.
     * 
     * Output Format:
     * For each testcase, output in a single line answer to the problem.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= E <= 10^9
     * 2 <= K <= 10^9
     */
    public static void solveCodeChefFODCHAIN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long E = scn.nextLong();
            long K = scn.nextLong();
            long levels = 0;
            while (E > 0) {
                E /= K;
                levels++;
            }
            System.out.println(levels);
        }
        scn.close();
    }

    /*
    * Problem:
    * Chef Sports conducted a fan poll to find out who their fans thought was the best captain.
    * The three players nominated were Dhoni, Rohit, and Kohli. 
    * They received A, B, and C votes, respectively.
    * Find out whether Dhoni won the poll, i.e, if he received the maximum number of votes.
    * Note: It is guaranteed that no two players received the same number of votes.
    *
    * Input Format:
    * The only line of input contains three space-separated integers A, B, and C -
    * the number of votes obtained by Dhoni, Rohit, and Kohli, respectively.
    * 
    * Output Format:
    * Print the answer on a single line: "Yes" (without quotes) if Dhoni won the poll, 
    * and "No" (without quotes) otherwise.
    * Each character of the output may be printed in either uppercase or lowercase, 
    * i.e, the strings No, no, nO, and NO` will all be treated as equivalent.
    *
    * Constraints:
    * 1 <= A <= 1000
    * 1 <= B <= 1000
    * 1 <= C <= 1000
    * A != B, A != C, and B != C
    */
    public static void solveCodeChefFIZZBUZZ2301() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong();
        long B = scn.nextLong();
        long C = scn.nextLong();
        boolean dhoni = (A == Math.max(A, Math.max(B, C)));
        System.out.println(dhoni ? "Yes" : "No");
        scn.close();
    }
    
    /*
    * Problem:
    * The apocalypse has arrived, and Alice and her 4 other family members 
    * (a total of 5 people) are now stuck in a shopping mall from where they have nowhere to run.
    * Fortunately, the place where they are stuck has frozen buns which they can eat and survive.
    * There are N buns in the mall, and each member of the family needs to eat X buns everyday to survive.
    * After the food supply runs out, the family can survive for a further D days.
    * How many days can Alice and family survive under these conditions?
    * Note: If there aren't enough buns to feed the whole family, nobody will eat anything. 
    * The samples below showcase an example of this.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and only line of each test case contains three space-separated integers N, X, and D -
    * the total number of frozen buns, the number of buns every member needs everyday, 
    * and the number of days everyone can survive after food gets exhausted, respectively.
    * 
    * Output Format:
    * For each test case, output on a new line the total number of days Alice and family can survive.
    *
    * Constraints:
    * 1 <= T <= 10^5
    * 0 <= N < 500
    * 1 <= X <= 10
    * 0 <= D < 20
    */
    public static void solveCodeChefFIZZBUZZ23_2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long D = scn.nextLong();
            long days = D + N / (5 * X);
            System.out.println(days);
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * All of Chef's friends are playing fantasy cricket based upon the ODI World Cup, and Chef would like to join them.
    * For a certain cricket match, Chef has decided upon his team of 11 players. 
    * However, he hasn't yet decided who should be the captain and who should be the vice-captain.
    * He's narrowed his decision down to N players out of the 11, 
    * from which he'll choose one to be the captain and one to be the vice captain.
    * How many different choices does he have?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and the only line of each testcase contains a single integer N, the number of players Chef is considering.
    *
    * Output Format:
    * For each test case, output on a new line the number of possible choices of captain and vice-captain.
    * 
    * Constraints:
    * 1 <= T <= 10
    * 2 <= N <= 11
    */
    public static void solveCodeChefFIZZBUZZ2303() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println(N * (N - 1));
        }
        scn.close();
    }
      
    /*
    * Problem:
    * Chef classifies a day to be either rainy, cloudy, or clear.
    * In a particular week, Chef finds X days to be rainy and Y days to be cloudy.
    * Find the number of clear days in the week.
    *
    * Input Format:
    * The first and only line of input will contain two space-separated integers X and Y, 
    * denoting the number of rainy and cloudy days in the week.
    *
    * Output Format:
    * Output the number of clear days in the week.
    *
    * Constraints:
    * 0 <= X,Y <= 7
    * 0 <= X + Y <= 7
    */
    public static void solveCodeChefCLEARDAY() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(7 - X - Y);
        scn.close();
    }
    
    /*
    * Problem:
    * Chef and Chefina are playing the famous game of Rock, Paper, Scissors.
    * The game consists of N rounds. 
    * In each round, both players choose one of the three moves: Rock, Paper, or Scissors, denoted by R, P, and S respectively.
    * If both players play the same move, the current round ends in a draw and neither of them gets a point.
    * If one of the players plays Rock and the other plays Scissors, the player who played Rock wins the round and gets a point.
    * If one of the players plays Scissors and the other plays Paper, the player who played Scissors wins the round and gets a point.
    * If one of the players plays Paper and the other plays Rock, the player who played Paper wins the round and gets a point.
    * The winner of the game is the player who gets the maximum number of points after playing all the rounds. 
    * If both players have the same number of points, then the game ends in a draw.
    * You are given two strings A and B, each of length N, 
    * consisting of uppercase English letters R, P, and S, 
    * where Ai denotes the move made by Chef in the ith round and Bi denotes the move made by Chefina in the ith round.
    * Find the minimum number of rounds Chef should have played differently to have won the game.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of multiple lines of input.
    * The first line of each test case contains an integer N - the number of rounds.
    * The second line contains string A of length N denoting the moves played by Chef.
    * The third line contains string B of length N denoting the moves played by Chefina.
    *
    * Output Format:
    * For each test case, output on a new line, the minimum number of rounds Chef should have played differently to have won the game.
    *
    * Constraints:
    * 1 <= T <= 7.10^4
    * 1 <= N <= 1000
    * Ai, Bi ∈ {R, P, S}
    * The sum of N over all test cases won't exceed 4.10^5
    */
    public static void solveCodeChefPASCRO() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            String A = scn.next();
            String B = scn.next();
            long score_A = 0;
            long score_B = 0;
            for (int i = 0; i < N; i++) {
                if (A.charAt(i) == 'R' && B.charAt(i) == 'S')
                    score_A++;
                else if (A.charAt(i) == 'S' && B.charAt(i) == 'P')
                    score_A++;
                else if (A.charAt(i) == 'P' && B.charAt(i) == 'R')
                    score_A++;
                else if (A.charAt(i) != B.charAt(i))
                    score_B++;
            }
            long difference = score_B - score_A;
            if (difference < 0)
                System.out.println(0);
            else
                System.out.println(difference / 2 + 1);
        }
        scn.close();
    }

    /*
    * Problem:
    * Chef has finally decided to complete all of his pending assignments.
    * There are X assignments where each assignment takes Y minutes to complete.
    * Find whether Chef would be able to complete all the assignments in Z days.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists three space-separated integers X, Y, and Z - 
    * the number of assignments, time taken in minutes to complete each assignment, 
    * and the number of days in which Chef wants to complete the assignments.
    *
    * Output Format:
    * For each test case, output on a new line, YES, if Chef would be able to complete all the assignments in Z days. 
    * Otherwise, print NO.
    * You may print each character of the string in uppercase or lowercase 
    * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
    *
    * Constraints:
    * 1 <= T <= 10^5
    * 1<= X, Y <= 100
    * 1 <= Z <= 10
    */
    public static void solveCodeChefASSIGNMNT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long Z = scn.nextLong();
            long needed = X * Y;
            long remainded = Z * 24 * 60;
            System.out.println(remainded >= needed ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem:
     * Given an integer N, find a permutation of size N such that:
     * 
     * A(i) != A(i-1)|A(i-2) for all 3 <= i <= N, where | denotes the bitwise or operation.
     * 
     * It is guaranteed that such permutation always exists. 
     * If multiple such permutations exist, you may print any.
     * Note that a permutation of size N consists of all integers from 1 to N exactly once.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists a single integer N — the size of the permutation.
     * 
     * Output Format:
     * For each test case, output on a new line, 
     * N space-separated integers denoting the permutation satisfying the given conditions.
     * It is guaranteed that such permutation always exists. If multiple such permutations exist, you may print any.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 3 <= N <= 10^5
     * The sum of N over all test cases won't exceed 10^6
     */
    public static void solveCodeChefPERMOR() {
        Scanner scn = new Scanner(System.in);
        long[] pattern3 = {1, 3, 2, 4};
        long[] pattern = {1, 2, 4, 3};
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            if (N % 4 == 3) {
                for (long i = 0; i < N; i++) {
                    System.out.print((4 * (i / 4) + pattern3[(int)i % 4]) + " ");
                }
            }
            else {
                for (long i = 0; i < N; i++) {
                    System.out.print((4 * (i / 4) + pattern[(int)i % 4]) + " ");
                }
            }
            System.out.println();
        }
        scn.close();
    }

    /*
    * Problem:
    * Dominater and Everule are very competitive, 
    * and keep trying to show that they are better at competitive programming than the other. 
    * What better measure is there than their rating?
    * Both of them participated in a contest. 
    * Before the contest, Dominater's rating was R1 and Everule's rating was R2.
    * Dominater's rating changed by D1 in the contest, and Everule's rating changed by D2.
    * Who has the higher final rating after the contest?
    * Print "Dominater" if his rating is higher, and "Everule" if his rating is higher (without the quotes).
    * It is guaranteed they do not have equal ratings at the end of the contest.
    *
    * Input Format:
    * The first line of input will contain two space-separated integers R1 and R2, 
    * denoting the initial ratings of Dominater and Everule.
    * The second line of input will contain two space-separated integers D1 and D2,
    * denoting the rating changes of Dominater and Everule.
    *
    * Output Format:
    * Output Dominater or Everule, depending on who has a higher rating at the end.
    * Each character of the output may be printed in either uppercase or lowercase, 
    * i.e, Everule, EVERULE, and evERuLe will all be treated as equivalent.
    *
    * Constraints:
    * 1 <= R1, R2 <= 3000
    * -200 <= D1, D2 <= 200
    * It is guaranteed Dominater and Everule have different final ratings.
    */
    public static void solveCodeChefCPRIVAL() {
        Scanner scn = new Scanner(System.in);
        long R1 = scn.nextLong();
        long R2 = scn.nextLong();
        long D1 = scn.nextLong();
        long D2 = scn.nextLong();
        long dominater = R1 + D1;
        long everule = R2 + D2;
        System.out.println(dominater > everule ? "Dominater" : "Everule");
        scn.close();
    }
    
    /*
    * Problem:
    * You are hosting a chess tournament with 2N people. 
    * Exactly X of them are rated players, and the remaining 2N − X are unrated players.
    * Your job is to distribute the players into N pairs, 
    * where every player plays against the person paired up with them.
    * Since you want the rated players to have an advantage, you want to pair them with unrated players. 
    * Thus, you want to minimize the number of rated players whose opponent is also rated.
    * Print the minimum number of rated players whose opponents are also rated, among all possible pairings.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of 1 line containing 2 space-separated integers N and X, 
    * meaning there are 2N players, and X of them are rated.
    *
    * Output Format:
    * For each test case, output on a new line the minimum number of rated players who will have rated opponents.
    * 
    * Constraints:
    * 1 <= T <= 2600
    * 1 <= N <= 50
    * 0 <= X <= 2 * N
    */
    public static void solveCodeChefCHESS_PAIR() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long unrated = 2 * N - X;
            System.out.println((X <= unrated) ? 0 : (X - unrated));
        }
        scn.close();
    }

    /*
    * Problem:
    * A palindromic prime number is a positive integer that is both a prime number (meaning it has exactly two divisors:
    * 1 and itself) and a palindrome in base 10 (meaning it reads the same both backwards and forwards).
    * Leading zeros are not considered when determining if a number is a palindrome 
    * (so 20 is not a palindrome, even though it can be written as 020).
    * You are given an integer N. Consider the first N palindromic prime numbers. 
    * How many of them have an even number of digits, and how many of them have an odd number of digits?
    *
    * Some examples:
    * 2,7, and 11 are palindromic primes.
    * 22 and 121 are palindromes that are not primes.
    * 17 and 37 are primes that are not palindromes.
    * 42 is neither a palindrome nor a prime.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and only line of each test case contains a single integer N -
    * meaning you must consider the first N palindromic prime numbers.
    *
    * Output Format:
    * For each test case, output on a new line two space-separated integers: 
    * among the first N palindromic primes, the number of them that have an even number of digits
    * and the number of them that have an odd number of digits, respectively.
    *
    * Constraints:
    * 1 <= T <= 10^5
    * 1 <= N <= 10^5
    */
    public static void solveCodeChefMD_RIEV() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            if (N < 5)
                System.out.println("0 " + N);
            else
                System.out.println("1 " + (N - 1));
        }
        scn.close();
    }
    
    /*
     * @brief: Method to show the CodeChef solved problems implemented.
     * It shows all procedures with name starting with "solveCodeChef".
     */
    public static void showCodeChefSolvedProblems() {
        String prefix = "solveCodeChef";
        for (Method m : CodeChef.class.getDeclaredMethods()) {
            if (m.getName().startsWith(prefix))
                System.out.println(m.getName().substring(prefix.length()) + " with procedure " + m.getName());
        }
    }
}
