package com.kampusmerdeka.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kampusmerdeka.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.apply {
            tombolSimpan.setOnClickListener {
                val namaLengkap = edtNamaLengkap.text.toString()
                val email = edtEmail.text.toString()

                editor.apply {
                    putString("nama_lengkap", namaLengkap)
                    putString("email", email)
                    apply()
                }
                toastSave()

                binding.edtNamaLengkap.text.clear()
                binding.edtEmail.text.clear()
            }

            tombolLoad.setOnClickListener {
                val namaLengkap = sharedPref.getString("nama_lengkap", null)
                val email = sharedPref.getString("email", null)

                tvNamaLengkap.text = namaLengkap
                tvEmail.text = email

                toastLoad()
            }

            tombolClear.setOnClickListener {
                val namaLengkap = sharedPref.getString("nama_lengkap", null)
                val email = sharedPref.getString("email", null)

                if (namaLengkap != null && email != null) {
                    tvNamaLengkap.text = ""
                    tvEmail.text = ""

                    toastClear()
                } else {
                    toastClearEmpty()
                }
            }
        }
    }

    private fun toastSave() {
        Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
    }

    private fun toastLoad() {
        Toast.makeText(this, "Data berhasil diload", Toast.LENGTH_SHORT).show()
    }

    private fun toastClear() {
        Toast.makeText(this, "Data telah dibersihkan", Toast.LENGTH_SHORT).show()
    }

    private fun toastClearEmpty() {
        Toast.makeText(this, "Mohon simpan data terlebih dahulu", Toast.LENGTH_SHORT).show()
    }
}