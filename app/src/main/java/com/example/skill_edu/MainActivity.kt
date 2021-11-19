package com.example.skill_edu

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.skill_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notificationManager: NotificationManager
    private val id = 655432
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val CHANNEL_ID = "CHANNEL_ID"

        lateinit var notification: Notification.Builder
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.android_logo)
        val longtext = "asdasdasdasdasdasdasdasdasdasdasdasdsadasdasdasdasdasdasdasdsadsad" +
                "asdasdasdasdasdasdasdasdasdasdasdasdsadasdasdasdasdasdasdasdsadsad" +
                "asdasdasdasdasdasdasdasdasdasdasdasdsadasdasdasdasdasdasdasdsadsad" +
                "asdasdasdasdasdasdasdasdasdasdasdasdsadasdasdasdasdasdasdasdsadsad" +
                "asdasdasdasdasdasdasdasdasdasdasdasdsadasdasdasdasdasdasdasdsadsad"
        val intent = Intent(this, MainActivity::class.java)
        intent.action = "open_activ"
        val intent1 = Intent()
        intent1.action = "close_notify"
        val pendingIntent1 = PendingIntent.getActivity(this, 0, intent, 0)
        val pendingIntent2 = PendingIntent.getBroadcast(this, 1, intent1, 0)
        val receiver = Reseiver()
        val filter = IntentFilter().also {
            it.addAction("close_notify")
            it.addAction("open_act")
        }
        registerReceiver(receiver, filter)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "CHANNEL_NAME"
            val descriptionText = "My Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            val action = Notification.Action.Builder(
                R.drawable.ic_launcher_foreground,
                "Open activity",
                pendingIntent1
            ).build()
            val action1 = Notification.Action.Builder(
                R.drawable.ic_launcher_foreground,
                "Close notifycation",
                pendingIntent2
            ).build()
            mChannel.description = descriptionText
            notificationManager.createNotificationChannel(mChannel)
            notification = Notification.Builder(this, CHANNEL_ID)
//                .setTimeoutAfter(5000)
                .setColor(getColor(R.color.teal_200))
                .setAutoCancel(true)
                .addAction(action)
                .addAction(action1)
                .setLargeIcon(Icon.createWithResource(this, R.drawable.ic_launcher_foreground))
        } else {
            notification = Notification.Builder(this)
        }

        notification.setContentTitle("Notify")
            .setOngoing(true)
            .setAutoCancel(true)
            .setShowWhen(true)
            .setOngoing(true)
            .setAutoCancel(true)
            .setContentText("text")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setProgress(100, 0, true)
//            .setStyle(Notification.BigPictureStyle().bigPicture(bitmap))
//            .setStyle(Notification.BigTextStyle().bigText(longtext))

        binding.notifycation.setOnClickListener {
            notification.setContentText("Push the button")
            notificationManager.notify(id, notification.build())
        }


        binding.edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrBlank()) {
                    notification.setContentText(s.toString())
                    notificationManager.notify(id, notification.build())
                } else {
                    notificationManager.cancel(id)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }


    inner class Reseiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action != null || intent?.action.equals("close_notify")) {
                notificationManager.cancel(id)
            } else if (intent?.action != null || intent?.action.equals("open_activ")) {
                context?.startActivity(Intent(context, MainActivity::class.java))
            }
            println(intent?.action)
        }

    }


}