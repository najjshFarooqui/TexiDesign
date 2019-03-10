package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import applligent.texidesign.R.id.countrySpinner

class NumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        val spinner: Spinner = findViewById(countrySpinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.Country_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter

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
