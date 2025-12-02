package pe.edu.upc.t_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.t_finanzas.dtos.UsuariosDTO;
import pe.edu.upc.t_finanzas.entities.Usuarios;
import pe.edu.upc.t_finanzas.serviceinterfaces.IUsuariosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private IUsuariosService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    @PreAuthorize("hasAuthority('USUARIO') or hasAuthority('ADMIN')")
    public List<UsuariosDTO> listar() {
        return uS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,UsuariosDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody UsuariosDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuarios u = modelMapper.map(dto, Usuarios.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }
    @PreAuthorize("hasAuthority('USUARIO') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public UsuariosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuariosDTO dto = m.map(uS.listId(id), UsuariosDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    @PutMapping
    public void modificar(@RequestBody UsuariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuarios u = m.map(dto, Usuarios.class);
        uS.update(u);
    }
    @PreAuthorize("hasAuthority('USUARIO') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.delete(id);
    }

    @PreAuthorize("hasAuthority('USUARIO') or hasAuthority('ADMIN')")
    @GetMapping("/obtenerid")
    public int obtenerIdPorUsername(@RequestParam String username) {
        return uS.obtenerId(username);
    }

    @PreAuthorize("hasAuthority('USUARIO') or hasAuthority('ADMIN')")
    @GetMapping("/misusuarios")
    public List<UsuariosDTO> listarUsuariosPorUsuario(@RequestParam("username")String username) {
        List<Usuarios> rastreos = uS.obtenerUsuariosPorUsername(username);
        ModelMapper m = new ModelMapper();
        return rastreos.stream().map(rastreo->m.map(rastreo, UsuariosDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/totalusuarios")
    public  int TotalUsuarios (){
        return uS.TotalUsuarios();
    }
}
