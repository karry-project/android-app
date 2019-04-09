package myapp.com.karry.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*
import myapp.com.karry.R
import myapp.com.karry.fragments.ChatFragment
import myapp.com.karry.fragments.ProfileFragment
import myapp.com.karry.fragments.SearchFragment
import myapp.com.karry.fragments.TripsFragment

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
                replaceFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_trips -> {
                replaceFragment(TripsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_chat-> {
                replaceFragment(ChatFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup fragments
        if (savedInstanceState == null) {
            navigation.isSelected
            navigation.selectedItemId = R.id.navigation_search
            replaceFragment(SearchFragment())
        }
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

     private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
