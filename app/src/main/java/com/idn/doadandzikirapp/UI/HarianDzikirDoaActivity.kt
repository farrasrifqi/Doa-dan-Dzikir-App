package com.idn.doadandzikirapp.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikirapp.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikirapp.Model.DoadanDzikirItem
import com.idn.doadandzikirapp.R
import com.idn.doadandzikirapp.databinding.ActivityHarianDzikirDoaBinding

class HarianDzikirDoaActivity : AppCompatActivity() {

    private var _binding : ActivityHarianDzikirDoaBinding? = null
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirData()
        initView()
    }

    private fun initView() {
        val mAdapter = DoadanDzikirAdapter()
        mAdapter.setData(providingDzikirData())
        binding.rvDzikirDoaHarian.adapter = mAdapter
        binding.rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
    }

    private fun providingDzikirData() : List<DoadanDzikirItem> {

        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabText = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemahDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoadanDzikirItem>()
        for (i in titleDzikir.indices) {
            val data = DoadanDzikirItem(
                titleDzikir[i],
                arabText[i],
                terjemahDzikir[i]
            )

            listData.add(data)
        }


        return listData
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

}