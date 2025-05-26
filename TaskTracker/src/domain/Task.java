package domain;

/**
 *
 * @author carlos Riccardo
 */
public class Task {
    
    private int id;
    private String descripcion;
    private String status; //Ej. completo,en proceso,etc.
    
    public Task(int id, String descripcion){
    this.id=id;
    this.descripcion=descripcion;
    this.status="En proceso...";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    //Dado que el reto es trabajar con lenguaje puro convertimos a Task en json
    
    public String toJson(){
    return String.format( "{ \"id\": %d, \"description\": \"%s\", \"status\": \"%s\" }",id,descripcion.replace("\"","\\\""),status);
    
            }
    
    
    
    
}
