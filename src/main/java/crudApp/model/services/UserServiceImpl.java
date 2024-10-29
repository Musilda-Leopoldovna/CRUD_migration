package crudApp.model.services;

import java.util.List;
import org.springframework.stereotype.Service;
import crudApp.model.dao.UserDao;
import crudApp.model.entity.User;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getListOfUsers() {
        return userDao.allUsers();
    }

    public void addNewUser(User user) {
        userDao.saveUser(user);
    }

    public void removeUserById(Long ID) {
        userDao.deleteUserDaoById(ID);
    }

    public void changeUser(User updUser) {
        userDao.changeUserDao(updUser);
    }

    public User getUserById(Long userId) {
        return userDao.findUserById(userId);
    }
}

