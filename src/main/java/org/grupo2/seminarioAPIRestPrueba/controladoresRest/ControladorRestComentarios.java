package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorComentarios;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.ComentariosException;
import org.grupo2.exceptions.UniversidadException;
import org.grupo2.exceptions.UsuarioException;
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
                                       @RequestParam(name = "idCarrera") int idCarrera) throws UniversidadException, CarreraException, UsuarioException {
        ControladorComentarios.getInstance().crearComentarioCarrera(alias, idUniversidad, comentario, idCarrera);
    }

    @PostMapping("/crearComentarioUniversidad")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearComentarioUniversidad(@RequestParam(name = "alias") String alias,
                                           @RequestParam(name = "idUniversidad") int idUniversidad,
                                           @RequestParam(name = "comentario") String comentario) throws UniversidadException, CarreraException, UsuarioException {
        ControladorComentarios.getInstance().crearComentarioUniversidad(alias, idUniversidad, comentario);
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
}
