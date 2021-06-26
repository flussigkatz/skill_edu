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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val widthMode = MeasureSpec.getMode(measuredWidth)
        val heightMode = MeasureSpec.getMode(measuredHeight)
        println("widthSize $widthSize")
        println("heightSize $heightSize")
        println("widthMode $widthMode")
        println("heightMode $heightMode")

        val resolveWidth = resolveSize(widthSize, measuredWidth)
        val resolveHeight = resolveSize(heightSize, measuredHeight)

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