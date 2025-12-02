package pe.edu.upc.t_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.t_finanzas.dtos.BonosDTO;
import pe.edu.upc.t_finanzas.entities.Bonos;
import pe.edu.upc.t_finanzas.serviceinterfaces.IBonosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bonos")
public class BonosController {
    @Autowired
    private IBonosService bS;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<BonosDTO> listar() {
        return bS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, BonosDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody BonosDTO dto) {
        ModelMapper m = new ModelMapper();
        Bonos l = m.map(dto, Bonos.class);
        bS.insert(l);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public BonosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        BonosDTO dto = m.map(bS.listId(id), BonosDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody BonosDTO dto) {
        ModelMapper m = new ModelMapper();
        Bonos l = m.map(dto, Bonos.class);
        bS.update(l);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        bS.delete(id);
    }
}
