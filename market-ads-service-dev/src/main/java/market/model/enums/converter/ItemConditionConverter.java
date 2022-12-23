package market.model.enums.converter;

import market.model.enums.ItemCategoryName;
import market.model.enums.ItemCondition;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ItemConditionConverter implements AttributeConverter<ItemCondition, String> {

    @Override
    public String convertToDatabaseColumn(ItemCondition itemCondition) {
        if (itemCondition == null) {
            return null;
        }
        return itemCondition.getNameItemCondition();
    }

    @Override
    public ItemCondition convertToEntityAttribute(String nameItemCondition) {
        if (nameItemCondition == null) {
            return null;
        }

        return Stream.of(ItemCondition.values())
                .filter(c -> c.getNameItemCondition().equals(nameItemCondition))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
