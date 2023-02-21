package com.example.bobmainsubmodules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.bob_modules.BobModuleMainActivity

class MyMainActivity : AppCompatActivity() {
    private lateinit var btnGo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGo = findViewById(R.id.btnGo)

        btnGo.setOnClickListener {
            val intent = Intent(this@MyMainActivity,BobModuleMainActivity::class.java)
            startActivity(intent)
            it.visibility = View.GONE
        }
    }
}