package presentacion;

import java.util.Scanner;
import dominio.*;
/*
Clase SistemaElecciones:
Atributos: eleccion (objeto Eleccion)
Métodos: iniciarEleccion(), mostrarResultados()
 */


public class SistemaElecciones {
    private final Eleccion eleccion;
    private final static Scanner teclado = new Scanner(System.in);


    //Constructor:
    public SistemaElecciones(Eleccion eleccion) {
        this.eleccion = eleccion;
    }


    //Método para iniciar la elección:
    public void iniciarEleccion() {
        System.out.println("Iniciando la eleccion ...");
        if (!eleccion.validarPapeletas()) System.out.println("No hay papeletas cargadas");
        else {
            for (Papeleta papeleta : eleccion.getPapeletas()) {
                System.out.println("Papeleta " + papeleta.getNombre());
            }

            if (eleccion.realizarRecuento()) {
                System.out.println("Elección procesada exitosamente.");
            } else {
                System.out.println("Error al procesar la elección.");
            }
        }
    }


    //Método para mostrar resultados:
    public void mostrarResultados() {
        System.out.println("Resultados de la elección:");
        eleccion.mostrarResultados();
    }


    //Menú de la interfaz:
    public void menu (){
        int opcion;

        do {
            System.out.print("Sistema de Elecciones:\n" +
                            "\tOpción 0: Salir del programa.\n" +
                            "\tOpción 1: Recuento de votos.\n" +
                    "Introduzca una de las opciones: ");
            opcion = teclado.nextInt();
            System.out.println();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    iniciarEleccion();
                    mostrarResultados();
                    break;
                default:
                    System.out.println("Opción incorrecta.\n");
                    break;
            }
        } while (opcion != 0);

    }
}