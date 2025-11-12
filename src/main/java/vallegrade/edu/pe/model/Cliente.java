package vallegrade.edu.pe.model;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String correo;
    private String telefono;

    public Cliente(){
    }
    public Cliente(int idCliente, String nombre, String correo, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
}
