package io.github.jerrymatera.alc4phase1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        about_btn.setOnClickListener {
            startActivity(Intent(this, AboutAlcActivity::class.java))
        }

        profile_btn.setOnClickListener {
            startActivity(Intent(this, DevProfileActivity::class.java))
        }
    }
}
