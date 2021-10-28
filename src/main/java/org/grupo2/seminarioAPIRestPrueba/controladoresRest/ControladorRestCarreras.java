package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorCarreras;
import org.grupo2.controladores.ControladorUniversidades;
import org.grupo2.exceptions.*;
import org.grupo2.modelo.Carrera;
import org.grupo2.modelo.Etiqueta;
import org.grupo2.vo.CarreraVO;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ControladorRestCarreras {

    @PostMapping("/crearCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearCarrera(@RequestParam(name = "idUniversidad") int idUniversidad,
                             @RequestParam(name = "nombreCarrera") String nombre,
                             @RequestParam(name = "descripcionCarrera") String descripcion,
                             @RequestParam(name = "duracionCarrera") int duracion,
                             @RequestParam(name = "perfilProfesional") String perfil) throws UniversidadException, CarreraException {
        ControladorCarreras.getInstance().crearCarrera(idUniversidad, nombre, descripcion, perfil,duracion);
    }

    @PostMapping("/agregarPlanEstudios")
    @CrossOrigin(origins="http://localhost:3000/")
    public void agregarPlanEstudios(@RequestParam(name = "idCarrera") int idCarrera,
                                    @RequestParam(name = "codigoPlan") String codigo,
                                    @RequestParam(name = "descripcionPlan") String descripcion) throws CarreraException, PlanEstudioException {
        ControladorCarreras.getInstance().addPlanEstudios(idCarrera, codigo, descripcion);
    }

    @PostMapping("/cambiarPlanEstudios")
    @CrossOrigin(origins="http://localhost:3000/")
    public void cambiarPlanEstudios(@RequestParam(name = "idCarrera") int idCarrera,
                                    @RequestParam(name = "idPlanEstudios") int idPlanEstudios) throws CarreraException, PlanEstudioException {
        ControladorCarreras.getInstance().modificarPlanEstudio(idCarrera, idPlanEstudios);
    }

    @PostMapping("/modificarNombre")
    @CrossOrigin(origins="http://localhost:3000/")
    public void modificarNombre(@RequestParam(name = "idCarrera") int idCarrera,
                                @RequestParam(name = "nuevoNombre") String nombre) throws CarreraException {
        ControladorCarreras.getInstance().setNombre(idCarrera, nombre);
    }


    @PostMapping("/modificarDescripcion")
    @CrossOrigin(origins="http://localhost:3000/")
    public void modificarDescripcion(@RequestParam(name = "idCarrera") int idCarrera,
                                     @RequestParam(name = "descripcion") String descripcion) throws CarreraException {
        ControladorCarreras.getInstance().setDescripcion(idCarrera, descripcion);
    }

    @PostMapping("/agregarPerfilProfesional")
    @CrossOrigin(origins="http://localhost:3000/")
    public void agregarPerfilProfesional(@RequestParam(name = "idCarrera") int idCarrera,
                                         @RequestParam(name = "perfil") String perfil) throws CarreraException {
        ControladorCarreras.getInstance().setProfessionalProfile(idCarrera, perfil);
    }

    @PostMapping("/addIdComun")
    @CrossOrigin(origins="http://localhost:3000/")
    public void agregarIdComun(@RequestParam(name = "idCarrera") int idCarrera,
                               @RequestParam(name = "idGlobal") int idGlobal) throws CarreraException {
        ControladorCarreras.getInstance().setIdCarreraGlobal(idCarrera, idGlobal);
    }

    @PostMapping("/addPuntuacion")
    @CrossOrigin(origins="http://localhost:3000/")
    public void agregarPuntuacion(@RequestParam(name = "idCarrera") int idCarrera,
                                  @RequestParam(name = "puntuacion") int puntuacion) throws CarreraException {
        ControladorCarreras.getInstance().agregarPuntuacion(idCarrera, puntuacion);
    }

    @RequestMapping("/getCarreraById")
    @CrossOrigin(origins="http://localhost:3000/")
    public CarreraVO getCarreraById(@RequestParam(name = "idCarrera") int idCarrera) throws CarreraException {
        return ControladorCarreras.getInstance().getCarreraById(idCarrera);
    }

    @RequestMapping("/getAllCarrerasSinRepeticion")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<CarreraVO> getAllCarrerasSinRepeticion() throws CarreraException{
        return ControladorCarreras.getInstance().getAllCarrerasSinRepeticion();
    }

    @RequestMapping("/getAllCarreras")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<CarreraVO> getAllCarreras() throws CarreraException {
        return ControladorCarreras.getInstance().getAllCarreras();
    }

    @RequestMapping("/getCarrerasByUniversidad")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<CarreraVO> getCarrerasByUniversidad(@RequestParam(name = "idUniversidad") int idUniversidad) throws CarreraException {
        return ControladorCarreras.getInstance().getCarrerasByUniversidad(idUniversidad);
    }

    @RequestMapping("/getAllCarrerasByNombre")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<CarreraVO> getCarrerasByNombre(@RequestParam(name = "nombreCarrera") String nombre) throws CarreraException {
        return ControladorCarreras.getInstance().getAllCarreraByNombre(nombre);
    }

    @RequestMapping("/getCarreraByUniversidadAndNombre")
    @CrossOrigin(origins="http://localhost:3000/")
    public CarreraVO getCarreraByUniversidad(@RequestParam(name = "nombreCarrera") String nombre,
                                             @RequestParam(name = "idUniversidad") int idUniversidad) throws CarreraException, UniversidadException {
        return ControladorCarreras.getInstance().getCarreraByNombreAndUniversidad(nombre, idUniversidad);
    }

    @RequestMapping("/getCarrerasByPuntuacion")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<CarreraVO> getCarrerasByPuntuacion(@RequestParam(name = "puntuacion") int puntuacion) throws CarreraException {
        return ControladorCarreras.getInstance().getCarrerasByPuntuacion(puntuacion);
    }

    @RequestMapping("/getCarrerasByUniversidadAndPuntuacion")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<CarreraVO> getCarrerasByUniversidadAndPuntuacion(@RequestParam(name = "idUniversidad") int idUniversidad,
                                                                 @RequestParam(name = "puntuacion") int puntuacion) throws CarreraException {
        return ControladorCarreras.getInstance().getCarrerasByUniversidadAndPuntuacion(idUniversidad, puntuacion);
    }

    @RequestMapping("/getCarrerasByIdComun")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<CarreraVO> getCarrerasByIdComun(@RequestParam(name = "idComun") int idComun) throws CarreraException {
        return ControladorCarreras.getInstance().getCarrerasByIdComun(idComun);
    }

    @RequestMapping("/getCarreraByUniversidadAndIdGlobal")
    @CrossOrigin(origins="http://localhost:3000/")
    public CarreraVO getCarreraByUniversidadAndIdGlobal(@RequestParam(name = "idUniversidad") int idUniversidad, @RequestParam(name = "idGlobal")int idGlobal) throws CarreraException, UniversidadException {
        return ControladorCarreras.getInstance().getCarreraByUniversidadAndIdCareerGlobal(idUniversidad,idGlobal);
    }

    @PostMapping("/actualizarPuntuacionCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public void actualizarPuntuacionCarrera(@RequestParam(name = "idCareer") int idCareer) throws PuntuacionesException, CarreraException {
        ControladorCarreras.getInstance().setPuntuacion(idCareer);
    }
    @RequestMapping("/getCarrerasByEtiquetas")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<CarreraVO> obtenerPuntuacionCarrera(@RequestParam(name="etiquetas")String etiquetas) throws EtiquetaCarreraException, CarreraException, EtiquetaException {
        return ControladorCarreras.getInstance().obtenerCarrerasPorEtiquetas(etiquetas);
    }

    @RequestMapping("/getCarrerasByString")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<CarreraVO> obtenerCarrerasByString(@RequestParam(name="carreras")String carreras,@RequestParam(name = "idGlobal")int idGlobal) throws CarreraException {
        return ControladorCarreras.getInstance().obtenerCarrerasByString(carreras,idGlobal);
    }

}
