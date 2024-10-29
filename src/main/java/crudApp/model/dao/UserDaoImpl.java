package crudApp.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import crudApp.model.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public void saveUser(User user) {
        em.persist(user);
    }

    public void deleteUserDaoById(Long ID) {
        User user = em.find(User.class, ID);
        em.remove(user);
    }

    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public User findUserById(Long userId) {
        return em.find(User.class, userId);
    }

    public void changeUserDao(User updUser) {
        em.merge(updUser);
    }
}
