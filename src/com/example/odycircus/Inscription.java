package com.example.odycircus;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.models.User;

import java.io.Serializable;

public class Inscription extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle chuby) {

		super.onCreate(chuby);
        setContentView(R.layout.inscription);

        Button valider;
        Button annuler;

        valider = (Button)findViewById(R.id.signup);
        ((Button) findViewById(R.id.signup)).setOnClickListener(this);

        annuler = (Button)findViewById(R.id.cancel);
        ((Button) findViewById(R.id.cancel)).setOnClickListener(this);

	}

    @Override
    public void onClick(View v) {
        EditText etLogin;
        EditText etEmail;
        EditText etMdp1;
        EditText etMdp2;

        etLogin = (EditText)findViewById(R.id.signuplog);
        etEmail = (EditText)findViewById(R.id.signupemail);
        etMdp1 = (EditText)findViewById(R.id.signupmdp);
        etMdp2 = (EditText)findViewById(R.id.signupmdp2);


        String login = etLogin.getText().toString();
        String email = etEmail.getText().toString();
        String mdp1 = etMdp1.getText().toString();
        String mdp2 = etMdp2.getText().toString();

        switch (v.getId()){
            case R.id.signup :
                if(login.equals("") || email.equals("") || mdp1.equals("") || mdp2.equals("")){
                    //Pop Up : Complete every fields
                    new AlertDialog.Builder(this)
                            .setTitle("Erreur")
                            .setMessage("Veuillez remplir tous les champs")
                            .show();
                } else {
                    if (!mdp1.equals(mdp2)){
                        //Pop Up : Passwords does not match
                        new AlertDialog.Builder(this)
                                .setTitle("Erreur")
                                .setMessage("Les mots de passes ne correspondent pas")
                                .show();
                    } else {
                        int[] returnCode = User.addUser(login, mdp1, email);
                        Intent intent = new Intent(this, Profil.class);

                        switch (returnCode[0]) {
                            case 0 :
                                //Activity : Go to new user profil page
                                if (User.getUser(returnCode[1]).equals(null)){
                                    //Pop Up : Error when trying to read created user
                                    new AlertDialog.Builder(this)
                                            .setTitle("Erreur")
                                            .setMessage("L'utilisateur créé n'est pas récupérable. Réessayer ulterieurement")
                                            .show();

                                }
                                else {
                                    intent.putExtra("user", returnCode[1]);
                                    startActivity(intent);
                                }
                            break;
                            case 1 :
                                //Pop Up : Login or email already use
                                new AlertDialog.Builder(this)
                                        .setTitle("Erreur")
                                        .setMessage("Le Login ou l'Email sont déjà utilisé(s)")
                                        .show();
                                break;
                            case 2 :
                                //Pop Up : Unable to reach server
                                new AlertDialog.Builder(this)
                                        .setTitle("Erreur")
                                        .setMessage("Impossible de contacter le serveur\nVerrifier votre connexion à Internet")
                                        .show();
                                break;
                        }
                    }
                }
                break;
            case R.id.cancel :
                etLogin.setText("");
                etEmail.setText("");
                etMdp1.setText("");
                etMdp2.setText("");
                break;
        }
    }
}
