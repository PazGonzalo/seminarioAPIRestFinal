package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorPlanesEstudio;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.PlanEstudioException;
import org.grupo2.vo.PlanEstudioVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorRestPlanesEstudio {

    @PostMapping("/crearPlanEstudios")
    public void crearPlanEstudios(@RequestParam(name = "codigo") String codigo,
                                  @RequestParam(name = "descripcion") String descripcion,
                                  @RequestParam(name = "idCarrera") int idCarrera) throws CarreraException, PlanEstudioException {
        ControladorPlanesEstudio.getInstance().crearPlanEstudios(codigo, descripcion, idCarrera);
    }

    @RequestMapping("/getPlanesEstudioCarreras")
    public List<PlanEstudioVO> getPlanesEstudioCarreras(@RequestParam(name = "idCarreraA") int idCarreraA,
                                                        @RequestParam(name = "idCarreraB") int idCarreraB) throws PlanEstudioException {
        return ControladorPlanesEstudio.getInstance().getPlanesEstudioCarreras(idCarreraA, idCarreraB);
    }

    @RequestMapping("/getPlanesEstudio")
    public List<PlanEstudioVO> getAllPlanEstudio() throws PlanEstudioException {
        return ControladorPlanesEstudio.getInstance().getAllPlanEstudio();
    }

    @RequestMapping("/getPlanEstudioByCarrera")
    public PlanEstudioVO getPlanEstudioByCarreraAndUniversidad(@RequestParam(name = "idCarrera") int idCarrera) throws PlanEstudioException {
        return ControladorPlanesEstudio.getInstance().getPlanEstudioByCarrera(idCarrera);
    }

    @RequestMapping("/getPlanEstudioByCodigo")
    public PlanEstudioVO getPlanEstudioByCodigo(@RequestParam(name = "codigo") String codigo) throws PlanEstudioException {
        return ControladorPlanesEstudio.getInstance().getPlanEstudioByCodigo(codigo);
    }

}
