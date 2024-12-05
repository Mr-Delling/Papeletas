package presentacion;

import java.util.Scanner;

import dominio.*;


public class SistemaElecciones {
private Eleccion eleccion;
private final static Scanner teclado = new Scanner(System.in);
// Constructor
public SistemaElecciones(Eleccion eleccion) {
    this.eleccion = eleccion;
}
 // Método para iniciar la elección
 public void iniciarEleccion() {
    System.out.println("Iniciando la elección...");
    if (eleccion.realizarRecuento()){
        System.out.println("Elección procesada exitosamente.");
    }else {
        System.out.println("Error al procesar la elección.");
    }
}
// Método para mostrar resultados
public void mostrarResultados() {
    System.out.println("Resultados de la elección:");
    eleccion.mostrarResultados();
}

public void menu (){
    int option;

    do {
        System.out.println("Sistema de Elecciones: "+ "\n"+ "Opcion 0: Salir"+"\n"+"Opcion 1: Recuento");
        System.out.print("Introduzca una de las opciones: ");
        option = teclado.nextInt();

        switch (option) {
            case 0: 
                System.out.println("Salir del programa");
            break;
            case 1:
                System.out.println("Recuento de votos");
                eleccion.realizarRecuento();
                mostrarResultados();
            break;
            default:
                System.out.println("Opcion incorrecta no sabes leer.");
            break;
        }
    } while (option != 0);
    
}
}
