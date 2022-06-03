package org.chealan.pencil

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.Window
import androidx.appcompat.app.AppCompatActivity


class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val eThread: Thread = object : Thread() {
            //创建子线程
            override fun run() {
                try {
                    Looper.prepare()
                    sleep(1000)
                    val it = Intent(this@StartActivity, MainActivity::class.java)
                    startActivity(it)
                    finish()
                    Looper.loop()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        eThread.start()


    }
}