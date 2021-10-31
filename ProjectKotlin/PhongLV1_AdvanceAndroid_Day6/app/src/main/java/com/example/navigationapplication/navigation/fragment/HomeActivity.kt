package com.example.navigationapplication.navigation.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.navigationapplication.R
import com.example.navigationapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityHomeBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostHomeFragment =
            supportFragmentManager.findFragmentById(R.id.navHostHomeFragment) as NavHostFragment
        navController = navHostHomeFragment.navController
        setSupportActionBar(binding.toolBar)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.chatFragment, R.id.groupFragment),
            binding.drawerHome
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.navHome.setupWithNavController(navController)
        binding.bnvHome.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}