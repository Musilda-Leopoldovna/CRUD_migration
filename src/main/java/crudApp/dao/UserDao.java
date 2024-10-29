package crudApp.dao;

import java.util.List;
import crudApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    void saveUser(User user);

    void deleteUserDaoByID(Long Id);

    void changeUserDao(User user);

    List<User> allUsers();

    User findUserByID(Long Id);
}
