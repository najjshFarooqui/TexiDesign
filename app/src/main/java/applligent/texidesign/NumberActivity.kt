package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*


class NumberActivity : AppCompatActivity() {

    lateinit var etNumber: EditText
    lateinit var nxtButton: Button
    lateinit var countryIcon: ImageView
    lateinit var countryCode: TextView

    lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        val countryView: RecyclerView = findViewById(R.id.countryView)
        val linearLayout: LinearLayout = findViewById(R.id.lLayout)
        etNumber = findViewById(R.id.etNumber)
        nxtButton = findViewById(R.id.nxtButton)
        countryIcon = findViewById(R.id.countryIcon)
        countryCode = findViewById(R.id.countryCode)

        countryView.visibility = View.INVISIBLE


        linearLayout.setOnClickListener {
            etNumber.visibility = View.INVISIBLE
            nxtButton.visibility = View.INVISIBLE
            linearLayout.visibility = View.INVISIBLE
            countryView.visibility = View.VISIBLE


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


        }
        countryView.setOnClickListener {
            etNumber.visibility = View.VISIBLE
            nxtButton.visibility = View.VISIBLE
            linearLayout.visibility = View.VISIBLE
            countryView.visibility = View.INVISIBLE


        }



        etNumber.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if (s.toString().trim { it <= ' ' }.length == 0) {
                    nxtButton.isEnabled = false
                } else {
                    nxtButton.isEnabled = true
                    nxtButton.setOnClickListener {
                        val intent = Intent(this@NumberActivity, CreateAccountActivity::class.java)
                        intent.putExtra("number", etNumber.text.toString())
                        startActivity(intent)


                    }
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


        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this@NumberActivity, MainActivity::class.java)

            startActivity(intent)

        }
    }
}
