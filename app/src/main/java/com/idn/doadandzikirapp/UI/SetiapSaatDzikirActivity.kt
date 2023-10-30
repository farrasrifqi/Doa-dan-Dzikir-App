package com.idn.doadandzikirapp.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikirapp.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikirapp.Model.DatadoaDzikir
import com.idn.doadandzikirapp.databinding.ActivitySetiapSaatDzikirBinding

class SetiapSaatDzikirActivity : AppCompatActivity() {

    private var _binding : ActivitySetiapSaatDzikirBinding? = null
    private val binding get() = _binding as ActivitySetiapSaatDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivitySetiapSaatDzikirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoadanDzikirAdapter()
        mAdapter.setData(DatadoaDzikir.listDzikir)
        binding.rvDzikirSetiapSaat.adapter = mAdapter
        binding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}