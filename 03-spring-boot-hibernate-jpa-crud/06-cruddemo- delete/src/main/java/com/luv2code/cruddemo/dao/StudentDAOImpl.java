package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    //implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {

        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create Query //queries are for the entity Student and not the table student
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);

        //return result list
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);

        //set query parameters
        theQuery.setParameter("theData", theLastName);

        //return list
        return theQuery.getResultList();

    }

    @Override
    @Transactional//beacause we are making changes in database
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional//beacause we are making changes in database
    public void delete(int id) {

        //find student with id
        Student theStudent = entityManager.find(Student.class, id);

        //remove that student
        entityManager.remove(theStudent);
    }


}
