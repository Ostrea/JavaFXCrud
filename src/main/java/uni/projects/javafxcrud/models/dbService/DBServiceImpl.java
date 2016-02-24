package uni.projects.javafxcrud.models.dbService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import uni.projects.javafxcrud.models.dbService.dataSets.CatalogDataSet;
import uni.projects.javafxcrud.models.dbService.dataSets.CommodityTypeDataSet;
import uni.projects.javafxcrud.models.dbService.dataSets.SupplierDataSet;
import uni.projects.javafxcrud.models.dbService.experiments.Student;
import uni.projects.javafxcrud.models.dbService.experiments.StudentGroup;

import java.util.ArrayList;

public class DBServiceImpl {
    private static final String hibernate_show_sql = "true";


    private final SessionFactory sessionFactory;

    public DBServiceImpl() {
        Configuration configuration = getMySqlConfiguration();
        sessionFactory = createSessionFactory(configuration);
    }

    private Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(CommodityTypeDataSet.class);
        configuration.addAnnotatedClass(CatalogDataSet.class);
        configuration.addAnnotatedClass(SupplierDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/javafxcrud");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "2134356");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration){
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);

    }



    /* Just for better understanding, dont mind it
    public void testingExperiments(){

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student stud1 = new Student("vasya");
        Student stud2 = new Student("vasya1");
        Student stud3 = new Student("vasya2");
        Student stud4 = new Student("vasya3");

       ArrayList students1 =  new ArrayList<Student>();
       ArrayList students2 =  new ArrayList<Student>();

        students1.add(stud1);
        students1.add(stud2);
        students2.add(stud3);
        students2.add(stud4);

        StudentGroup sg1 = new StudentGroup(122);
        StudentGroup sg2 = new StudentGroup(123);

        stud1.setSg(sg1);
        stud2.setSg(sg1);
        stud3.setSg(sg2);
        stud4.setSg(sg2);

        sg1.setStudents(students1);
        sg2.setStudents(students2);

        session.save(stud1);
        session.save(stud2);
        session.save(stud3);
        session.save(stud4);

        session.save(sg1);
        session.save(sg2);

        long id = 7;
        Student stud5 = (Student) session.get(Student.class, id);
        System.out.println(stud5.getSg().getNumber());
        transaction.commit();
        session.close();

    }*/

    public void testing(){

    }

}
