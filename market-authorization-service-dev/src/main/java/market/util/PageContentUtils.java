package market.util;

import market.dto.converter.Converter;
import market.dto.page.PageContentResponseDto;
import market.dto.page.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class PageContentUtils<E, D> {

    public PageContentResponseDto<D> getPageContentDto(Page<E> page, Converter<E, D> converter, Pageable pageable) {

        return new PageContentResponseDto<>(
                new PageDto(
                        page.getTotalElements(),
                        page.getTotalPages(),
                        pageable.getPageNumber() + 1,
                        pageable.getPageSize(),
                        pageable.getOffset(),
                        pageable.hasPrevious()
                ),
                page.getContent().isEmpty() ?
                        Collections.emptyList() :
                        page.getContent().stream().map(converter::convertToDto).collect(Collectors.toList())
        );
    }
}
