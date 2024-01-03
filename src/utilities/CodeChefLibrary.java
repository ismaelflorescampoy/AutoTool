package utilities;

import java.util.HashMap;

/**
 * @class CodeChefLibrary
 * @brief A library of utility functions for CodeChef problems
 * @author 
 */
public class CodeChefLibrary {

    /**
     * @brief Check if a character is a vowel
     * @param c Character to check
     * @return true if the character is a vowel, false otherwise
     */
    public static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
               c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * @brief Check if a year is leap
     * @param y Year
     * @return true if the year is leap, false otherwise
     */
    public static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    /**
     * @brief Check if a date is valid
     * @param d Day
     * @param m Month
     * @param y Year
     * @return true if the date is valid, false otherwise
     */
    public static boolean isValid(int d, int m, int y) {
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

    /**
     * Check if 'n' is prime. 'n' must be positive (1 or more)
     * @param n value to test
     * @return TRUE if value is primer and FALSE otherwise
     */
    public static boolean isPrime(long n) {
        if (n == 1)
            return false;
        if (n % 2 == 0)
            return n == 2;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Calculates greater common divisor between <b><i>a</i></b> and <b><i>b</i></b>.
     * If returned value is 1, both values are prime among them
     * @param a first value to check
     * @param b second value to check
     * @return greater common divisor found
     */
    public static long mcd(long a, long b) {
        long lAux;
        if (a < b) {
            lAux = a;
            a = b;
            b = lAux;
        }
        while (a % b != 0) {
            lAux = a % b;
            a = b;
            b = lAux;
        }
        return b;
    }

    /**
     * @brief Given two character's frequency maps f1 and f2 for two different strings, 
     * checks if the characters in f1 can fit into f2 given the maximum length provided.
     * @param length The maximum length available.
     * @param f1 The first hash map with character's frequency map.
     * @param f2 The second hash map with character's frequency map.
     * @return True if the characters in f1 can fit into f2 given the length, false otherwise.
     */
        public static boolean fits(int lenght, HashMap<Character, Integer> f1, HashMap<Character, Integer> f2) {
        boolean fits = true;
        for (Character c : f1.keySet()) {
            int chars_to_put = f1.get(c);
            int free_spaces = lenght - (f2.containsKey(c) ? f2.get(c) : 0);
            if (chars_to_put > free_spaces)
                fits = false;
        }
        return fits;
    }

    /**
     * @brief Returns a hash map that contains the frequency of each character in the input string.
     * @param S The input string.
     * @return A hash map that contains the frequency of each character in the input string.
     */
    public static HashMap<Character, Integer> getFrequencyMap(String S) {
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

    /**
     * @brief Checks if the first number is equal to the third number but different from the second number.
     * @param first The first number.
     * @param second The second number.
     * @param third The third number.
     * @return True if the first number is equal to the third number but different from the second number, false otherwise.
     */
    public static boolean posibleMishear(long first, long second, long third) {
        boolean mishear = false;
        if (second != Long.MIN_VALUE) {
            if (first != second && first != Long.MIN_VALUE)
                mishear = true;
            else if (third != second && third != Long.MIN_VALUE)
                mishear = true;
        }
        return mishear;
    }
}