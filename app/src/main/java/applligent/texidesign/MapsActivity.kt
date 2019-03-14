package applligent.texidesign


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException
import java.util.*

class MapsActivity : FragmentActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    lateinit var locationManager: LocationManager

    lateinit var locationListener: LocationListener

    lateinit var btnNow: Button
    lateinit var btnlater: Button
    lateinit var mapView: RelativeLayout
    lateinit var pickSearch: android.support.v7.widget.SearchView
    lateinit var dropSearch: SearchView
    lateinit var searchViews: RelativeLayout
    lateinit var linearLayout: LinearLayout


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {

            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    run {

                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)

                    }

                }

            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        btnNow = findViewById(R.id.rideNowBtn)
        btnlater = findViewById(R.id.rideLaterBtn)
        mapView = findViewById(R.id.mapView)
        pickSearch = findViewById(R.id.pick)
        dropSearch = findViewById(R.id.drop)
        searchViews = findViewById(R.id.searchLayout)
        linearLayout = findViewById(R.id.btnLayout)


        mapView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN ->
                        linearLayout.visibility = View.INVISIBLE

                }

                return v?.onTouchEvent(event) ?: true
            }
        })


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {

                val userLocation = LatLng(location.latitude, location.longitude)

                mMap!!.clear()
                mMap!!.addMarker(MarkerOptions().position(userLocation).title("Your Location"))
                mMap!!.moveCamera(CameraUpdateFactory.newLatLng(userLocation))

                val geocoder = Geocoder(applicationContext, Locale.getDefault())

                try {

                    val listAddresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)

                    if (listAddresses != null && listAddresses.size > 0) {

                        Log.i("PlaceInfo", listAddresses[0].toString())

                        var address = ""

                        if (listAddresses[0].subThoroughfare != null) {

                            address += listAddresses[0].subThoroughfare + " "

                        }

                        if (listAddresses[0].thoroughfare != null) {

                            address += listAddresses[0].thoroughfare + ", "

                        }

                        if (listAddresses[0].locality != null) {

                            address += listAddresses[0].locality + ", "

                        }

                        if (listAddresses[0].postalCode != null) {

                            address += listAddresses[0].postalCode + ", "

                        }

                        if (listAddresses[0].countryName != null) {

                            address += listAddresses[0].countryName

                        }

                        Toast.makeText(this@MapsActivity, address, Toast.LENGTH_SHORT).show()

                    }

                } catch (e: IOException) {

                    e.printStackTrace()

                }

            }

            override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {

            }

            override fun onProviderEnabled(s: String) {

            }

            override fun onProviderDisabled(s: String) {

            }
        }

        if (Build.VERSION.SDK_INT < 23) {
            try {


                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
            } catch (se: SecurityException) {
                println(se)
            }
        } else {

            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)

            } else {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)

                val lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

                val userLocation = LatLng(lastKnownLocation.latitude, lastKnownLocation.longitude)
                mMap!!.clear()

                mMap!!.addMarker(MarkerOptions().position(userLocation).title("Your Location"))
                mMap!!.moveCamera(CameraUpdateFactory.newLatLng(userLocation))


            }


        }


    }
}
