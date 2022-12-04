package com.study.bookratingapplication


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.CheckBoxPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SeekBarPreference


class SettingFragment : PreferenceFragmentCompat() {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_visualizer)

        val changeDisplay = preferenceManager.findPreference("change_theme") as CheckBoxPreference?
        changeDisplay?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { preference, newValue ->

                Toast.makeText(context, newValue.toString(), Toast.LENGTH_LONG).show()
                if (newValue == true) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else if (newValue == false) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                true
            }


    }

}

