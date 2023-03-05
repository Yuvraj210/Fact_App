package social.fact.yuvi_factsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        science.setOnClickListener {
           val imgref="yuvi"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)

        }


        human_body.setOnClickListener {
            val imgref="human_body"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)

        }

        Do_You_Know.setOnClickListener {
            val imgref="do_you_Know"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        Saicologi.setOnClickListener {
            val imgref="Saicology"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        Mobile.setOnClickListener {
            val imgref="Mobile"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        Moon.setOnClickListener {
            val imgref="Moon"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }


        space.setOnClickListener {
            val imgref="Space"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        technology.setOnClickListener {
            val imgref="Technology"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        Sun.setOnClickListener {
            val imgref="Sun"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        khoj.setOnClickListener {
            val imgref="Khoj"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        healthTip.setOnClickListener {
            val imgref="HealthTip"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        AmazingFact.setOnClickListener {
            val imgref="AmazingFact"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        Lifefact.setOnClickListener {
            val imgref="LifeFact"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }

        worldFact.setOnClickListener {
            val imgref="WorldFact"
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("yuvraj",imgref)
            startActivity(intent)
        }




    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Do you want to exit ?")
        builder.setTitle("Alert !")
        builder.setIcon(R.drawable.exit_to_app_24)
        builder.setCancelable(false)
        builder.setInverseBackgroundForced(true)
        builder.setPositiveButton("Yes") {
                dialog, which -> finish()
        }

        builder.setNegativeButton("No") {
                dialog, which -> dialog.cancel()
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}