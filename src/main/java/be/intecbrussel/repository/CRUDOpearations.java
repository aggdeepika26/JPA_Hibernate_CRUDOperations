package be.intecbrussel.repository;

import be.intecbrussel.model.Student;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CRUDOpearations {
    public void insertEntity(EntityManager en, Student student) {
        //voeg code hier toe.

       // Student student = new Student("Rame","Fadatare","rames@javaguides.com");
        en.getTransaction().begin();
        en.persist(student);
        en.getTransaction().commit();
    }
    public Optional<Student> findEntity(EntityManager en, int id)
    {
        Student student = en.find(Student.class,id);
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        return Optional.ofNullable(student);
    }
    public void updateEntity(EntityManager en,Student student ) {
        en.getTransaction().begin();
        en.merge(student);
        en.getTransaction().commit();
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());

    }
    public void removeEntity(EntityManager en, Student student) {
        en.getTransaction().begin();
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        en.remove(student);
        en.getTransaction().commit();

    }
}


