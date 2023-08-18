package com.prosoft;

import com.prosoft.model.Book;
import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.SQLException;
import java.util.List;

/**
 * hibernate-config-demo - конфигурирование БЕЗ файла persistence.xml с использованием SessionFactory
 */
public class Main {
    private final static int BOOK_COUNT = 5;
    private final static int BOOK_ID_FOR_FIND_AND_MERGE = 3;
    private final static int BOOK_ID_FOR_DELETE = 4;

    public static void main(String[] args) throws SQLException {

        /** Запускаем web-сервер для работы с консолью h2 по адресу http://localhost:8082/ */
        Server server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
        server.start();

        /** Конфигурация Hibernate БЕЗ файла persistence.xml */
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.prosoft.model.Book.class);
        configuration.setProperty("connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:books");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "true");
        configuration.setProperty("hibernate.connection.pool_size", "10");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        /** EntityManage */
        EntityManager entityManager = sessionFactory.createEntityManager();

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
