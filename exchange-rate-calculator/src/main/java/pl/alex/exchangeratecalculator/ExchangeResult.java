package pl.alex.exchangeratecalculator;

import java.math.BigDecimal;

public class ExchangeResult {
    private final BigDecimal base;
    private final BigDecimal result;
    private final ExchangeType type;

    public ExchangeResult(BigDecimal base, BigDecimal result, ExchangeType type) {
        this.base = base;
        this.result = result;
        this.type = type;
    }

    public BigDecimal getBase() {
        return base;
    }

    public BigDecimal getResult() {
        return result;
    }

    public ExchangeType getType() {
        return type;
    }
}
