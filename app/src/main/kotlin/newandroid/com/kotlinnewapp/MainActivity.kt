package newandroid.com.kotlinnewapp

import android.support.v7.app.AppCompatActivity
import android.support.design.widget.BottomNavigationView
import android.os.Bundle
import android.support.v7.app.ActionBar


class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        BottomNavigationViewHelper.disableShiftMode(bottomNavigation)

    }
}
