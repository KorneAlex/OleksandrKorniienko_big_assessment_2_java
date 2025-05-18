package utils;

/**
 * This class contains utilities to check different types of data
 */
public class Checkers {
    public static boolean isYes(String answer) { // if yes then true, else - default
        /**
         * This method check if given string is not empty and if the first character of the string is "y" or "Y",
         * returns true
         *
         * @param answer the string that has to be checked
         * @return true if the first character of the string is "y" or "Y".
         */
        if (0 < answer.length()) {
            if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean YesNotTF(String string) {
        return string.equalsIgnoreCase("y") || string.equalsIgnoreCase("yes") || string.equalsIgnoreCase("true") || string.equals("+");
    }

    public static double maxOfTwo(double one, double two) {
        return one > two ? one : two;
    }


        /** This method gets sting and tries to parse an integer between min and max.
         If not - creates recursion until the number that fit our expectations entered.
         P.S. I had two of these methods, but I created a universal one! DRY!
         */
    public static int isInRange(int min, int max) {
        String pos = ScannerInput.nextLine();
        try {
            int num = Integer.parseInt(pos);
            if (min <= num && num <= max) {
                return num;
            } else {
                System.out.print("\nEntered number is not in range [ " + min + ", " + max + "]. Try again: ");
                return isInRange(min, max);
            }
        } catch (NumberFormatException e) {
            System.out.print("\nPlease enter a number in range [ " + min + ", " + max + "]: ");
            return isInRange(min, max);
        }
    }

    public static int isInRange(int min, int max, int defaultValue) {
        /** This method gets sting and tries to parse an integer between min and max.
         If not - creates recursion until the number that fit our expectations entered.
         P.S. I had two of these methods, but I created a universal one! DRY!
         */
        String pos = ScannerInput.nextLine();
        if (pos.equalsIgnoreCase("c")) {
            System.out.println("Edit cancelled");
            return defaultValue;
        } else {
            try {
                int num = Integer.parseInt(pos);
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.print("\nEntered number is not in range [ " + min + ", " + max + "]. Try again: ");
                    return isInRange(min, max);
                }
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter a number in range [ " + min + ", " + max + "]: ");
                return isInRange(min, max);
            }
        }
    }

    public static double isInRange(double min, double max, double defaultValue) {
        /** This method gets sting and tries to parse an double between min and max.
         If not - creates recursion until the number that fit our expectations entered.
         P.S. I had two of these methods, but I created a universal one! DRY!
         */
        String pos = ScannerInput.nextLine();
        if (pos.equalsIgnoreCase("c")) {
            return defaultValue;
        } else {
            try {
                double num = Double.parseDouble(pos);
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.print("\nEntered number is not in range [ " + min + ", " + max + "]. Try again: ");
                    return isInRange(min, max, defaultValue);
                }
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter a number in range [ " + min + ", " + max + "]: ");
                return isInRange(min, max, defaultValue);
            }
        }
    }

    public static double isInRange(double min, double max) {
        /** This method gets sting and tries to parse an double between min and max.
         If not - creates recursion until the number that fit our expectations entered.
         P.S. I had two of these methods, but I created a universal one! DRY!
         */
        String pos = ScannerInput.nextLine();
        try {
            double num = Double.parseDouble(pos);
            if (min <= num && num <= max) {
                return num;
            } else {
                System.err.print("\nEntered number is not in range [ " + min + ", " + max + "]. Try again: ");
                return isInRange(min, max);
            }
        } catch (NumberFormatException e) {
            System.err.print("\nPlease enter a number in range [ " + min + ", " + max + "]: ");
            return isInRange(min, max);
        }
    }

    /**
     * This method returns the user input only if the input is bigger than the min value
     * @param minimumValue the min value to compare with the input
     * @return users' input when bigger than the min value
     */
    public static double inputIsBiggerThan(double minimumValue) {
        double input = ScannerInput.nextDouble();
        if (input > minimumValue) {
            return input;
        }
        System.err.print("\nEntered number is less than " + minimumValue + ". Try again: ");
        return inputIsBiggerThan(minimumValue);
    }

    public static double inputIsInRange(double min, double max) {
        double input = ScannerInput.nextDouble();
        if (input >= min && input <= max) {
            return input;
        }
        System.err.print("\nEntered number is not in range " + min + " and " + max + ". Try again: ");
        return inputIsInRange(min, max);
    }
}
