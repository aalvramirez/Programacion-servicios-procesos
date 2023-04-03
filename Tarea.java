package server;

public class Tarea {
    private String descripcion;
    private String estado;

    public Tarea(){
        descripcion = "";
        estado = "";}
    //getters y setters
    public String getDescripcion() {
        return descripcion;}
    public void setDescription(String descripcion) {
        this.descripcion = descripcion;}

    public String getEstado() {
        return estado;}
    public void setEstado(String estado) {
        this.estado = estado;}

    @Override
    public String toString() {
        return "Tarea{" + "descripcion='" + descripcion + ", estado='" + estado + "}";}
}