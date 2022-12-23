package market.repository;

import market.model.Report;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {
    List<Report> findAllByMessageContaining(String str, Pageable pageable);

//    @Query("SELECT r FROM Report r WHERE r.createDate between :startDate and :endDate")
//    List<Report> findAllByMessageContaining(@Param("startDate") ZonedDateTime startDate,
//                                            @Param("endDate") ZonedDateTime endDate,
//                                            Pageable pageable);
}
