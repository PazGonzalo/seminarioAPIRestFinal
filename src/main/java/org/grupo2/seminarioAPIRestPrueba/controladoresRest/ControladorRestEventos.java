package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorEventos;
import org.grupo2.exceptions.EventoException;
import org.grupo2.exceptions.UniversidadException;
import org.grupo2.vo.EventoVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ControladorRestEventos {

    @PostMapping("/crearEvento")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearEvento(@RequestParam(name = "nombre") String nombre,
                            @RequestParam(name = "descripcion") String descripcion,
                            @RequestParam(name = "fecha") String fecha,
                            @RequestParam(name = "hora") String hora,
                            @RequestParam(name = "presentacion") String presentacion,
                            @RequestParam(name = "idUniversidad") int idUniversidad) throws UniversidadException, EventoException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaFinal = LocalDate.parse(fecha, formatter);
        ControladorEventos.getInstancia().crearEvento(nombre, descripcion, fechaFinal, hora, idUniversidad,presentacion);
    }

    @RequestMapping("/getAllEventos")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<EventoVO> getAllEventos() throws EventoException {
        return ControladorEventos.getInstancia().getAllEventos();
    }

    @RequestMapping("/getEventosByUniversidad")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<EventoVO> getEventosByUniversidad(@RequestParam(name = "idUniversidad") int idUniversidad) throws EventoException {
        return ControladorEventos.getInstancia().getEventosByUniversidad(idUniversidad);
    }

    @RequestMapping("/getEventoById")
    @CrossOrigin(origins="http://localhost:3000/")
    public EventoVO getEventoById(@RequestParam(name = "idEvento") int idEvento) throws EventoException {
        return ControladorEventos.getInstancia().getEventoById(idEvento);
    }

}
