package com.study.bookratingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction: FragmentTransaction = mFragmentManager.beginTransaction()
        val settingFragment = SettingFragment()
        mFragmentTransaction.replace(android.R.id.content, settingFragment)
        mFragmentTransaction.commit()
    }
}