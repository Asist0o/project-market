package market.service.Impl;

import market.model.SizeName;
import market.repository.SizeNameRepository;
import market.service.SizeNameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SizeNameServiceImpl implements SizeNameServices {

    private final SizeNameRepository sizeNameRepository;

    @Autowired
    public SizeNameServiceImpl(SizeNameRepository sizeNameRepository) {
        this.sizeNameRepository = sizeNameRepository;
    }

    @Override
    public List<SizeName> findAll() {
        return sizeNameRepository.findAll();
    }

    @Override
    public SizeName findById(long id) {
        return sizeNameRepository.getById(id);
    }

    @Override
    @Transactional
    public void save(SizeName size) {
        sizeNameRepository.save(size);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        sizeNameRepository.deleteById(id);
    }

    @Override
    public SizeName getSizeName(String name) {
        return sizeNameRepository.getSizeNameByName(name);
    }

    @Override
    public boolean checkSizeName(String name) {
        return sizeNameRepository.existsByName(name);
    }
}
