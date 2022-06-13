package com.dao;

import com.model.Employee;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e from Employee e", Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        em.persist(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        TypedQuery<Employee> query = em.createQuery("select employee from Employee employee where employee.id = :id", Employee.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


    @Override
    public void deleteEmployee(Long id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        em.merge(employee);
    }
}
