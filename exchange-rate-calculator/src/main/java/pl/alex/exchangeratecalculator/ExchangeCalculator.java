package pl.alex.exchangeratecalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeCalculator {
    static ExchangeResult calculate(BigDecimal base, ExchangeType type){
        BigDecimal exchangeRate = type.getRate();
        BigDecimal result = base.multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP);
        return new ExchangeResult(base,result,type);
    }
}
