package com.computadores.urjc.acv.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.computadores.urjc.acv.Class.User;
import com.computadores.urjc.acv.Database.Database;
import com.computadores.urjc.acv.R;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // Set padding for Tiles
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(0, tilePadding, 0, tilePadding);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return recyclerView;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private CardView mCardViewTop;
        private View insideLayout;
        private TextView division;
        private Context context;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.card_user, parent, false));
            mCardViewTop=itemView.findViewById(R.id.card_articulo);
            insideLayout = itemView.findViewById(R.id.layout_card_articulo);
            context=itemView.getContext();
            nombre=(TextView) itemView.findViewById(R.id.card_title);
        }
    }
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder>{
        // Set numbers of List in RecyclerView.
        ArrayList<User> objetos;
        Database database;
        public ContentAdapter(Context context) {
            database =new Database(context);
            database.open();
            Cursor c= database.getAllUsers();
            this.objetos = new ArrayList<User>();
            while (c.moveToNext()){
                objetos.add(new User(c.getString(1)));
            }
            objetos.add(new User("jonads"));
            objetos.add(new User("Eustaquio"));
            database.close();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            User user= objetos.get(position);
            holder.nombre.setText(user.getNombre());
            holder.mCardViewTop.setCardBackgroundColor(Color.GRAY);




            final String mensaje="Esto es una prueba";

            final String correo="CompraVentaURJC@gmail.com";
            final String contraseña = "compraventaldm18";
            holder.mCardViewTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    Properties properties= new Properties();
                    properties.put("mail.smtp.host","smtp.googlemail.com");
                    properties.put("mail.smtp.socketFactory.port","465");
                    properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                    properties.put("mail.smtp.auth","true");
                    properties.put("mail.smtp.port","465");

                    try {
                        Session   session = Session.getDefaultInstance(properties, new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return  new PasswordAuthentication(correo,contraseña);
                            }
                        });
                        if(session!=null){
                            Message message= new MimeMessage(session);
                            message.setFrom(new InternetAddress(correo));
                            message.setSubject(("asunto urjc"));
                            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(""));
                            message.setContent(mensaje,"text/html; charset=utf-8");
                            Transport.send(message);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return objetos.size();
        }
    }



}
