package com.idn.doadandzikirapp.UI.Detail

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idn.doadandzikirapp.Model.Artikel
import com.idn.doadandzikirapp.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {
    private var _binding: ActivityDetailArticleBinding? = null
    private val binding get() = _binding as ActivityDetailArticleBinding

//    companion object {
//        const val DATA_TITLE = "title"
//        const val DATA_DESC = "data"
//        const val DATA_IMAGE = "image"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islam"
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data = when{
            SDK_INT >= 33 -> intent.getParcelableExtra("data", Artikel::class.java)
            else -> @Suppress("DEPRECATION") intent.getParcelableExtra("key") as? Artikel
        }

//        val dataTitle = intent.getStringExtra(DATA_TITLE)
//        val dataDesc = intent.getStringExtra(DATA_DESC)
//        val dataImage = intent.getIntExtra(DATA_IMAGE,0)

        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDesc.text = data
                ?.descArtikel
            data?.imageArtikel?.let { imgDetail.setImageResource(it) }
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}
