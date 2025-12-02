package pe.edu.upc.t_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.t_finanzas.dtos.InmueblesDTO;
import pe.edu.upc.t_finanzas.entities.Inmuebles;
import pe.edu.upc.t_finanzas.serviceinterfaces.IInmueblesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inmuebles")
public class InmueblesController {
    @Autowired
    private IInmueblesService iS;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    @GetMapping
    public List<InmueblesDTO> listar() {
        return iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, InmueblesDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody InmueblesDTO dto) {
        ModelMapper m = new ModelMapper();
        Inmuebles l = m.map(dto, Inmuebles.class);
        iS.insert(l);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public InmueblesDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        InmueblesDTO dto = m.map(iS.listId(id), InmueblesDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody InmueblesDTO dto) {
        ModelMapper m = new ModelMapper();
        Inmuebles l = m.map(dto, Inmuebles.class);
        iS.update(l);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        iS.delete(id);
    }

    @GetMapping("/precioprom")
    public  double PrecioProm (){
        return iS.PrecioProm();
    }
}
