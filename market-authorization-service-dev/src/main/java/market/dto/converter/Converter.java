package market.dto.converter;

public interface Converter<M, D> {

    M convertToModel(D dto);

    D convertToDto(M model);
}