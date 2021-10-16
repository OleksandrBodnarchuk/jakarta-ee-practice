package pl.alex.exchangeratecalculator;

import java.math.BigDecimal;

public enum ExchangeType {
    EURPLN("EUR","PLN",new BigDecimal("4.35")),
    PLNEUR("PLN","EUR", new BigDecimal("0.23"));

    private final String base;
    private final String target;
    private final BigDecimal rate;


    ExchangeType(String base, String target, BigDecimal rate) {
        this.base = base;
        this.target = target;
        this.rate = rate;
    }

    public String getBase() {
        return base;
    }

    public String getTarget() {
        return target;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
