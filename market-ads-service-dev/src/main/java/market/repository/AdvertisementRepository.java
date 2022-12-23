package market.repository;

import market.model.Advertisement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AdvertisementRepository extends PagingAndSortingRepository<Advertisement, Long> {

    List<Advertisement> findAll();

    Page<Advertisement> findAllByDescriptionLikeIgnoreCase(Pageable pageable, String description);

    List<Advertisement> getAdvertisementsByImportant(Boolean important);

    Advertisement getAdvertisementById(Long id);
}
