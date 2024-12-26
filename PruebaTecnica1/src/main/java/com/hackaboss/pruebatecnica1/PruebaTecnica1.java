package com.hackaboss.pruebatecnica1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import logica.Empleado;
import logica.excepciones.SalarioInvalidoException;
import persistencia.ControladoraPersistencia;

public class PruebaTecnica1 {

    private static Scanner sc = new Scanner(System.in);
    private static ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public static void main(String[] args) throws SalarioInvalidoException {

        int opcion = 0;

        while (true) {
            menu();
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingresa los datos del nuevo empleado: ");
                    Empleado empleado = ingresarDatos();
                    controlPersis.crearEmpleado(empleado);
                    System.out.println("¡Empleado dado de alta correctamente!");
                }
                case 2 -> {
                    System.out.println("Ingrese el id del empleado que desea eliminar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    controlPersis.borrarEmpleado(id);
                    System.out.println("Empleado eliminado correctamente.");
                }
                case 3 -> {
                    System.out.println("¿Desea consultar todos los empleados (1) o por cargo (2)?");
                    consultarEmpleados();

                }
                case 4 -> {
                    System.out.println("Ingrese el ID del empleado a modificar: ");
                    modEmpleados();
                }
                case 5 -> {
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta pronto!");
                    return;
                }

                default ->
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        }

    }

    public static void menu() {
        System.out.println("==============================================");
        System.out.println("       Menú Principal - Gestión de Empleados");
        System.out.println("==============================================");
        System.out.println("| 1. Alta de empleado                        |");
        System.out.println("| 2. Baja de empleado                        |");
        System.out.println("| 3. Consulta de empleados                   |");
        System.out.println("| 4. Modificaciones de empleado              |");
        System.out.println("| 5. Salir                                   |");
        System.out.println("==============================================");
        System.out.print("Seleccione una opción (1-5): ");
    }

    public static Empleado ingresarDatos() {
        Empleado empleado = new Empleado();
        Scanner sc = new Scanner(System.in);

        //Solicitud del nombre
        String nombre = null;
        boolean nombreValido = false;

        while (nombreValido != true) {

            try {
                System.out.println("Ingrese el nombre del empleado: ");
                nombre = sc.nextLine();
                validarDato(nombre);
                nombreValido = true;
                empleado.setNombre(nombre);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Soicitud del apellido
        String apellido = null;
        boolean apellidoValido = false;

        while (apellidoValido != true) {

            try {
                System.out.println("Ingrese el apellido del empleado: ");
                apellido = sc.nextLine();
                validarDato(apellido);
                apellidoValido = true;
                empleado.setApellido(apellido);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Solicitud del cargo
        String cargo = null;
        boolean cargoValido = false;

        while (cargoValido != true) {

            try {
                System.out.println("Ingrese el cargo del empleado: ");
                cargo = sc.nextLine();
                validarDato(cargo);
                cargoValido = true;
                empleado.setCargo(cargo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Solicitud del salario
        double salario = 0.0;
        boolean salarioValido = false;

        while (salarioValido != true) {

            try {
                System.out.println("Ingrese el salario del empleado: ");
                salario = Double.parseDouble(sc.nextLine());
                validarSalario(salario);
                salarioValido = true;
                empleado.setSalario(salario);
            } catch (SalarioInvalidoException e) {
                System.out.println(e.getMessage());
            }

        }

        //Solicitar la fecha de inicio
        LocalDate fechaInicio = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (fechaInicio == null) {

            try {
                System.out.print("Introduce una fecha en formato yyyy-MM-dd: ");
                String fecha = sc.nextLine();
                fechaInicio = LocalDate.parse(fecha, formato);
                empleado.setFechaInicio(fechaInicio);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida.Por favor, ingresa una nueva fecha.");

            }

        }
        return empleado;
    }

    private static void consultarEmpleados() {
        int consultaOpcion = Integer.parseInt(sc.nextLine());
        switch (consultaOpcion) {
            case 1 -> {
                List<Empleado> empleados = controlPersis.traerEmpleados();
                for (Empleado emp : empleados) {
                    System.out.println(emp);
                }
            }
            case 2 -> {
                System.out.println("Ingrese el cargo que desea consultar: ");
                String cargoConsulta = sc.nextLine();
                List<Empleado> empleadosPorCargo = controlPersis.traerEmpleados().stream()
                        .filter(emp -> emp.getCargo().equalsIgnoreCase(cargoConsulta))
                        .toList();

                if (empleadosPorCargo.isEmpty()) {
                    System.out.println("No se encontraron empleados con el cargo: " + cargoConsulta);
                } else {
                    for (Empleado emp : empleadosPorCargo) {
                        System.out.println(emp);
                    }
                }
            }
            default ->
                System.out.println("Opción no válida.");
        }

    }

    private static void validarDato(String dato) {
        if (dato == null || dato.trim().isEmpty()) {
            throw new IllegalArgumentException("Este dato no puede estar vacío");
        }

    }

    private static void modEmpleados() {
        int idModificar = Integer.parseInt(sc.nextLine());
        Empleado empleadoModificar = controlPersis.buscarEmpleado(idModificar);
        if (empleadoModificar != null) {
            System.out.println("Datos actuales del empleado: " + empleadoModificar);

            Empleado actEmpleado = ingresarDatos();

            empleadoModificar.setNombre(actEmpleado.getNombre());
            empleadoModificar.setApellido(actEmpleado.getApellido());
            empleadoModificar.setCargo(actEmpleado.getCargo());
            empleadoModificar.setSalario(actEmpleado.getSalario());
            empleadoModificar.setFechaInicio(actEmpleado.getFechaInicio());

            controlPersis.editarEmpleado(empleadoModificar);
            System.out.println("Empleado modificado correctamente. ");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void validarSalario(double salario) throws SalarioInvalidoException {

        if (salario <= 0) {
            throw new SalarioInvalidoException("El salario ingresado es inválido. Debe ser mayor a 0");
        }

    }
}
