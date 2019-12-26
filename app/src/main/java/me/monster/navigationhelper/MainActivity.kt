package me.monster.navigationhelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.monster.navigationhelper.lib.KeepStateNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.fragment)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment?
        val navigator = KeepStateNavigator(this, navHostFragment!!.childFragmentManager, R.id.fragment)
        navController.navigatorProvider.addNavigator(navigator)
        navController.setGraph(R.navigation.demo_navigation)
    }
}
