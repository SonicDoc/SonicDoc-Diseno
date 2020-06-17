package com.example.sonicdocv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.sonicdocv2.fragments.DoctorFragment
import com.example.sonicdocv2.fragments.ProfileFragment
import com.example.sonicdocv2.fragments.ReservaFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = "MainActivity"

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    //btm Navigation
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        navigateTo(item)
    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, getFragmentFor(item))
            .addToBackStack(getFragmentFor(item).toString())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit() > 0
    }

    //btm Navigation destination
    private fun getFragmentFor(item: MenuItem): Fragment {
        return when(item.itemId) {
            R.id.menu_citas -> ReservaFragment()
            R.id.menu_doctores -> DoctorFragment()
            R.id.menu_perfil -> ProfileFragment()
            else -> ReservaFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent: Intent = intent
        val msgLogin = intent.getStringExtra("username")
        Toast.makeText(this,"Bienvenido $msgLogin",Toast.LENGTH_LONG).show()

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        //btmNavigation
        //btm_navView.selectedItemId = R.id.menu_citas
        val btm_navView: BottomNavigationView = findViewById(R.id.btm_navView)
        btm_navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    //drawer Navigation
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_citasAnteriores -> {
                Toast.makeText(this, "Citas anteriores", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_editarPerfil -> {
                Toast.makeText(this, "Editar Perfil", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Cerrar Sesión", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}
