package com.example.kotlin04_churrascometro

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Implementacoes:
        var sbMen = findViewById<SeekBar>(R.id.SeekBarMen)
        var menQtt = findViewById<TextView>(R.id.TextViewMen)
        var sbWomen = findViewById<SeekBar>(R.id.SeekBarWomen)
        var womenQtt = findViewById<TextView>(R.id.TextViewWomen)

        sbMen?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                menQtt.text = progress.toString()
                calculate(progress, sbWomen.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        sbWomen?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                womenQtt.text = progress.toString()
                calculate(sbMen.progress, progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    fun calculate(menQtt: Int, womenQtt: Int) {
        val outputSausage = findViewById<TextView>(R.id.TextViewQttSausage)
        val outputMeat = findViewById<TextView>(R.id.TextViewQttMeat)
        val sausageQtt: Double = (menQtt * 250.0 + womenQtt * 150.0)/1000
        val meatQtt: Double = (menQtt * 450.0 + womenQtt * 300.0)/1000

        outputSausage.text = sausageQtt.toString() + "Kg"
        outputMeat.text = meatQtt.toString() + "Kg"
    }
}