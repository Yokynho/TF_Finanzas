package pe.edu.upc.t_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.t_finanzas.dtos.IndicadoresFinancierosDTO;
import pe.edu.upc.t_finanzas.entities.IndicadoresFinancieros;
import pe.edu.upc.t_finanzas.serviceinterfaces.IIndicadoresFinancierosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/indicadores")
public class IndicadoresFinancierosController {
    @Autowired
    private IIndicadoresFinancierosService iS;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<IndicadoresFinancierosDTO> listar() {
        return iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IndicadoresFinancierosDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody IndicadoresFinancierosDTO dto) {
        ModelMapper m = new ModelMapper();
        IndicadoresFinancieros l = m.map(dto, IndicadoresFinancieros.class);
        iS.insert(l);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public IndicadoresFinancierosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        IndicadoresFinancierosDTO dto = m.map(iS.listId(id), IndicadoresFinancierosDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody IndicadoresFinancierosDTO dto) {
        ModelMapper m = new ModelMapper();
        IndicadoresFinancieros l = m.map(dto, IndicadoresFinancieros.class);
        iS.update(l);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        iS.delete(id);
    }
}
