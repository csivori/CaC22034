package modelo;

import java.io.Serializable;

public class AutenticadorBean implements Serializable {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    private static final String USER_ESPERADO = "car";
    private static final String CLAVE_ESPERADA = "123";

// CONSTRUCTORES
    public AutenticadorBean(){}
    
// GETTERs & SETTERs

// OVERRIDES

// METODOS PUBLICOS
    public boolean isUsrAndPwdOK(String usr, String pwd) {
        return usr.equals(USER_ESPERADO) && pwd.equals(CLAVE_ESPERADA);
    }
// METODOS PRIVADOS

}
