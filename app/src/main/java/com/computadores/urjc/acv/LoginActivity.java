package com.computadores.urjc.acv;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.computadores.urjc.acv.Activities.MenuActivity;
import com.computadores.urjc.acv.Database.UserDatabase;
import com.computadores.urjc.acv.Utils.SessionManager;

import static java.lang.Thread.sleep;

public class LoginActivity extends AppCompatActivity {
    private  Context context;

    UserDatabase userDatabase;
    // Session Manager Class
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = getApplication();
        userDatabase=new UserDatabase(getApplication());

        session=new SessionManager(context);

        Button button_inciar_sesion=(Button) findViewById(R.id.button_inicio_sesion);
        Button button_registro=(Button) findViewById(R.id.button_registro);
        button_inciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder= new AlertDialog.Builder(LoginActivity.this);
                View view=getLayoutInflater().inflate(R.layout.dialog_inicio_sesion,null);
                builder.setView(view);
                final AlertDialog dialog=builder.create();
                dialog.show();
                final EditText email=view.findViewById(R.id.email_sesion);
                final EditText editPassword= (EditText) view.findViewById(R.id.password_sesion);
                Button buttonSesion=(Button) view.findViewById(R.id.button_dialog_inicio_sesion);
                buttonSesion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        // Get username, password from EditText
                        String username = email.getText().toString();
                        String password = editPassword.getText().toString();

                        // Check if username, password is filled
                        if(username.trim().length() > 0 && password.trim().length() > 0){
                            // For testing puspose username, password is checked with sample data
                            // username = test
                            // password = test
                            userDatabase.open();
                            if(!username.equals("name")){
                                Cursor c=userDatabase.getUser(username);
                               if(c==null) {
                                   Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
                                   userDatabase.close();
                               }
                                else if(username.equals(c.getString(1)) && password.equals(c.getString(3))){

                                    // Creating user login session
                                    // For testing i am stroing name, email as follow
                                    // Use user real data

                                    session.createLoginSession(username, c.getString(2));
                                    userDatabase.close();
                                    // Staring MainActivity
                                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
                                    userDatabase.close();
                                }


                            }else{
                                // username / password doesn't match
                                Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();

                                userDatabase.close();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(),"Usuario o contraseña sin completar",Toast.LENGTH_LONG).show();

                            // user didn't entered username or password
                            // Show alert asking him to enter the details


                        }

                    }
                });

                Button buttonRegistro=(Button) view.findViewById(R.id.button_dialog_cancelar_inicio);
                buttonRegistro.setOnClickListener(new View.OnClickListener() {
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

                final EditText email=view.findViewById(R.id.email_registro);
                final EditText user_name=view.findViewById(R.id.user_name_registro);
                final EditText password=view.findViewById(R.id.password_registro);
                Button buttn=(Button) view.findViewById(R.id.button_dialog_registro);
                buttn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(email.toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Correo incorrecto", Toast.LENGTH_LONG).show();
                        }else if (user_name.toString().trim().length()==0){
                            Toast.makeText(getApplicationContext(),"Usuario sin rellenar",Toast.LENGTH_LONG).show();

                        }else if (password.toString().trim().length()==0){
                            Toast.makeText(getApplicationContext()," Contraseña sin rellenar",Toast.LENGTH_LONG).show();
                        }
                        else {
                            userDatabase.open();
                            userDatabase.insert(user_name.getText().toString(), email.getText().toString(), password.getText().toString(), "sdg");
                            userDatabase.close();
                            session.createLoginSession("test", "test");

                            // Staring MainActivity
                            Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }
}
