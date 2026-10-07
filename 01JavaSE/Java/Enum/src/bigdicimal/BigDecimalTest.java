package bigdicimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        /*System.out.println(0.1+0.2);
        System.out.println(0.1-0.2);
        System.out.println(0.1*0.2);
        System.out.println(0.1/0.2);*/

        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        System.out.println(bd1.multiply(bd2));

        System.out.println(bd1.divide(bd2,2, RoundingMode.DOWN)); //向下进位
        System.out.println(bd1.divide(bd2,2, RoundingMode.FLOOR)); //向上进位
        System.out.println(bd1.divide(bd2,2, RoundingMode.HALF_UP)); //四舍五入
    }
}
