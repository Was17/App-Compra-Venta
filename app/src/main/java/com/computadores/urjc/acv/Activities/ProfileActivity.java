package com.computadores.urjc.acv.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.computadores.urjc.acv.Database.Database;
import com.computadores.urjc.acv.R;
import com.computadores.urjc.acv.Utils.SessionManager;


public class ProfileActivity extends AppCompatActivity {
    private Context context;
    private SessionManager sessionManager;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = getApplication();
        database =new Database(getApplication());
        sessionManager=new SessionManager(this);
        TextView email=(TextView)findViewById(R.id.email_perfil);
        TextView nombre=(TextView)findViewById(R.id.user_name_perfil);
        Button modificar_contraseña=(Button)findViewById(R.id.button_modificar_contraseña);
        email.setText(sessionManager.getUserDetails().get("email"));
        nombre.setText(sessionManager.getUserDetails().get("name"));
        modificar_contraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(getApplicationContext(),ChangePasswordActivity.class);
                startActivity(intent);

            }
        });

    }
}
