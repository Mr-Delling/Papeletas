package presentacion;

import dominio.*;
import java.util.ArrayList;
import java.util.List;

public class Eleccion {
    /*
    Clase Eleccion:
    Atributos: candidatos (lista de objetos Candidato), papeletas (lista de objetos Papeleta)
    Métodos: realizarRecuento(), eliminarCandidatoConMenosVotos(), comprobarMayoríaAbsoluta(), validarPapeletas()
     */
    private static List<Candidato> candidatos;
    private List<Papeleta> papeletas = new ArrayList<>();


    //Constructores:
    public Eleccion(List<Papeleta> papeletas) {
        this.papeletas = papeletas;
        candidatos = List.of(
                new Candidato("Pepito"),
                new Candidato("Juan")
        );
    }

    public static Candidato getCandidato(int indiceCandidato) {
        switch (indiceCandidato) {
            case 1:
                return candidatos.get(0);
            case 2:
                return candidatos.get(1);
            default:
                System.out.println("Este candidato no existe.");
                return null;
        }
    }
}