//package market.service.impl;
//
//import lombok.AllArgsConstructor;
//import market.repository.ExistRepository;
//import market.service.CheckExistService;
//import org.springframework.stereotype.Service;
//
//@AllArgsConstructor
//@Service
//public class CheckExistServiceImpl<T> implements CheckExistService<T> {
//
//    private final ExistRepository<T> existRepository;
//
//    @Override
//    public Boolean checkExistsEntity(Long id) {
//        return existRepository.existsById(id);
//    }
//}
