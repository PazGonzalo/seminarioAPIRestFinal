package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorComentarios;
import org.grupo2.controladores.ControladorPuntuaciones;
import org.grupo2.exceptions.*;
import org.grupo2.vo.ComentarioVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestComentarios {

    @PostMapping("/crearComentarioCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearComentarioCarrera(@RequestParam(name = "alias") String alias,
                                       @RequestParam(name = "idUniversidad") int idUniversidad,
                                       @RequestParam(name = "comentario") String comentario,
                                       @RequestParam(name = "idCarrera") int idCarrera,
                                       @RequestParam(name = "punctuation") int punctuation,
                                       @RequestParam(name="rol")String rol) throws UniversidadException, CarreraException, UsuarioException, PuntuacionesException {
        ControladorComentarios.getInstance().crearComentarioCarrera(alias,rol ,idUniversidad, comentario, idCarrera,punctuation);
    }

    @PostMapping("/crearComentarioUniversidad")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearComentarioUniversidad(@RequestParam(name = "alias") String alias,
                                           @RequestParam(name = "idUniversidad") int idUniversidad,
                                           @RequestParam(name = "comentario") String comentario,
                                           @RequestParam(name = "rol" ) String rol) throws UniversidadException, CarreraException, UsuarioException {
        ControladorComentarios.getInstance().crearComentarioUniversidad(alias,rol, idUniversidad, comentario);
    }

    @RequestMapping("/getComentariosByUniversidad")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<ComentarioVO> leerComentariosUniversidad(@RequestParam(name = "idUniversidad") int idUniversidad) throws ComentariosException {
        return ControladorComentarios.getInstance().leerComentariosUniversidad(idUniversidad);
    }

    @RequestMapping("/getComentariosByCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<ComentarioVO> leerComentariosCarrera(@RequestParam(name = "idUniversidad") int idUniversidad,
                                                     @RequestParam(name = "idCarrera") int idCarrera) throws ComentariosException, UniversidadException, CarreraException {
        return ControladorComentarios.getInstance().leerComentariosCarrera(idUniversidad, idCarrera);
    }

    @RequestMapping("/getPendientesByUniversidad")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<ComentarioVO> getComentariosPendientesByUniversidad() throws ComentariosException {
        return ControladorComentarios.getInstance().getComentariosPendientesByUniversidades();
    }

    @RequestMapping("/getPendientesByCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<ComentarioVO> getComentariosPendientesByCarrera() throws ComentariosException {
        return ControladorComentarios.getInstance().getComentariosPendientesByCarreras();
    }

    @RequestMapping("/aprobarComentario")
    @CrossOrigin(origins="http://localhost:3000/")
    public void aprobarComentario(@RequestParam(name = "idComentario") int idComentario) throws ComentariosException {
        ControladorComentarios.getInstance().aprobarComentario(idComentario);
    }

}
