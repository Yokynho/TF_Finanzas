package pe.edu.upc.t_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.t_finanzas.dtos.CuotasDTO;
import pe.edu.upc.t_finanzas.entities.Cuotas;
import pe.edu.upc.t_finanzas.serviceinterfaces.ICuotasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuotas")
public class CuotasController {
    @Autowired
    private ICuotasService cS;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<CuotasDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CuotasDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody CuotasDTO dto) {
        ModelMapper m = new ModelMapper();
        Cuotas l = m.map(dto, Cuotas.class);
        cS.insert(l);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public CuotasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CuotasDTO dto = m.map(cS.listId(id), CuotasDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody CuotasDTO dto) {
        ModelMapper m = new ModelMapper();
        Cuotas l = m.map(dto, Cuotas.class);
        cS.update(l);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }


    @GetMapping("/saldo-inicial")
    public double calcularSaldoInicial(@RequestParam double monto_financiar, @RequestParam double cuota_inicial) {
        return cS.calcularSaldoInicial(monto_financiar, cuota_inicial);
    }

    @GetMapping("/tep")
    public double calcularTasaEfectivaMensual(@RequestParam double valor_taza) {
        return cS.calcularTasaEfectivaMensual(valor_taza);
    }

    @GetMapping("/tabla")
    public List<Cuotas> generarTablaAmortizacion(@RequestParam double monto_financiar,@RequestParam double cuota_inicial,@RequestParam double valor_taza,
                                                 @RequestParam int plazo,@RequestParam String tipo_periodo_gracia,@RequestParam int periodo_gracia,
                                                 @RequestParam String nombre_entidad,@RequestParam Boolean aplicaBonoIntegrador ,@RequestParam Boolean viviendaSostenible,
                                                 @RequestParam Boolean aplicaBonoTP, @RequestParam String tipoVivienda){
        return cS.generarTablaAmortizacion(monto_financiar,cuota_inicial,valor_taza, plazo, tipo_periodo_gracia,periodo_gracia,nombre_entidad, aplicaBonoIntegrador, viviendaSostenible, aplicaBonoTP, tipoVivienda);
    }
}
