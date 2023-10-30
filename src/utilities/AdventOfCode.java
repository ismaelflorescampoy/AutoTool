package utilities;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @class AdventOfCode 
 * @brief A library of solutions for Advent of Code problems. All function names must start with 'solveAdventOfCode'
 * @author Ismael Flores
 */
public class AdventOfCode {

    /**
     * @brief Solves the "2015day1" problem on Advent of Code (part 1).
     * @param part the part of the problem to solve (1 or 2)
     * @see <a href="https://adventofcode.com/2015/day/1">https://adventofcode.com/2015/day/1</a>
     */
    public static void solveAdventOfCode2015day1(String part) {
        Scanner scn = new Scanner(System.in);
        String S = scn.next();
        long floor = 0;
        long position = 1;
        long basement_position = 0;
        for (char c : S.toCharArray()) {
            if (c == '(')
                floor++;
            else
                floor--;
            if (floor == -1 && basement_position == 0)
                basement_position = position;
            position++;
        }
        if (part.equals("1"))
            System.out.println(floor);
        else
            System.out.println(basement_position);
        scn.close();
    }

    /*
     * @brief: Method to show the Advent Of Code solved problems implemented.
     * It shows all procedures with name starting with "solveAdventOfCode".
     */
    public static void showAdventOfCodeSolvedProblems() {
        String prefix = "solveAdventOfCode";
        for (Method m : AdventOfCode.class.getDeclaredMethods()) {
            if (m.getName().startsWith(prefix))
                System.out.println(m.getName().substring(prefix.length()) + " with procedure " + m.getName());
        }
    }
}