import java.util.Scanner;

public class NumeroFlotante_LeonardoAvilesMeneses {

    public static void main(String[] args) {	

        Scanner scanner = new Scanner(System.in);
        
        //crear metodo que permita mostrar la parte entera y la parte en en decimal por separado de un float

        // SIN PEDIR DATOS POR CONSOLA

        //se declaran los variables principales
        float numeroPrincipal = 457.245f;
        float parteEntera = 0;
        float parteDecimal = 0;

        //se realiza la operacion de modulo 1 para que nos regrese el restante del numero principal
        parteDecimal = numeroPrincipal % 1;

        // se resta la parte decimal del numero principal y se asigna a la variable de parte entera
        parteEntera = numeroPrincipal - parteDecimal;

        //se imprimen los valores por consola

        System.out.println("La parte entera del numero: "+ numeroPrincipal+ "es: "+parteEntera+" y la parte decimal es: "+parteDecimal);
        String a =scanner.nextLine();
	}

    
}
