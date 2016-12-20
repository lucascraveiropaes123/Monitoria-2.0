package Disciplina;

import Bolsista.Bolsista;
import Bolsista.BolsistaDAO;
import HibernateUtil.HibernateUtil;
import Professor.Professor;
import Professor.ProfessorDAO;
import java.util.ArrayList;
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
                tx = session.beginTransaction();

                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

                disciplina = session.createQuery("FROM Disciplina").list();  
                
                tx.commit();
                                
                System.out.println("Listado");
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
            disciplina.setInstituicao_id(disciplinaNova.getInstituicao_id());
            
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
            
            ProfessorDAO pDAO = new ProfessorDAO();
            List<Professor> professores = (List<Professor>)pDAO.listProfessor();
            
            BolsistaDAO bDAO = new BolsistaDAO();
            List<Bolsista> bolsistas = (List<Bolsista>)bDAO.listBolsista();
            
            for(Professor professor : professores)
            {
                Integer pID = Integer.parseInt(professor.getMateria());
                if(pID.equals(disciplina.getKey_disciplina()))
                {
                    System.out.println("Professor: " + professor.getNome_completo());
                    System.out.println("Status: Deletado");
                    pDAO.deleteProfessor(professor.getId_professor());
                }
            }
            
            for(Bolsista bolsista : bolsistas)
            {
                if(bolsista.getMateria().equals(disciplina.getKey_disciplina()))
                {
                    System.out.println("Bolsista: " + bolsista.getNome_completo());
                    System.out.println("Status: Deletado");
                    bDAO.deleteBolsista(bolsista.getId_bolsista());
                }
            }
            
            System.out.println("Disciplina: " + disciplina.getNome());
            System.out.println("Status: Deletada");
            
            session.delete(disciplina); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        }finally {
            session.close(); 
        }
    }
    
    public List<Disciplina> listDisciplinaByID(Integer InstituicaoID){
        
        List<Disciplina> todasDisciplinas = (List<Disciplina>)listDisciplina();
        
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();

        for(Disciplina disciplina : todasDisciplinas)
        {
            if(disciplina.getInstituicao_id().equals(InstituicaoID))
            {
                System.out.println("Disciplina: " + disciplina.getNome());
                disciplinas.add(disciplina);
            }
        }
        
        return disciplinas;
    }
}