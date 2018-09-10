package newandroid.com.kotlinnewapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.Fragment
import newandroid.com.kotlinnewapp.presentation.MainPresenter
import newandroid.com.kotlinnewapp.view.*



class MainActivity : AppCompatActivity(), MainView {


    val homeFragment = HomeFragment()
    val speakersFragment = SpeakersFragment()
    val favoritesFragment = FavoritesFragment()
    val sponsorsFragment = SponsorsFragment()
    val moreFragment = MoreFragment ()

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //toolbar_title.text = getString(R.string.programa)
        toolbar_title.setTextColor(Color.WHITE)

        //val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        BottomNavigationViewHelper.disableShiftMode(navigationView)

        navigationView.setOnNavigationItemSelectedListener {

            when(it.itemId){

                R.id.navigation_home -> {
                    replaceFragment(homeFragment)
                    presenter.setToolbarText()
                }
                R.id.navigation_speakers -> {
                    replaceFragment(speakersFragment)
                    toolbar_title.text = "Ponentes"
                }
                R.id.navigation_favorites -> {
                    replaceFragment(favoritesFragment)
                    toolbar_title.text = "Favoritos"
                }
                R.id.navigation_sponsors -> {
                    replaceFragment(favoritesFragment)
                    toolbar_title.text = "Patrocinadores"
                }
                R.id.navigation_more -> {
                    replaceFragment(favoritesFragment)
                    toolbar_title.text = "Más"
                }
            }
            true
        }
        navigationView.selectedItemId = R.id.navigation_home


    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun setToolbarText(text:String){
            toolbar_title.text = text
    }

    override fun setMainTitle(text:String){
            setTitle(text)
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
