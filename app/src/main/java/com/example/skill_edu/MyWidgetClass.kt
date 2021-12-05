package com.example.skill_edu

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.RemoteViews
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MyWidgetClass : AppWidgetProvider() {

    private val doggyApi: DoggyApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/image/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(DoggyApi::class.java)
    }

    private val scope = CoroutineScope(Dispatchers.IO)

    fun getBitmapFromURL(src: String): Bitmap? {
        return try {
            val url = URL(src)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            println(e.localizedMessage)
            null
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        if (intent?.action != ACTION_WIDGET) return
        val appWidgetManager = AppWidgetManager.getInstance(context)
        val appWidgetComponentName = ComponentName(context!!, MyWidgetClass::class.java)

        RemoteViews(
            context.packageName,
            R.layout.app_widget
        ).apply{
            scope.launch {
                val url = doggyApi.getRandomDog().message
                val bitmap = getBitmapFromURL(url)
                setImageViewBitmap(R.id.image_widget, bitmap)
                appWidgetManager?.updateAppWidget(appWidgetComponentName, this@apply)
            }
        }

    }

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        appWidgetIds?.forEach {
            val pendingIntent = Intent(context, MyWidgetClass::class.java).let {
                it.action = ACTION_WIDGET
                PendingIntent.getBroadcast(context, 0, it, 0)
            }

            RemoteViews(
                context?.packageName,
                R.layout.app_widget
            ).apply{
                setOnClickPendingIntent(R.id.image_widget, pendingIntent)
                scope.launch {
                    val url = doggyApi.getRandomDog().message
                    val bitmap = getBitmapFromURL(url)
                    setImageViewBitmap(R.id.image_widget, bitmap)
                    appWidgetManager?.updateAppWidget(it, this@apply)
                }
            }
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetId: Int,
        newOptions: Bundle?
    ) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
    }

    override fun onDeleted(context: Context?, appWidgetIds: IntArray?) {
        super.onDeleted(context, appWidgetIds)
    }

    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
    }

    override fun onDisabled(context: Context?) {
        super.onDisabled(context)
    }

    override fun onRestored(context: Context?, oldWidgetIds: IntArray?, newWidgetIds: IntArray?) {
        super.onRestored(context, oldWidgetIds, newWidgetIds)
    }

    companion object {
        private const val ACTION_WIDGET = "ACTION_WIDGET"
    }
}