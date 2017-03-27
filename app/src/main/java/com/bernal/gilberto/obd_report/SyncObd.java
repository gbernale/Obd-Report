package com.bernal.gilberto.obd_report;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import static android.R.attr.id;
import static com.bernal.gilberto.obd_report.R.id.buttonLogout;
import static com.google.android.gms.internal.zzt.TAG;


public class SyncObd extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    int REQUEST_ENABLE_BT = 2;
    View view;
    ArrayList deviceStrs = new ArrayList();
    ArrayList devices = new ArrayList();
    //  from other app
    ListView listViewPaired;
    ListView listViewDetected;
    ArrayList<BluetoothDevice> listPairedBtd;
    ArrayList<String> arrayListpaired;
    ArrayAdapter<String> adapter, detectedAdapter;
    private String btList;
    private Button buttonLogout;
    public String dvAddress;
    BluetoothSocket socket = null;
    private UUID uuid;
    private TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sync_obd, container, false);
        tv = (TextView) view.findViewById(R.id.tv);
        buttonLogout = (Button) view.findViewById(R.id.buttonLogout);
        arrayListpaired = new ArrayList<String>();
        listPairedBtd = new ArrayList<BluetoothDevice>();
        listViewDetected = (ListView) view.findViewById(R.id.listViewDetected);
        listViewPaired = (ListView) view.findViewById(R.id.listViewPaired);
        listViewDetected.setAdapter(detectedAdapter);
        detectedAdapter.notifyDataSetChanged();
        listViewPaired.setAdapter(adapter);


        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                deviceStrs.add(device.getName() + "\n" + device.getAddress());
                devices.add(device.getAddress());
                // btList= (device.getName() + " " + device.getAddress());
                // tv.append(btList);
                arrayListpaired.add(device.getName() + "\n" + device.getAddress());
                listPairedBtd.add(device);
                adapter.notifyDataSetChanged();
            }

        }
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.select_dialog_singlechoice,
                deviceStrs.toArray(new String[deviceStrs.size()]));
        alertDialog.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                int position = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
                String deviceAddress = devices.get(position).toString();
                dvAddress = deviceAddress;
                // TODO save deviceAddress
            }
        });
        // show list
        Intent discoverableIntent =
                new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);

        //BluetoothDevice device = btAdapter.getRemoteDevice(dvAddress);
        BluetoothAdapter bltAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice devicex = bltAdapter.getRemoteDevice(dvAddress);
        String id = UUID.randomUUID().toString();
        uuid = UUID.fromString(id);
        try {
            BluetoothSocket socket = devicex.createInsecureRfcommSocketToServiceRecord(uuid);
        } catch (IOException e) {
            Log.e(TAG, "Socket's create() method failed", e);
        }
        try {
            socket.connect();
        } catch (IOException connectException) {
            // Unable to connect; close the socket and return.
            try {
                socket.close();
            } catch (IOException closeException) {
                Log.e(TAG, "Could not close the client socket", closeException);
            }

        }

        return inflater.inflate(R.layout.fragment_sync_obd, container, false);
    }
}


