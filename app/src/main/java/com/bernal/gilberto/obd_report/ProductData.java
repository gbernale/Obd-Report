package com.bernal.gilberto.obd_report;

/**
 * Created by Registered User on 4/18/2017.
 */

public class ProductData {
    public String PrdNombre;
    public int PrdPrecio;
    public int PrdCantidad;
    public int PrdTotal;
    public String PrdPhoto;

    public ProductData(){};

    public ProductData(String PrdNombre, int PrdPrecio,int PrdCantidad, int PrdTotal, String PrdPhoto) {
        this.PrdNombre = PrdNombre;
        this.PrdPrecio = PrdPrecio;
        this.PrdCantidad = PrdCantidad;
        this.PrdTotal = PrdTotal;
        this.PrdPhoto = PrdPhoto;
    }

    public String getPrdNombre() {
        return PrdNombre;
    }

    public int getPrdPrecio(){  return PrdPrecio;}
    public int getPrdCantidad(){return PrdCantidad;}
    public String getPrdPhoto(){return PrdPhoto;}
    public int getPrdTotal(){return PrdTotal;}
}
