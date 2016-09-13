package Instituicao;

import HibernateUtil.*; 
import java.util.List; 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

public class InstituicaoDAO {
    
    public Instituicao loginInstituicao(String login, String senha)
    {
        Session session = HibernateUtil.abrirSessaoComBD();
        
        Instituicao instituicao = null;
        
        try {
            instituicao = (Instituicao) session
                    .createQuery("from Instituicao where login= :login and senha= :senha")
                    .setString("login", login).setString("senha", senha).uniqueResult();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return instituicao;
    }
   
    public boolean addInstituicao(Instituicao instituicao)
    {
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        Integer instituicaoID = null;
        boolean foi = false;


        try{
            tx = session.beginTransaction();
            instituicaoID = (Integer) session.save(instituicao); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null){
                tx.rollback();
            }
            throw e;
        }finally {
           session.close(); 
        }
        if (instituicaoID != null){
            foi= true;
        }
        return foi;
    }
   
   
    public List listInstituicao( )
    {
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            
            List <Instituicao> instituicao = session.createQuery("FROM Instituicao").list(); 
            
            tx.commit();
            
            return instituicao; // retorna o nome da lista

        }catch (HibernateException e) {

            if (tx!=null){
                tx.rollback();
            }

            e.printStackTrace(); 

        }finally {
            session.close(); 
        }
        return null;
    }
   
    public void updateInstituicao(Integer InstituicaoID ){
       
        Session session = HibernateUtil.abrirSessaoComBD();

        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            Instituicao instituicao = 
                (Instituicao)session.get(Instituicao.class, InstituicaoID); 
            session.update(instituicao); 

            tx.commit();

        }catch (HibernateException e) {

            if (tx!=null) tx.rollback();

            e.printStackTrace(); 

        }finally {
            session.close(); 
        }
     }
   
    public void deleteInstituicao(Integer InstituicaoID){
       
        Session session = HibernateUtil.abrirSessaoComBD();

        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            Instituicao instituicao = 
                      (Instituicao)session.get(Instituicao.class, InstituicaoID); 
            session.delete(instituicao); 

            tx.commit();

        }catch (HibernateException e) {

            if (tx!=null) tx.rollback();

            e.printStackTrace(); 

        }finally {
            session.close(); 
        }
    }
}