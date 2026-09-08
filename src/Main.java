import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        boolean mostrar_Menu = true;
        while (mostrar_Menu) {
            System.out.println("Inicio de programa");
            System.out.println("1. Probando array");
            System.out.println("2. probando arraylist");
            System.out.println("3. salir");
            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
                case "1":
                    System.out.println("array de estudiantes");
                    probandoArray();
                    break;

            }
        }
    }

    static void probandoArray() {
        String[] estudiantes = new String[3];
        estudiantes[0] = "Juan";
        estudiantes[1] = "Maria";
        estudiantes[2] = "Pedro";

        Integer[] edades = new Integer[3];
        edades[0] = 20;
        edades[1] = 22;
        edades[2] = 21;

        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Estudiante: " + estudiantes[i] + ", Edad: " + edades[i]);
        }
    }
}
