# TaskTrackerCLI
Projecto que permite hacer un seguimiento de tus tareas a traves de CLI.
https://roadmap.sh/projects/task-tracker


TaksTracker/
│
├── src/
│   ├── domain/
│   │   ├── Task.java
│   │   └── TaskManager.java
│   │
│   └── main/
│       └── Main.java
│
├── out/                 # Archivos compilados (creado tras compilar)
├── tareas.json          # Archivo donde se guardan las tareas (se crea automáticamente)
└── README.md

# Funcionalidades
.Agregar tareas

.Actualizar tareas

.Eliminar tareas

.Cambiar estado: todo, in-progress, done

.Listar tareas por estado o todas

.Persistencia en archivo .json

.Sin dependencias externas
//Falta detalles de info de las tareas a agregar.

#Como compilar desde CLI
javac -d out src/domain/*.java src/main/Main.java

Uso de la aplicación

Ejecución general:

java -cp out main.Main [comando] [argumentos...]

java -cp out main.Main add "..."


java -cp out main.Main update 1 "..."


java -cp out main.Main delete 1

java -cp out main.Main mark-in-progress 1  
java -cp out main.Main mark-done 1
java -cp out main.Main list
java -cp out main.Main list done → Valores de estado válidos: todo, in-progress, done





