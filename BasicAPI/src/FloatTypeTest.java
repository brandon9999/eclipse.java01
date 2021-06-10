import java.math.BigDecimal;


public class FloatTypeTest 
{
    public static void main(String[] args) 
    {
        float f = 0.12345678901234567890f;
        double d = 0.12345678901234567890d;
        BigDecimal b = new BigDecimal("0.12345678901234567890");
 
        System.out.println(String.format("float       %%f: %.20f", f));
        System.out.println(String.format("double      %%f: %.20f", d));
        System.out.println(String.format("BigDecimal  %%f: %.20f", b));
    }
}