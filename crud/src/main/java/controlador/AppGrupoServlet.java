package controlador;

import java.io.IOException;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Grupo;
import modelo.Modelo;
import modelo.ModeloFactory;

@WebServlet(name = "AppGrupoServlet", urlPatterns = {"/grupo"})
public class AppGrupoServlet extends HttpServlet {

    private Modelo model;
    private final String URI_LISTADO = "listadoProductos.jsp";
    private final String URI_LISTADO_GRUPOS = "listadoGrupos.jsp";
    private final String URI_DEL = "WEB-INF/pages/grupo/borrarGrupo.jsp";
    private final String URI_UPD = "WEB-INF/pages/grupo/editarGrupo.jsp";

    @Override
    public void init() throws ServletException {
        this.model = getModelo();
    }

    protected void procesarAcciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Grupo g;
        int id;
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        System.out.println("Accion: " + accion);
        switch (accion) {
            case "add":
                g = new Grupo();
                cargarGrupoSegunParams(g, request);
                if (model.addGrupo(g) != 1) {
                    throw new RuntimeException("Ya existe el Grupo: ");
                }
                mostrarProductos(request, response);
                break;

            case "edit":
                id = parseInt(request.getParameter("id"));
                g = model.getGrupo(id);
                request.setAttribute("grupoAEditar", g);
                request.getRequestDispatcher(URI_UPD).forward(request, response);
                break;
            case "edit2":
                g = actualizarGrupoSegunParams(request);
                model.updGrupo(g);
                mostrarProductos(request, response);
                break;
            case "remove":
                id = parseInt(request.getParameter("id"));
                request.setAttribute("grupoABorrar", model.getGrupo(id));
                request.getRequestDispatcher(URI_DEL).forward(request, response);
                break;
            case "remove2":
                id = parseInt(request.getParameter("grupo"));
                model.delGrupo(id);
                mostrarProductos(request, response);
                break;
            default:
//                mostrarProductos(request, response);
                mostrarGrupos(request, response);
                break;
        }
    }

    protected void mostrarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesionHttp = request.getSession();
        sesionHttp.setAttribute("accesoTablas", "");
        sesionHttp.setAttribute("listaProductos", model.getProductosConGrupo(""));
        sesionHttp.setAttribute("listaGrupos", model.getGrupos());
        response.sendRedirect(URI_LISTADO);
    }
    protected void mostrarGrupos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesionHttp = request.getSession();
        sesionHttp.setAttribute("accesoTablas", "");     
        sesionHttp.setAttribute("listaGrupos", model.getGrupos());
        response.sendRedirect(URI_LISTADO_GRUPOS);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesarAcciones(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesarAcciones(request, response);
    }

    private void cargarGrupoSegunParams(Grupo g, HttpServletRequest request) {
//        g.setIdGrupo(parseInt(request.getParameter("idGrupo")));
        g.setDescGrupo(request.getParameter("descGrupo"));
    }

    private Grupo actualizarGrupoSegunParams(HttpServletRequest request) {
        Grupo g = new Grupo();
        g.setIdGrupo(parseInt(request.getParameter("grupo")));
        g.setDescGrupo(request.getParameter("descGrupoNuevo"));
        return g;
    }

    private Modelo getModelo() throws ServletException {
        Modelo m = null;
        try ( InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            Properties props = new Properties();
            props.load(is);
            String tipoModelo = props.getProperty("tipoModelo");
            m = ModeloFactory.getInstance().crearModelo(tipoModelo);
        } catch (IOException ex) {
            throw new ServletException("Error de E/S al al leer 'config' para iniciar el Servlet", ex);
        }
        return m;
    }
}
