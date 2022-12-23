package market.money;

public enum Currency {

    USD("USD"),
    EUR("EUR"),
    RUR("RUR"),
    XXX("XXX");

    private final String currencyCode;

    Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return currencyCode;
    }
}
