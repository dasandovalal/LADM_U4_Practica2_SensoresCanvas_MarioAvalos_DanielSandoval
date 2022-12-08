package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_marioavalos_danielsandoval

import android.graphics.Canvas
import android.graphics.Paint

class Fondo(lienzo:Lienzo,colorFondo:Int) {
    val l = lienzo
    var colorF = colorFondo

    val p = Paint()

    fun dibujarFondo(c:Canvas){
        c.drawColor(colorF)
    }

}