package Ejercicio2;

import java.util.*;

import Ejercicio2.Persona;

public class ejercicio2 {
    
    public static void main(String[] args) {

        Persona persona1 = new Persona("Carlos","Sanchez");
        Persona persona2 = new Persona("Juan","Mendez");
        Persona persona3 = new Persona("Pedro","Linares");
        Persona persona4 = new Persona("Luis","Marquez");
        Persona persona5 = new Persona("Alejandro","Parra");


        //Se crea la lista de personas
        List<Persona> personas = new ArrayList<Persona>();

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);

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
