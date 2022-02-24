package com.example.lightsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lightsensor.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button botaoLight,botaoList;
    TextView listSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        botaoLight = findViewById( R.id.buttonLightSensor );
        botaoList = findViewById( R.id.buttonSensorList );
        listSensor = findViewById( R.id.tvSensorList );

        botaoList.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSensorList();
            }
        } );

        botaoLight.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLightSensor();
            }
        } );

    }

    private void showLightSensor() {
        Intent intent = new Intent(this, LightSensor.class);
        startActivity( intent );
    }

    private void showSensorList () {
        Intent intent1 = new Intent( this, SensorList.class );
//        intent.putExtra( "listSensor", listSensor.getText().toString() );
        startActivity( intent1 );
    }
}
