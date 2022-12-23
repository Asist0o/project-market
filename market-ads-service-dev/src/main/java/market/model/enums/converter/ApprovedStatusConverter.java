package market.model.enums.converter;

import market.model.enums.ApprovedStatus;
import market.model.enums.GenderType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ApprovedStatusConverter implements AttributeConverter<ApprovedStatus, String> {
    @Override
    public String convertToDatabaseColumn(ApprovedStatus approvedStatus) {
        if (approvedStatus == null) {
            return null;
        }
        return approvedStatus.getNameApprovedStatus();
    }

    @Override
    public ApprovedStatus convertToEntityAttribute(String approvedStatus) {
        if (approvedStatus == null) {
            return null;
        }

        return Stream.of(ApprovedStatus.values())
                .filter(c -> c.getNameApprovedStatus().equals(approvedStatus))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
