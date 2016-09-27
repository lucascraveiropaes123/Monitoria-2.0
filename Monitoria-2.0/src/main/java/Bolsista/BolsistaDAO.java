package Bolsista;

import HibernateUtil.HibernateUtil;
import Bolsista.Bolsista;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BolsistaDAO {
    
    public Integer addBolsista (Bolsista bolsista){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        Integer bolsistaID = null;
        try{
            tx = session.beginTransaction();
                        
            bolsistaID = (Integer)session.save(bolsista);
            
            tx.commit();
            
        }catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        
        return bolsistaID;
    }
    
    public List<Bolsista> listBolsista(){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        List bolsista = null;
        try{
                tx = session.beginTransaction();

                BolsistaDAO bolsistaDAO = new BolsistaDAO();

                bolsista = session.createQuery("FROM Bolsista").list();  
                
                tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        return bolsista;
    }
    
    public Bolsista getBolsista(Integer BolsistaID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Bolsista bolsista = (Bolsista) session.createQuery("from Bolsista where id_bolsista = ?").setInteger(0, BolsistaID).uniqueResult();
            
            if (bolsista != null)
            {
                return bolsista;
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
    
    public void updateBolsista (Integer bolsistaID, Bolsista bolsistaNova){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            
            System.out.println("Vou atualizar...");
            
            tx = session.beginTransaction();
            
            Bolsista bolsista = (Bolsista) session.createQuery("from Bolsista where id_bolsista = ?").setInteger(0, bolsistaID).uniqueResult();
            
            System.out.println("Atualizando...");
            
            bolsista.setLogin(bolsistaNova.getLogin());
            bolsista.setMateria(bolsistaNova.getMateria());
            bolsista.setPrimeiro_nome(bolsistaNova.getPrimeiro_nome());
            bolsista.setNome_completo(bolsistaNova.getNome_completo());
            bolsista.setSenha(bolsistaNova.getSenha());
            
            session.update(bolsista); 
            
            System.out.println("Atualizei...");
            
            tx.commit();
            
            session.flush();                        
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
    }
    
    public void deleteBolsista(Integer BolsistaID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Bolsista bolsista = (Bolsista)session.get(Bolsista.class, BolsistaID); 
            
            session.delete(bolsista); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        }finally {
            session.close(); 
        }
    }
}