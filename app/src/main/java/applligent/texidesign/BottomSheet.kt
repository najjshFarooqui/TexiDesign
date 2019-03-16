package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.widget.*

class BottomSheet : AppCompatActivity() {
    lateinit var etNumber: EditText
    lateinit var adapter: CustomAdapter
    lateinit var nxtButton: Button
    lateinit var tvBanner: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)
        val countryView: RecyclerView = findViewById(R.id.countryView)
        etNumber = findViewById(R.id.etNumber)
        nxtButton = findViewById(R.id.nxtButton)
        tvBanner = findViewById(R.id.tvBanner)
        countryView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val countries = ArrayList<Countries>()
        countries.add(Countries("India", "+91"))
        countries.add(Countries("Pakistan", "+92"))
        countries.add(Countries("Australia", "+08"))
        countries.add(Countries("Canada", "+02"))
        countries.add(Countries("India", "+91"))
        countries.add(Countries("Pakistan", "+92"))
        countries.add(Countries("Australia", "+08"))
        countries.add(Countries("Canada", "+02"))
        countries.add(Countries("India", "+91"))
        countries.add(Countries("Pakistan", "+92"))
        countries.add(Countries("Australia", "+08"))
        countries.add(Countries("Canada", "+02"))
        countries.add(Countries("India", "+91"))
        countries.add(Countries("Pakistan", "+92"))
        countries.add(Countries("Australia", "+08"))
        countries.add(Countries("Canada", "+02"))
        countries.add(Countries("India", "+91"))
        countries.add(Countries("Pakistan", "+92"))
        countries.add(Countries("Australia", "+08"))
        countries.add(Countries("Canada", "+02"))
        countries.add(Countries("India", "+91"))
        countries.add(Countries("Pakistan", "+92"))
        countries.add(Countries("Australia", "+08"))
        countries.add(Countries("Canada", "+02"))
        adapter = CustomAdapter(countries)
        countryView.adapter = adapter


        etNumber.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if (s.toString().trim { it <= ' ' }.length == 0) {
                    nxtButton.isEnabled = false
                } else {
                    nxtButton.isEnabled = true
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
                // TODO Auto-generated method stub

            }

            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub

            }
        })


        nxtButton.setOnClickListener {
            val intent = Intent(this@BottomSheet, MapsActivity::class.java)

            startActivity(intent)

        }
        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this@BottomSheet, MapsActivity::class.java)
            intent.putExtra("getNumber", etNumber.text.toString())
            startActivity(intent)

        }


    }
}
