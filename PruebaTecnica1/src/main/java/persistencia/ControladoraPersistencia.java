package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Empleado;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    empleadoJpaController empleadoJpa = new empleadoJpaController();

    public void crearEmpleado(Empleado empleado) {
        empleadoJpa.create(empleado);
    }

    public void borrarEmpleado(int id) {
        try {
            empleadoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(int id) {
        return empleadoJpa.findempleado(id);
    }

    public List<Empleado> traerEmpleados() {
        return empleadoJpa.findempleadoEntities();
    }

    public void editarEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
