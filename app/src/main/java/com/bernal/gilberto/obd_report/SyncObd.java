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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import static com.google.android.gms.internal.zzt.TAG;


public class SyncObd extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    int REQUEST_ENABLE_BT = 2;
    View view;
    ArrayList deviceStrs = new ArrayList();
    ArrayList devices = new ArrayList();
    public  String dvAddress;
    BluetoothSocket socket = null;
    private     UUID uuid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sync_obd, container, false);


        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
        }
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

       /* Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
            }
        }  */

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        Set <BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();
        if (pairedDevices.size() > 0)
        {
            for (BluetoothDevice device : pairedDevices)
            {
                deviceStrs.add(device.getName() + "\n" + device.getAddress());
                devices.add(device.getAddress());
            }
        }
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.select_dialog_singlechoice,
                deviceStrs.toArray(new String[deviceStrs.size()]));
        alertDialog.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
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
        }
            catch (IOException e) {
            Log.e(TAG, "Socket's create() method failed", e);
        }
        try {
        socket.connect(); }
        catch (IOException connectException) {
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
