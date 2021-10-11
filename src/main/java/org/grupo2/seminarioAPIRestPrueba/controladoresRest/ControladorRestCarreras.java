package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorCarreras;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.PlanEstudioException;
import org.grupo2.exceptions.UniversidadException;
import org.grupo2.vo.CarreraVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorRestCarreras {

    @PostMapping("/crearCarrera")
    public void crearCarrera(@RequestParam(name = "idUniversidad") int idUniversidad,
                             @RequestParam(name = "nombreCarrera") String nombre,
                             @RequestParam(name = "descripcionCarrera") String descripcion,
                             @RequestParam(name = "perfilProfesional") String perfil) throws UniversidadException, CarreraException {
        ControladorCarreras.getInstance().crearCarrera(idUniversidad, nombre, descripcion, perfil);
    }

    @PostMapping("/agregarPlanEstudios")
    public void agregarPlanEstudios(@RequestParam(name = "idCarrera") int idCarrera,
                                    @RequestParam(name = "codigoPlan") String codigo,
                                    @RequestParam(name = "descripcionPlan") String descripcion) throws CarreraException, PlanEstudioException {
        ControladorCarreras.getInstance().addPlanEstudios(idCarrera, codigo, descripcion);
    }

    @PostMapping("/cambiarPlanEstudios")
    public void cambiarPlanEstudios(@RequestParam(name = "idCarrera") int idCarrera,
                                    @RequestParam(name = "idPlanEstudios") int idPlanEstudios) throws CarreraException, PlanEstudioException {
        ControladorCarreras.getInstance().modificarPlanEstudio(idCarrera, idPlanEstudios);
    }

    @PostMapping("/modificarNombre")
    public void modificarNombre(@RequestParam(name = "idCarrera") int idCarrera,
                                @RequestParam(name = "nuevoNombre") String nombre) throws CarreraException {
        ControladorCarreras.getInstance().setNombre(idCarrera, nombre);
    }

    @PostMapping("/modificarDescripcion")
    public void modificarDescripcion(@RequestParam(name = "idCarrera") int idCarrera,
                                     @RequestParam(name = "descripcion") String descripcion) throws CarreraException {
        ControladorCarreras.getInstance().setDescripcion(idCarrera, descripcion);
    }

    @PostMapping("/agregarPerfilProfesional")
    public void agregarPerfilProfesional(@RequestParam(name = "idCarrera") int idCarrera,
                                         @RequestParam(name = "perfil") String perfil) throws CarreraException {
        ControladorCarreras.getInstance().setProfessionalProfile(idCarrera, perfil);
    }

    @PostMapping("/addIdComun")
    public void agregarIdComun(@RequestParam(name = "idCarrera") int idCarrera,
                               @RequestParam(name = "idGlobal") int idGlobal) throws CarreraException {
        ControladorCarreras.getInstance().setIdCarreraGlobal(idCarrera, idGlobal);
    }

    @PostMapping("/addPuntuacion")
    public void agregarPuntuacion(@RequestParam(name = "idCarrera") int idCarrera,
                                  @RequestParam(name = "puntuacion") int puntuacion) throws CarreraException {
        ControladorCarreras.getInstance().agregarPuntuacion(idCarrera, puntuacion);
    }

    @RequestMapping("/getCarreraById")
    public CarreraVO getCarreraById(@RequestParam(name = "idCarrera") int idCarrera) throws CarreraException {
        return ControladorCarreras.getInstance().getCarreraById(idCarrera);
    }

    @RequestMapping("/getAllCarreras")
    public List<CarreraVO> getAllCarreras() throws CarreraException {
        return ControladorCarreras.getInstance().getAllCarreras();
    }

    @RequestMapping("/getCarrerasByUniversidad")
    public List<CarreraVO> getCarrerasByUniversidad(@RequestParam(name = "idUniversidad") int idUniversidad) throws CarreraException {
        return ControladorCarreras.getInstance().getCarrerasByUniversidad(idUniversidad);
    }

    @RequestMapping("/getAllCarrerasByNombre")
    public List<CarreraVO> getCarrerasByNombre(@RequestParam(name = "nombreCarrera") String nombre) throws CarreraException {
        return ControladorCarreras.getInstance().getAllCarreraByNombre(nombre);
    }

    @RequestMapping("/getCarreraByUniversidadAndNombre")
    public CarreraVO getCarreraByUniversidad(@RequestParam(name = "nombreCarrera") String nombre,
                                             @RequestParam(name = "idUniversidad") int idUniversidad) throws CarreraException, UniversidadException {
        return ControladorCarreras.getInstance().getCarreraByNombreAndUniversidad(nombre, idUniversidad);
    }

    @RequestMapping("/getCarrerasByPuntuacion")
    public List<CarreraVO> getCarrerasByPuntuacion(@RequestParam(name = "puntuacion") int puntuacion) throws CarreraException {
        return ControladorCarreras.getInstance().getCarrerasByPuntuacion(puntuacion);
    }

    @RequestMapping("/getCarrerasByUniversidadAndPuntuacion")
    public List<CarreraVO> getCarrerasByUniversidadAndPuntuacion(@RequestParam(name = "idUniversidad") int idUniversidad,
                                                                 @RequestParam(name = "puntuacion") int puntuacion) throws CarreraException {
        return ControladorCarreras.getInstance().getCarrerasByUniversidadAndPuntuacion(idUniversidad, puntuacion);
    }

    @RequestMapping("/getCarrerasByIdComun")
    public List<CarreraVO> getCarrerasByIdComun(@RequestParam(name = "idComun") int idComun) throws CarreraException {
        return ControladorCarreras.getInstance().getCarrerasByIdComun(idComun);
    }


}
