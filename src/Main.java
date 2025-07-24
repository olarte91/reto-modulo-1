import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int option = 0;
    static String studentName = "N/A";
    static double grade1 = 0.0;
    static double grade2 = 0.0;
    static double grade3 = 0.0;
    static double averageGrade = 0.0;

    public static void main(String[] args) throws Exception {
        mainMenu();
    }

    /**
     * Método que muestra el menú principal y las opciones que puede elegir el usuario
     */
    public static void mainMenu() {
        System.out.println("\n--- Sistema de Registro de Estudiantes ---\n");

        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Mostrar promedio del estudiante");
        System.out.println("4. Salir");
        System.out.print("Ingrese su opción: ");

        option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                registerStudentName();
                break;

            case 2:
                showStudentInfo();
                break;
            case 3:
                showAverageGrades();
                break;
            case 4:
                break;

            default:
                System.out.println("\nOpción incorrecta!\n");
                mainMenu();

        }
    }

    /**
     * Método para registrar la tercer nota del estudiante, la nota se valida con el
     * método {@link #validateGrade(double)}
     */
    private static void registerThirdGrade() {
        System.out.println("--- Registrar nota 3 ---\n");
        System.out.print("Nota 3: ");
        grade3 = scanner.nextDouble();
        if(validateGrade(grade3)){
            System.out.println("\nNota 3 registrada con éxito!\n");
            mainMenu();
        }else{
            System.out.println("Nota no válida, debe estar entre 0 y 100");
            registerThirdGrade();
        }
    }

    /**
     * Método para registrar la segunda nota del estudiante, la nota se valida con el
     * método {@link #validateGrade(double)}
     */
    private static void registerSecondGrade() {
        System.out.println("--- Registrar nota 2 ---\n");
        System.out.print("Nota 2: ");
        grade2 = scanner.nextDouble();
        if (validateGrade(grade2)) {
            System.out.println("\nNota 2 registrada con éxito!\n");
            registerThirdGrade();
        } else {
            System.out.println("Nota no válida, debe estar entre 0 y 100");
            registerSecondGrade();
        }
    }

    /**
     * Método para registrar la primer nota del estudiante, la nota se valida con el método {@link #validateGrade(double)}
     */
    private static void registerFirstGrade() {
        System.out.println("\n--- Registrar nota 1 ---\n");
        System.out.print("Nota 1: ");
        grade1 = scanner.nextDouble();
        if (validateGrade(grade1)) {
            System.out.println("\nNota 1 registrada con éxito!\n");
            registerSecondGrade();
        } else {
            System.out.println("Nota no válida, debe estar entre 0 y 100");
            registerFirstGrade();
        }
    }

    /**
     * Método que registra el nombre del estudiante, se valida que el nombre sea correcto con el método {@link #validateName(String)}
     */
    private static void registerStudentName() {
       System.out.println("\n--- Registrar nobmre del estudiante ---\n");
       System.out.print("Ingrese el nobmre del estudiante: ");
       studentName = scanner.nextLine();
       if(validateName(studentName)){
           System.out.println("Nombre del usuario registrado con éxito!");
           registerFirstGrade();
       }else{
        System.out.println("\nNombre del estudiante inválido!\n");
        registerStudentName();
       }
       
    }

    /**
     * Método que muestra la información del estudiante
     */
    public static void showStudentInfo() {
        System.out.println("\n--- Información del estudiante ---\n");
        System.out.println("Nombre del estudiante: " + studentName);
        System.out.println("Nota 1: " + grade1);
        System.out.println("Nota 2: " + grade2);
        System.out.println("Nota 3: " + grade3);
        scanner.nextLine();
        mainMenu();
    }

    /**
     * Método que calcula el promedio de notas del estudiante
     * @param nota1 Primera nota del estudiante
     * @param nota2 Segunda nota del estudiante
     * @param nota3 Tercera nota del estudiante
     * @return Promedio de notas del estudiante
     */
    public static double calculateAverageGrades(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3;
    }

    /**
     * Metodo que imprime el promedio del estudiante
     */
    public static void showAverageGrades() {
        System.out.printf("\n--- Promedio estudiante %s ---\n", studentName);
        System.out.printf("Promedio: %.2f\n", calculateAverageGrades(grade1, grade2, grade3));
        scanner.nextLine();
        mainMenu();
    }

    /**
     * Método para validar la nota de un alumno, no debe ser menor de 0 y mayor de 100
     * @param grade nota del alumno
     * @return true en caso de que la nota esté en el rango permitido, false en caso contrario
     */
    public static boolean validateGrade(double grade) {
        if (grade >= 0.0 && grade <= 100.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para validar el nombre del estudiante
     * @param name nombre de estudiante a validar
     * @return true si el nombre no está vacío y false en caso de estar vacío
     */
    public static boolean validateName(String name){
        if(name != ""){
            return true;
        }else{
            return false;
        }

    }

}
