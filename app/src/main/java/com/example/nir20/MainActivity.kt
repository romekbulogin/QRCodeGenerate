package com.example.nir20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import io.github.g0dkar.qrcode.render.Colors

class MainActivity : AppCompatActivity() {

    private lateinit var qrCode: ImageView
    private lateinit var editData: EditText
    private lateinit var buttonGenerate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        qrCode = findViewById<ImageView>(R.id.qrCode)
        editData = findViewById<EditText>(R.id.editData)
        buttonGenerate = findViewById<Button>(R.id.buttonGenerate)

        buttonGenerate.setOnClickListener {
            val data = editData.text.toString().trim()

            if(data.isEmpty()) {
                Toast.makeText(this,"Enter some data",Toast.LENGTH_SHORT).show()
            }
            else {
                val startColor = Colors.rgba(0, 135, 220) // Light Blue
                val endColor = Colors.rgba(0, 55, 120) // Dark Blue
                GradientColorQRCode().createQRCode(data,startColor,endColor)
            }
        }
    }
}
