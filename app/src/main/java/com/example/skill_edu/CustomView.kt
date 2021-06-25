package com.example.skill_edu

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.FrameLayout

class CustomView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : View(context, attributeSet) {

    var strokeWidthAttr = 0f
    var strokeColorAttr = Color.WHITE

    init {
        val attributes = context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.CustomView,
            0,
            0
        )

        try {
            strokeColorAttr = attributes.getColor(R.styleable.CustomView_stoke_color, Color.WHITE)
            strokeWidthAttr = attributes.getFloat(R.styleable.CustomView_stroke_width, 0F)
        } finally {
            attributes.recycle()
        }
    }

    private val strokePaint = Paint().apply{
        color = strokeColorAttr
        style = Paint.Style.STROKE
        strokeWidth = strokeWidthAttr
    }

    val triangle = Path()
    val a = Point(300,500)
    val b = Point(800, 500)
    val c = Point(550, 100)

    override fun onDraw(canvas: Canvas?) {
//        canvas?.drawLine(0F, 0F, width.toFloat(), height.toFloat(), strokePaint )
        canvas?.drawRect(300f, 500f, 800f, 1000f, strokePaint)
        canvas?.drawRect(600f, 800f, 700f, 1000f, strokePaint)
        canvas?.drawPoint(675f, 900f, strokePaint)
        triangle.fillType = Path.FillType.EVEN_ODD
        triangle.moveTo(a.x.toFloat(), a.y.toFloat())
        triangle.lineTo(b.x.toFloat(), b.y.toFloat())
        triangle.lineTo(c.x.toFloat(), c.y.toFloat())
        triangle.close()
        canvas?.drawPath(triangle, strokePaint)
        canvas?.drawCircle(550f, 300f, 40f, strokePaint)

    }

}