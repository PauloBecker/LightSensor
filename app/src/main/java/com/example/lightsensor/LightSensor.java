package com.example.lightsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class LightSensor extends AppCompatActivity implements SensorEventListener {

    SensorManager mSensorManager;
    Sensor mSensorLight;
    TextView mTvLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_light_sensor );
        mTvLight=findViewById( R.id.tvSensorList );

        mSensorManager = (SensorManager) getSystemService( getApplicationContext().SENSOR_SERVICE );
        mSensorLight = mSensorManager.getDefaultSensor( Sensor.TYPE_LIGHT );
        mSensorManager.registerListener( this, mSensorLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();

        float currentValue = event.values[0];
        mTvLight.setText( Float.toString( currentValue ) );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}