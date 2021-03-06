package com.example.pazar4

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pazar4.Models.Oglas
import com.example.pazar4.ViewModels.ShopViewModel
import com.example.pazar4.databinding.ActivityBasicBinding
import kotlin.coroutines.coroutineContext


class BasicActivity : AppCompatActivity() {

 //   private val OglasViewModel : ShopViewModel = ShopViewModel(this.application)

    private lateinit var shopViewModel: ShopViewModel

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityBasicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        shopViewModel = ViewModelProvider(this).get(ShopViewModel :: class.java)

        binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_basic)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_basic)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun FetchAllOglasi() : List<Oglas>?{

        return shopViewModel.getOglasi()
    }

    fun FetchOglasById(id: Long): Oglas? {

        Toast.makeText(this, "Fetching oglas with Id + " + id.toString(), Toast.LENGTH_LONG).show()

        return shopViewModel.findOglasById(id)


    }

}