package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout


class NumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        val countryCode: Button = findViewById(R.id.btnId)
        countryCode.setOnClickListener {
            val countryView: RecyclerView = findViewById(R.id.countryView)
            countryView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
            val countries = ArrayList<User>()
            countries.add(User("India", "+91"))
            countries.add(User("Pakistan", "+92"))
            countries.add(User("Australia", "08"))
            countries.add(User("Canada", "+02"))
            val adapter = CustomAdapter(countries)

            //now adding the adapter to recyclerview
            countryView.adapter = adapter

        }
        val etNumber: EditText = findViewById(R.id.etNumber)
        val nxtButton: Button = findViewById(R.id.nxtButton)
        nxtButton.setOnClickListener {
            val intent = Intent(this@NumberActivity, CreateAccountActivity::class.java)
            intent.putExtra("number", etNumber.text.toString())
            startActivity(intent)


        }

        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this@NumberActivity, MainActivity::class.java)

            startActivity(intent)

        }
    }
}
