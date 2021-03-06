package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorPuntuaciones;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.PuntuacionesException;
import org.grupo2.exceptions.UniversidadException;
import org.grupo2.vo.PuntuacionVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorRestPuntuaciones {

    @PostMapping("/crearPuntuacionCarrera")
    public void crearPuntuacionCarrera(@RequestParam(name = "idUsuario") int idUsuario,
                                       @RequestParam(name = "idUniversidad") int idUniversidad,
                                       @RequestParam(name = "puntuacion") int puntuacion,
                                       @RequestParam(name = "idCarrera") int idCarrera) throws UniversidadException, CarreraException {
        ControladorPuntuaciones.getInstance().crearPuntuacionCarrera(idUsuario, idUniversidad, puntuacion, idCarrera);
    }

    @PostMapping("/crearPuntuacionUniversidad")
    public void crearPuntuacionUniversidad(@RequestParam(name = "idUsuario") int idUsuario,
                                           @RequestParam(name = "idUniversidad") int idUniversidad,
                                           @RequestParam(name = "puntuacion") int puntuacion) throws UniversidadException, CarreraException {
        ControladorPuntuaciones.getInstance().crearPuntuacionUniversidad(idUsuario, idUniversidad, puntuacion);
    }

    @RequestMapping("/getPuntuacionesCarrera")
    public List<PuntuacionVO> leerPuntuacionCarrera(@RequestParam(name = "idUniversidad") int idUniversidad,
                                                    @RequestParam(name = "idCarrera") int idCarrera) throws PuntuacionesException {
        return ControladorPuntuaciones.getInstance().leerPuntuacionCarrera(idUniversidad, idCarrera);
    }

    @RequestMapping("/getPuntuacionesUniversidad")
    public List<PuntuacionVO> leerPuntuacionUniversidad(@RequestParam(name = "idUniversidad") int idUniversidad) throws PuntuacionesException {
        return ControladorPuntuaciones.getInstance().leerPuntuacionUniversidad(idUniversidad);
    }

}
