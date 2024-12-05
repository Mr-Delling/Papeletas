package dominio;

import java.util.ArrayList;
import java.util.List;

public class Eleccion {
    /*
    Clase Eleccion:
    Atributos: candidatos (lista de objetos Candidato), papeletas (lista de objetos Papeleta)
    Métodos: realizarRecuento(), eliminarCandidatoConMenosVotos(), comprobarMayoríaAbsoluta(), validarPapeletas()
     */
    private final static  List<Candidato> candidatos = List.of(
        new Candidato("Pepito"),
        new Candidato("Juan"),
        new Candidato("Alejandro"),
        new Candidato("Matthew")    
);;
    private List<Papeleta> papeletas = new ArrayList<>();


    //Constructores:
    public Eleccion(List<Papeleta> papeletas) {
        this.papeletas = papeletas;
    }


    //Métodos de candidatos
    public static Candidato getCandidato(int indiceCandidato) {
        switch (indiceCandidato) {
            case 1:
                return candidatos.get(0);
            case 2:
                return candidatos.get(1);
            case 3:
                return candidatos.get(2);
            case 4:
                return candidatos.get(3);
            default:
                System.out.println("Este candidato no existe.");
                return null;
        }
    }
    public static int indiceCandidato(Candidato candidato) {
        switch (candidato.getNombre()) {
            case "Pepito":
                return 1;
            case "Juan":
                return 2;
            case "Alejandro":
                return 3;
            case "Matthew":
                return 4;
            default:
                System.out.println("Este candidato no existe.");
                return -1;
        }
    }


    //Métodos de Eleccion
    public boolean realizarRecuento() {
        try{
            for (Papeleta papeleta : papeletas) {
                for (Candidato candidato : candidatos) {
                    if (papeleta.getCandidatos().contains(candidato)) {
                        candidato.setVotos(candidato.getVotos() + 1);
                    }
                }
            }
        }catch (NullPointerException e){
            System.out.println("No hay papeletas o candidatos");
        }
        return true;
    }
    // Metodo de MostrarResultados
    public void mostrarResultados() {
        for (Candidato candidato : candidatos) {
            System.out.println("Nombre: " + candidato.getNombre() + " Votos: "+ candidato.getVotos() );
        }
    }

    public boolean eliminarCandidatoConMenosVotos() {
        try {
            Candidato menosVotos = candidatos.get(0);
            for (Candidato candidato : candidatos) {
                if (menosVotos.getVotos() > candidato.getVotos()) {
                    menosVotos = candidato;
                }
            }
            candidatos.remove(menosVotos);
            return true;
        } catch (NullPointerException e) {
            System.out.println("Error de eliminación.");
            return false;
        }
    }
}