package com.example.odycircus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UploadPhoto extends Activity implements View.OnClickListener {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uploadphoto);	
		
		
		
		
		 Button bouttonMem = (Button)findViewById(R.id.bouttonMemoire);
	     ((Button)findViewById(R.id.bouttonMemoire)).setOnClickListener(this);
	     
	     Button bouttonAppareil = (Button)findViewById(R.id.bouttonAppareil);
	     ((Button)findViewById(R.id.bouttonAppareil)).setOnClickListener(this);

	
	}
	

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		
			case R.id.bouttonMemoire:
			
			
				
				
			case R.id.bouttonAppareil:
		
		}
	}


}