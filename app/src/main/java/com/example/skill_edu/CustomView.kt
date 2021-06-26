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

    private val paint1 = Paint().apply{
        color = strokeColorAttr
        style = Paint.Style.FILL
    }
    private val paint2 = Paint().apply{
        color = strokeColorAttr
        style = Paint.Style.FILL
    }
    private val paint3 = Paint().apply{
        color = strokeColorAttr
        style = Paint.Style.FILL
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        paint1.shader = RadialGradient(
            width / 2f,
            height / 3f / 2f,
            300f,
            Color.MAGENTA,
            Color.RED,
            Shader.TileMode.CLAMP
        )
        val colors = intArrayOf(
            Color.BLUE,
            Color.CYAN,
            Color.GREEN,
            Color.MAGENTA,
            Color.RED,
            Color.YELLOW,
        )

        paint2.shader = LinearGradient(
            width / 4f + width / 3f,
            height / 3f * 2f,
            width / 4f * 3f + width / 8f,
            height / 3f * 2f + width / 2f,
            colors,
            null,
            Shader.TileMode.MIRROR
        )

    }

    val triangle = Path()


    override fun onDraw(canvas: Canvas?) {
        val rect = (height / 3) + (width / 2)
        canvas?.drawRect(
            width / 4f, height / 3f, width / 4f * 3f, rect.toFloat(), paint2
        )
        triangle.fillType = Path.FillType.EVEN_ODD
        triangle.moveTo(width / 2f, height / 3f * 2f)
        triangle.lineTo(width / 4f, height - 100f)
        triangle.lineTo(width / 4f * 3f, height -100f)
        triangle.close()
        canvas?.drawPath(triangle, paint3)
        canvas?.drawCircle(width / 2f, height / 3f / 2f, 300f, paint1)

    }


}