package com.kampusmerdeka.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var buttonTambah: Button
    private lateinit var buttonKurangi: Button
    private lateinit var buttonClear: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        buttonTambah = findViewById(R.id.tombolTambah)
        buttonKurangi = findViewById(R.id.tombolKurang)
        buttonClear = findViewById(R.id.tombolClear)
        textView = findViewById(R.id.textView)

        textView.text = viewModel.angka.toString()

        buttonTambah.setOnClickListener{

            viewModel.tambahAngka()
            textView.text = viewModel.angka.toString()

        }


        buttonKurangi.setOnClickListener {

            viewModel.kurangAngka()
            textView.text = viewModel.angka.toString()

        }

        buttonClear.setOnClickListener {

            viewModel.clearAngka()
            textView.text = viewModel.angka.toString()
        }



    }
}