package com.prosoft;

import com.prosoft.model.Book;
import org.h2.tools.Server;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Hibernate demo!
 */
public class Main {
    private final static int BOOK_COUNT = 5;
    private final static int BOOK_ID_FOR_FIND_AND_MERGE = 3;
    private final static int BOOK_ID_FOR_DELETE = 4;

    public static void main(String[] args) throws NamingException, SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException, SQLException {

        /** Запускаем web-сервер для работы с консолью h2 по адресу http://localhost:8082/ */
        Server server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
        server.start();

        /** Создаем EntityManagerFactory и EntityManage */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateDemoPerUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /** Создаем транзакцию */
        EntityTransaction transaction = entityManager.getTransaction();

        /** CRUD: create Добавляем новые книги через persist */
        transaction.begin();
        for (int i = 0; i < BOOK_COUNT; i++) {
            entityManager.persist(new Book("Name of the book " + i));
        }
        transaction.commit();

        /** CRUD: read Поиск и загрузка сущности find */
        transaction.begin();
        Book book3 = entityManager.find(Book.class, Long.valueOf(BOOK_ID_FOR_FIND_AND_MERGE));
        if (book3 != null) {
            System.out.println("Найдена книга: " + book3.toString());
        } else {
            System.out.println(" Книга с id=" + BOOK_ID_FOR_FIND_AND_MERGE + " не найдена!");
        }
        transaction.commit();

        /** CRUD: update Обновление сущности в БД merge */
        transaction.begin();
        if (book3 != null) {
            book3.setTitle("New Name of the book " + BOOK_ID_FOR_FIND_AND_MERGE + "!");
            book3 = entityManager.merge(book3);
            System.out.println("Book3 is merged! " + book3.toString());
        }
        transaction.commit();

        /** CRUD: delete Удаление сущности remove BOOK_ID_FOR_DELETE */
        transaction.begin();
        Book book4 = entityManager.find(Book.class, Long.valueOf(BOOK_ID_FOR_DELETE));
        if (book4 != null) {
            System.out.println("Найдена книга для удаления: " + book4.toString());
            entityManager.remove(book4);
            System.out.println("Книга: " + book4.toString() + "удалена!");
        } else {
            System.out.println(" Книга с id=" + BOOK_ID_FOR_DELETE + " для удаления не найдена!");
        }
        transaction.commit();

        /** Читаем все книги через createQuery */
        transaction.begin();
        List<Book> bookList = entityManager.createQuery("select b from Book b").getResultList();
        System.out.println("bookList (" + bookList.size() + "): ");
        bookList.forEach(b -> {
            System.out.println("  " + b.getId() + " " + b.getTitle());
        });
        transaction.commit();

        /** Закрытие entityManager */
        entityManager.close();
    }
}
