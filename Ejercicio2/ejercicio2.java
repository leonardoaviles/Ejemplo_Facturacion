package Ejercicio2;

import java.util.*;

import Ejercicio2.Persona;

public class ejercicio2 {
    
    public static void main(String[] args) {

        //Se crea la lista de personas
        List<Persona> personas = Arrays.asList(new Persona("Carlos","Sanchez"),
                                               new Persona("Juan","Mendez"),
                                               new Persona("Pedro","Linares"),
                                               new Persona("Luis","Marquez"),
                                               new Persona("Alejandro","Parra"));

        //Se utiliza la propiedad sort de la clase lista para poder iterar las personas y se utiliza la clase comparator para
        //poder comparar los valores
        personas.sort(Comparator.comparing(Persona::getNombre));

        System.out.println("Comparando por nombre");

        for(Persona personaFinal : personas){
            System.out.println("Nombre: "+ personaFinal.getNombre() + " Apellido: "+ personaFinal.getApellido());
        }  


        System.out.println("\nComparando por apellido");

        personas.sort(Comparator.comparing(Persona::getApellido));

        for(Persona personaFinal : personas){
            System.out.println("Nombre: "+ personaFinal.getNombre() + " Apellido: "+ personaFinal.getApellido());
        }

        System.out.println("\nComparando por apellido a la inversa");

        personas.sort(Comparator.comparing(Persona::getApellido).reversed());

        for(Persona personaFinal : personas){
            System.out.println("Nombre: "+ personaFinal.getNombre() + " Apellido: "+ personaFinal.getApellido());
        }   
    }

}
