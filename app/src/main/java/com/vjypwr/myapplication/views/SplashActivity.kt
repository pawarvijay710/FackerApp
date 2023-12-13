package com.vjypwr.myapplication.views

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vjypwr.myapplication.R
import com.vjypwr.myapplication.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val path = "android.resource://" + packageName + "/" + R.raw.fake_app_splash
        binding.splashVideoVIew.setOnCompletionListener(MediaPlayer.OnCompletionListener {
            startActivity(Intent(this, UserManagementActivity::class.java))
            finish()
        })

        binding.splashVideoVIew.setVideoPath(path)
        binding.splashVideoVIew.start()

    }
}