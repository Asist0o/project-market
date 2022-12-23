package market.service.Impl;

import market.dao.PageDtoDao;
import market.dto.PageDto;
import market.service.PageDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PageDtoServiceImpl<T> implements PageDtoService<T> {

    private final PageDtoDao<T> pageDtoDao;

    @Autowired
    public PageDtoServiceImpl(PageDtoDao<T> pageDtoDao) {
        this.pageDtoDao = pageDtoDao;
    }

    @Override
    public PageDto<T> getPageDto(int currentPage, int countOnPage, String search) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.setTotalEntitiesCount(pageDtoDao.getTotalEntitiesCount());
        pageDto.setCurrentPage(currentPage);
        pageDto.setCountOnPage(countOnPage);
        pageDto.setPageCount((int)(pageDto.getTotalEntitiesCount() / countOnPage) + 1);
        pageDto.setEntities(pageDtoDao.getEntitiesList(currentPage, countOnPage, search));
        return pageDto;
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<T> getInterestingPageDto(int currentPage, int countOnPage) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.setTotalEntitiesCount(pageDtoDao.getInterestingEntitiesCount());
        pageDto.setCurrentPage(currentPage);
        pageDto.setCountOnPage(countOnPage);
        pageDto.setPageCount((int)(pageDto.getTotalEntitiesCount() / countOnPage) + 1);
        pageDto.setEntities(pageDtoDao.getInterestingList(currentPage, countOnPage));
        return pageDto;
    }

}