package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorUniversidades;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.PuntuacionesException;
import org.grupo2.exceptions.UniversidadException;
import org.grupo2.vo.UniversidadVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestUniversidades {

    @PostMapping("/crearUniversidad")
    @CrossOrigin(origins = "http://localhost:3000/")
    public void crearUniversidad(@RequestParam(name = "nombre") String nombre,
                                 @RequestParam(name = "descripcion") String descripcion,
                                 @RequestParam(name = "ubicacion") String ubicacion,
                                 @RequestParam(name = "provincia") String provincia,
                                 @RequestParam(name = "tipo") String tipo,
                                 @RequestParam(name = "localidad") String localidad) throws UniversidadException {
        ControladorUniversidades.getInstance().crearUniversidad(nombre, descripcion, ubicacion, provincia, localidad,tipo);
    }

    @PostMapping("/actualizarUniversidad")
    @CrossOrigin(origins = "http://localhost:3000/")
    public void actualizarUniversidad(@RequestParam(name = "nombre") String nombre,
                                      @RequestParam(name = "descripcion") String descripcion,
                                      @RequestParam(name = "zona") String zona) throws UniversidadException {
        ControladorUniversidades.getInstance().actualizarUniversidad(nombre, descripcion, zona);
    }

    @PostMapping("/actualizarPuntuacion")
    @CrossOrigin(origins = "http://localhost:3000/")
    public void actualizarPuntuacion(@RequestParam(name = "idUniversidad") int idUniversidad) throws UniversidadException, PuntuacionesException {
        ControladorUniversidades.getInstance().actualizarPuntuacion(idUniversidad);
    }

    @RequestMapping("/getUniversidades")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<UniversidadVO> getUniversidades() throws UniversidadException {
        return ControladorUniversidades.getInstance().getAllUniversidades();
    }

    @RequestMapping("/getUniversidadByID")
    @CrossOrigin(origins = "http://localhost:3000/")
    public UniversidadVO getUniversidadById(@RequestParam(name = "idUniversidad") int idUniversidad) throws UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadByID(idUniversidad);
    }

    @RequestMapping("/getUniversidadByNombre")
    @CrossOrigin(origins = "http://localhost:3000/")
    public UniversidadVO getUniversidadByNombre(@RequestParam(name = "nombre") String nombre) throws UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadByNombre(nombre);
    }

    @RequestMapping("/getUniversidadesByUbicacion")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<UniversidadVO> getUniversidadesByZona(@RequestParam(name = "zona") String zona) throws UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadesByUbicacion(zona);
    }

    @RequestMapping("/getUniversidadesByCarrera")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<UniversidadVO> getUniversidadesByCarrera(@RequestParam(name = "idCarrera") int idCarrera) throws CarreraException, UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadesByCarrera(idCarrera);
    }

    @PostMapping("/actualizarGallery")
    @CrossOrigin(origins = "http://localhost:3000/")
    public void actualizarGallery(@RequestParam(name = "idUniversidad") int idUniversidad, @RequestParam(name = "photo") String photo) throws UniversidadException {
        ControladorUniversidades.getInstance().actualizarGallery(idUniversidad, photo);
    }

    @RequestMapping("/getUniversidadesByString")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<UniversidadVO> getUniversidadesByString(@RequestParam(name = "universidades") String universidades) throws UniversidadException {
        return ControladorUniversidades.getInstance().UniversidadesByString(universidades);
    }

    @RequestMapping("/getUniversidadesByProvincia")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<UniversidadVO> getUniversidadesByProvincia(@RequestParam(name = "provincia") String provincia) throws UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadesByProvincia(provincia);
    }

    @RequestMapping("/getUniversidadesByProvinciaAndTipo")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<UniversidadVO> getUniversidadesByProvinciaAndTipo(@RequestParam(name = "provincia") String provincia,
                                                                  @RequestParam(name = "tipo") String tipo) throws UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadesByProvinciaAndTipo(provincia, tipo);
    }

    @RequestMapping("/getUniversidadesByCarreraAndTipo")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<UniversidadVO> getUniversidadesByCarreraAndTipo(@RequestParam(name = "idCarrera") int idCarrera,
                                                         @RequestParam(name = "tipo") String tipo) throws CarreraException, UniversidadException {
        return ControladorUniversidades.getInstance().getUniversidadesByCarreraAndTipo(idCarrera, tipo);
    }

}
