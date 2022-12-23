package market.service;

import market.model.SizeName;

import java.util.List;

public interface SizeNameServices {
    List<SizeName> findAll();
    SizeName findById(long id);
    void save(SizeName size);
    void deleteById(long id);
    SizeName getSizeName(String name);
    boolean checkSizeName(String name);
}
