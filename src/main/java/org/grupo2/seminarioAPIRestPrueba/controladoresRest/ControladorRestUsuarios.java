package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorUsuarios;
import org.grupo2.exceptions.UsuarioException;
import org.grupo2.vo.UsuarioVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestUsuarios {

    @PostMapping("/crearUsuario")
    @CrossOrigin(origins="http://localhost:3000/")
    public void crearUsuario(@RequestParam(name = "alias") String alias,
                             @RequestParam(name = "rol") String rol) throws UsuarioException {
        ControladorUsuarios.getInstance().crearUsuario(alias, rol);
    }

    @PostMapping("/setRol")
    @CrossOrigin(origins="http://localhost:3000/")
    public void setRol(@RequestParam(name = "alias") String alias,
                       @RequestParam(name = "rol") String rol) throws UsuarioException {
        ControladorUsuarios.getInstance().setRol(alias, rol);
    }

    @RequestMapping("/getUsuarioById")
    @CrossOrigin(origins="http://localhost:3000/")
    public UsuarioVO getUsuarioById(@RequestParam(name = "idUsuario") int idUser) throws UsuarioException {
        return ControladorUsuarios.getInstance().getUsuarioById(idUser);
    }

    @RequestMapping("/getUsuarioByAlias")
    @CrossOrigin(origins="http://localhost:3000/")
    public UsuarioVO getUsuarioByAlias(@RequestParam(name = "alias") String alias) throws UsuarioException {
        return ControladorUsuarios.getInstance().getUsuarioByAlias(alias);
    }

    @RequestMapping("/getAllUsuarios")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<UsuarioVO> getAllUsuarios() throws UsuarioException {
        return ControladorUsuarios.getInstance().getAllUsuario();
    }

    @RequestMapping("/getUsuariosByRol")
    @CrossOrigin(origins="http://localhost:3000/")
    public List<UsuarioVO> getUsuariosByRol(@RequestParam(name = "rol") String rol) throws UsuarioException {
        return ControladorUsuarios.getInstance().getUsuariosByRol(rol);
    }
}

