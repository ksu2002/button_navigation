package net.intervyaz.viewintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import net.intervyaz.viewintro.databinding.ActivityMainBinding
import net.intervyaz.viewintro.databinding.FragmentSettingsBinding

import androidx.annotation.NonNull
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val fragment_home = FragmentFirst()
        val fragment_settings = SettingsFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, fragment_settings, "fragment_settings")
            .hide(fragment_settings).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, fragment_home, "fragment_home").commit()
        var active = fragment_home
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_1 -> {
                    supportFragmentManager.beginTransaction().hide(active)
                        .show(fragment_home).commit();
                  active = fragment_home;
                    true
                }
                R.id.item_2 -> {
                    supportFragmentManager.beginTransaction().hide(active)
                        .show(fragment_settings).commit();
                   active = fragment_home;
                    true
                }

                else -> false
            }
        }
    }
}
