package controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.AutenticadorBean;

@WebServlet(name = "ServletControlador", urlPatterns = {"/servlet-controlador"})
public class ServletControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String usr = request.getParameter("usuario");
            String pwd = request.getParameter("clave");

            AutenticadorBean sb = new AutenticadorBean();

            if (sb.isUsrAndPwdOK(usr, pwd)) {
                request.setAttribute("emoji", "\uD83D\uDE0F");
                RequestDispatcher rd = request.getRequestDispatcher("vistas/ingreso.jsp");
                rd.forward(request, response);
            } else {
                redirigirAError(request, response, "Usuario o Clave Incorrecta");
            }
        } catch (Exception e) {
            redirigirAError(request, response, e.getMessage());
        }
    }

    private void redirigirAError(HttpServletRequest request, HttpServletResponse response, String msgError)
            throws ServletException, IOException {
        request.setAttribute("clase", "ServletControlador");
        request.setAttribute("msgError", msgError);
        RequestDispatcher rd = request.getRequestDispatcher("vistas/manejador-de-error.jsp");
        rd.forward(request, response);
    }
}
