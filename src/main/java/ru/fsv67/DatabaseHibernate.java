package ru.fsv67;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/*
 * 2. С помощью JPA(Hibernate) выполнить:
 * 2.1 Описать сущность Book из пункта 1.1
 * 2.2 Создать Session и сохранить в таблицу 10 книг
 * 2.3 Выгрузить список книг какого-то автора
 */
public class DatabaseHibernate {
    final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    Book book;

    /**
     * Метод создания и заполнения таблицы BOOKS
     */
    public void createTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            book = new Book("Программист-прагматик", "Дэвид Томас");
            session.persist(book);
            book = new Book("Чистый код", "Роберт Мартин");
            session.persist(book);
            book = new Book("Совершенный код", "Стив Макконнелл");
            session.persist(book);
            book = new Book("Паттерны объектно-ориентированного проектирования", "Эрих Гамма");
            session.persist(book);
            book = new Book("Head First. Паттерны проектирования", "Эрик Фримен");
            session.persist(book);
            book = new Book("Шаблоны корпоративных приложений", "Мартин Фаулер");
            session.persist(book);
            book = new Book("Идеальный программист", "Роберт Мартин");
            session.persist(book);
            book = new Book("Психбольница в руках пациентов", "Алан Купер");
            session.persist(book);
            book = new Book("Искусство программирования", "Дональд Кнут");
            session.persist(book);
            book = new Book("Грокаем алгоритмы", "Адитья Бхаргава");
            session.persist(book);
            book = new Book("Алгоритмы. Построение и анализ", "Томас Кормен");
            session.persist(book);
            session.getTransaction().commit();
        }
    }

    /**
     * Метод поиска в базе данных по автору
     *
     * @param searchAuthor строка (имя автора)
     */
    public void getBooksByAuthor(String searchAuthor) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Book WHERE author = :author";
            Query<Book> bookQuery = session.createQuery(hql, Book.class);
            bookQuery.setParameter("author", searchAuthor);
            List<Book> books = bookQuery.getResultList();
            books.forEach(System.out::println);
        }
    }
}
