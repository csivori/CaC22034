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
import modelo.Modelo;
import modelo.ModeloFactory;
import modelo.Producto;

@WebServlet(name = "AppServlet", urlPatterns = {"/app"})
public class AppServlet extends HttpServlet {

    private Modelo model;
    private final String URI_LIST = "listadoProductos.jsp";
    private final String URI_DEL = "WEB-INF/pages/productos/borrarProducto.jsp";
    private final String URI_UPD = "WEB-INF/pages/productos/editarProducto.jsp";

    @Override
    public void init() throws ServletException {
        this.model = getModelo();
    }

    protected void procesarAcciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto p;
        int id;
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;

        System.out.println("Accion: " + accion);
        switch (accion) {
            case "add":
                p = new Producto();
                cargarProductoSegunParams(p, request);
                model.addProducto(p);
                mostrarProductos(request, response, "");
                break;
            case "edit":
                id = parseInt(request.getParameter("id"));
                p = model.getProducto(id);
                request.setAttribute("productoAEditar", p);
                request.setAttribute("yaTieneFoto", (!p.getFoto().contains("productoGenerico")));
                request.getRequestDispatcher(URI_UPD).forward(request, response);
                break;
            case "edit2":
                p = actualizarProductoSegunParams(request);
                model.updProducto(p);
                mostrarProductos(request, response, "");
                break;
            case "remove":
                id = parseInt(request.getParameter("id"));
                request.setAttribute("productoABorrar", model.getProducto(id));
                request.getRequestDispatcher(URI_DEL).forward(request, response);
                break;
            case "remove2":
                id = parseInt(request.getParameter("id"));
                model.delProducto(id);
                mostrarProductos(request, response, "");
                break;
            case "buscar":
                mostrarProductos(request, response, request.getParameter("buscar"));
                break;
            default:
                mostrarProductos(request, response, "");
        }
    }

    protected void mostrarProductos(HttpServletRequest request, HttpServletResponse response, String buscar)
            throws ServletException, IOException {
        HttpSession sesionHttp = request.getSession();
        sesionHttp.setAttribute("accesoTablas", "");
        sesionHttp.setAttribute("listaProductos", model.getProductosConGrupo(buscar));
        sesionHttp.setAttribute("listaGrupos", model.getGrupos());
        response.sendRedirect(URI_LIST);
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

    private void cargarProductoSegunParams(Producto p, HttpServletRequest request) {
        p.setGrupo(parseInt(request.getParameter("grupo")));
        p.setDescripcion(request.getParameter("descripcion"));
        p.setStock(Integer.parseInt(request.getParameter("stock")));
        p.setFoto(request.getParameter("fotoBase64"));
    }

    private Producto actualizarProductoSegunParams(HttpServletRequest request) {
        Producto p = new Producto();
        cargarProductoSegunParams(p, request);
        p.setId(parseInt(request.getParameter("id")));
        return p;
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
