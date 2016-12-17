package Servlets;

import Bolsista.Bolsista;
import Bolsista.BolsistaDAO;
import Instituicao.Instituicao;
import Instituicao.InstituicaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            
            InstituicaoDAO iDAO = new InstituicaoDAO();
            BolsistaDAO bDAO = new BolsistaDAO();
            Integer loginValidation = 0;
            
            List<Instituicao> instituicoes = iDAO.listInstituicao();
            List<Bolsista> bolsistas = bDAO.listBolsista();
                    
            String login = request.getParameter("cnpj");
            String senha = request.getParameter("senha");
            
            for (Instituicao instituicao : instituicoes)
            {   
                String instituicaoCnpj = Integer.toString(instituicao.getCnpj());

                if(senha.equals(instituicao.getSenha()) && login.equals(instituicaoCnpj))
                {   
                    session.setAttribute("Instituicao", instituicao);

                    loginValidation = 1;
                }
            }
            
            for (Bolsista bolsista : bolsistas)
            {                      
                if(senha.equals(bolsista.getSenha()) && login.equals(bolsista.getLogin()))
                {    
                    session.setAttribute("Bolsista", bolsista);

                    loginValidation = 2;
                }
            }
            
            if(loginValidation == 1)
            {
                RequestDispatcher view = request.getRequestDispatcher("Index.jsp");
                view.forward(request,response); 
            }
            else if(loginValidation == 2)
            {
                RequestDispatcher view = request.getRequestDispatcher("BolsistaIndex.jsp");
                view.forward(request,response); 
            }
            else if(loginValidation == 0)
            {
                System.out.println("\n\nSem Conexão Com o Banco...\n\n");
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
