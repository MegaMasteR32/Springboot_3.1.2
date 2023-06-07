package com.example.springboot.dao;


import com.example.springboot.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;




    @Override
    @Transactional
    public void saveUser(User user) {
//        entityManager.getCurrentSession().saveOrUpdate(user);
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void delete(int id) {
//        TypedQuery<User> query = entityManager.getCurrentSession().createQuery("delete from User where id =:userID");
//        query.setParameter("userID", id);
//        query.executeUpdate();
        entityManager.createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.flush();

    }

    @Override
    @Transactional
    public User getById(int id) {
//        return entityManager.getCurrentSession().get(User.class, id);
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
//        TypedQuery<User> query = entityManager.getCurrentSession().createQuery("from User");
//        return query.getResultList();
        return entityManager.createQuery("from User").getResultList();
    }
}