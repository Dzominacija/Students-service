package rs.leadit.learning.nikola.students.business.logic;

import rs.leadit.learinig.nikola.students.database.model.Book;
import rs.leadit.learinig.nikola.students.database.model.Exam;
import rs.leadit.learinig.nikola.students.database.model.Student;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
public class ExamManager {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Exam createExam(Exam exam) {
        entityManager.persist(exam);
        return exam;
    }
    @Transactional
    public Exam updateExamById(int id, Exam exam) {
        Exam exam1 = entityManager.createNamedQuery("Exam.findExamById", Exam.class)
                .setParameter("id", id).getSingleResult();
        exam1.setExamName(exam.getExamName());
        entityManager.persist(exam1);
        return exam1;
    }

    public Exam findExamById(int exam_id) {
        return entityManager.createNamedQuery("Exam.findExamById", Exam.class).setParameter("id", exam_id)
                .getSingleResult();
    }

    public List<Exam> getAllExams() {
        return entityManager.createNamedQuery("Exam.getAllExams", Exam.class).getResultList();
    }

    @Transactional
    public String deleteExamById(int id) {
        entityManager.remove(entityManager.find(Exam.class,id));
        return "Object with " +  id + " deleted";
    }
}
