package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_marioavalos_danielsandoval

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(activity: MainActivity): View(activity) {

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
}