package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorUniversidades;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.UniversidadException;
import org.grupo2.vo.UniversidadVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ControladorRestUniversidades {

    @PostMapping("/crearUniversidad")
    public void crearUniversidad(@RequestParam(name = "nombre") String nombre,
                                 @RequestParam(name = "descripcion") String descripcion,
                                 @RequestParam(name = "zona") String zona) throws UniversidadException {
        ControladorUniversidades.getInstance().crearUniversidad(nombre, descripcion, zona);
    }

    @PostMapping("/actualizarUniversidad")
    public void actualizarUniversidad(@RequestParam(name = "nombre") String nombre,
                                      @RequestParam(name = "descripcion") String descripcion,
                                      @RequestParam(name = "zona") String zona) throws UniversidadException {
        ControladorUniversidades.getInstance().actualizarUniversidad(nombre, descripcion, zona);
    }

    @PostMapping("/actualizarPuntuacion")
    public void actualizarPuntuacion(@RequestParam(name = "idUniversidad") int idUniversidad,
                                     @RequestParam(name = "puntuacion") int puntuacion) throws UniversidadException {
        ControladorUniversidades.getInstance().actualizarPuntuacion(puntuacion, idUniversidad);
    }

    @RequestMapping("/getUniversidades")
    public List<UniversidadVO> getUniversidades() throws UniversidadException {
        return ControladorUniversidades.getInstance().getAllUniversidades();
    }

    @RequestMapping("/getUniversidadByID")
    public UniversidadVO getUniversidadById(@RequestParam(name = "idUniversidad") int idUniversidad) throws UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadByID(idUniversidad);
    }

    @RequestMapping("/getUniversidadByNombre")
    public UniversidadVO getUniversidadByNombre(@RequestParam(name = "nombre") String nombre) throws UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadByNombre(nombre);
    }

    @RequestMapping("/getUniversidadesByUbicacion")
    public List<UniversidadVO> getUniversidadesByZona(@RequestParam(name = "zona") String zona) throws UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadesByUbicacion(zona);
    }

    //FIXME DEVUELVE UNIVERSIDADES REPETIDAS, HABRIA QUE TOMAR EL CONCEPTO DE CONJUNTOS PARA QUE NO SE REPITA
    @RequestMapping("/getUniversidadesByCarrera")
    public Set<UniversidadVO> getUniversidadesByCarrera(@RequestParam(name = "idCarrera") int idCarrera) throws CarreraException {
        return ControladorUniversidades.getInstance().getUniversidadesByCarrera(idCarrera);
    }

}
