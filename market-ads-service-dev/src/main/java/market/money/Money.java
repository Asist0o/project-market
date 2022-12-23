package market.money;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Money {

    @Id
    private Long id;
    private Currency currency;
    private Double value;

    public Money(Currency currency, Double value) {
        this.currency = currency;
        this.value = value;
    }

    public static Money of(Currency currency, Double value) {
        return new Money(currency, value);
    }

    public static Money of(String currency, Double value) {
        return new Money(Currency.valueOf(currency), value);
    }

    public static Money of(String currencyAndValue) {
        return new Money(Currency.valueOf(currencyAndValue.split(" ")[0]),
                Double.valueOf(currencyAndValue.split(" ")[1]));
    }
}
