package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_marioavalos_danielsandoval

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Figura(lienzo:Lienzo,x:Float,y:Float,img:Int) {
    val l=lienzo
    var x = x
    var y = y
    val img = BitmapFactory.decodeResource(l.resources,img)

    var p = Paint()

    fun dibujar(c:Canvas){
        c.drawBitmap(img,x,y,p)
    }
}