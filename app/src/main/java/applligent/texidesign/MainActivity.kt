package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryTv: TextView = findViewById(R.id.tvCountry)
        countryTv.setOnClickListener {
            val intent = Intent(this@MainActivity, NumberActivity::class.java)

            startActivity(intent)
        }
        val number: EditText = findViewById(R.id.etNumber)
        number.setOnClickListener {
            val intent = Intent(this@MainActivity, NumberActivity::class.java)

            startActivity(intent)
        }

    }
}
