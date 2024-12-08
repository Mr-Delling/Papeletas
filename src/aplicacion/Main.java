package aplicacion;

import java.util.ArrayList;
import dominio.*;
import presentacion.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Papeleta> papeletas = new ArrayList<>();
        Papeleta papeleta1 = Papeleta.leer("Papeleta1");
        papeletas.add(papeleta1);
        papeletas.add(Papeleta.leer("Papeleta2"));
        Eleccion eleccion = new Eleccion(papeletas);

        System.out.println();
        SistemaElecciones sistemaElecciones = new SistemaElecciones(eleccion);
        sistemaElecciones.menu();
    }
}