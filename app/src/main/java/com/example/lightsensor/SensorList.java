package com.example.lightsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorList extends AppCompatActivity {

    SensorManager mSensorManager;
    Sensor mSensorList;
    TextView mTvLight;
    String strListSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sensor_list);

        mTvLight=findViewById( R.id.tvSensorList);
        mSensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);

//        Intent intent = getIntent();
//        strListSensor = intent.getStringExtra( "listSensor" );

        List<Sensor> listSensor = mSensorManager.getSensorList( Sensor.TYPE_ALL );
        StringBuilder sensorListTxt = new StringBuilder();
        for (Sensor s:listSensor) {
            sensorListTxt.append( s.getName()).append( System.getProperty( "line.separator" ));
        }
        mTvLight.setText( sensorListTxt );
    }
}