package dangerwind.code;

import java.util.Scanner;
import static dangerwind.code.Calculate.FinalCalc;
import static dangerwind.code.Repository.*;


public class App {


    public static void main(String[] args) {

        System.out.println("Консольный калькулятор\n");
        while (true) {
            LogClear();
            System.out.println("Введите выражение (можно использовать скобки) и нажмите enter");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            var ttt = FinalCalc(input);

            System.out.println(getLogOperation().toString());
            System.out.println(ttt);
            System.out.print("Считаем еще раз? Enter или Y-да, N-нет]: ");
            input = scanner.nextLine();
            if (!input.equals("Y") && !input.equals("y") && !input.isEmpty()) {
                break;
            }
            System.out.println();
        }
        System.out.println("Спасибо за рассчеты! ");
    }
}

