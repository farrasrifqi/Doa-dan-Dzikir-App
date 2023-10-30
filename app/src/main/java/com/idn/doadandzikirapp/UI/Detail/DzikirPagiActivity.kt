package com.idn.doadandzikirapp.UI.Detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikirapp.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikirapp.Model.DatadoaDzikir
import com.idn.doadandzikirapp.databinding.ActivityDzikirPagiBinding

class DzikirPagiActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirPagiBinding? = null
    private val binding get() = _binding as ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Pagi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPagi.apply {
            val mAdapter = DoadanDzikirAdapter()
            mAdapter.setData(DatadoaDzikir.listDzikirPagi)
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