package applligent.texidesign

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_succcess)

        val varContinue: TextView = findViewById(R.id.tvContinue)
        varContinue.setOnClickListener {
            val intent = Intent(this@SuccessActivity, HomeActivity::class.java)
            startActivity(intent)


        }
    }
}