package utils;

/**
 * This class contains utilities to work with Strings
 */
public class StringUtilities {
    public static String truncateString(String stringToTruncate, int length) {
        /**
         * This method takes in a string, passed as a parameter and valdiates whether it is less than or equal to
         * a specific length or not.
         *
         * @param strToCheck The string that will be checked to see if it is a specific length
         * @param maxLength The length that the string will be validated against
         * @return True if the string is less than or equal the max length and false otherwise.
         */
        if (stringToTruncate.length() <= length) {
            return stringToTruncate;
        } else {
            return stringToTruncate.substring(0, length);
        }
    }

    public static String printStars(int num) {
        /**
         * This method creates a string of stars.
         *
         * @param num Stars quantity
         * @return String of stars printed on the new line.
         */
        String theStars = "\n";
        for (int i = 0; i < num; i++) {
            theStars += "*";
        }
        return theStars;
    }

    public static String printSymbols(String symbol, int num) {
        /**
         * This method creates a string of user defined symbols.
         *
         * @param num Symbols quantity
         * @return String of symbols difined by user printed on the same line.
         */
        String printSymbols = "";
        for (int i = 0; i < num; i++) {
            printSymbols += symbol;
        }
        return printSymbols;
    }

    public static String changeStringLength(String str, int length, String symbol) {
        /**
         * This method gets string and make it as long as requested with extra symbols in the beginning in case if the string was shorter or
         * trims it if it was longer
         *
         * @param str the string to modify
         * @param length required length
         * @param symbol symbol to add in front if the string is too short
         * @return Returns the string of wished length
         */
        if (str.length() == length) {
            return str;
        } else if (str.length() < length) {
            return printSymbols(symbol, length - str.length()) + str;
        } else {
            str = str.substring(0, length);
        }
        return str + "";
    }

    /**This method I took from my first assessment
     * It gets a name makes it lovercase, goes one by one character checking their neighbor characters.
     * If the previous character is " " or " O'" or " Mc" then current character becomes capital.
     *
     * @param name gets name from the user
     * @return edited name
     */
}
