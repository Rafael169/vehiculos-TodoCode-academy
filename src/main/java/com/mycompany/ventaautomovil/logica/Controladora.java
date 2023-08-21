package com.mycompany.ventaautomovil.logica;

import com.mycompany.ventaautomovil.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    //comunicacion entre la controladora de persistencia y esta
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void agregarAutomovil(String modelo, String marca, String motor, String color,
            String patente, int cantPuerta) {

        Automovil auto = new Automovil();

        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuerta);

        //llamamos a la controladora de persistencia 
        controlPersis.agregarAutomovil(auto);

        //cierre de la primera parte que era agregar a la BD
    }

    public List<Automovil> traerAutos() {
        return controlPersis.traerAutos();
    }
    //hasta aqui se cargan los datos en la tabla 

    public void borrarAuto(int idAuto) {
        controlPersis.borrarAuto(idAuto);
    }
    //aqui termina la eliminacion 

    public Automovil traerAutos(int idAuto) {
        return controlPersis.traerAutos(idAuto);
    }

    public void modificarAuto(Automovil auto, String modelo, String marca, String motor,
            String color, String patente, int cantPuerta) {
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuerta);
        
        //le pido a la persistencia que modifique 
        controlPersis.modificarAuto(auto);

    }

}
