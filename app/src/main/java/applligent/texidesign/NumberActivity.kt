package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout


class NumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        val countryView: RecyclerView = findViewById(R.id.countryView)
        val countryCodeButton: Button = findViewById(R.id.btnId)


        countryView.visibility = View.INVISIBLE


        countryCodeButton.setOnClickListener {
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
            val adapter = CustomAdapter(countries)
            countryView.adapter = adapter


        }

        val etNumber: EditText = findViewById(R.id.etNumber)
        val nxtButton: Button = findViewById(R.id.nxtButton)

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
