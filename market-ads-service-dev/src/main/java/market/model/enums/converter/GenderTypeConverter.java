package market.model.enums.converter;

import market.model.enums.GenderType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenderTypeConverter implements AttributeConverter<GenderType, String> {
    @Override
    public String convertToDatabaseColumn(GenderType genderType) {
        if (genderType == null) {
            return null;
        }
        return genderType.getNameGenderType();
    }

    @Override
    public GenderType convertToEntityAttribute(String nameGenderType) {
        if (nameGenderType == null) {
            return null;
        }

        return Stream.of(GenderType.values())
                .filter(c -> c.getNameGenderType().equals(nameGenderType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
