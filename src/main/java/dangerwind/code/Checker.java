package dangerwind.code;

public class Checker {

    public static boolean checkSymbols(String checkingString) {
        String allowedLetter = "[0-9 +\\-*/().]*";
        return checkingString.matches(allowedLetter);
    }

    public static boolean signAndBrackets (String checkingString) {
        String[] invalidComb = {"()", ")(", "-\\", "+\\","+*", "-*", "*\\", "\\*", "\\\\", "**",
                "-)", "+)", "*)", "\\)", "(\\", "(*"};

        for (var strInv : invalidComb) {
            if (checkingString.contains(strInv)) {
                return false;
            }
        }

        var lastSim = checkingString.charAt(checkingString.length() - 1);
        return lastSim != '-' && lastSim != '+' && lastSim != '*' && lastSim != '/';

    }
    public static boolean checkBrackets (String checkingString) {

        char[] lettersToCheck = checkingString.toCharArray();
        int countOfBrecket = 0;
        for (var ch : lettersToCheck) {
            if (ch == '(') {
                countOfBrecket++;
            } else {
                if (ch == ')') {
                    countOfBrecket--;
                }
            }

            if (countOfBrecket < 0) {
                return false;
            }
        }
        return countOfBrecket == 0;
    }

}
