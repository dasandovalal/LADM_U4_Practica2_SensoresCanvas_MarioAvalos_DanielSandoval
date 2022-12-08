package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_marioavalos_danielsandoval

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import android.view.View
import kotlinx.coroutines.delay

class Lienzo(activity: MainActivity): View(activity),SensorEventListener {

    var m = activity

    lateinit var sensorManager:SensorManager

    val noche = Color.rgb(18,47,80)
    val dia = Color.rgb(0,170,228)

    var fondo = Fondo(this,dia)
    var bruja = Figura(this,300f,700f,R.drawable.bruja180)
    var luna = Figura(this,700f,100f,R.drawable.iconfinder_04_moon_sleepy_night_emoticon_weather_smiley_3375696)
    var sol = Figura(this,700f,100f,R.drawable.iconfinder_07_sun_smile_happy_emoticon_weather_smiley_3375693)
    var nubeFeliz = Figura(this,200f,200f,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nubeTriste = Figura(this,480f,400f,R.drawable.iconfinder_06_rain_cloud_cry_emoticon_weather_smiley_3375694)
    var nubeEnojada = Figura(this,150f,600f,R.drawable.iconfinder_08_thunder_cloud_angry_emoticon_weather_smiley_3375692)
    var nubeNieve = Figura(this,750f,300f,R.drawable.iconfinder_10_snow_coud_emoticon_weather_smiley_3375690)

    val p = Paint()

    init {
        settearSensores()
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        fondo.dibujarFondo(c)
        bruja.dibujar(c)
        luna.dibujar(c)
        sol.dibujar(c)
        nubeFeliz.dibujar(c)
        nubeTriste.dibujar(c)
        nubeEnojada.dibujar(c)
        nubeNieve.dibujar(c)
    }

    override fun onSensorChanged(event: SensorEvent) {
        if(event.sensor.type==Sensor.TYPE_ACCELEROMETER){
            //Las figuras tienen diferentes velocidades entre si
            nubeTriste.x += -event.values[0]
            nubeTriste.y += event.values[1]/2
            nubeFeliz.x += -event.values[0]/2
            nubeFeliz.y += event.values[1]/4
            nubeEnojada.x += -event.values[0]/3
            nubeEnojada.y += event.values[1]/6
            nubeNieve.x += -event.values[0]/4
            nubeNieve.y += event.values[1]/8
            sol.x += -event.values[0]/5
            sol.y += event.values[1]/10
            luna.x += -event.values[0]/5
            luna.y += event.values[1]/10
        }
        if(event.sensor.type==Sensor.TYPE_PROXIMITY){
            if (event.values[0]<1f){
                //Hacemos de dia, sale el sol y se esconde la luna
                fondo.colorF=dia
                luna.p.alpha=0
                sol.p.alpha=255
            }else{
                //Se hace de noche, fuera el sol
                fondo.colorF=noche
                sol.p.alpha=0
                luna.p.alpha=255
            }
        }
        invalidate()

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    fun settearSensores(){
        //Ubicar el acelerometro
        sensorManager = m.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
        SensorManager.SENSOR_DELAY_NORMAL)

        //Ubicar el sensor de proximidad
        sensorManager = m.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,
        sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
        SensorManager.SENSOR_DELAY_NORMAL)

    }
}