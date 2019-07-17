package io.github.jerrymatera.alc4phase1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DevProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_profile)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.devprofile)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
