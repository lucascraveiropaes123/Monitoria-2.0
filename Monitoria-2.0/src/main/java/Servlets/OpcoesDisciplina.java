package Servlets;

import Bolsista.Bolsista;
import Bolsista.BolsistaDAO;
import Disciplina.Disciplina;
import Disciplina.DisciplinaDAO;
import Instituicao.Instituicao;
import Professor.Professor;
import Professor.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OpcoesDisciplina extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            
            DisciplinaDAO dDAO = new DisciplinaDAO();

            Integer id = Integer.parseInt(request.getParameter("disciplina"));
            Disciplina disciplina = dDAO.getDisciplina(id);

            String opcao = request.getParameter("opcao");
            
            if(opcao.equalsIgnoreCase("Atualizar"))
            {
                session.setAttribute("DisciplinaVelha", disciplina);

                RequestDispatcher view = request.getRequestDispatcher("AtualizarDisciplina.jsp");
                view.forward(request,response);  
            }
            else if(opcao.equalsIgnoreCase("Excluir"))
            {
                boolean bolsistaExiste = false;
                boolean professorExiste = false;
                
                ProfessorDAO pDAO = new ProfessorDAO();

                List<Professor> professores = (List<Professor>)pDAO.listProfessor();

                BolsistaDAO bDAO = new BolsistaDAO();

                List<Bolsista> bolsistas = (List<Bolsista>)bDAO.listBolsista();
                
                for (Bolsista bolsista : bolsistas)
                {
                    if(id.equals(bolsista.getMateria()))
                    {
                        bolsistaExiste = true;
                    }
                }

                for (Professor professor : professores)
                {
                    if(id.equals(professor.getMateria()))
                    {
                        professorExiste = true;
                    }
                }
                
                if(professorExiste == true || bolsistaExiste == true)
                {
                    RequestDispatcher view = request.getRequestDispatcher("ErrorExclusão.jsp");
                    view.forward(request,response);
                }
                else    
                {
                    dDAO.deleteDisciplina(id);

                    RequestDispatcher view = request.getRequestDispatcher("ListarDisciplina.jsp");
                    view.forward(request,response); 
                }
                
                
            }
            else
            {
                RequestDispatcher view = request.getRequestDispatcher("Error.jsp");
                view.forward(request,response);
            }
        } 
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
