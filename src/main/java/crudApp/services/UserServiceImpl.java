package crudApp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import crudApp.dao.UserDao;
import crudApp.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<User> getListOfUsers() {
        return userDao.findAll();
    }

    public void addNewUser(User user) {
        userDao.save(user);
    }

    public void removeUserByID(Long ID) {
        userDao.deleteById(ID);
    }

    public void changeUser(User updUser) {
        userDao.save(updUser);
    }

    public User getUserByID(Long userId) {
        return userDao.findById(userId).orElse(new User());
    }
}

