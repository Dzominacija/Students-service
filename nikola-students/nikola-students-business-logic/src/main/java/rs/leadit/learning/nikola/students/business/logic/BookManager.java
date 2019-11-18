package rs.leadit.learning.nikola.students.business.logic;

import rs.leadit.learinig.nikola.students.database.model.Book;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Dependent
public class BookManager implements Serializable {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Book createBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Transactional
    public Book updateBook(int book_id, Book book) {
        Book book1 = entityManager.createNamedQuery("Book.findBookById", Book.class).setParameter("id", book_id)
                .getSingleResult();
        book1.setExam(book.getExam());
        book1.setTitle(book.getTitle());
        book1.setWriter(book.getWriter());
        entityManager.persist(book1);
        return book1;
    }
    public Book getBookById(int id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> getBooksByExamId(int id) {
        return entityManager.createNamedQuery("Book.getBooksByExamId", Book.class).setParameter("id",id).getResultList();
    }

    public Book getBooksByTitle(String title) {
        return entityManager.createNamedQuery("Book.getBookByName", Book.class).setParameter("title", title).
                getSingleResult();
    }

    public List<Book> getAllBooks() {
        return entityManager.createNamedQuery("Book.getAll", Book.class).getResultList();
    }

    @Transactional
    public String deleteBookById(int id) {
        entityManager.remove(entityManager.find(Book.class,id));
        return "Object with " +  id + " deleted";
    }
}
