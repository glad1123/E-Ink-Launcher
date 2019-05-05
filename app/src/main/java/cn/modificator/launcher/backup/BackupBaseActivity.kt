package cn.modificator.launcher.backup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import cn.modificator.launcherlawnchair.R
import cn.modificator.launcher.blur.BlurWallpaperProvider
import cn.modificator.launcher.config.FeatureFlags

@SuppressLint("Registered")
open class BackupBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        FeatureFlags.applyDarkTheme(this)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_settings)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (FeatureFlags.currentTheme != 2)
            BlurWallpaperProvider.applyBlurBackground(this)
    }

    override fun setContentView(v: View) {
        val contentParent = findViewById<ViewGroup>(R.id.content)
        contentParent.removeAllViews()
        contentParent.addView(v)
    }

    override fun setContentView(resId: Int) {
        val contentParent = findViewById<ViewGroup>(R.id.content)
        contentParent.removeAllViews()
        LayoutInflater.from(this).inflate(resId, contentParent)
    }

    override fun setContentView(v: View, lp: ViewGroup.LayoutParams) {
        val contentParent = findViewById<ViewGroup>(R.id.content)
        contentParent.removeAllViews()
        contentParent.addView(v, lp)
    }
}