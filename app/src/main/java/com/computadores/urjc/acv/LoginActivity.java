package com.computadores.urjc.acv;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
context=getApplicationContext();
        Button button_inciar_sesion=(Button) findViewById(R.id.button_inicio_sesion);
        Button button_registro=(Button) findViewById(R.id.button_registro);
        button_inciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder= new AlertDialog.Builder(LoginActivity.this);
                View view=getLayoutInflater().inflate(R.layout.dialog_inicio_sesion,null);
                builder.setView(view);
                Button buttn=(Button) view.findViewById(R.id.button_dialog_inicio_sesion);
                buttn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,MenuActivity.class);
                        startActivity(intent);
                    }
                });

                final AlertDialog dialog=builder.create();
                dialog.show();
                Button button=(Button) view.findViewById(R.id.button_dialog_cancelar_inicio);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
            }
        });
        button_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(LoginActivity.this);
                View view=getLayoutInflater().inflate(R.layout.dialog_registro,null);
                builder.setView(view);

                Button buttn=(Button) view.findViewById(R.id.button_dialog_registro);
                buttn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,MenuActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog dialog=builder.create();


                dialog.show();
            }
        });
    }
}
