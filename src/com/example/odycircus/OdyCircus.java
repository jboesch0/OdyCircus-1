package com.example.odycircus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.models.User;

import java.io.Serializable;


public class OdyCircus extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.odycircus);

        Button buttonConnexion = (Button) findViewById(R.id.login);
        buttonConnexion.setOnClickListener(this);

        Button buttonInscription = (Button) findViewById(R.id.bouttonInscription);
        buttonInscription.setOnClickListener(this);

        Button boutonMap = (Button) findViewById(R.id.boutonMap);
        boutonMap.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.boutonMap :
                startActivity(new Intent(OdyCircus.this, Map.class));
                break;
            case R.id.bouttonInscription :
                startActivity(new Intent(OdyCircus.this, Inscription.class));
                break;

            case R.id.login :

                EditText etLogin = (EditText) findViewById(R.id.userlogin);
                EditText etMdp = (EditText) findViewById(R.id.userPass);
                String log = etLogin.getText().toString();
                String mdp = etMdp.getText().toString();
                Intent intent = new Intent(this, Profil.class);

                if (log.equals("") || mdp.equals("")){
                    new AlertDialog.Builder(this)
                            .setTitle("Erreur Utilisateur")
                            .setMessage("Veuillez remplir les champs")
                            .show();
                } else {
                    int id = User.login(log,mdp);
                    switch (id){
                        case -1 :
                            new AlertDialog.Builder(this)
                                    .setTitle("Erreur Application")
                                    .setMessage("Impossible de joindre le serveur. Verifier la connexion internet")
                                    .show();
                            break;
                        case -2 :
                            new AlertDialog.Builder(this)
                                    .setTitle("Erreur Utilisateur")
                                    .setMessage("Utilisateur Inconnu")
                                    .show();
                            break;
                        default :
                            intent.putExtra("user", id);
                            break;
                    }

                }

                startActivity(intent);
                break;
        }

    }
}


