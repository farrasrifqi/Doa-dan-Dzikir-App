package com.idn.doadandzikirapp.UI.Detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikirapp.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikirapp.Model.DatadoaDzikir
import com.idn.doadandzikirapp.databinding.ActivityDzikirPetangBinding

class DzikirPetangActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirPetangBinding? = null
    private val binding get() = _binding as ActivityDzikirPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Petang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPetang.apply {
            val mAdapter = DoadanDzikirAdapter()
            mAdapter.setData(DatadoaDzikir.listDzikirPetang)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}