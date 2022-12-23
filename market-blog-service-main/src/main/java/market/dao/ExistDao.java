package market.dao;

public interface ExistDao {

    Boolean checkExistsEntity(Class entity, Long id);
}
