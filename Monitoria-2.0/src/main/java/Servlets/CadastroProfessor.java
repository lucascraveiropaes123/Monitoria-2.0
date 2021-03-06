package Servlets;

import Instituicao.Instituicao;
import Professor.Professor;
import Professor.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastroProfessor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            HttpSession session = request.getSession();
            
            Instituicao instituicao = (Instituicao)session.getAttribute("Instituicao");
            
            ProfessorDAO pDAO = new ProfessorDAO();
            Professor professor = new Professor();
            
            String nomeCompleto = request.getParameter("primeiroNome") + " " + request.getParameter("sobrenome");
            
            professor.setLogin(request.getParameter("login"));
            professor.setMateria(request.getParameter("materia"));
            professor.setNome_completo(nomeCompleto);
            professor.setPrimeiro_nome(request.getParameter("primeiroNome"));
            professor.setSenha(request.getParameter("senha"));
            professor.setInstituicao_id(instituicao.getCnpj());
            
            Integer ID = pDAO.addProfessor(professor);
                        
            if(ID != null)
            {
                RequestDispatcher view = request.getRequestDispatcher("Index.jsp");
                view.forward(request,response);
            }
            else
            {
                RequestDispatcher view = request.getRequestDispatcher("Error.jsp");
                view.forward(request,response);
            }
        } finally {
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
