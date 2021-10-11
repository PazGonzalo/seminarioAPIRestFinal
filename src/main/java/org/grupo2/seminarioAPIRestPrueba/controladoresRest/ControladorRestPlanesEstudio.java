package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorPlanesEstudio;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.PlanEstudioException;
import org.grupo2.vo.PlanEstudioVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestPlanesEstudio {

    @PostMapping("/crearPlanEstudios")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearPlanEstudios(@RequestParam(name = "codigo") String codigo,
                                  @RequestParam(name = "descripcion") String descripcion,
                                  @RequestParam(name = "idCarrera") int idCarrera) throws CarreraException, PlanEstudioException {
        ControladorPlanesEstudio.getInstance().crearPlanEstudios(codigo, descripcion, idCarrera);
    }

    @RequestMapping("/getPlanesEstudioCarreras")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<PlanEstudioVO> getPlanesEstudioCarreras(@RequestParam(name = "idCarreraA") int idCarreraA,
                                                        @RequestParam(name = "idCarreraB") int idCarreraB) throws PlanEstudioException {
        return ControladorPlanesEstudio.getInstance().getPlanesEstudioCarreras(idCarreraA, idCarreraB);
    }

    @RequestMapping("/getPlanesEstudio")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<PlanEstudioVO> getAllPlanEstudio() throws PlanEstudioException {
        return ControladorPlanesEstudio.getInstance().getAllPlanEstudio();
    }

    @RequestMapping("/getPlanEstudioByCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public PlanEstudioVO getPlanEstudioByCarreraAndUniversidad(@RequestParam(name = "idCarrera") int idCarrera) throws PlanEstudioException {
        return ControladorPlanesEstudio.getInstance().getPlanEstudioByCarrera(idCarrera);
    }

    @RequestMapping("/getPlanEstudioByCodigo")
    @CrossOrigin(origins="http://localhost:3000/")
    public PlanEstudioVO getPlanEstudioByCodigo(@RequestParam(name = "codigo") String codigo) throws PlanEstudioException {
        return ControladorPlanesEstudio.getInstance().getPlanEstudioByCodigo(codigo);
    }

}
