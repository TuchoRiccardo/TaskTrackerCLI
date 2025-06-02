package domain;

/**
 *
 * @author carlos Riccardo
 */
public class Task {
    
    private int id;
    private String descripcion;
    private String status; //Ej. completo,en proceso,etc.
    
    public Task(int id, String descripcion,String status){
    this.id=id;
    this.descripcion=descripcion;
    this.status=status;
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
    return String.format( "{ \"id\": %d, \"descripcion\": \"%s\", \"status\": \"%s\" }",id,descripcion.replace("\"","\\\""),status);
    
            }
    //Metodo para convertir un Json a Task
    
    public static Task fromJson(String json){
    //Eliminamos llaves y espacios
        json=json.trim().replaceAll("[{}\"]","");
    String [] parts=json.split(",");
    
    int id=0;
    String descripcion="";
    String status="";
    
        for(String part: parts){
            String [] keyValue=part.trim().split(":",2);
            if(keyValue.length <2) continue;
            
            String key = keyValue[0].trim();
            String valor= keyValue[1].trim();
            
            switch (key){
                case "id":
                    id=Integer.parseInt(valor);
                    break;
                case "descripcion":
                    descripcion=valor;
                    break;
                    
                  case"status":
                      status=valor;
                      break;
            }
        }        
        
        return new Task(id,descripcion,status);
    
    }
    
    
    
}
