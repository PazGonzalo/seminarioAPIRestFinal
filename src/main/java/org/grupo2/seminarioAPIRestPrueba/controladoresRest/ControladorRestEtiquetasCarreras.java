package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorEtiquetasCarreras;
import org.grupo2.exceptions.CarreraException;
import org.grupo2.exceptions.EtiquetaCarreraException;
import org.grupo2.exceptions.EtiquetaException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRestEtiquetasCarreras {

    //TODO ESTA CLASE NO CREO QUE SEA NECESARIA, DADO QUE ETIQUETASCARRERAS ES UNA CLASE UTILIZADA SOLO POR EL BACK-END.
    @PostMapping("/crearEtiquetaCarrera")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearEtiquetaCarrera(@RequestParam(name = "idCarrera") int idCarrera,
                                     @RequestParam(name = "peso") int peso,
                                     @RequestParam(name = "idEtiqueta") int idEtiqueta) throws EtiquetaCarreraException, CarreraException, EtiquetaException {
        ControladorEtiquetasCarreras.getInstance().crearEtiquetasCarreras(idCarrera,idEtiqueta,peso);
    }

}
