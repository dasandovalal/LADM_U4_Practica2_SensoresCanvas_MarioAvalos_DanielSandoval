package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_marioavalos_danielsandoval

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View
import kotlinx.coroutines.delay

class Lienzo(activity: MainActivity): View(activity),SensorEventListener {

    var m = activity

    lateinit var sensorManager:SensorManager

    val noche = Color.rgb(18,47,80)
    val dia = Color.rgb(241,212,52)

    var fondo = Fondo(this,dia)
    var bruja = Figura(this,300f,700f,R.drawable.bruja180)
    var luna = Figura(this,450f,200f,R.drawable.iconfinder_04_moon_sleepy_night_emoticon_weather_smiley_3375696)
    var nubeFeliz = Figura(this,100f,100f,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nubeTriste = Figura(this,800f,100f,R.drawable.iconfinder_06_rain_cloud_cry_emoticon_weather_smiley_3375694)
    var nubeEnojada = Figura(this,100f,400f,R.drawable.iconfinder_08_thunder_cloud_angry_emoticon_weather_smiley_3375692)
    var nubeNieve = Figura(this,800f,400f,R.drawable.iconfinder_10_snow_coud_emoticon_weather_smiley_3375690)

    val p = Paint()

    init {
        settearSensores()
    }


    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        fondo.dibujarFondo(c)
        bruja.dibujar(c)
        luna.dibujar(c)
        nubeFeliz.dibujar(c)
        nubeTriste.dibujar(c)
        nubeEnojada.dibujar(c)
        nubeNieve.dibujar(c)
    }

    override fun onSensorChanged(event: SensorEvent) {
        //if(event.sensor.type==Sensor.TYPE_ACCELEROMETER){ }
        if(event.sensor.type==Sensor.TYPE_PROXIMITY){
            if (event.values[0]>=1f){
                fondo.colorF=dia
            }else{
                fondo.colorF=noche
            }
        }
        invalidate()

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    fun settearSensores(){
        sensorManager = m.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
        SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager = m.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,
        sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
        SensorManager.SENSOR_DELAY_NORMAL)

    }
}