package utilities;

import java.util.*;

/**
 * @class CodeChef
 * @author ismael.flores
 */
public class CodeChef {

    /**
     * Check if 'n' is prime. 'n' must be positive (1 or more)
     * @param n value to test
     * @return TRUE if value is primer and FALSE otherwise
     */
    private static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        if (n % 2 == 0) {
            return n == 2;
        }
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @brief Check if a year is leap
     * @param y Year
     * @return true if the year is leap, false otherwise
     */
    private static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    /**
     * @brief Check if a date is valid
     * @param d Day
     * @param m Month
     * @param y Year
     * @return true if the date is valid, false otherwise
     */
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

    /*
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
    * The third line of each test case contains NN space-separated integers, 
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

    /*
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

    /* 
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

    /*
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

    /*
     * Problem:
     * Finally, a COVID vaccine is out on the market and the Chefland government has asked you to form a plan to distribute it to the public as soon as possible. 
     * There are a total of NN people with ages a1, a2, ..., aN.
     * There is only one hospital where vaccination is done and it is only possible to vaccinate up to DD people per day. 
     * Anyone whose age is >= 80 or <= 9 is considered to be at risk. 
     * On each day, you may not vaccinate both a person who is at risk and a person who is not at risk. 
     * Find the smallest number of days needed to vaccinate everyone.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first line of each test case contains two space-separated integers N and D.
     * The second line contains NN space-separated integers a1, a2, ..., aN.
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

    private static boolean fits(int lenght, HashMap<Character, Integer> f1, HashMap<Character, Integer> f2) {
        boolean fits = true;
        for (Character c : f1.keySet()) {
            int chars_to_put = f1.get(c);
            int free_spaces = lenght - (f2.containsKey(c) ? f2.get(c) : 0);
            if (chars_to_put > free_spaces)
                fits = false;
        }
        return fits;
    }

    private static HashMap<Character, Integer> getFrequencyMap(String S) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char character = S.charAt(i);
            if (frequencyMap.containsKey(character))
                frequencyMap.put(character, frequencyMap.get(character) + 1);
            else
                frequencyMap.put(character, 1);
        }        
        return frequencyMap;
    }
    
    public static void solveCodeChefCC_COPY() {
        String codechef = "codechef";
        ArrayList<HashMap<Character, Integer>> fMapsCodechef = new ArrayList<>();
        for (int k = 0; k < codechef.length(); k++)
            fMapsCodechef.add(getFrequencyMap(codechef.substring(k)));
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
                            f2 = getFrequencyMap(S1);
                            fMapsS.put(S1, f2);
                        }
                        if (fits(codechef.length() - i - 1, fMapsCodechef.get(i + 1), f2)) {
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

    private static boolean posibleMishear(long first, long second, long third) {
        boolean mishear = false;
        if (second != Long.MIN_VALUE) {
            if (first != second && first != Long.MIN_VALUE)
                mishear = true;
            else if (third != second && third != Long.MIN_VALUE)
                mishear = true;
        }
        return mishear;
    }
    
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
                if (posibleMishear(first, second, third))
                    count++;
            }
            first = second;
            second = third;
            third = Long.MIN_VALUE;
            if (posibleMishear(first, second, third))
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
    
    public static void solveCodeChefAIRINDEX() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        scn.close();        
        System.out.println(X < 100 ? "YES" : "NO");
    }
    
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
                if (isPrime(x + y + j)) {
                    System.out.println(j);
                    found = true;
                }
                j++;
            }
        }
        scn.close();
    }
}
