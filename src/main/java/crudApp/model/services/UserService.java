package crudApp.model.services;

import java.util.List;
import crudApp.model.entity.User;

public interface UserService {
    void addNewUser(User user);

    void removeUserById(Long userID);

    void changeUser(User user);

    List<User> getListOfUsers();

    User getUserById(Long ID);
}

