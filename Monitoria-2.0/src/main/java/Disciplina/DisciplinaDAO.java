package Disciplina;

import HibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DisciplinaDAO {
    
    public Integer addDisciplina (Disciplina disciplina){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        Integer disciplinaID = null;
        try{
            tx = session.beginTransaction();
                        
            disciplinaID = (Integer)session.save(disciplina);
            
            //session.flush();                              
            
            tx.commit();
            
        }catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        
        return disciplinaID;
    }
    
    public List<Disciplina> listDisciplina(){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        List disciplina = null;
        try{
                System.out.println("\n\n\n\nTô listando...\n\n\n");

                tx = session.beginTransaction();

                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

                disciplina = session.createQuery("FROM Disciplina").list();  
                
                tx.commit();
                                
                System.out.println("Listei...");
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        return disciplina;
    }
    
    public Disciplina getDisciplina(Integer DisciplinaID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Disciplina disciplina = (Disciplina) session.createQuery("from Disciplina where key_disciplina = ?").setInteger(0, DisciplinaID).uniqueResult();
            
            if (disciplina != null)
            {
                return disciplina;
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
    
    public void updateDisciplina (Integer disciplinaID, Disciplina disciplinaNova){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Disciplina disciplina = (Disciplina) session.createQuery("from Disciplina where key_disciplina = ?").setInteger(0, disciplinaID).uniqueResult();
            
            disciplina.setNome(disciplinaNova.getNome());
            
            session.update(disciplina); 
            
            tx.commit();
            
            session.flush();                        
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
    }
    
    public void deleteDisciplina (Integer DisciplinaID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            
            
            Disciplina disciplina = getDisciplina(DisciplinaID);
//(Disciplina)session.get(Disciplina.class, DisciplinaID); 
            
            session.delete(disciplina); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        }finally {
            session.close(); 
        }
    }
}