package modelo;

public class ModeloFactory {

// ATRIBUTOS PUBLICOS    

// ATRIBUTOS PRIVADOS
    private static ModeloFactory mf = null;

// CONSTRUCTORES
    private ModeloFactory() {}

// GETTERs & SETTERs

// OVERRIDES

// METODOS PUBLICOS
public static ModeloFactory getInstance() {
    if (mf == null) {
        mf = new ModeloFactory();
    }
    return mf;
}

public Modelo crearModelo(String nombreModelo) {
    Modelo m = null;
    String nombreClase = mf.getClass().getPackage().getName() + ".Modelo" + nombreModelo;
    try {
        m = (Modelo) Class.forName(nombreClase).getDeclaredConstructor().newInstance();
    } catch (Exception ex) {
        throw new RuntimeException("Ocurrió un error al instanciar un modelo de tipo " + nombreClase, ex);
    }
    return m;
}
// METODOS PRIVADOS

}
