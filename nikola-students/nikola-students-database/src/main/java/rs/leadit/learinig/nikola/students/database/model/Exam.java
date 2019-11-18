package rs.leadit.learinig.nikola.students.database.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exam")
@NamedQueries({
        @NamedQuery(name = "Exam.getAllExams", query = "select e from Exam e"),
        @NamedQuery(name = "Exam.deleteExamById", query = "delete from Exam e where e.id = :id"),
        @NamedQuery(name = "Exam.findExamById", query = "select e from Exam e where e.id = :id")
})
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private int id;
    @Column(name = "exam_name",nullable = false)
    private String examName;

    @OneToMany(targetEntity = Book.class, mappedBy = "exam")
    private List<Book> books = new ArrayList<>();

    public Exam() {
    }

    public Exam(String examName) {
        this.examName = examName;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

}
