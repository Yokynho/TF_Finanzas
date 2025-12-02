package pe.edu.upc.t_finanzas.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.t_finanzas.entities.Cuotas;

import java.util.List;

public interface ICuotasService {
    public List<Cuotas> list();
    public  void insert(Cuotas c);
    public Cuotas listId(int id);
    public void update(Cuotas c);
    public void  delete(int id);

    public double calcularSaldoInicial (@Param("monto_financiar") double monto_financiar, @Param("cuota_inicial") double cuota_inicial);
    public double calcularTasaEfectivaMensual (@Param("valor_taza") double valor_taza);


    public List<Cuotas> generarTablaAmortizacion(
            @Param("monto_financiar") double monto_financiar,
            @Param("cuota_inicial") double cuota_inicial,
            @Param("valor_taza") double valor_taza,
            @Param("plazo") int plazo,
            @Param("tipo_periodo_gracia") String tipo_periodo_gracia,
            @Param("periodo_gracia") int periodo_gracia,
            @Param("nombre_entidad") String nombre_entidad,
            @Param("aplicaBonoIntegrador") Boolean aplicaBonoIntegrador,
            @Param("viviendaSostenible") Boolean viviendaSostenible,
            @Param("aplicaBonoTP") Boolean aplicaBonoTP,
            @Param("tipoVivienda") String tipoVivienda
    );
}
