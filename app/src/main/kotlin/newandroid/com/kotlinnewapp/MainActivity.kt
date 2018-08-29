package newandroid.com.kotlinnewapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setTitle("")
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar_title.text = getString(R.string.programa)
        toolbar_title.setTextColor(Color.WHITE)

        //val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        BottomNavigationViewHelper.disableShiftMode(navigationView)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
