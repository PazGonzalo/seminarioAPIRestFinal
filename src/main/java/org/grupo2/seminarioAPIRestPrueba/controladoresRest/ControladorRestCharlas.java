package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorCharlas;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.CharlaException;
import org.grupo2.vo.CharlaVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ControladorRestCharlas {

    @PostMapping("/crearCharla")
    @CrossOrigin(origins = "http://localhost:3000/")
    public void crearCharlaInformativa(@RequestParam(name = "nombre") String nombre,
                                       @RequestParam(name = "descripcion") String descripcion,
                                       @RequestParam(name = "fecha") String fecha,
                                       @RequestParam(name = "hora") String hora,
                                       @RequestParam(name = "idCarrera") int idCarrera) throws CarreraException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaFinal = LocalDate.parse(fecha, formatter);
        ControladorCharlas.getInstancia().crearCharla(nombre,descripcion,fechaFinal,hora,idCarrera);
    }

    @RequestMapping("/getAllCharlas")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<CharlaVO> getAllCharlas() throws CharlaException {
        return ControladorCharlas.getInstancia().getAllCharlas();
    }

    @RequestMapping("/getCharlaById")
    @CrossOrigin(origins = "http://localhost:3000/")
    public CharlaVO getCharlaById(@RequestParam(name = "idCharla") int idCharla) throws CharlaException {
        return ControladorCharlas.getInstancia().getCharlaById(idCharla);
    }

    @RequestMapping("/getCharlasByCarrera")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<CharlaVO> getCharlasByCarrera(@RequestParam(name = "idCarrera") int idCarrera) throws CharlaException {
        return ControladorCharlas.getInstancia().getCharlasByCarrera(idCarrera);
    }

}
