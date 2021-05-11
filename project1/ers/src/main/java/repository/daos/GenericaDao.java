package repository.daos;

import java.util.List;

public interface GenericaDao<I> {

    // crud operations
    I add(I i);

    List<I> getAll();

    I get(I i);

    int update(I i);

    int remove(I i);

}
