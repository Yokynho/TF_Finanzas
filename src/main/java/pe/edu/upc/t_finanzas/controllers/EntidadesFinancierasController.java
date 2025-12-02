package pe.edu.upc.t_finanzas.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.t_finanzas.dtos.EntidadesFinancierasDTO;
import pe.edu.upc.t_finanzas.entities.EntidadesFinancieras;
import pe.edu.upc.t_finanzas.serviceinterfaces.IEntidadesFinancierasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entidades")
public class EntidadesFinancierasController {
    @Autowired
    private IEntidadesFinancierasService eS;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    @GetMapping
    public List<EntidadesFinancierasDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EntidadesFinancierasDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody EntidadesFinancierasDTO dto) {
        ModelMapper m = new ModelMapper();
        EntidadesFinancieras l = m.map(dto, EntidadesFinancieras.class);
        eS.insert(l);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public EntidadesFinancierasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EntidadesFinancierasDTO dto = m.map(eS.listId(id), EntidadesFinancierasDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody EntidadesFinancierasDTO dto) {
        ModelMapper m = new ModelMapper();
        EntidadesFinancieras l = m.map(dto, EntidadesFinancieras.class);
        eS.update(l);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        eS.delete(id);
    }
}
