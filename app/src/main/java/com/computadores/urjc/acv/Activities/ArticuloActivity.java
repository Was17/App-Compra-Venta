package com.computadores.urjc.acv.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.computadores.urjc.acv.Database.Database;
import com.computadores.urjc.acv.R;

public class ArticuloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView=findViewById(R.id.articulo_descripcion);
        TextView nombre=findViewById(R.id.articulo_nombre);
        ImageView imagen=findViewById(R.id.articulo_imagen);

      Database database=new Database(getApplicationContext());
      database.open();
      try{
          Intent mIntent = getIntent();
          int id = Integer.parseInt(mIntent.getStringExtra("id"));
          Cursor c =database.getArticulo(id);
          c.moveToFirst();
          textView.setText(c.getString(3));
          nombre.setText(c.getString(1));
          imagen.setImageURI(Uri.parse(c.getString(4)));
      }catch (Exception e){

          database.close();

      }
       database.close();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
