package com.kampusmerdeka.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kampusmerdeka.room.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appDb : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = AppDatabase.getDatabase(this)

        binding.btnWriteData.setOnClickListener {
            writeData()
        }

        binding.btnReadData.setOnClickListener {
            readData()
        }

        binding.btnDeleteAll.setOnClickListener {
            GlobalScope.launch {
                appDb.studentDB().deleteAll()
            }
        }

        binding.btnUpdate.setOnClickListener {
            updateData()
        }
    }

    private fun updateData() {

        val namaDepan = binding.etNamaDepan.text.toString()
        val namaBelakang = binding.etNamaBelakang.text.toString()
        val NIM = binding.etNim.text.toString()

        if (namaDepan.isNotEmpty() && namaBelakang.isNotEmpty() && NIM.isNotEmpty()){

            GlobalScope.launch(Dispatchers.IO) {
                appDb.studentDB().update(namaDepan, namaBelakang, NIM.toInt())
            }

            binding.etNamaDepan.text.clear()
            binding.etNamaBelakang.text.clear()
            binding.etNim.text.clear()

            Toast.makeText(this@MainActivity, "Berhasil update", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "Mohon masukkan data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun writeData() {

        val namaDepan = binding.etNamaDepan.text.toString()
        val namaBelakang = binding.etNamaBelakang.text.toString()
        val NIM = binding.etNim.text.toString()

        if (namaDepan.isNotEmpty() && namaBelakang.isNotEmpty() && NIM.isNotEmpty()){
            val student = Student(
                null, namaDepan, namaBelakang, NIM.toInt()
            )
            GlobalScope.launch(Dispatchers.IO) {
                appDb.studentDB().insert(student)
            }

            binding.etNamaDepan.text.clear()
            binding.etNamaBelakang.text.clear()
            binding.etNim.text.clear()

            Toast.makeText(this@MainActivity, "Berhasil input", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "Mohon masukkan data", Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun displayData(student: Student) {
        withContext(Dispatchers.Main) {
            binding.tvNamaDepan.text = student.namaDepan
            binding.tvNamaDepan.text = student.namaBelakang
            binding.tvNim.text = student.NIM.toString()
        }
    }

    private fun readData() {
        val rollNo = binding.etNimRead.text.toString()

        if (rollNo.isNotEmpty()) {
            lateinit var student: Student

            GlobalScope.launch {
                student = appDb.studentDB().findByRoll(rollNo.toInt())
                displayData(student)
            }
        }
    }
}