package dangerwind.code;

public class Sercher {

    public static String SerchMain(String input) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        String sign ="";
        boolean switcher = false;

        char[] chString = input.toCharArray();

        for (var i = 0 ; i < chString.length ; i++) {
            var ch = chString[i];

            if ((ch == '+' || ch == '-')) {
                if (!switcher) {
                    first.delete(0, first.length());
                    continue;
                } else {
                    if (!second.isEmpty()) {
                        break;
                    }
                }
            }
            if ((ch == '*' || ch == '/') && (!switcher)) {
                switcher = true;
                sign = String.valueOf(ch);
            } else {
                if (!switcher) {
                    first.append(ch);
                } else {
                    second.append(ch);
                }
            }
        }

        if (first.isEmpty() || second.isEmpty() || sign.isEmpty()) {
            return "";
        }
        first.append(sign).append(second);
        return first.toString();
    }

    public static String SearchBrMain(String checkingString) {
        char[] lettersToCheck = checkingString.toCharArray();
        StringBuilder strToCalculate = new StringBuilder();
        boolean flagStart = false;

        for (var ch : lettersToCheck) {
            if (ch == ')' & flagStart) {
                return strToCalculate.toString();
            }

            if (flagStart) {
                strToCalculate.append(ch);
            }

            if (ch == '(') {
                flagStart = true;
                strToCalculate = new StringBuilder();
            }
        }
        return "";
    }
}
