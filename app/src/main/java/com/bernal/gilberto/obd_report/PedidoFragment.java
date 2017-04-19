package com.bernal.gilberto.obd_report;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class PedidoFragment extends Fragment {

    private TextView tv_prod_tamal,tv_tamal_precio,tv_tamal_total;
    private TextView tv_prod_morcilla, tv_morcilla_precio,tv_morcilla_total;
    private TextView tv_prod_picada_small,tv_picada_small_precio,tv_picada_small_total;
    private TextView tv_prod_picada_big,tv_picada_big_precio,tv_picada_big_total;
    private TextView tv_prod_sancocho,tv_sancocho_precio,tv_sancocho_total;
    private TextView tv_prod_huesitos,tv_huesitos_precio,tv_huesitos_total;
    private TextView tv_nombre,tv_direccion1,tv_direccion2,tv_telefono,tv_email,tv_fecha,tv_comments;

    private EditText et_tamal_cantidad,et_morcilla_cantidad,et_picada_small_cantidad;
    private EditText et_picada_big_cantidad,et_sancocho_cantidad,et_huesitos_cantidad;
    private EditText et_nombre,et_direccion1,et_direccion2,et_telefono,et_email,et_fecha,et_notas;
    private View view;

    String tamal_cantidad,morcilla_cantidad,picada_small_cantidad;
    String picada_big_cantidad,sancocho_cantidad,huesitos_cantidad;
    String nombre,direccion1,direccion2,telefono,email,fecha,et_comments;

    private FirebaseAuth firebaseAuth;
    private Button buttonCancelar;
    private DatabaseReference databaseReference;


/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }  */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pedido, container, false);
        firebaseAuth= FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        tv_prod_tamal = (TextView) view.findViewById(R.id.tv_prod_tamal);
        tv_tamal_precio = (TextView) view.findViewById(R.id.tv_tamal_precio);
        tv_tamal_total = (TextView) view.findViewById(R.id.tv_tamal_total);
        tv_prod_morcilla = (TextView) view.findViewById(R.id.tv_prod_morcilla);
        tv_morcilla_precio = (TextView) view.findViewById(R.id.tv_morcilla_precio);
        tv_morcilla_total = (TextView) view.findViewById(R.id.tv_morcilla_total);
        tv_prod_picada_small = (TextView) view.findViewById(R.id.tv_prod_picada_small);
        tv_picada_small_precio = (TextView) view.findViewById(R.id.tv_picada_small_precio);
        tv_picada_small_total = (TextView) view.findViewById(R.id.tv_picada_small_total);
        tv_prod_picada_big = (TextView) view.findViewById(R.id.tv_prod_picada_big);
        tv_picada_big_precio = (TextView) view.findViewById(R.id.tv_picada_big_precio);
        tv_picada_big_total = (TextView) view.findViewById(R.id.tv_picada_big_total);
        tv_prod_sancocho = (TextView) view.findViewById(R.id.tv_prod_sancocho);
        tv_sancocho_precio = (TextView) view.findViewById(R.id.tv_sancocho_precio);
        tv_sancocho_total = (TextView) view.findViewById(R.id.tv_sancocho_total);
        tv_prod_huesitos = (TextView) view.findViewById(R.id.tv_prod_huesitos);
        tv_huesitos_precio = (TextView) view.findViewById(R.id.tv_huesitos_precio);
        tv_huesitos_total = (TextView) view.findViewById(R.id.tv_huesitos_total);
        tv_nombre = (TextView) view.findViewById(R.id.tv_nombre);
        tv_direccion1 = (TextView) view.findViewById(R.id.tv_direccion1);
        tv_direccion2 = (TextView) view.findViewById(R.id.tv_direccion2);
        tv_telefono = (TextView) view.findViewById(R.id.tv_telefono);
        tv_email = (TextView) view.findViewById(R.id.tv_email);
        tv_fecha = (TextView) view.findViewById(R.id.tv_fecha);
        tv_comments = (TextView) view.findViewById(R.id.tv_notas);

        et_tamal_cantidad = (EditText) view.findViewById(R.id.et_tamal_cantidad);
        et_morcilla_cantidad = (EditText) view.findViewById(R.id.et_morcilla_cantidad);
        et_picada_small_cantidad = (EditText) view.findViewById(R.id.et_picada_small_cantidad);
        et_picada_big_cantidad = (EditText) view.findViewById(R.id.et_picada_big_cantidad);
        et_sancocho_cantidad = (EditText) view.findViewById(R.id.et_sancocho_cantidad);
        et_huesitos_cantidad = (EditText) view.findViewById(R.id.et_huesitos_cantidad);
        et_nombre = (EditText) view.findViewById(R.id.et_nombre);
        et_direccion1 = (EditText) view.findViewById(R.id.et_direccion1);
        et_direccion2 = (EditText) view.findViewById(R.id.et_direccion2);
        et_telefono = (EditText) view.findViewById(R.id.et_telefono);
        et_email = (EditText) view.findViewById(R.id.et_email);
        et_fecha = (EditText) view.findViewById(R.id.et_fecha);
        et_notas = (EditText) view.findViewById(R.id.et_notas);
        buttonCancelar = (Button) view.findViewById(R.id.buttonCancelar);


        tamal_cantidad = et_tamal_cantidad.getText().toString().trim();
        morcilla_cantidad= et_morcilla_cantidad.getText().toString().trim();
        picada_small_cantidad= et_picada_small_cantidad.getText().toString().trim();
        picada_big_cantidad= et_picada_big_cantidad.getText().toString().trim();
        sancocho_cantidad= et_sancocho_cantidad.getText().toString().trim();
        huesitos_cantidad= et_huesitos_cantidad.getText().toString().trim();
        nombre= et_nombre.getText().toString().trim();
        direccion1= et_direccion1.getText().toString().trim();
        direccion2= et_direccion2.getText().toString().trim();
        telefono= et_telefono.getText().toString().trim();
        email= et_email.getText().toString().trim();
        fecha= et_fecha.getText().toString().trim();

        return inflater.inflate(R.layout.fragment_pedido, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event



}
