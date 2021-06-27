package com.example.skill_edu

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.Button

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

    fun log (widthMeasureSpec: Int, heightMeasureSpec: Int) {
        when(MeasureSpec.getMode(widthMeasureSpec)) {
            MeasureSpec.AT_MOST -> println("AT_MOST ${App.count}")
            MeasureSpec.EXACTLY -> println("EXACTLY ${App.count}")
            MeasureSpec.UNSPECIFIED -> println("UNSPECIFIED ${App.count}")
        }
        App.count++
//        println("widthSize ${MeasureSpec.getSize(widthMeasureSpec)}")
//        println("heightSize ${MeasureSpec.getSize(heightMeasureSpec)}")
//        println("widthMode ${MeasureSpec.getMode(widthMeasureSpec)}")
//        println("heightMode ${MeasureSpec.getMode(heightMeasureSpec)}")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        log(widthMeasureSpec, heightMeasureSpec)

        val resolveWidth = resolveSize(
            MeasureSpec.getSize(widthMeasureSpec), widthMeasureSpec
        )
        val resolveHeight = resolveSize(
            MeasureSpec.getSize(heightMeasureSpec), heightMeasureSpec
        )

        setMeasuredDimension(resolveWidth, resolveHeight)
    }

    private val strokePaint = Paint().apply{
        color = strokeColorAttr
        style = Paint.Style.STROKE
        strokeWidth = strokeWidthAttr
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawLine(0F, 0F, width.toFloat(), height.toFloat(), strokePaint )
    }

}