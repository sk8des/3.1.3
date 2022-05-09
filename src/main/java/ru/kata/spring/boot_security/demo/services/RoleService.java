package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RoleService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> getRoles() {
        return entityManager.createQuery("select role from Role role", Role.class).getResultList();
    }
}
