package utilities;

import java.util.*;

/**
 * @class CodeChef 
 * @brief A library of solutions for CodeChef problems
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
     * For example, 22 apples and 44 oranges can be distributed equally to two contestants, 
     * where each one receives 11 apple and 22 oranges.
     * However, 22 apples and 55 oranges can only be distributed equally to one contestant.
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
}
