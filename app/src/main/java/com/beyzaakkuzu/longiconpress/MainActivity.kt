package com.beyzaakkuzu.iconlongpress

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.beyzaakkuzu.longiconpress.R
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongThread")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val shortcutManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            getSystemService(ShortcutManager::class.java)
        } else {
            TODO("VERSION.SDK_INT < N_MR1")
        }


        val info1= ShortcutInfo.Builder(this, "ID1")
            .setShortLabel("Yeni Sunu Oluştur")
            .setLongLabel("Open Android Page")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_launcher_foreground))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://programmerworld.co/android/")))
            .build()

        val info2 = ShortcutInfo.Builder(this, "ID2")
            .setShortLabel("Şablon Seç")
            .setLongLabel("Open Android Page")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_launcher_foreground))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://programmerworld.co/android/")))
            .build()

        val info3 = ShortcutInfo.Builder(this, "ID3")
            .setShortLabel("Şablon Seç")
            .setLongLabel("Open Android Page")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_launcher_foreground))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://programmerworld.co/android/")))
            .build()

        val shortcutInfoList: MutableList<ShortcutInfo> = ArrayList()
        shortcutInfoList.add(info1)
        shortcutInfoList.add(info2)
        shortcutInfoList.add(info3)
        shortcutManager.dynamicShortcuts = shortcutInfoList
    }
}