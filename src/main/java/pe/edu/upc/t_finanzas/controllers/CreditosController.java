package pe.edu.upc.t_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.t_finanzas.dtos.CreditosDTO;
import pe.edu.upc.t_finanzas.dtos.UsuariosDTO;
import pe.edu.upc.t_finanzas.entities.Creditos;
import pe.edu.upc.t_finanzas.entities.Usuarios;
import pe.edu.upc.t_finanzas.serviceinterfaces.ICreditosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/creditos")
public class CreditosController {
    @Autowired
    private ICreditosService cS;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    @GetMapping
    public List<CreditosDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CreditosDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    @PostMapping
    public void insertar(@RequestBody CreditosDTO dto) {
        ModelMapper m = new ModelMapper();
        Creditos l = m.map(dto, Creditos.class);
        cS.insert(l);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    @GetMapping("/{id}")
    public CreditosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CreditosDTO dto = m.map(cS.listId(id), CreditosDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    @PutMapping
    public void modificar(@RequestBody CreditosDTO dto) {
        ModelMapper m = new ModelMapper();
        Creditos l = m.map(dto, Creditos.class);
        cS.update(l);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @PreAuthorize("hasAuthority('USUARIO') or hasAuthority('ADMIN')")
    @GetMapping("/miscreditos")
    public List<CreditosDTO> listarCreditosPorUsuario(@RequestParam("username")String username) {
        List<Creditos> creditos = cS.obtenerCreditosPorUsername(username);
        ModelMapper m = new ModelMapper();
        return creditos.stream().map(credito->m.map(credito, CreditosDTO.class)).collect(Collectors.toList());
    }
}
