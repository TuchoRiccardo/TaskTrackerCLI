package domain;

import java.io.*;
import java.util.*;

/**
 *
 * @author carlos riccardo
 */
public class TaskManager {

    private List<Task> tareas;
    private final File archivo;

    public TaskManager(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
        this.tareas = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public void agregarTarea(String descripcion) {
        int nuevoId = tareas.size() > 0 ? tareas.get(tareas.size() - 1).getId() + 1 : 1;
        Task nuevaTarea = new Task(nuevoId, descripcion, "Por hacer");
        tareas.add(nuevaTarea);
        guardarEnArchivo();
        System.out.println("Tarea añadida con ID: " + nuevoId);

    }

    public void actualizarTarea(int id, String nuevaDescripcion) {
        for (Task t : tareas) {
            if (t.getId() == id) {
                t.setDescripcion(nuevaDescripcion);
                guardarEnArchivo();
                System.out.println("tarea actualizada");
                return;
            }

        }
        System.out.println("Tarea con ID: " + id + " no encontrada");
    }

    public void eliminarTarea(int id) {

        if (tareas.removeIf(t -> t.getId() == id)) {
            guardarEnArchivo();
            System.out.println("Tarea eliminado con el Id " + id);
        } else {
            System.out.println("Tarea con ID: " + id + " no encontrada");
        }

    }
    
    public void cambiarEstado(int id,String nuevoEstado){
    for(Task t: tareas){
    if(t.getId()==id){
    t.setStatus(nuevoEstado);
    guardarEnArchivo();
        System.out.println("Estado actualizado");
    return;
    }
        }
        System.out.println("Tarea con el Id: "+id+" no encontrada");
    }
    
    public void listarTodas(){
    if(tareas.isEmpty()){
        System.out.println("no hay tareas");
    return;
    }
    for(Task t:tareas){
        System.out.printf("ID: %d - %s [%s]%n",t.getId(),t.getDescripcion(),t.getStatus());
    }
    }
    
    public void listarPorEstado(String estado){
    boolean encontrado=false;
    for(Task t:tareas){
    if(t.getStatus().equalsIgnoreCase(estado)){
        System.out.printf("ID: %d - %s [%s]%n",t.getId(),t.getDescripcion(),t.getStatus());
        encontrado=true;
    }
    }
     
    if(!encontrado){
        System.out.println("No se encontraron tareas con estado: "+estado);
    }
        
        
        }

    
    public void guardarEnArchivo(){
    
        try(PrintWriter pw=new PrintWriter(new FileWriter(archivo))){
        
        for(Task t:tareas){
        pw.println(t.toJson());
        
        }
        
        }catch(IOException e){
        System.err.println("Error al guardar tareas en el archivo: "+e.getMessage());
        }
    
    
    
    }
    
    public void cargarDesdeArchivo(){
    tareas.clear();
    if (!archivo.exists()) return;
    
    try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
    
    String linea;
    while((linea=br.readLine())!=null){
    tareas.add(Task.fromJson(linea));
    }
    
    
    }catch(IOException e){
        System.err.println("Error al cargar tareas: "+e.getMessage());
    }
    
    
    
    }
    
}
