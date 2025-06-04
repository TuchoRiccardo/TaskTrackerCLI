package main;

import domain.*;



public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Instanciando el TaskManager");
TaskManager manager = new TaskManager("Tarea.json");


        System.out.println("Bienvenido al programa");
if(args.length ==0){
mostrarAyudas();
return;
}

String comando =args[0];

switch (comando){
        
 case "add":
                if (args.length >= 2) {
                    String descripcion = unirArgumentos(args, 1);
                    manager.agregarTarea(descripcion);
                } else {
                    System.out.println("Error: Falta la descripción de la tarea.");
                }
                break;

case "update":
                if (args.length >= 3) {
                    try {
                        int id = Integer.parseInt(args[1]);
                        String nuevaDesc = unirArgumentos(args, 2);
                        manager.actualizarTarea(id, nuevaDesc);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El ID debe ser un número.");
                    }
                } else {
                    System.out.println("Uso: update <id> \"nueva descripción\"");
                }
                break;
                
                  case "delete":
                if (args.length == 2) {
                    try {
                        int id = Integer.parseInt(args[1]);
                        manager.eliminarTarea(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El ID debe ser un número.");
                    }
                } else {
                    System.out.println("Uso: delete <id>");
                }
                break;

case "mark-in-progress":
                marcarEstado(manager, args, "in-progress");
                break;
                
case "mark-done":
                marcarEstado(manager, args, "done");
                break;
                
case "list":
                if (args.length == 1) {
                    manager.listarTodas();
                } else {
                    manager.listarPorEstado(args[1]);
                }
                break;
                
 default:
                System.out.println("Comando no reconocido: " + comando);
                mostrarAyudas();
    
                
}



        
        
    }
  
    
    
//Menu CLI    
    private static void marcarEstado(TaskManager manager, String [] args, String status){
    
    if(args.length ==2){
    try{
    int id=Integer.parseInt(args[1]);
    manager.cambiarEstado(id, status);
    
    }catch(NumberFormatException e){
        System.out.println("Error: el Id debe ser un numero");
    
    }
    
    
    
    }else{
        System.out.println("Uso: "+(status.equals("en progreso")? "marcar como iniciado":"marcar como hecho")+" <id>");
    }
    
    
    }
    
    
    private static String unirArgumentos(String [] args,int desde){
    StringBuilder sb = new StringBuilder();
    
        for (int i = desde; i < args.length; i++) {
            sb.append(args[i]);
            if(i < args.length -1) sb.append(" ");
        }
    
        
    return sb.toString();
    
    }

   
    
    private static void mostrarAyudas(){
    
        System.out.println("Comandos disponibles:\n" +
"            add \"descripción\"            - Agrega una nueva tarea\n" +
"            update <id> \"nueva desc.\"    - Actualiza la descripción de una tarea\n" +
"            delete <id>                  - Elimina una tarea\n" +
"            mark-in-progress <id>        - Marca como en progreso\n" +
"            mark-done <id>               - Marca como completada\n" +
"            list                         - Lista todas las tareas\n" +
"            list <estado>                - Lista tareas por estado (todo, in-progress, done)\n" +
"            \"\"\"");
    
    
    }
}
    

