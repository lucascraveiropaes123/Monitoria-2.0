package Servlets;

import Bolsista.Bolsista;
import Planilha.Planilha;
import Planilha.PlanilhaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastroPlanilha extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            
            Bolsista bolsista = (Bolsista)session.getAttribute("Bolsista");
            
            PlanilhaDAO pDAO = new PlanilhaDAO();
            Planilha planilha = new Planilha();
            
            planilha.setVisitante(request.getParameter("nome_completo_visitante"));
            planilha.setTipo_documento(request.getParameter("documento"));
            planilha.setNum_documento(request.getParameter("num_documento"));
            planilha.setComputador(request.getParameter("computador"));
            planilha.setLaboratorio(request.getParameter("laboratorio"));
            planilha.setHora_entrada(request.getParameter("hora_entrada"));
            planilha.setMin_entrada(request.getParameter("min_entrada"));
            planilha.setHora_saida(request.getParameter("hora_saida"));
            planilha.setMin_saida(request.getParameter("min_saida"));
            planilha.setBolsista(bolsista.getId_bolsista());
            
            
            planilha.setData_dia(Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
            planilha.setData_mes(Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));
            planilha.setData_ano(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
            
            Integer ID = pDAO.addPlanilha(planilha);
            
            if(ID != null)
            {
                session.setAttribute("Planilha", planilha);
                
                RequestDispatcher view = request.getRequestDispatcher("IndexBolsista.jsp");
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
