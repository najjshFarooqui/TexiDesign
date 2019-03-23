package applligent.texidesign


import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    private var mMap: GoogleMap? = null
    private lateinit var drawerLayout: DrawerLayout
    lateinit var adapter: TaxiSelectAdapter
    lateinit var continueButton: Button
    lateinit var linearButtonLayout: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

        val view = LayoutInflater.from(applicationContext).inflate(R.layout.tool_bar, null, false)
        val rides = view.findViewById(R.id.rides) as TextView
        val rentals = view.findViewById(R.id.rentals) as TextView
        val outstations = view.findViewById(R.id.outstations) as TextView
        val menu = view.findViewById(R.id.menu) as ImageView
        val notifications = view.findViewById(R.id.notification) as ImageView
        val navBar = findViewById(R.id.drawer_layout) as DrawerLayout
        continueButton = findViewById(R.id.btn_continue)
        linearButtonLayout = findViewById(R.id.buttons)


        val includedLayout = findViewById(R.id.cab_selector) as View

        val taxiView: RecyclerView = includedLayout.findViewById(R.id.cabs)


        taxiView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val taxies = ArrayList<Taxies>()
        taxies.add(Taxies("mini", "+91"))
        taxies.add(Taxies("micro", "+92"))
        taxies.add(Taxies("Auto", "+08"))
        taxies.add(Taxies("Sedan", "+02"))
        adapter = TaxiSelectAdapter(taxies)
        taxiView.adapter = adapter
        continueButton.setOnClickListener {
            continueButton.visibility = View.INVISIBLE
            linearButtonLayout.visibility = View.VISIBLE
            includedLayout.visibility = View.VISIBLE
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney, Australia, and move the camera.
        val sydney = LatLng(-34.0, 151.0)
        mMap!!.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))
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


