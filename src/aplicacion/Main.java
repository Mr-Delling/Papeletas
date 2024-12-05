import java.util.ArrayList;

import dominio.*;
import presentacion.*;

public class Main {
    public static void main(String[] args) {

        Papeleta papeleta1 = Papeleta.leer("papeleta1");

        ArrayList<Papeleta> papeletas = new ArrayList<>();
        papeletas.add(papeleta1);
        Eleccion eleccion = new Eleccion(papeletas);
        SistemaElecciones sistemaElecciones = new SistemaElecciones(eleccion);
        sistemaElecciones.menu();
    }
}
