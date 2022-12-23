package market.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvInfoForPostDto {
    private Long idAdvertisement;
    private String description;
    private Set<Long> idImages;
}
