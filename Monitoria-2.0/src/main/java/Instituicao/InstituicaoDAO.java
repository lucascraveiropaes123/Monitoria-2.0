package Instituicao;

import Bolsista.*;
import Disciplina.Disciplina;
import Disciplina.DisciplinaDAO;
import HibernateUtil.*; 
import Professor.*;
import java.util.List; 
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

public class InstituicaoDAO {
    
    public Integer addInstituicao (Instituicao instituicao){
        Session session = HibernateUtil.abrirSessaoComBD();        
        Transaction tx = null;
        Integer instituicaoID = null;
        try{
            tx = session.beginTransaction();
                        
            instituicaoID = (Integer)session.save(instituicao);
            
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
                tx = session.beginTransaction();

                instituicao = session.createQuery("FROM Instituicao").list();  
                
                tx.commit();
                                
                System.out.println("Listado");
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        return instituicao;
    }
    
    public Instituicao getInstituicao(Integer InstituicaoID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Instituicao instituicao = (Instituicao) session.createQuery("from Instituicao where cnpj = ?").setInteger(0, InstituicaoID).uniqueResult();
            
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
            
            Instituicao instituicao = (Instituicao) session.createQuery("from Instituicao where cnpj = ?").setInteger(0, instituicaoID).uniqueResult();
                    
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
    
    public void deleteInstituicao(Integer InstituicaoID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Instituicao instituicao = getInstituicao(InstituicaoID);
            
            System.out.println("Instituicao: " + instituicao.getNome());
            
            ProfessorDAO pDAO = new ProfessorDAO();
            List<Professor> professores = (List<Professor>)pDAO.listProfessor();
            
            BolsistaDAO bDAO = new BolsistaDAO();
            List<Bolsista> bolsistas = (List<Bolsista>)bDAO.listBolsista();
            
            DisciplinaDAO dDAO = new DisciplinaDAO();
            List<Disciplina> disciplinas = (List<Disciplina>)dDAO.listDisciplina();
            
            for(Professor professor : professores)
            {
                if(professor.getInstituicao_id().equals(instituicao.getCnpj()))
                {
                    System.out.println("Professor: " + professor.getNome_completo());
                    System.out.println("Status: Deletado");
                    pDAO.deleteProfessor(professor.getId_professor());
                }
            }
            
            for(Bolsista bolsista : bolsistas)
            {
                if(bolsista.getInstituicao_id().equals(instituicao.getCnpj()))
                {
                    System.out.println("Bolsista: " + bolsista.getNome_completo());
                    System.out.println("Status: Deletado");
                    bDAO.deleteBolsista(bolsista.getId_bolsista());
                }
            }
            
            for(Disciplina disciplina : disciplinas)
            {
                if(disciplina.getInstituicao_id().equals(instituicao.getCnpj()))
                {
                    System.out.println("Disciplina: " + disciplina.getNome());
                    System.out.println("Status: Deletado");
                    dDAO.deleteDisciplina(disciplina.getKey_disciplina());
                }
            }
            
            System.out.println("Instituicao: " + instituicao.getNome());
            System.out.println("Status: Deletado");
            
            session.delete(instituicao); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        }finally {
            session.close(); 
        }
    }
    
    public int numProfessores(Integer ID)
    {
        ProfessorDAO pDAO = new ProfessorDAO();
        List<Professor> professores = (List<Professor>)pDAO.listProfessor();
        
        int i=0;
        
        for(Professor professor : professores)
        {
            if(professor.getInstituicao_id().equals(ID))
            {
                i++;
            }
        }
        
        return i;
    }
    
    public int numBolsistas(Integer ID)
    {
        BolsistaDAO bDAO = new BolsistaDAO();
        List<Bolsista> bolsistas = (List<Bolsista>)bDAO.listBolsista();
        
        int i=0;
        
        for(Bolsista bolsista : bolsistas)
        {
            if(bolsista.getInstituicao_id().equals(ID))
            {
                i++;
            }
        }
        
        return i;
    }
}