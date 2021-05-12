package repository.daos;

import java.util.List;

import repository.models.User;

public interface UserDao {

    // crud operations
    int add(User u);

    List<User> getAll();

    User get(User i);

    User getByUsername(String username);

    User update(User i);

    int remove(User i);

}
