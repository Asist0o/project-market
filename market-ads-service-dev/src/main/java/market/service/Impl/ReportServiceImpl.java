package market.service.Impl;

import market.model.Report;
import market.repository.ReportRepository;
import market.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService {

   private final ReportRepository repository;

    @Autowired
    public ReportServiceImpl(ReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Report> findAll(int PageNumber, int PageSize) {
        Pageable paging = PageRequest.of(PageNumber, PageSize);
        Page<Report> pagedResult = repository.findAll(paging);
        return pagedResult.stream().toList();
    }

    @Override
    public List<Report> findAllByMessageContaining(String str, int PageNumber, int PageSize) {
        Pageable paging = PageRequest.of(PageNumber, PageSize);
        return repository.findAllByMessageContaining(str, paging);
    }

//    @Override
//    public List<Report> findAllByCreateDate(String str, int PageNumber, int PageSize) {
//        Pageable paging = PageRequest.of(PageNumber, PageSize);
//        return repository.findAllByMessageContaining(str, paging);
//    }
//
//    @Override
//    public List<Report> findAllByStatus(String str, int PageNumber, int PageSize) {
//        return null;
//    }
}
