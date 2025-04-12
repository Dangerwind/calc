package dangerwind.code;

import java.util.regex.Pattern;

import static dangerwind.code.Checker.*;
import static dangerwind.code.Repository.LogAdd;
import static dangerwind.code.Repository.LogAddP;
import static dangerwind.code.Repository.LogAddP;
import static dangerwind.code.Sercher.SerchMain;
import static dangerwind.code.Sercher.searchBrMain;

public class Calculate {
    public static String SymplCalc(String inputS) {
        String input = inputS;

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        boolean changeFlag = true;

        while(changeFlag) {
            changeFlag = false;
            first.delete(0, first.length());
            second.delete(0, second.length());
            String sign ="";
            boolean switcher = false;

            char[] chString = input.toCharArray();
            first.append(chString[0]);

            for (var i = 1 ; i < chString.length ; i++) {
                var ch = chString[i];
                if ((ch == '+' || ch == '-' || ch == '*' || ch == '/') && (!switcher)) {
                    switcher = true;
                    sign = String.valueOf(ch);
                    i++;
                    second.append(chString[i]);
                } else {
                    if (!switcher) {
                        first.append(ch);
                    } else {
                        if ((ch == '+' || ch == '-' || ch == '*' || ch == '/')) {
                            break;
                        }
                        second.append(ch);
                    }
                }
            }
            if (switcher) {
                var num1 = Double.parseDouble(first.toString());
                var num2 = Double.parseDouble(second.toString());
                double result = 0;
                switch (sign) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                }

                String subst = first + sign + second;
                input = input.replaceFirst(Pattern.quote(subst), String.valueOf(result));
                switcher = false;
                changeFlag = true;
            }

        }
        return input;

    }


    public static String FinalCalc(String inputString) {
        LogAdd("Вы ввели: " + inputString);
        Repository.setMainString(inputString);
        var formStr = Repository.getMainString();
        LogAdd("Убрали лишние пробелы: " + formStr);
        if (!checkSymbols(formStr)) {
            LogAdd("Непонятные символы вы используете");
            return "";
        }
        if (!checkBrackets(formStr)) {
            LogAdd("Вы со скобками напутали");
            return "";
        }

        if (!signAndBrackets(formStr)) {
            LogAdd("Математические знаки неправильно расставлены ");
            return "";
        }

        boolean ifCharnge = true;
        while(ifCharnge) {
            ifCharnge = false;
            formStr = Repository.getMainString();
            var eqq = searchBrMain(formStr);
            var origEqq = eqq;
            if (!eqq.isEmpty()) {
                LogAdd("Вычисяем скобки (" + eqq + ")");
                boolean flag = true;
                while(flag) {
                    flag = false;
                    var xxx = SerchMain(eqq);
                    if (!xxx.isEmpty()) {
                        LogAddP( xxx + "=");
                        var rez = SymplCalc(xxx);
                        if (!rez.isEmpty()) {
                            LogAdd(rez);
                            eqq = eqq.replaceFirst(Pattern.quote(xxx), rez);
                            flag = true;
                        } else {

                        }
                    }
                }
                var otv = SymplCalc(eqq);
                Repository.changeString("("+origEqq+")", otv);
                LogAdd("Получилось что (" + origEqq + ")=" + otv);

                var mainRez = Repository.getMainString();
                mainRez = mainRez.replaceFirst(Pattern.quote("--"), "+");
                mainRez = mainRez.replaceFirst(Pattern.quote("++"), "+");
                mainRez = mainRez.replaceFirst(Pattern.quote("+-"), "-");
                mainRez = mainRez.replaceFirst(Pattern.quote("-+"), "-");
                mainRez = mainRez.replaceFirst(Pattern.quote("*+"), "*");
                mainRez = mainRez.replaceFirst(Pattern.quote("/+"), "/");
                Repository.setMainString(mainRez);
                ifCharnge = true;
            }
        }
        var mainRez = Repository.getMainString();
        LogAdd("Потом считаем все что осталось " + mainRez);
        boolean flag = true;
        while(flag) {
            flag = false;
            var xxx = SerchMain(mainRez);
            if (!xxx.isEmpty()) {
                LogAddP( xxx + "=");
                var rez = SymplCalc(xxx);
                if (!rez.isEmpty()) {
                    LogAdd(rez);
                    mainRez = mainRez.replaceFirst(Pattern.quote(xxx), rez);
                    flag = true;
                }
            }
        }
        var itogo = SymplCalc(mainRez);
        Repository.setMainString(itogo);
        LogAdd("Ответ: ");
        LogAdd(inputString + "=" + Repository.getMainString());

        return itogo;
    }
}


