package converter.ejb;

import java.math.BigDecimal;


/**
 * This is the bean class for the ConverterBean enterprise bean.
 * @author ian
 */
@Stateless
public class ConverterBean {
    private BigDecimal euroRate = new BigDecimal("0.0078");
    private BigDecimal yenRate = new BigDecimal("96.0650");

    public BigDecimal dollarToYen(BigDecimal dollars) {
        BigDecimal result = dollars.multiply(yenRate);

        return result.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal yenToEuro(BigDecimal yen) {
        BigDecimal result = yen.multiply(euroRate);

        return result.setScale(2, BigDecimal.ROUND_UP);
    }
}
