package market.converters;

import market.dto.AdsDto;
import market.dto.ItemDto;
import market.model.Advertisement;
import market.model.Item;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AdsConverter {

    private final ModelMapper modelMapper;
    private final Converter<Item,ItemDto> itemItemDtoConverter = mappingContext -> {
        ItemConverter itemConverter = new ItemConverter();
        return itemConverter.convertToDto(mappingContext.getSource());
    };
    private final Converter<ItemDto,Item> itemDtoItemConverter = mappingContext -> {
        ItemConverter itemConverter = new ItemConverter();
        return itemConverter.convertToEntity(mappingContext.getSource());
    };

    public AdsConverter() {
        this.modelMapper = new ModelMapper();


        modelMapper.createTypeMap(Advertisement.class, AdsDto.class).
                addMappings(mapper -> mapper.using(itemItemDtoConverter).map(Advertisement::getItem, AdsDto::setItemDto));

        modelMapper.createTypeMap(AdsDto.class, Advertisement.class)
                .addMappings(mapper -> mapper.using(itemDtoItemConverter).map(AdsDto::getItemDto, Advertisement::setItem));
    }

    public AdsDto convertToDto(Advertisement advertisement) {
        return modelMapper.map(advertisement, AdsDto.class);
    }

    public Advertisement convertToEntity(AdsDto adsDto) {
        return modelMapper.map(adsDto, Advertisement.class);
    }

}
