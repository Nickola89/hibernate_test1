import hibernate_test.entity.Detail;
import hibernate_test.entity.Employee;
import org.example.entity.Company;
import org.example.entity.PersonalInfo;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.HibernateUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {

        Company company = Company.builder()
                .name("Amazon")
                .build();

        User user = User.builder()
                .username("oleg@mail.com")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Oleg")
                        .lastname("Olegov")
                        .birthDate(LocalDate.of(1990,04,21))
                        .build())
                .company(company)
                .build();

      /*  try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()){
           try ( Session session1 = sessionFactory.openSession()) {
               session1.beginTransaction();

              session1.save(company);
               session1.save(user);

               session1.getTransaction().commit();
           }*/

        Detail detail = Detail.builder()
                .city("Baku")
                .phoneNumber("123456789")
                .email("zaur@mail.ru")
                .build();

        Employee employee = Employee.builder()
                .firstName("Zaur")
                .surname("Tregulov")
                .department("Dev")
                .salary(800)
                .empDetail(detail)
                .build();

      /*  Detail detail = Detail.builder()
                .city("Yakutsk")
                .phoneNumber("123789456")
                .email("ivan@mail.ru")
                .build();

        Employee employee = Employee.builder()
                .firstName("Ivan")
                .surname("Ivanov")
                .department("HR")
                .salary(700)
                .empDetail(detail)
                .build();
*/

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()){
           try (Session session = sessionFactory.openSession()) {
               session.beginTransaction();
               Employee employee1 = session.get(Employee.class, 2);
               session.delete(employee1);
               session.getTransaction().commit();

           }









            /*User user2 = new User("petr@mail.ru", "Petr",
                    "Petrov",LocalDate.of(1990,04,13), 33);*/

//            session.save(user);
//            session.delete(user);
//            User user1 = session.get(User.class, "ivan@mail.com");
//            session.save(user2);
//            System.out.println(user1);

            /*User user4 = session.get(User.class, user2.getUsername());
            System.out.println(user4);*/

           /* List<User> users = session.createQuery("from User " +
                            "where firstname='Petr'")
                            .getResultList();
            for (User u : users)
                System.out.println(u);*/

          /*  User user5 = session.get(User.class, "ivan@mail.com");
            user5.setAge(26);*/

            /*session.createQuery("UPDATE User SET age=27 WHERE age=26")
                            .executeUpdate();*/

          /*  User user6 = session.get(User.class, "anna@mail.ru");
            session.delete(user6);*/

//            session.getTransaction().commit();
        }

    }
}
