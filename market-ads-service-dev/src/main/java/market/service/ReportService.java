package market.service;

import market.model.Report;

import java.util.List;

public interface ReportService {
    List<Report> findAll(int PageNumber, int PageSize);
    List<Report> findAllByMessageContaining(String str, int PageNumber, int PageSize);
//    List<Report> findAllByCreateDate(String str, int PageNumber, int PageSize);
//    List<Report> findAllByStatus(String str, int PageNumber, int PageSize);
}
