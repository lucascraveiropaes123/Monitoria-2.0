package HibernateUtil;

import Instituicao.Instituicao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
            /*factory = new AnnotationConfiguration().configure()
                    .addAnnotatedClass(Instituicao.class)
                    .addAnnotatedClass(Professor.class)
                    .addAnnotatedClass(Disciplina.class)
                    .addAnnotatedClass(Bolsista.class)
                    .addAnnotatedClass(Tipos_Equipamento.class)
                    .addAnnotatedClass(Equipamento.class)
                    .addAnnotatedClass(Usuario.class)
                    .buildSessionFactory();*/
            
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instituicao.class);
            
            
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

