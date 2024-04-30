package be.intecbrussel.service;

import be.intecbrussel.connection.JPAUtil;
import be.intecbrussel.model.Student;
import be.intecbrussel.repository.CRUDOpearations;

import javax.persistence.EntityManager;
import java.util.Optional;

public class StudentService {
    private CRUDOpearations crudOperations = new CRUDOpearations();
    public void createStudent(Student student)
    {
        EntityManager en = JPAUtil.getEntityManager();
        crudOperations.insertEntity(en,student);
        en.close();
    }

    public Optional<Student> findEntity(int id)
    {
        EntityManager en = JPAUtil.getEntityManager();
        Optional<Student> optionalStudent = crudOperations.findEntity(en,id);
        en.close();
        return optionalStudent;
    }
    public void updateEntity(Student student)
    {
        EntityManager en = JPAUtil.getEntityManager();
        int studentId = student.getId();
        Optional<Student> optionalStudent = crudOperations.findEntity(en,studentId);
        if(optionalStudent.isEmpty())
        {
            en.close();
            return;
        }
        Student updatedStudent = optionalStudent.get();
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        crudOperations.updateEntity(en,updatedStudent);
        en.close();
    }

    public void removeEntity(int id)
    {
        EntityManager en = JPAUtil.getEntityManager();
        Optional<Student> optionalStudent = crudOperations.findEntity(en,id);
        if(optionalStudent.isPresent())
        {
            crudOperations.removeEntity(en,optionalStudent.get());
        }
        en.close();

    }




}
