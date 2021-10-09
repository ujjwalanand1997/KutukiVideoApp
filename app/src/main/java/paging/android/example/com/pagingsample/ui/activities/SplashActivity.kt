package paging.android.example.com.pagingsample.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import paging.android.example.com.pagingsample.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler().postDelayed(
            {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }, 2000
        )

    }
}