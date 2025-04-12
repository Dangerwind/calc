package dangerwind.code;


import dangerwind.code.Repository;
import org.junit.jupiter.api.Test;

import static dangerwind.code.Calculate.FinalCalc;
import static dangerwind.code.Calculate.SymplCalc;
import static dangerwind.code.Checker.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AppTest {

    @Test
    public void testCheckBrackets() {
        var str = "5 * 7 + (5-(6*4*(+5-3))) + (-1+-2) - 6/(5-(-12*+2-3/1))";
        System.out.println("Вначале: " + str);

        Repository.setMainString(str);

        assertTrue(checkSymbols(str));
        assertTrue(checkBrackets(str));
        assertTrue(signAndBrackets(str));
    }

    @Test
    public void testFCalc() {
        // var reppo = new Repository("", "");
        var str = "5 * 7 + (5-(6*4*(+5+3*2 + 4*2))) + (-1+-2) - 6/(5-(-12*+2-3/1))";
        assertEquals("-419.1875", FinalCalc(str));
    }

    @Test
    public void testSimplCalc() {
        var str = "4/2-2+5-8";
        assertEquals("-3.0", symplCalc(str));
    }


}
