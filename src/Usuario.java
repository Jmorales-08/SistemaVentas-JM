public class Usuario {
    private String nombre;
    private String password;

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean validarPassword(String passwordIngresada) {
        return this.password.equals(passwordIngresada);
    }
}
