package rs.leadit.learinig.nikola.students.database.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name = "Book.getAll", query = "select b from Book b"),
        @NamedQuery(name = "Book.getBookByName", query = "select b from Book b where b.title = :title"),
        @NamedQuery(name = "Book.getBooksByExamId", query = "select b from Book b where b.exam.id = :id"),
        @NamedQuery(name = "Book.findBookById", query = "select b from Book b where b.id = :id"),
        @NamedQuery(name = "Book.deleteBookById", query = "delete from Book b where b.id = :id")
})
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "writer", nullable = false)
    private String writer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_id", foreignKey = @ForeignKey(name = "fk_exam"))
    private Exam exam;

    public Book() {

    }

    public Book(String title, String writer) {
        this.title = title;
        this.writer = writer;
    }

//    public Book(String title, String writer, Exam exam) {
//        this.title = title;
//        this.writer = writer;
//        this.exam = exam;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", exam=" + exam +
                '}';
    }


    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

}
