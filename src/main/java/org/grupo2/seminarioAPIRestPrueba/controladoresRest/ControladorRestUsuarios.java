package org.grupo2.seminarioAPIRestPrueba.controladoresRest;

import org.grupo2.controladores.ControladorUsuarios;
import org.grupo2.exceptions.UsuarioException;
import org.grupo2.vo.UsuarioVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorRestUsuarios {

    @PostMapping("/crearUsuario")
    public void crearUsuario(@RequestParam(name = "alias") String alias,
                             @RequestParam(name = "rol") String rol) throws UsuarioException {
        ControladorUsuarios.getInstance().crearUsuario(alias, rol);
    }

    @PostMapping("/setRol")
    public void setRol(@RequestParam(name = "alias") String alias,
                       @RequestParam(name = "rol") String rol) throws UsuarioException {
        ControladorUsuarios.getInstance().setRol(alias, rol);
    }

    @RequestMapping("/getUsuarioById")
    public UsuarioVO getUsuarioById(@RequestParam(name = "idUsuario") int idUser) throws UsuarioException {
        return ControladorUsuarios.getInstance().getUsuarioById(idUser);
    }

    @RequestMapping("/getUsuarioByAlias")
    public UsuarioVO getUsuarioByAlias(@RequestParam(name = "alias") String alias) throws UsuarioException {
        return ControladorUsuarios.getInstance().getUsuarioByAlias(alias);
    }

    @RequestMapping("/getAllUsuarios")
    public List<UsuarioVO> getAllUsuarios() throws UsuarioException {
        return ControladorUsuarios.getInstance().getAllUsuario();
    }

    @RequestMapping("/getUsuariosByRol")
    public List<UsuarioVO> getUsuariosByRol(@RequestParam(name = "rol") String rol) throws UsuarioException {
        return ControladorUsuarios.getInstance().getUsuariosByRol(rol);
    }


}
