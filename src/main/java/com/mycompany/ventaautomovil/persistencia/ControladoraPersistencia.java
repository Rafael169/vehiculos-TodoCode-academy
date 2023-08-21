package com.mycompany.ventaautomovil.persistencia;

import com.mycompany.ventaautomovil.logica.Automovil;
import com.mycompany.ventaautomovil.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    AutomovilJpaController autoJpa = new AutomovilJpaController();
    //cierre de la primera parte que era agregar a la BD
    
    
    public void agregarAutomovil(Automovil auto) {

        autoJpa.create(auto);
        //cierre de la primera parte que era agregar a la BD

    }

    public List<Automovil> traerAutos() {
       return autoJpa.findAutomovilEntities();
    }
    //hasta aqui se cargan los datos en la tabla 

    public void borrarAuto(int idAuto) {
        try {
            autoJpa.destroy(idAuto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //aqui termina la eliminacion 

    public Automovil traerAutos(int idAuto) {
        return autoJpa.findAutomovil(idAuto);
    }

    public void modificarAuto(Automovil auto) {
        try {
            autoJpa.edit(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
