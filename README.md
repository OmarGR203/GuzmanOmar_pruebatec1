# SISTEMA DE GESTION DE EMPLEADOS
Prueba Tecnica número 1 de Java Básico para el Bootcamp de Hack a Boss.

## Descripcion

Este proyecto es una aplicación basica de consola en Java para poder gestionar la informacion de los empleados en alguna organización. El sistema permite crear, eliminar, consultar y modificar la información de los empleados.

## Funcionalidades

* **Alta de empleado:** Permite ingresar los datos por consola del nombre, apellido, cargo, salario y fecha de ingreso de un nuevo empleado. 
* **Baja de empleado:** Permite eliminar a un empleado mediante su identificados unico (id).
* **Consulta de empleado:** Permite realizar la consulta de todos los empleados registrados asi como buscar los empleados filtrando por su cargo.
* **Actualización de empleado:** Permite modificar la informacion de un empleado existente.

 ### Clases
 - **Empleado:** Clase que contiene la entidad del empleado, en donde se declaran sus atributos y sus metodos constructores, getters y setters.
 - **PruebaTecnica1** Clase que contiene el metodo principal del proyecto, asi como el menu interactivo y las validaciones de datos.
 - **SalarioInvalidoException:** Clase que contiene la excepción personalidaza en caso que se ingrese un dato inválido.
 - 
 ### Metodos
 - **menu:** Método que muestra el menu interactivo ASCII.
 - **ingresarDatos:** Método para ingresar los datos de los empleados, ya sea para crear uno nuevo o actualizar los ya existentes
 - **consultarEmpleados:** Método que recorre un switch de dos casos, el primero en donde se listan los empleados existentes en la Base de Datos y el segundo para filtrar el listado de acuerdo al cargo del empleado
 - **modEmpleados:** Método para modificar a un empleado de acuerdo al id proporcionado, dado este se muestra el empleado a modificar y se solicitan los datos nuevos.
 - **validarSalario:** Método para validar que el salario sea mayor a 0.
 - **validarDAto:** Método para validar que algun dato, ya sea nombre, apellido o cargo no tenga que ingresar obligatoriamente y no quede vacio.

## Requisitos 

- Java 11 o superior.
- Gestor de Base de Datos MySQL
- IDE
- Servidor de Base de Datos
- Ejecutar la Base de Datos del sistema en el siguiente URL [https://github.com/OmarGR203/GuzmanOmar_pruebatec1/blob/master/empleado.sql]

## Pruebas
![Imagen del repositorio](https://github.com/OmarGR203/GuzmanOmar_pruebatec1/blob/master/ImagenPruebas.png)


## Supuestos
- Se tomo en cuenta que los empleados necesitan un identificados unico (id).
- Se asume que el usuario tiene acceso al sistema sin necesitar credenciales de acceso.
- Se asume que el usuario coloca la fecha correctamente con el formato solicitado.
- Se asume que al actualizar o eliminar la informacion de un empleado, el usuario conoce su id.
