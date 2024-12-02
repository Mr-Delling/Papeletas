# Gestor de Conteo de Papeletas

## Descripción
Este proyecto es una aplicación de consola que permite gestionar el conteo de papeletas sacando cual es el ganador por mayoria absoluta, si este es un empate se ira eliminando uno a uno los partidos con menos botaciones y se distribuiran estas entre los prtidos restantes
## Instalación
1. Clona el repositorio:
   ```bash
   git clone  https://github.com/Mr-Delling/Papeletas.git

## Estructura del proyecto
src/
├── aplicacion/
│   └── Main.java
├── dominio/
│   ├── Candidato.java
│   ├── Eleccion.java
│   └── Papeleta.java
└── presentacion/
    └── SistemaElecciones.java
