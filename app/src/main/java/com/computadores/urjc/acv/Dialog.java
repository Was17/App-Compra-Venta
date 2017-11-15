package com.computadores.urjc.acv;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * Created by was12 on 10/11/2017.
 */
public class Dialog extends DialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity(),R.layout.dialog_inicio_sesion);
        final View content = getActivity().getLayoutInflater().inflate(R.layout.dialog_inicio_sesion,null);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.setView(content)
                // Add action buttons
                .setPositiveButton(""/*Mensaje para el botón positivo*/, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Código para cuando se haga click en positivo
                    }
                })
                .setNegativeButton(""/*Mensaje para el botón negativo*/, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Código para cuando se haga click en negativo
                    }
                });
        return builder.create();
    }
}
