package rs.leadit.learinig.nikola.students.database.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name = "Student.getAll", query = "select a from Student a"),
        @NamedQuery(name = "Student.getByEmail", query = "select a from Student a where a.email = :email"),
        @NamedQuery(name = "Student.getById", query = "select a from Student a where a.id = :id"),
        @NamedQuery(name = "Student.deleteStudentById", query = "delete from Student a where a.id = :id")
})
public class Student implements Serializable {
    private static final long serialVersionUID = -839877505786861016L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "Employee_Project",
//            joinColumns = { @JoinColumn(name = "student_id") },
//            inverseJoinColumns = { @JoinColumn(name = "exam_id") }
//    )
    @ManyToMany(targetEntity = Exam.class, fetch = FetchType.EAGER)
    @JoinTable(name = "student_exam"
    ,joinColumns = { @JoinColumn(name = "student_id") }
    ,inverseJoinColumns = { @JoinColumn(name = "exam_id")} )
    private List<Exam> exams = new ArrayList<>();

    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
//    @ManyToMany
//    @JoinTable(name = "students_books",
//    joinColumns = "student_id",
//    inverseJoinColumns = "book_id")
//    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fName='" + firstName + '\'' +
                ", lName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}
