package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorMaterias;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.MateriaException;
import org.grupo2.exceptions.PlanEstudioException;
import org.grupo2.vo.MateriaVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestMaterias {

    @PostMapping("/crearMateria")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearMateria(@RequestParam(name = "nombre") String nombre,
                             @RequestParam(name = "descripcion") String descripcion,
                             @RequestParam(name = "cargaHoraria") int cargaHoraria,
                             @RequestParam(name = "año") int año,
                             @RequestParam(name = "idPlanEstudios") int idPlan) throws MateriaException, CarreraException, PlanEstudioException {
        ControladorMaterias.getInstance().crearMateria(nombre, descripcion, cargaHoraria, idPlan,año);
    }

    @PostMapping("/actualizarNombre")
    @CrossOrigin(origins="http://localhost:3000/")
    public void updateNombre(@RequestParam(name = "nombre") String nombre,
                             @RequestParam(name = "idMateria") int id) throws MateriaException {
        ControladorMaterias.getInstance().actualizarNombre(nombre, id);
    }

    @PostMapping("/actualizarDescripcion")
    @CrossOrigin(origins="http://localhost:3000/")
    public void actualizarDescripcion(@RequestParam(name = "descripcion") String descripcion,
                                      @RequestParam(name = "idMateria") int id) throws MateriaException {
        ControladorMaterias.getInstance().actualizarDescripcion(descripcion, id);
    }

    @PostMapping("/actualizarCargaHoraria")
    @CrossOrigin(origins="http://localhost:3000/")
    public void actualizarCargaHoraria(@RequestParam(name = "cargaHoraria") int cargaHoraria,
                                       @RequestParam(name = "idMateria") int id) throws MateriaException {
        ControladorMaterias.getInstance().actualizarCargaHoraria(cargaHoraria, id);
    }

    @RequestMapping("/getMateriaByID")
    @CrossOrigin(origins="http://localhost:3000/")
    public MateriaVO getMateriaById(@RequestParam(name = "idMateria") int idMateria) throws MateriaException {
        return ControladorMaterias.getInstance().getMateriaById(idMateria);
    }

    @RequestMapping("/getMateriasByCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<MateriaVO> getMateriasByCarrera(@RequestParam(name = "idCarrera") int idCarrera) throws MateriaException, CarreraException, PlanEstudioException {
        return ControladorMaterias.getInstance().getMateriasByCarrera(idCarrera);
    }

    @RequestMapping("/getMateriasByPlan")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<MateriaVO> getMateriasByPlanEstudios(@RequestParam(name = "idPlanEstudios") int idPlan) throws MateriaException, PlanEstudioException {
        return ControladorMaterias.getInstance().getMateriasByPlan(idPlan);
    }

    @RequestMapping("/getMateriasByNombre")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<MateriaVO> getMateriasByNombre(@RequestParam(name = "nombreMateria") String nombre) throws MateriaException {
        return ControladorMaterias.getInstance().getMateriaByNombre(nombre);
    }


}
