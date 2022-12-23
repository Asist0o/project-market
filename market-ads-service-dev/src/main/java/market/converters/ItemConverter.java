package market.converters;

import market.dto.ItemDto;
import market.model.Item;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    private final ModelMapper modelMapper;

    public ItemConverter() {
        this.modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Item.class, ItemDto.class).addMapping(Item::getItemCondition, ItemDto::setItemCondition);
    }

    public ItemDto convertToDto(Item item) {
        return modelMapper.map(item, ItemDto.class);
    }

    public Item convertToEntity(ItemDto itemDto) {
        return modelMapper.map(itemDto, Item.class);
    }
}
