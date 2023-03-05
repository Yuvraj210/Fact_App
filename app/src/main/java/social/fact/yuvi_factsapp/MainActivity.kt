package social.fact.yuvi_factsapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    lateinit var adapter: factAdepter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arr= ArrayList<FactModal>()

        val folderpath = intent.getStringExtra("yuvraj")
        val imgref= Firebase.storage.reference.child(folderpath.toString())

        imgref.listAll().addOnSuccessListener {

            for (result in it.items){
                result.downloadUrl.addOnCompleteListener {
                    Log.d("url",it.result.toString())
                    arr.add(FactModal(it.result.toString()))
                    adapter.notifyDataSetChanged()
                }
            }
            adapter = factAdepter(this, arr)
            RecyclerImage.adapter = adapter

        }
        RecyclerImage.layoutManager = LinearLayoutManager(this)



        MenuButton.setOnClickListener {
            if (FullDrawer_layout.isDrawerOpen(Gravity.LEFT)){

               FullDrawer_layout.closeDrawer(Gravity.LEFT)
            }
            else
            {
                FullDrawer_layout.openDrawer(Gravity.LEFT)
            }
        }

        navigationView.setNavigationItemSelectedListener {

            when(it.itemId)
            {

                R.id.NShare->{
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here")
                    val app_url = " https://play.google.com/store/apps/details?id=chat.social.shayariapp"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, app_url)
                    startActivity(Intent.createChooser(shareIntent, "Share via"))
                    true
                }

                R.id.NRate->{
                    val uri = Uri.parse("market://details?id=$packageName")
                    val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
                    try {
                        startActivity(myAppLinkToMarket)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
                    }

                    true}
                R.id.NMore->{
                    try {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
                    } catch (e: ActivityNotFoundException) {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
                    }
                    true}

                else-> false
            }

        }


    }

    override fun onBackPressed() {

        if (FullDrawer_layout.isDrawerOpen(Gravity.LEFT)){
           FullDrawer_layout.closeDrawer(Gravity.LEFT)
        }
        else
        {
            super.onBackPressed()
        }



    }


}
