package repository.daos;

import java.util.List;

import repository.models.User;

public interface UserDao {

    // crud operations
    User add(User u);

    List<User> getAll();

    User get(User i);

    int update(User i);

    int remove(User i);

}
