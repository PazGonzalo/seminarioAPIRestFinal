package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorGalerias;
import org.grupo2.exceptions.GaleriaException;
import org.grupo2.exceptions.UniversidadException;
import org.grupo2.modelo.Galeria;
import org.grupo2.vo.GaleriaVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestGalerias {

    @PostMapping("/crearFoto")
    @CrossOrigin(origins = "http://localhost:3000/")
    public void crearFoto(@RequestParam(name = "nombre") String nombre,
                          @RequestParam(name = "archivo") String archivo,
                          @RequestParam(name = "idUniversidad") int idUniversidad) throws GaleriaException, UniversidadException {
        ControladorGalerias.getInstance().crearFotoUniversidad(nombre,archivo,idUniversidad);
    }
    @RequestMapping("/obtenerFotosPorUniversidad")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<GaleriaVO> obtenerFotosPorUniversidad(int idUniversidad) throws GaleriaException {
        return ControladorGalerias.getInstance().obtenerFotosPorUniversidad(idUniversidad);
    }

}
