package pe.edu.upc.t_finanzas.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.t_finanzas.entities.EntidadesFinancieras;
import pe.edu.upc.t_finanzas.repositories.IEntidadesFinancierasRepository;
import pe.edu.upc.t_finanzas.serviceinterfaces.IEntidadesFinancierasService;

import java.util.List;

@Service
public class EntidadesFinancierasServiceImplements implements IEntidadesFinancierasService {

    @Autowired
    private IEntidadesFinancierasRepository eR;

    @Override
    public List<EntidadesFinancieras> list() {
        return eR.findAll();
    }

    @Override
    public void insert(EntidadesFinancieras i) {
        if(i.getNombre_entidad().equalsIgnoreCase("Banco de Crédito del Perú") ||
                i.getNombre_entidad().equalsIgnoreCase("Interbank") ||
                i.getNombre_entidad().equalsIgnoreCase("Banco Pichincha") ||
                i.getNombre_entidad().equalsIgnoreCase("BanBif") ||
                i.getNombre_entidad().equalsIgnoreCase("BBVA Perú") ||
                i.getNombre_entidad().equalsIgnoreCase("Scotiabank") ||
                i.getNombre_entidad().equalsIgnoreCase("Banco GNB del Perú") ||
                i.getNombre_entidad().equalsIgnoreCase("Banco de Comercio") ){
            i.setTipo_entidad("Banca Múltiple");
        } else if (i.getNombre_entidad().equalsIgnoreCase("CMAC Huancayo") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Ica") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Cusco") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Trujillo") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Maynas") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Arequipa") ) {
            i.setTipo_entidad("Caja Municipal de Ahorro y Credito (CMAC)");
        } else if (i.getNombre_entidad().equalsIgnoreCase("Financiera Efectiva") ||
                i.getNombre_entidad().equalsIgnoreCase("Financiera CrediScotia") ||
                i.getNombre_entidad().equalsIgnoreCase("Vívela") ) {
            i.setTipo_entidad("Financiera");
        } else if (i.getNombre_entidad().equalsIgnoreCase("EDPYME miCasita")) {
            i.setTipo_entidad("EDPYME");
        } else if (i.getNombre_entidad().equalsIgnoreCase("CRAC Raíz")) {
            i.setTipo_entidad("Caja Rural de Ahorro y Credito (CRAC)");
        }

        if(i.getNombre_entidad().equalsIgnoreCase("Banco de Crédito del Perú")) {
            i.setTasa_base(9.43);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Interbank")) {
            i.setTasa_base(9.27);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Banco Pichincha")) {
            i.setTasa_base(9.72);
        } else if(i.getNombre_entidad().equalsIgnoreCase("BanBif")) {
            i.setTasa_base(9.62);
        } else if(i.getNombre_entidad().equalsIgnoreCase("BBVA Perú")) {
            i.setTasa_base(9.02);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Scotiabank")) {
            i.setTasa_base(8.98);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Banco GNB del Perú")) {
            i.setTasa_base(9.50); // valor de ejemplo
        } else if(i.getNombre_entidad().equalsIgnoreCase("Banco de Comercio")) {
            i.setTasa_base(10.27);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Huancayo")) {
            i.setTasa_base(12.98);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Ica")) {
            i.setTasa_base(10.89);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Cusco")) {
            i.setTasa_base(13.56);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Trujillo")) {
            i.setTasa_base(11.39);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Maynas")) {
            i.setTasa_base(14.50);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Arequipa")) {
            i.setTasa_base(11.41);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Financiera Efectiva")) {
            i.setTasa_base(9.44);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Financiera CrediScotia")) {
            i.setTasa_base(12.36);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Vívela")) {
            i.setTasa_base(10.81);
        } else if(i.getNombre_entidad().equalsIgnoreCase("EDPYME miCasita")) {
            i.setTasa_base(11.00); // valor de ejemplo
        } else if(i.getNombre_entidad().equalsIgnoreCase("CRAC Raíz")) {
            i.setTasa_base(12.00); // valor de ejemplo
        }

        eR.save(i);
    }

    @Override
    public EntidadesFinancieras listId(int id) {
        return eR.findById(id).orElse(new EntidadesFinancieras());
    }

    @Override
    public void update(EntidadesFinancieras i) {

        if(i.getNombre_entidad().equalsIgnoreCase("Banco de Crédito del Perú") ||
                i.getNombre_entidad().equalsIgnoreCase("Interbank") ||
                i.getNombre_entidad().equalsIgnoreCase("Banco Pichincha") ||
                i.getNombre_entidad().equalsIgnoreCase("BanBif") ||
                i.getNombre_entidad().equalsIgnoreCase("BBVA Perú") ||
                i.getNombre_entidad().equalsIgnoreCase("Scotiabank") ||
                i.getNombre_entidad().equalsIgnoreCase("Banco GNB del Perú") ||
                i.getNombre_entidad().equalsIgnoreCase("Banco de Comercio") ){
            i.setTipo_entidad("Banca Múltiple");
        } else if (i.getNombre_entidad().equalsIgnoreCase("CMAC Huancayo") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Ica") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Cusco") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Trujillo") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Maynas") ||
                i.getNombre_entidad().equalsIgnoreCase("CMAC Arequipa") ) {
            i.setTipo_entidad("Caja Municipal de Ahorro y Credito (CMAC)");
        } else if (i.getNombre_entidad().equalsIgnoreCase("Financiera Efectiva") ||
                i.getNombre_entidad().equalsIgnoreCase("Financiera CrediScotia") ||
                i.getNombre_entidad().equalsIgnoreCase("Vívela") ) {
            i.setTipo_entidad("Financiera");
        } else if (i.getNombre_entidad().equalsIgnoreCase("EDPYME miCasita")) {
            i.setTipo_entidad("EDPYME");
        } else if (i.getNombre_entidad().equalsIgnoreCase("CRAC Raíz")) {
            i.setTipo_entidad("Caja Rural de Ahorro y Credito (CRAC)");
        }

        if(i.getNombre_entidad().equalsIgnoreCase("Banco de Crédito del Perú")) {
            i.setTasa_base(9.43);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Interbank")) {
            i.setTasa_base(9.27);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Banco Pichincha")) {
            i.setTasa_base(9.72);
        } else if(i.getNombre_entidad().equalsIgnoreCase("BanBif")) {
            i.setTasa_base(9.62);
        } else if(i.getNombre_entidad().equalsIgnoreCase("BBVA Perú")) {
            i.setTasa_base(9.02);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Scotiabank")) {
            i.setTasa_base(8.98);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Banco GNB del Perú")) {
            i.setTasa_base(9.50); // valor de ejemplo
        } else if(i.getNombre_entidad().equalsIgnoreCase("Banco de Comercio")) {
            i.setTasa_base(10.27);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Huancayo")) {
            i.setTasa_base(12.98);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Ica")) {
            i.setTasa_base(10.89);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Cusco")) {
            i.setTasa_base(13.56);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Trujillo")) {
            i.setTasa_base(11.39);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Maynas")) {
            i.setTasa_base(14.50);
        } else if(i.getNombre_entidad().equalsIgnoreCase("CMAC Arequipa")) {
            i.setTasa_base(11.41);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Financiera Efectiva")) {
            i.setTasa_base(9.44);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Financiera CrediScotia")) {
            i.setTasa_base(12.36);
        } else if(i.getNombre_entidad().equalsIgnoreCase("Vívela")) {
            i.setTasa_base(10.81);
        } else if(i.getNombre_entidad().equalsIgnoreCase("EDPYME miCasita")) {
            i.setTasa_base(11.00); // valor de ejemplo
        } else if(i.getNombre_entidad().equalsIgnoreCase("CRAC Raíz")) {
            i.setTasa_base(12.00); // valor de ejemplo
        }


        eR.save(i);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }
}
