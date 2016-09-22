package HibernateUtil;

import Bolsista.Bolsista;
import Disciplina.Disciplina;
import Instituicao.Instituicao;
import Professor.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {            
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instituicao.class)
                    .addAnnotatedClass(Professor.class)
                    .addAnnotatedClass(Bolsista.class)
                    .addAnnotatedClass(Disciplina.class);
            
            factory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Falha ao criar sessionFactory. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session abrirSessaoComBD() {
        Session session = factory.openSession();
        return session;
       
    }
}

