package Servlets;

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
            Instituicao userLogado = new Instituicao(); 
                    
            String cnpj = request.getParameter("cnpj");
            String senha = request.getParameter("senha");
            
            List<Instituicao> instituicoes = iDAO.listInstituicao();
       
            System.out.println("\n\nTo no servlet...\n\n");
            
            if(instituicoes != null)
            {
                for (Instituicao instituicao : instituicoes)
                {            
                    if(senha.equals(instituicao.getSenha()) && cnpj.equals(instituicao.getCnpj()))
                    {                  
                        System.out.println("\nFuncionou porra! " + instituicao.getCnpj());

                        String CNPJ = instituicao.getCnpj();
                        userLogado.setCnpj(CNPJ);

                        userLogado.setEmail(instituicao.getEmail());
                        userLogado.setNome(instituicao.getNome());
                        userLogado.setNum_cartao(instituicao.getNum_cartao());
                        userLogado.setSenha(instituicao.getSenha());
                    }
                }
                
                session.setAttribute("Instituicao", userLogado);

                RequestDispatcher view = request.getRequestDispatcher("Index.jsp");
                view.forward(request,response);   

                System.out.println("\n\nEntrei no IF\n\n");
            }
            else
            {
                System.out.println("\n\nNão consegui logar...\n\n");
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
