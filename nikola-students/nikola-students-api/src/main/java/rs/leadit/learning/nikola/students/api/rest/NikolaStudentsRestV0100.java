package rs.leadit.learning.nikola.students.api.rest;


import rs.leadit.learinig.nikola.students.database.model.Book;
import rs.leadit.learinig.nikola.students.database.model.Exam;
import rs.leadit.learinig.nikola.students.database.model.Student;
import rs.leadit.learning.nikola.students.business.logic.BookManager;
import rs.leadit.learning.nikola.students.business.logic.ExamManager;
import rs.leadit.learning.nikola.students.business.logic.LoginManager;
import rs.leadit.learning.nikola.students.business.logic.StudentsManager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@RequestScoped
@Path("/01.00")
public class NikolaStudentsRestV0100 {
    private static int counter = 0;

    public NikolaStudentsRestV0100() {
        System.out.println("Creating NikolaStudentsRestV0100 " + ++counter);
    }

    @Inject
    private LoginManager loginManager;

    @GET
    @Path("/login/{user}/{pass}")
    public boolean login(@PathParam("user") String username, @PathParam("pass") String password) {
        System.gc();
        loginManager.setUsername(username);
        loginManager.setPassword(password);
        return loginManager.login();
    }

    @Inject
    private StudentsManager studentsManager;

    @POST
    @Path("/students/save")
    @Produces({"application/json"})
    public Student createStudent(Student student) {
        return studentsManager.createNewStudent(student);
    }

    @PUT
    @Path("/students/update/{id}")
    @Produces({"application/json"})
    public Student updateStudentById(@PathParam("id") int id, Student student) {
        return studentsManager.updateStudentById(id, student);
    }

    @GET
    @Path("/students/findById/{id}")
    @Produces({"application/json"})
    public Student getStudentById(@PathParam("id") int id) {
        return studentsManager.getStudentById(id);
    }

    @GET
    @Path("/students/findByEmail/{email}")
    @Produces({"application/json"})
    public Student getStudentByEmail(@PathParam("email") String email) {
        return studentsManager.getStudentByEmail(email);
    }

    @GET
    @Path("/students/findAll")
    @Produces({"application/json"})
    public List<Student> getAllStudents() {
        return studentsManager.getAllStudents();
    }

    @DELETE
    @Path("/students/deleteById/{id}")
    @Produces({"text/plain"})
    public String deleteStudentById(@PathParam("id") int id) {
        return studentsManager.deleteStudentById(id);
    }



    @Inject
    private BookManager bookManager;

    @POST
    @Path("/book/save")
    @Produces({"application/json"})
    public Book createBook(Book book) {
        return bookManager.createBook(book);
    }

    @PUT
    @Path("/book/update/{id}")
    @Produces({"application/json"})
    public Book updateBookById(@PathParam("id") int id, Book book) {
        return bookManager.updateBook(id, book);
    }

    @GET
    @Path("/book/findById/{id}")
    @Produces({"application/json"})
    public Book getBookById(@PathParam("id") int id) {
        return bookManager.getBookById(id);
    }

    @GET
    @Path("/book/exam/{id}")
    @Produces({"application/json"})
    public List<Book> getBooksByExam(@PathParam("id") int id) {
        return bookManager.getBooksByExamId(id);
    }

    @GET
    @Path("/book/title/{title}")
    @Produces({"application/json"})
    public Book getBookByTitle(@PathParam("title") String title) {
        return bookManager.getBooksByTitle(title);
    }

    @GET
    @Path("/book/findAll")
    @Produces({"application/json"})
    public List<Book> getAllBooks() {
        return bookManager.getAllBooks();
    }

    @DELETE
    @Path("/book/deleteById/{id}")
    @Produces({"text/plain"})
    public String deleteBookById(@PathParam("id") int id) {
        return bookManager.deleteBookById(id);
    }



    @Inject
    private ExamManager examManager;

    @POST
    @Path("/exam/save")
    @Produces({"application/json"})
    public Exam createExam(Exam exam) {
        return examManager.createExam(exam);
    }

    @PUT
    @Path("/exam/update/{id}")
    @Produces({"application/json"})
    public Exam updateExamById(@PathParam("id") int id, Exam exam) {
        return examManager.updateExamById(id, exam);
    }

    @GET
    @Path("/exam/findById/{id}")
    @Produces({"application/json"})
    public Exam getExamById(@PathParam("id") int id) {
        return examManager.findExamById(id);
    }

    @GET
    @Path("/exam/findAll")
    @Produces({"application/json"})
    public List<Exam> getAllExams() {
        return examManager.getAllExams();
    }

    @GET
    @Path("/exams/student/{id}")
    @Produces({"application/json"})
    public List<Exam> getExamsByStudentId(@PathParam("id") int id) {
        return studentsManager.getExamsByStudentId(id);
    }

    @DELETE
    @Path("/exam/deleteById/{id}")
    @Produces({"text/plain"})
    public String deleteExamById(@PathParam("id") int id) {
        return examManager.deleteExamById(id);
    }
}
