package com.example.tugasandroidadvance.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.tugasandroidadvance.data.ItemPost
import com.example.tugasandroidadvance.databinding.ActivityMain2Binding
import com.example.tugasandroidadvance.fragment.SEND_DATA_TO_MAIN_ACTIVITY2

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain2)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )


        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_MAIN_ACTIVITY2)
        if (dataPost != null) {
            showData(dataPost)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun showData(itemPost: ItemPost) {

        Glide.with(this).load(itemPost.imageUrl).into(binding.imgDetail)
        binding.txtDetailTitle.text = itemPost.txtTitle
        binding.txtDetailSubtitle.text = itemPost.txtSubtitle
        binding.txtDetailText.text = itemPost.txtDetail


        binding.fabDetailOpenWebsite.setOnClickListener {
            var url = "https://doraemon.fandom.com/wiki/Doraemon_Wiki"
            when (itemPost.txtTitle) {
                "Doraemon" -> {
                    url = "https://doraemon.fandom.com/wiki/Doraemon"
                }
                "Nobita Nobi" -> {
                    url = "https://doraemon.fandom.com/wiki/Nobita_Nobi"
                }
                "Shizuka Minamoto" -> {
                    url = "https://doraemon.fandom.com/wiki/Shizuka_Minamoto"
                }
                "Takeshi \"Gian\" Gouda" -> {
                    url = "https://doraemon.fandom.com/wiki/Takeshi_Gouda"
                }
                "Suneo Honekawa" -> {
                    url = "https://doraemon.fandom.com/wiki/Suneo_Honekawa"
                }
                "Anywhere Door" -> {
                    url = "https://doraemon.fandom.com/wiki/Anywhere_Door"
                }
                "Take-Copter" -> {
                        url = "https://doraemon.fandom.com/wiki/Take-copter"
                }

                "Time Machine" -> {
                       url =  "https://doraemon.fandom.com/wiki/Time_Machine"
                }

                "Copying Toast" -> {
                    url = "https://doraemon.fandom.com/wiki/Copying_Toast"
                }

                "Small Light" -> {
                    url = "https://doraemon.fandom.com/wiki/Small_Light"
                }

                "Doraemon (2005 anime)" -> {
                    url = "https://doraemon.fandom.com/wiki/Doraemon_(2005_anime)"
                }

                "Doraemon (1979 anime)" -> {
                    url = "https://doraemon.fandom.com/wiki/Doraemon_(1979_anime)"
                }

            }
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }
    }
}
