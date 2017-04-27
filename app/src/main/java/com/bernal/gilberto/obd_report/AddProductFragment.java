package com.bernal.gilberto.obd_report;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.bernal.gilberto.obd_report.R.id.buttonLogout;
import static com.bernal.gilberto.obd_report.R.id.buttonSaveData;


public class AddProductFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private EditText et_productname,et_productprice,et_productcantidad,et_productunidad, et_productphoto;
    private TextView tv_products;
    private View view;
    private Button buttonSaveData, buttonLogout;
    private static final String TAG = "AddProductFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_add_product, container, false);
        firebaseAuth= FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        buttonLogout = (Button) view.findViewById(R.id.buttonLogout);
        buttonSaveData = (Button) view.findViewById(R.id.buttonSaveData);

        // loadUserdata(user);

        buttonSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {

                et_productname = (EditText) view.findViewById(R.id.et_productname);
                et_productprice = (EditText) view.findViewById(R.id.et_productprice);
                et_productcantidad = (EditText) view.findViewById(R.id.et_productcantidad);
                et_productunidad = (EditText) view.findViewById(R.id.et_productunidad);
                et_productphoto = (EditText) view.findViewById(R.id.et_productphoto);
                tv_products = (TextView) view.findViewById(R.id.tv_Products);

                String pname = et_productname.getText().toString().trim();
                String sprice = et_productprice.getText().toString().trim();
                int pprice=Integer.parseInt(sprice);
                String sunidad = et_productunidad.getText().toString().trim();
                int punidad = Integer.parseInt(sunidad);
                String scantidad = et_productcantidad.getText().toString().trim();
                int pcantidad = Integer.parseInt(scantidad);
                String pphoto = et_productphoto.getText().toString().trim();
                ProductData pdata = new ProductData(pname,pprice,pcantidad,punidad, pphoto);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child("ProductData").child(user.getUid()).setValue(pdata);
                Toast.makeText(getContext(), "Product Data saved  .....", Toast.LENGTH_LONG).show();
                //loadUserdata(user);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                Intent intent = new Intent();
                intent.setClass(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        return view;


        //return inflater.inflate(R.layout.fragment_add_product, container, false);
    }


}
