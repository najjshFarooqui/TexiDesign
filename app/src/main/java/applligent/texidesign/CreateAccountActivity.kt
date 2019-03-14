package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CreateAccountActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var referralCode: EditText
    lateinit var regButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        val i: Intent = intent
        val number: String = i.extras.getString("number", "")
        val tvNumber: TextView = findViewById(R.id.tvNumber)
        tvNumber.text = number

        name = findViewById(R.id.etName)
        email = findViewById(R.id.etEmail)
        referralCode = findViewById(R.id.etCode)
        regButton = findViewById(R.id.regButton)
        name.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if (s.toString().trim { it <= ' ' }.length == 0) {
                    regButton.isEnabled = false
                } else {
                    regButton.isEnabled = true
                    regButton.setOnClickListener {
                        val intent = Intent(this@CreateAccountActivity, SuccessActivity::class.java)
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
        }


        )
    }
}




