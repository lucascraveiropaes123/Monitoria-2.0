package Professor;

import HibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProfessorDAO {
    
    public Integer addProfessor (Professor professor){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        Integer professorID = null;
        try{
            tx = session.beginTransaction();
                        
            professorID = (Integer)session.save(professor);
            
            tx.commit();
            
        }catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        
        return professorID;
    }
    
    public List<Professor> listProfessor(){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        List professor = null;
        try{
                tx = session.beginTransaction();

                ProfessorDAO professorDAO = new ProfessorDAO();

                professor = session.createQuery("FROM Professor").list();  
                
                tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        return professor;
    }
    
    public Professor getProfessor(Integer ProfessorID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Professor professor = (Professor) session.createQuery("from Professor where id_professor = ?").setInteger(0, ProfessorID).uniqueResult();
            
            if (professor != null)
            {
                return professor;
            } 
                        
            tx.commit(); 
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx!=null) tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }
    
    public void updateProfessor (Integer professorID, Professor professorNova){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Professor professor = (Professor) session.createQuery("from Professor where id_professor = ?").setInteger(0, professorID).uniqueResult();
            
            professor.setLogin(professorNova.getLogin());
            professor.setMateria(professorNova.getMateria());
            professor.setPrimeiro_nome(professorNova.getPrimeiro_nome());
            professor.setNome_completo(professorNova.getNome_completo());
            professor.setSenha(professorNova.getSenha());
            
            session.update(professor); 
            
            tx.commit();
            
            session.flush();                        
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
    }
    
    public void deleteProfessor(Integer ProfessorID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Professor professor = (Professor)session.get(Professor.class, ProfessorID); 
            
            session.delete(professor); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        }finally {
            session.close(); 
        }
    }
}