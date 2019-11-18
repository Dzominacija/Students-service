package rs.leadit.learning.nikola.students.business.logic;

import rs.leadit.learinig.nikola.students.database.model.Exam;
import rs.leadit.learinig.nikola.students.database.model.Student;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class StudentsManager implements Serializable {
    private static final long serialVersionUID = 2777191271935562489L;

    @Inject
    private EntityManager entityManager;

    public StudentsManager() {
        System.out.println("Creating students manager");
    }

    @Transactional
    public Student createNewStudent(Student student) {
        entityManager.persist(student);
        return student;
        //entityManager.flush();
        //entityManager.remove(student);
        //entityManager.find(Student.class, 15);
    }

    @Transactional
    public Student updateStudentById(int id, Student student) {
        Student student1 = entityManager.find(Student.class, id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setExams(student.getExams());
        entityManager.persist(student1);
        return student1;
    }

    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    public Student getStudentByEmail(String email) {
        return entityManager.createNamedQuery("Student.getByEmail", Student.class)
                .setParameter("email", email)
                .getSingleResult();
    }
    public List<Exam> getExamsByStudentId(int id) {
        Student s = entityManager.find(Student.class, id);
        List<Exam> exams = s.getExams();
        return exams;
    }

    public List<Student> getAllStudents() {
        return entityManager.createNamedQuery("Student.getAll", Student.class).getResultList();
    }

    @Transactional
    public String deleteStudentById(int id) {
        entityManager.remove(entityManager.find(Student.class,id));
        return "Object with " + id + " deleted";
    }
}
