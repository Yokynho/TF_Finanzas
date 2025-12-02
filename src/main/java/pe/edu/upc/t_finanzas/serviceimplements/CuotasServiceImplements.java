package pe.edu.upc.t_finanzas.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.t_finanzas.entities.Cuotas;
import pe.edu.upc.t_finanzas.repositories.ICuotasRepository;
import pe.edu.upc.t_finanzas.serviceinterfaces.ICuotasService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CuotasServiceImplements implements ICuotasService {

    @Autowired
    private ICuotasRepository cR;

    @Override
    public List<Cuotas> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Cuotas c) {
        cR.save(c);
    }

    @Override
    public Cuotas listId(int id) {
        return cR.findById(id).orElse(new Cuotas());
    }

    @Override
    public void update(Cuotas c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public double calcularSaldoInicial(double monto_financiar, double cuota_inicial) {
        return monto_financiar * (1 - (cuota_inicial/100));
    }

    @Override
    public double calcularTasaEfectivaMensual(double valor_taza) {
        return (Math.pow((1+(valor_taza/100)), 12))-1;
    }

    public double redondear(double valor, int decimales) {
        double factor = Math.pow(10, decimales);
        return Math.round(valor * factor) / factor;
    }





    @Override
    public List<Cuotas> generarTablaAmortizacion(
            double monto_financiar,
            double cuota_inicial,
            double valor_taza, // TEA
            int plazo, // años
            String tipo_periodo_gracia,
            int periodo_gracia,
            String nombre_entidad,
            Boolean aplicaBonoIntegrador,
            Boolean viviendaSostenible,
            Boolean aplicaBonoTP,
            String tipoVivienda) {

        //Gastos/costes INICIALES
        double gastosNotariales = 0;
        double gastosRegistrales = 0;
        double tasacionInmueble = 0;
        double comisionEstudio = 0;
        double comisionActivacion = 0;
        double evaluacionLegal = 0;
        double portesEnvios = 0;

        // --- Gastos según entidad PERIODICOS ---
        double seguroDesgravamen = 0;
        double seguroContraRiesgo = 0;
        double comisionPeriodica = 0;
        double portes=0;
        double gastosAdmin=0;


        switch (nombre_entidad) {
            case "Banco de Crédito del Perú":
                seguroDesgravamen = 0.045 / 100;
                seguroContraRiesgo = ((0.40 / 100) * monto_financiar) / 12;
                gastosNotariales = 180;
                gastosRegistrales = 250;
                tasacionInmueble = 130;
                comisionEstudio = 90;
                comisionActivacion = 0;
                evaluacionLegal = 60;
                portesEnvios = 20;
                comisionPeriodica = 3.0;
                portes = 3.5;
                gastosAdmin = 10;
                break;

            case "Interbank":
                seguroDesgravamen = 0.050 / 100;
                seguroContraRiesgo = ((0.38 / 100) * monto_financiar) / 12;
                gastosNotariales = 200;
                gastosRegistrales = 230;
                tasacionInmueble = 120;
                comisionEstudio = 100;
                comisionActivacion = 50;
                evaluacionLegal = 70;
                portesEnvios = 15;
                //COSTES PERIODICOS
                comisionPeriodica = 2.5;
                portes = 2.0;
                gastosAdmin = 9;
                break;

            case "BBVA Perú":
                seguroDesgravamen = 0.046 / 100;
                seguroContraRiesgo = ((0.41 / 100) * monto_financiar) / 12;
                gastosNotariales = 170;
                gastosRegistrales = 240;
                tasacionInmueble = 140;
                comisionEstudio = 110;
                comisionActivacion = 20;
                evaluacionLegal = 65;
                portesEnvios = 20;
                comisionPeriodica = 3.2;
                portes = 3.0;
                gastosAdmin = 11;
                break;

            case "Banco Pichincha":
                seguroDesgravamen = 0.048 / 100;
                seguroContraRiesgo = ((0.39 / 100) * monto_financiar) / 12;
                gastosNotariales = 190;
                gastosRegistrales = 220;
                tasacionInmueble = 125;
                comisionEstudio = 95;
                comisionActivacion = 30;
                evaluacionLegal = 60;
                portesEnvios = 18;
                comisionPeriodica = 2.8;
                portes = 2.5;
                gastosAdmin = 9;
                break;

            case "BanBif":
                seguroDesgravamen = 0.047 / 100;
                seguroContraRiesgo = ((0.42 / 100) * monto_financiar) / 12;
                gastosNotariales = 185;
                gastosRegistrales = 235;
                tasacionInmueble = 135;
                comisionEstudio = 100;
                comisionActivacion = 25;
                evaluacionLegal = 65;
                portesEnvios = 17;
                comisionPeriodica = 3.0;
                portes = 2.8;
                gastosAdmin = 10;
                break;

            case "Scotiabank":
                seguroDesgravamen = 0.044 / 100;
                seguroContraRiesgo = ((0.40 / 100) * monto_financiar) / 12;
                gastosNotariales = 175;
                gastosRegistrales = 245;
                tasacionInmueble = 130;
                comisionEstudio = 105;
                comisionActivacion = 40;
                evaluacionLegal = 70;
                portesEnvios = 19;
                comisionPeriodica = 3.1;
                portes = 3.0;
                gastosAdmin = 11;
                break;

            case "Banco GNB del Perú":
                seguroDesgravamen = 0.049 / 100;
                seguroContraRiesgo = ((0.43 / 100) * monto_financiar) / 12;
                gastosNotariales = 180;
                gastosRegistrales = 225;
                tasacionInmueble = 120;
                comisionEstudio = 90;
                comisionActivacion = 35;
                evaluacionLegal = 55;
                portesEnvios = 16;
                comisionPeriodica = 2.9;
                portes = 2.5;
                gastosAdmin = 9;
                break;

            case "Banco de Comercio":
                seguroDesgravamen = 0.046 / 100;
                seguroContraRiesgo = ((0.41 / 100) * monto_financiar) / 12;
                gastosNotariales = 170;
                gastosRegistrales = 230;
                tasacionInmueble = 125;
                comisionEstudio = 85;
                comisionActivacion = 20;
                evaluacionLegal = 60;
                portesEnvios = 15;
                comisionPeriodica = 2.7;
                portes = 2.3;
                gastosAdmin = 8;
                break;

            case "CMAC Huancayo":
                seguroDesgravamen = 0.052 / 100;
                seguroContraRiesgo = ((0.45 / 100) * monto_financiar) / 12;
                gastosNotariales = 160;
                gastosRegistrales = 210;
                tasacionInmueble = 110;
                comisionEstudio = 80;
                comisionActivacion = 15;
                evaluacionLegal = 50;
                portesEnvios = 12;
                comisionPeriodica = 2.5;
                portes = 2.0;
                gastosAdmin = 7;
                break;

            case "CMAC Ica":
                seguroDesgravamen = 0.051 / 100;
                seguroContraRiesgo = ((0.44 / 100) * monto_financiar) / 12;
                gastosNotariales = 165;
                gastosRegistrales = 215;
                tasacionInmueble = 115;
                comisionEstudio = 85;
                comisionActivacion = 20;
                evaluacionLegal = 55;
                portesEnvios = 13;
                comisionPeriodica = 2.6;
                portes = 2.1;
                gastosAdmin = 7.5;
                break;

            case "CMAC Cusco":
                seguroDesgravamen = 0.053 / 100;
                seguroContraRiesgo = ((0.46 / 100) * monto_financiar) / 12;
                gastosNotariales = 170;
                gastosRegistrales = 220;
                tasacionInmueble = 120;
                comisionEstudio = 90;
                comisionActivacion = 25;
                evaluacionLegal = 55;
                portesEnvios = 14;
                comisionPeriodica = 2.7;
                portes = 2.2;
                gastosAdmin = 8;
                break;

            case "CMAC Trujillo":
                seguroDesgravamen = 0.052 / 100;
                seguroContraRiesgo = ((0.45 / 100) * monto_financiar) / 12;
                gastosNotariales = 175;
                gastosRegistrales = 225;
                tasacionInmueble = 125;
                comisionEstudio = 95;
                comisionActivacion = 30;
                evaluacionLegal = 60;
                portesEnvios = 15;
                comisionPeriodica = 2.8;
                portes = 2.3;
                gastosAdmin = 8.5;
                break;

            case "CMAC Maynas":
                seguroDesgravamen = 0.055 / 100;
                seguroContraRiesgo = ((0.47 / 100) * monto_financiar) / 12;
                gastosNotariales = 160;
                gastosRegistrales = 210;
                tasacionInmueble = 110;
                comisionEstudio = 80;
                comisionActivacion = 20;
                evaluacionLegal = 50;
                portesEnvios = 12;
                comisionPeriodica = 2.4;
                portes = 2.0;
                gastosAdmin = 7;
                break;

            case "CMAC Arequipa":
                seguroDesgravamen = 0.051 / 100;
                seguroContraRiesgo = ((0.44 / 100) * monto_financiar) / 12;
                gastosNotariales = 165;
                gastosRegistrales = 215;
                tasacionInmueble = 115;
                comisionEstudio = 85;
                comisionActivacion = 25;
                evaluacionLegal = 55;
                portesEnvios = 13;
                comisionPeriodica = 2.6;
                portes = 2.1;
                gastosAdmin = 7.5;
                break;

            case "Financiera Efectiva":
                seguroDesgravamen = 0.060 / 100;
                seguroContraRiesgo = ((0.50 / 100) * monto_financiar) / 12;
                gastosNotariales = 150;
                gastosRegistrales = 200;
                tasacionInmueble = 105;
                comisionEstudio = 75;
                comisionActivacion = 20;
                evaluacionLegal = 45;
                portesEnvios = 10;
                comisionPeriodica = 2.3;
                portes = 1.8;
                gastosAdmin = 6.5;
                break;

            case "Financiera CrediScotia":
                seguroDesgravamen = 0.058 / 100;
                seguroContraRiesgo = ((0.49 / 100) * monto_financiar) / 12;
                gastosNotariales = 155;
                gastosRegistrales = 205;
                tasacionInmueble = 110;
                comisionEstudio = 80;
                comisionActivacion = 25;
                evaluacionLegal = 50;
                portesEnvios = 11;
                comisionPeriodica = 2.4;
                portes = 1.9;
                gastosAdmin = 7.0;
                break;

            case "Vívela":
                seguroDesgravamen = 0.057 / 100;
                seguroContraRiesgo = ((0.48 / 100) * monto_financiar) / 12;
                gastosNotariales = 160;
                gastosRegistrales = 210;
                tasacionInmueble = 110;
                comisionEstudio = 85;
                comisionActivacion = 30;
                evaluacionLegal = 55;
                portesEnvios = 12;
                comisionPeriodica = 2.5;
                portes = 2.0;
                gastosAdmin = 7.2;
                break;

            case "EDPYME miCasita":
                seguroDesgravamen = 0.062 / 100;
                seguroContraRiesgo = ((0.52 / 100) * monto_financiar) / 12;
                gastosNotariales = 145;
                gastosRegistrales = 195;
                tasacionInmueble = 100;
                comisionEstudio = 70;
                comisionActivacion = 20;
                evaluacionLegal = 45;
                portesEnvios = 10;
                comisionPeriodica = 2.2;
                portes = 1.8;
                gastosAdmin = 6.0;
                break;

            case "CRAC Raíz":
                seguroDesgravamen = 0.059 / 100;
                seguroContraRiesgo = ((0.50 / 100) * monto_financiar) / 12;
                gastosNotariales = 150;
                gastosRegistrales = 200;
                tasacionInmueble = 105;
                comisionEstudio = 75;
                comisionActivacion = 20;
                evaluacionLegal = 48;
                portesEnvios = 11;
                comisionPeriodica = 2.3;
                portes = 1.9;
                gastosAdmin = 6.8;
                break;

            default:
                throw new IllegalArgumentException("Entidad no reconocida: " + nombre_entidad);
        }


        double montoBBPInicial=0;
        double montoBonoIntegrador=0;
        double montoViviendaSostenible=0;
        double montoBBPFINAL=0;
        double montoTechoPropio=0;
        double saldoInicial = 0;
        
        double saldo = (monto_financiar * (1 - (cuota_inicial / 100)))+ gastosNotariales + gastosRegistrales +
                tasacionInmueble + comisionEstudio + comisionActivacion + evaluacionLegal + portesEnvios;


        //CALCULOS PARA BONOS NO DE TECHO PROPIO

        if(aplicaBonoIntegrador) {
            montoBonoIntegrador = 3600;
        }

        if(!aplicaBonoTP){
            if(monto_financiar>=68800 && monto_financiar<=98100){
                montoBBPInicial=27400 + montoBonoIntegrador;
                montoViviendaSostenible=33700 + montoBonoIntegrador;
                if(viviendaSostenible){
                    montoBBPFINAL=montoViviendaSostenible;
                } else {
                    montoBBPFINAL=montoBBPInicial;
                }
            } else if (monto_financiar>98100 && monto_financiar<=146900) {
                montoBBPInicial=22800 +montoBonoIntegrador;
                montoViviendaSostenible=29100 +montoBonoIntegrador;
                if(viviendaSostenible){
                    montoBBPFINAL=montoViviendaSostenible;
                } else {
                    montoBBPFINAL=montoBBPInicial;
                }
            } else if (monto_financiar>146900 && monto_financiar<=244600) {
                montoBBPInicial=20900 +montoBonoIntegrador;
                montoViviendaSostenible=27200 +montoBonoIntegrador;
                if(viviendaSostenible){
                    montoBBPFINAL=montoViviendaSostenible;
                } else {
                    montoBBPFINAL=montoBBPInicial;
                }
            } else if (monto_financiar>244600 && monto_financiar<=362100) {
                montoBBPInicial=7800 +montoBonoIntegrador;
                montoViviendaSostenible=14100 +montoBonoIntegrador;
                if(viviendaSostenible){
                    montoBBPFINAL=montoViviendaSostenible;
                } else {
                    montoBBPFINAL=montoBBPInicial;
                }
            } else if (monto_financiar>=362100 && monto_financiar<=488800) {
                montoBBPFINAL=0;
            }

            saldoInicial = saldo - montoBBPFINAL;
        }

        

        // CALCULOS PARA BONO TECHO PROPIO



        if(aplicaBonoTP){
            if(tipoVivienda.equalsIgnoreCase("VIS Priorizada en Lote Unifamiliar") && monto_financiar<=60000){
                montoTechoPropio=56710;
            } else if ( tipoVivienda.equalsIgnoreCase("VIS Priorizada en Edificio Multifamiliar / Conjunto Residencial / Quinta") && monto_financiar>60000 && monto_financiar<=70000) {
                montoTechoPropio=51895;
            } else if ( tipoVivienda.equalsIgnoreCase("VIS en Lote Unifamiliar")&& monto_financiar>70000 && monto_financiar<=104500) {
                montoTechoPropio=50825;
            } else if ( tipoVivienda.equalsIgnoreCase("VIS en Edificio Multifamiliar / Conjunto Residencial / Quinta")  && monto_financiar>104500 && monto_financiar<=130500) {
                montoTechoPropio=46545;
            }
            saldoInicial = saldo - montoTechoPropio;
        }


        // --- Variables base ---
        
        int n = plazo * 12 ;// número de meses
        double TEA = valor_taza;
        double TEM = (Math.pow(1 + (TEA / 100), 1.0/12) - 1)*100; // Tasa efectiva mensual correcta

        double TEMcal = redondear(TEM, 7);

        // Cuota fija según método francés
        //double cuota = saldoInicial * (((TEM/100)*(Math.pow((1+(TEM/100)),n)))/(Math.pow((1+(TEM/100)),n)-1));

        double TEP = (TEM/100) + seguroDesgravamen;

        double saldoInicialOriginal = saldoInicial;

        List<Cuotas> tabla = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            String tipoGracia;

            if (tipo_periodo_gracia.equalsIgnoreCase("TOTAL") && i <= periodo_gracia) {
                tipoGracia = "T";
            } else if (tipo_periodo_gracia.equalsIgnoreCase("PARCIAL") && i <= periodo_gracia) {
                tipoGracia = "P";
            } else {
                tipoGracia = "S";
            }

            double interes = 0;
            double seguro = saldoInicial * seguroDesgravamen;
            double amortizacion =0;
            double saldoFinal=0;
            double cuotafinal = 0;
            double flujo= 0;
            //double COK = 12/100.0;






            if (tipoGracia.equalsIgnoreCase("T")){
                interes = saldoInicial * (TEM/100);
                cuotafinal =0;
                amortizacion = 0;
                saldoFinal = saldoInicial + interes;
                flujo=cuotafinal+seguroContraRiesgo+comisionPeriodica+portes+gastosAdmin+seguro;
            } else if (tipoGracia.equalsIgnoreCase("P")){
                interes = saldoInicial * (TEM/100);
                cuotafinal = interes;
                amortizacion = 0;
                saldoFinal = saldoInicial;
                flujo=cuotafinal+seguroContraRiesgo+comisionPeriodica+portes+gastosAdmin+seguro;
            } else {
                interes = saldoInicial * (TEM/100);
                cuotafinal = saldoInicial * (((TEP)*(Math.pow((1+(TEP)),n-i+1)))/(Math.pow((1+(TEP)),n-i+1)-1));
                amortizacion = cuotafinal - interes - seguro;
                saldoFinal = saldoInicial - amortizacion;
                flujo=cuotafinal+seguroContraRiesgo+comisionPeriodica+portes+gastosAdmin;
            }

            //CALCULOS PARA VAN, TIR, TASA DE DESCUENTO Y TCEA
            //double tasaDescuento =  Math.pow((1+COK),(1/12.0))-1;




            double saldoInicialCal = redondear(saldoInicial, 2);
            double saldoFinalCal = redondear(saldoFinal, 2);
            double interesCal = redondear(interes, 2);
            double seguroCal = redondear(seguro, 2);
            double amortizacionCal = redondear(amortizacion, 2);
            double cuotaCal = redondear(cuotafinal,2);
            double flujoCal = redondear(flujo,2);
            double seguroRiesgoCal = redondear(seguroContraRiesgo,2);

            Cuotas cuotaObj = new Cuotas();
            cuotaObj.setNumeroCuota(i);
            cuotaObj.setTep(TEMcal);
            cuotaObj.setPlazo_gracia(tipoGracia);
            cuotaObj.setSaldo_inicial(saldoInicialCal);
            cuotaObj.setInteres(interesCal);
            cuotaObj.setCuota(cuotaCal);
            cuotaObj.setAmortizacion(amortizacionCal);
            cuotaObj.setSeguros(seguroCal);
            cuotaObj.setSeguro_riesgo(seguroRiesgoCal);
            cuotaObj.setComision_periodica(comisionPeriodica);
            cuotaObj.setPortes(portes);
            cuotaObj.setGastos_admin(gastosAdmin);
            cuotaObj.setSaldo_final(Math.max(saldoFinalCal, 0));
            cuotaObj.setFlujo(flujoCal);

            tabla.add(cuotaObj);

            saldoInicial = saldoFinal;
        }

        double COK_anual = 0.08;
        double COK_mensual = Math.pow(1 + COK_anual, 1.0/12) - 1;

// Flujo inicial: préstamo recibido → positivo
        double flujoInicial = saldoInicialOriginal;

        double VAN = flujoInicial;

        int periodo = 1;
        for (Cuotas c : tabla) {

            double flujoNegativo = -1 * c.getFlujo(); // cuota pagada → negativo

            VAN += flujoNegativo / Math.pow(1 + COK_mensual, periodo);

            periodo++;
        }
        double VANCal = redondear(VAN, 2);

        for (Cuotas c : tabla) {
            c.setVan(VANCal);
        }



        double tir = 0.1; // valor inicial (10%)
        double precision = 1e-7;
        int maxIter = 1000;

        for (int iter = 0; iter < maxIter; iter++) {
            double f = flujoInicial; // VAN con tasa tir
            double fDeriv = 0;       // derivada del VAN respecto a tir
            int periodoc = 1;

            for (Cuotas c : tabla) {
                double flujoNegativo = -1 * c.getFlujo();
                f += flujoNegativo / Math.pow(1 + tir, periodoc);
                fDeriv += (-periodoc * flujoNegativo) / Math.pow(1 + tir, periodoc + 1);
                periodoc++;
            }

            double nuevoTir = tir - f / fDeriv;

            if (Math.abs(nuevoTir - tir) < precision) {
                tir = nuevoTir;
                break;
            }
            tir = nuevoTir;
        }


        double TIR_porcentaje = tir * 100;
        double TCEA= (Math.pow(1+tir,12)-1)*100;


        double TIRCal = redondear(TIR_porcentaje, 5);
        double TCEACal = redondear(TCEA, 5);

        for (Cuotas c : tabla) {
            c.setTir(TIRCal);
            c.setTcea(TCEACal);
        }








        return tabla;
    }

}
