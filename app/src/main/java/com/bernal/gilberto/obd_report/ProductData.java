package com.bernal.gilberto.obd_report;

/**
 * Created by Registered User on 4/18/2017.
 */


public class ProductData {


    public String prdNombre;
    public int prdPrecio;
    public int prdCantidad;
    public int prdUnidad;
    public String prdPhoto;

    public ProductData(String PrdNombre, int PrdPrecio, int PrdCantidad, int PrdUnidad, String PrdPhoto) {
        this.prdNombre = PrdNombre;
        this.prdPrecio = PrdPrecio;
        this.prdCantidad = PrdCantidad;
        this.prdUnidad = PrdUnidad;
        this.prdPhoto = PrdPhoto;
    }

    public String getPrdNombre() {
        return prdNombre;
    }

    public int getPrdPrecio() {
        return prdPrecio;
    }

    public int getPrdCantidad() {
        return prdCantidad;
    }

    public int getPrdUnidad() {
        return prdUnidad;
    }

    public String getPrdPhoto() {
        return prdPhoto;
    }


}
