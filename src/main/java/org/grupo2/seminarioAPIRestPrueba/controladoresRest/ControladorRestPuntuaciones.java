package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorPuntuaciones;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.PuntuacionesException;
import org.grupo2.exceptions.UniversidadException;
import org.grupo2.exceptions.UsuarioException;
import org.grupo2.vo.PuntuacionVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestPuntuaciones {
/*
    @PostMapping("/crearPuntuacionCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearPuntuacionCarrera(@RequestParam(name = "alias") String alias,
                                       @RequestParam(name = "idUniversidad") int idUniversidad,
                                       @RequestParam(name = "puntuacion") int puntuacion,
                                       @RequestParam(name = "idCarrera") int idCarrera) throws UniversidadException, CarreraException, PuntuacionesException, UsuarioException {
        ControladorPuntuaciones.getInstance().crearPuntuacionCarrera(alias, idUniversidad, puntuacion, idCarrera);
    }
*/
    @PostMapping("/crearPuntuacionUniversidad")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearPuntuacionUniversidad(@RequestParam(name = "alias") String alias,
                                           @RequestParam(name = "idUniversidad") int idUniversidad,
                                           @RequestParam(name = "puntuacion") int puntuacion) throws UniversidadException, CarreraException, UsuarioException, PuntuacionesException {
        ControladorPuntuaciones.getInstance().crearPuntuacionUniversidad(alias, idUniversidad, puntuacion);
    }

    @RequestMapping("/getPuntuacionesCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<PuntuacionVO> leerPuntuacionCarrera(@RequestParam(name = "idUniversidad") int idUniversidad,
                                                    @RequestParam(name = "idCarrera") int idCarrera) throws PuntuacionesException {
        return ControladorPuntuaciones.getInstance().leerPuntuacionCarrera(idUniversidad, idCarrera);
    }

    @RequestMapping("/getPuntuacionesUniversidad")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<PuntuacionVO> leerPuntuacionUniversidad(@RequestParam(name = "idUniversidad") int idUniversidad) throws PuntuacionesException {
        return ControladorPuntuaciones.getInstance().leerPuntuacionUniversidad(idUniversidad);
    }

}
