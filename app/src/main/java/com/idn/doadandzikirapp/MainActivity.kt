package com.idn.doadandzikirapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.idn.doadandzikirapp.Adapter.ArtikelAdapter
import com.idn.doadandzikirapp.Model.Artikel
import com.idn.doadandzikirapp.UI.Detail.DetailArticleActivity
import com.idn.doadandzikirapp.UI.HarianDzikirDoaActivity
import com.idn.doadandzikirapp.UI.PagiPetangDzikirActivity
import com.idn.doadandzikirapp.UI.QauliyahShalatActivity
import com.idn.doadandzikirapp.UI.SetiapSaatDzikirActivity
import com.idn.doadandzikirapp.Utils.OnItemCallback

class MainActivity : AppCompatActivity() {
    private var keep = true
    private val runner = Runnable { keep = false }

    private lateinit var vpArtikel: ViewPager2
    private val listArtikel: ArrayList<Artikel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            for (i in 0 until listArtikel.size) {
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }

            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,R.drawable.dot_active)
            )

        }
    }

    private lateinit var sliderIndicator: Array<ImageView?>

//     private lateinit var listArtikel: ArrayList<Artikel>

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition { keep }


        val handler = Handler()
        handler.postDelayed(runner, 1800)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menggunakan constructor Handler dengan Looper dari main thread
        // Delay dalam milidetik (2 detik)

        initData()
        initView()
        setupViewPager()
    }

    private fun setupViewPager() {
        val llSliderDots: LinearLayout = findViewById(R.id.ll_slider_dots)

        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            sliderIndicator[i] = ImageView(this)
            sliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )

            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            param.setMargins(9, 0, 8, 0)
            param.gravity = Gravity.CENTER_VERTICAL
            llSliderDots.addView(sliderIndicator[i], param)
        }

        sliderIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_active
            )
        )

    }

    private fun initData() {
        val judulArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val kontenArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

//        val listData = arrayListOf<Artikel>()
        for (i in judulArtikel.indices) {
            val data = Artikel(
                imageArtikel.getResourceId(i, 0), judulArtikel[i], kontenArtikel[i]
            )
            listArtikel.add(data)
        }
        imageArtikel.recycle()
//        return listData
    }

    private fun initView() {
        val llDzikirDoaShalat: LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
        llDzikirDoaShalat.setOnClickListener {
            startActivity(Intent(this, QauliyahShalatActivity::class.java))
        }

        val llDzikirSetiapSaat: LinearLayout = findViewById(R.id.ll_dzikir_setiap_saat)
        llDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }

        val llDzikirDoaHarian: LinearLayout = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
        }

        val llDzikirPagiPetang: LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }

        vpArtikel = findViewById(R.id.vp_artikel)
        val mAdapter = ArtikelAdapter()
        mAdapter.setData(listArtikel)
        vpArtikel.adapter = mAdapter

        vpArtikel.registerOnPageChangeCallback(slidingCallback)

        mAdapter.setOnItemClickCallback(object : OnItemCallback {
            override fun onItemClicked(item: Artikel) {
                val intent = Intent(this@MainActivity,DetailArticleActivity::class.java)
                intent.putExtra("data",item)
                startActivity(intent)
            }
        })
    }

}





