package com.example.odycircus;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.models.User;

public class Profil extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle superDuyAnh) {
		// TODO Auto-generated method stub
		super.onCreate(superDuyAnh);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.profil);

        Button modifier = (Button) findViewById(R.id.modify);
        ((Button) findViewById(R.id.modify)).setOnClickListener(this);

        Button fil = (Button) findViewById(R.id.filphoto);
        ((Button) findViewById(R.id.filphoto)).setOnClickListener(this);

        Button circus = (Button) findViewById(R.id.circus);
        ((Button) findViewById(R.id.circus)).setOnClickListener(this);

        Button disconnect = (Button) findViewById(R.id.disconnect);
        ((Button) findViewById(R.id.disconnect)).setOnClickListener(this);

        TextView tvNom = (TextView) findViewById(R.id.nom);
        TextView tvLogin = (TextView) findViewById(R.id.login);
        TextView tvEmail = (TextView) findViewById(R.id.email);

        int id = getIntent().getIntExtra("user", -1);

        if(-1 == id){
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Utilisateur indisponible")
                    .show();
        } else {
            User user = User.getUser(id);
            tvNom.setText(user.getFirstName() + " " + user.getLastName());
            tvLogin.setText(user.getUsername());
            tvEmail.setText(user.getEmail());
        }


	}


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.modify :
                //Go to modification profil view
            case R.id.circus :
                //Go to user's circus
            case R.id.filphoto :
                //Go to photo timeline
            case R.id.disconnect :
                //Call disconnect function
        }

    }
}
