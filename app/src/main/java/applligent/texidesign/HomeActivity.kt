package applligent.texidesign

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView


class HomeActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    lateinit var tvRides: Button
    lateinit var tvRentals: Button
    lateinit var tvOutstations: Button
    lateinit var iconNotification: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("")
        setSupportActionBar(toolbar)
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        tvRides = toolbar.findViewById(R.id.rides)
        tvRides.setOnClickListener {

            tvRides.setBackgroundColor(R.drawable.round_button)


        }

        tvRentals = toolbar.findViewById(R.id.rentals)
        tvRentals.setOnClickListener {

            tvRentals.setBackgroundColor(R.drawable.round_button)


        }
        tvOutstations = toolbar.findViewById(R.id.outstations)
        tvOutstations.setOnClickListener {

            tvOutstations.setBackgroundColor(R.drawable.round_button)


        }


        drawerLayout = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawerLayout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}


