package com.zakdroid.candysuharnica.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.ui.main.MainActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val ivNote = findViewById<ImageView>(R.id.imgViewLogo)
        ivNote.alpha = 0f
        ivNote.animate().setDuration(2000).alpha(1f).withEndAction{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}