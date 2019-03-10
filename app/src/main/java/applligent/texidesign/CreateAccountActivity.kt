package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CreateAccountActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var referralCode: EditText
    val nxtButton: Button = findViewById(R.id.nxtButton)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        val i: Intent = getIntent()
        val number: String = i.getExtras().getString("number", "")
        val tvNumber: TextView = findViewById(R.id.tvNumber)
        tvNumber.setText(number)

        name = findViewById(R.id.etName)
        email = findViewById(R.id.etEmail)
        referralCode = findViewById(R.id.etCode)
        if (name.text.isEmpty() || name.text.equals("") //&& email.text.isEmpty()||name.text.equals("")&& referralCode.text.isEmpty()||name.text.equals("")
        ) {
            nxtButton.isEnabled = false
        } else {


            val nxtButton: Button = findViewById(R.id.nxtButton)
            nxtButton.setOnClickListener {
                val intent = Intent(this@CreateAccountActivity, SuccessActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
