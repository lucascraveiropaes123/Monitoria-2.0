package Servlets;

import Bolsista.Bolsista;
import Bolsista.BolsistaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastroBolsista extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            
            BolsistaDAO pDAO = new BolsistaDAO();
            Bolsista bolsista = new Bolsista();
            
            String nomeCompleto = request.getParameter("primeiroNome") + " " + request.getParameter("sobrenome");
            
            bolsista.setLogin(request.getParameter("login"));
            bolsista.setMateria(request.getParameter("materia"));
            bolsista.setNome_completo(nomeCompleto);
            bolsista.setPrimeiro_nome(request.getParameter("primeiroNome"));
            bolsista.setSenha(request.getParameter("senha"));
            
            Integer ID = pDAO.addBolsista(bolsista);
                        
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
