package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User findById(long userId) {
        Query query = em.createQuery("select u from User u where u.id = :userId", User.class);
        query.setParameter("userId", userId);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void update(User updateUser) {
        em.merge(updateUser);
    }

    @Override
    public void deleteById(Long userId) {
        em.remove(findById(userId));
    }
}
