package market.model.enums.converter;

import market.model.enums.ItemCategoryName;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ItemCategoryNameConverter implements AttributeConverter<ItemCategoryName, String> {

    @Override
    public String convertToDatabaseColumn(ItemCategoryName itemCategoryName) {
        if (itemCategoryName == null) {
            return null;
        }
        return itemCategoryName.getRuName();
    }

    @Override
    public ItemCategoryName convertToEntityAttribute(String ruName) {
        if (ruName == null) {
            return null;
        }

        return Stream.of(ItemCategoryName.values())
                .filter(c -> c.getRuName().equals(ruName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
