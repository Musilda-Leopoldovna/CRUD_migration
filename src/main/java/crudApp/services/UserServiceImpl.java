package crudApp.services;

import java.util.List;
import org.springframework.stereotype.Service;
import crudApp.dao.UserDao;
import crudApp.entity.User;

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

    public void removeUserByID(Long ID) {
        userDao.deleteUserDaoByID(ID);
    }

    public void changeUser(User updUser) {
        userDao.changeUserDao(updUser);
    }

    public User getUserByID(Long userId) {
        return userDao.findUserByID(userId);
    }
}

