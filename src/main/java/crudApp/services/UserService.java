package crudApp.services;

import java.util.List;
import crudApp.entity.User;

public interface UserService {
    void addNewUser(User user);

    void removeUserByID(Long userID);

    void changeUser(User user);

    List<User> getListOfUsers();

    User getUserByID(Long ID);
}

