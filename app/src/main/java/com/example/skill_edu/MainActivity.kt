package com.example.skill_edu

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
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
import com.example.skill_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val CHANNEL_ID = "CHANNEL_ID"
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val id = 655432
        lateinit var notification: Notification.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "CHANNEL_NAME"
            val descriptionText = "My Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            notificationManager.createNotificationChannel(mChannel)
            notification = Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("Notify")
                .setContentText("Text")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
        } else {
            notification = Notification.Builder(this)
                .setContentTitle("Notify")
                .setContentText("Text")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
        }

        binding.edit.addTextChangedListener(object : TextWatcher{
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


}