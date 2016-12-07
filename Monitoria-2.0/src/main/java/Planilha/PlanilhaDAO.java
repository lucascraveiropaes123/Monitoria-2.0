package Planilha;

import HibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanilhaDAO {
    public Integer addPlanilha (Planilha planilha){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        Integer planilhaID = null;
        try{
            tx = session.beginTransaction();
                        
            planilhaID = (Integer)session.save(planilha);
            
            tx.commit();
            
        }catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        
        return planilhaID;
    }
    
    public List<Planilha> listPlanilha(){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        List planilha = null;
        try{
                tx = session.beginTransaction();

                PlanilhaDAO planilhaDAO = new PlanilhaDAO();

                planilha = session.createQuery("FROM Planilha").list();  
                
                tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally {
            session.close(); 
        }
        return planilha;
    }
    
    public Planilha getPlanilha(Integer PlanilhaID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Planilha planilha = (Planilha) session.createQuery("from Planilha where id_planilha = ?").setInteger(0, PlanilhaID).uniqueResult();
            
            if (planilha != null)
            {
                return planilha;
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
    
    public void updatePlanilha (Integer planilhaID, Planilha planilhaNova){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Planilha planilha = (Planilha) session.createQuery("from Planilha where id_planilha = ?").setInteger(0, planilhaID).uniqueResult();
            
            
            
            planilha.setBolsista(planilhaNova.getBolsista());
            planilha.setComputador(planilhaNova.getComputador());
            planilha.setData_dia(planilhaNova.getData_dia());
            planilha.setData_mes(planilhaNova.getData_mes());
            planilha.setData_ano(planilhaNova.getData_ano());
            planilha.setHora_entrada(planilhaNova.getHora_entrada());
            planilha.setHora_saida(planilhaNova.getHora_saida());
            planilha.setMin_entrada(planilhaNova.getMin_entrada());
            planilha.setMin_saida(planilhaNova.getMin_saida());
            planilha.setId_planilha(planilhaNova.getId_planilha());
            planilha.setLaboratorio(planilhaNova.getLaboratorio());
            planilha.setNum_documento(planilhaNova.getNum_documento());
            planilha.setTipo_documento(planilhaNova.getTipo_documento());
            planilha.setVisitante(planilhaNova.getVisitante());
            planilha.setInstituicao_id(planilhaNova.getInstituicao_id());
            
            session.update(planilha); 
            
            System.out.println("Atualizado");
            
            tx.commit();
            
            session.flush();                        
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
    }
    
    public void deletePlanilha(Integer PlanilhaID){
        Session session = HibernateUtil.abrirSessaoComBD();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Planilha planilha = (Planilha)session.get(Planilha.class, PlanilhaID); 
            
            session.delete(planilha); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        }finally {
            session.close(); 
        }
    }
}
