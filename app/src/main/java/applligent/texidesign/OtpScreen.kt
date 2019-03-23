package applligent.texidesign

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView


class OtpScreen : AppCompatActivity() {

    lateinit var label: TextView
    lateinit var time: TextView

    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var et3: EditText
    lateinit var et4: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_screen)
        label = findViewById(R.id.warning_label)
        time = findViewById(R.id.remaining_time)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        et3 = findViewById(R.id.et3)
        et4 = findViewById(R.id.et4)





        et1.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if (s.length == 1) {
                    et2.requestFocus();
                } else if (s.length == 0) {
                    et1.clearFocus();
                }
            }


            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {

            }

            override fun afterTextChanged(s: Editable) {


            }
        }


        )

        et2.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if (s.length == 1) {
                    et3.requestFocus();
                } else if (s.length == 0) {
                    et2.clearFocus();
                }
            }


            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {

            }

            override fun afterTextChanged(s: Editable) {


            }
        }


        )

        et3.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if (s.length == 1) {
                    et4.requestFocus();
                } else if (s.length == 0) {
                    et3.clearFocus();
                }
            }


            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {

            }

            override fun afterTextChanged(s: Editable) {


            }
        }


        )

        et4.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if (s.length == 1) {
                    var otp: String =
                        et1.text.toString() + et2.text.toString() + et3.text.toString() + et4.text.toString()


                    //Todo: verify if otp matches or not
                    if (otp.equals("1234")) {
                        val intent = Intent(this@OtpScreen, SuccessActivity::class.java)
                        startActivity(intent)
                    } else {
                        //Todo: if otp does not matches


                        label.setTextColor(Color.parseColor("#FFF50004"))


                        label.setText(R.string.warning_label)


                    }


                } else if (s.length == 0) {
                    et4.clearFocus();
                }
            }


            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {

            }

            override fun afterTextChanged(s: Editable) {


            }
        }


        )


    }
}
