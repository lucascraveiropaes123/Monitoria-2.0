package Instituicao;

import HibernateUtil.*; 
import java.util.List; 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

public class InstituicaoDAO {
    
    public String addInstituicao (Instituicao instituicao){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        String instituicaoID = null;
        try{
            tx = session.beginTransaction();
                        
            instituicaoID = (String) session.save(instituicao);
            
            //session.flush();                              
            
            tx.commit();
            
        }catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        
        return instituicaoID;
    }
    
    public List<Instituicao> listInstituicao(){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        List instituicao = null;
        try{
                System.out.println("\n\n\n\nTô listando...\n\n\n");

                tx = session.beginTransaction();

                InstituicaoDAO instituicaoDAO = new InstituicaoDAO();

                instituicao = session.createQuery("FROM Instituicao").list();  
                
                tx.commit();
                                
                System.out.println("Listei...");
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        return instituicao;
    }
    
    public Instituicao getInstituicao(String InstituicaoID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Instituicao instituicao = (Instituicao) session.createQuery("from Instituicao where cnpj = ?").setString(0, InstituicaoID).uniqueResult();
            
            if (instituicao != null)
            {
                return instituicao;
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
    
    public void updateInstituicao (Integer instituicaoID, Instituicao instituicaoAntiga){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Instituicao instituicao = (Instituicao) session.createQuery("from Instituicao where pk_instituicao = ?").setInteger(0, instituicaoID).uniqueResult();
            
            instituicao.setCnpj(instituicaoAntiga.getCnpj());
            
            instituicao.setEmail(instituicaoAntiga.getEmail());
            
            instituicao.setSenha(instituicaoAntiga.getSenha());
            
            instituicao.setNome(instituicaoAntiga.getNome());
            
            instituicao.setNum_cartao(instituicaoAntiga.getNum_cartao());
                        
            session.update(instituicao); 
            
            tx.commit();
            
            session.flush();                        
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
    }
    
    public void deleteProfessor(Integer InstituicaoID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Instituicao instituicao = (Instituicao)session.get(Instituicao.class, InstituicaoID); 
            
            session.delete(instituicao); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        }finally {
            session.close(); 
        }
    }
}