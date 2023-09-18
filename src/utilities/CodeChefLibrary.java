package utilities;

/**
 * @class CodeChefLibrary
 * @brief A library of utility functions for CodeChef problems
 * @author 
 */
public class CodeChefLibrary {

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
}