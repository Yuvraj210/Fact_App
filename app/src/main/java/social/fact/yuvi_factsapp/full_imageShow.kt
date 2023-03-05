package social.fact.yuvi_factsapp

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.app.DownloadManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_full_image_show.*
import java.io.File
import java.util.*


class full_imageShow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image_show)

        val imageUrl = intent.getStringExtra("image")


        Glide.with(this).load(imageUrl).into(imageShower)
        val DM = getSystemService(DOWNLOAD_SERVICE) as DownloadManager

        Back_Arrow.setOnClickListener {

           onBackPressed()
        }



        next.setOnClickListener {
            requestStoragePermission()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                Toast.makeText(this, "downloading", Toast.LENGTH_SHORT).show()

                val calendar = Calendar.getInstance()
                val timestamp = calendar.timeInMillis

                val filename = "${timestamp}_yuviFact-image.jpg"

                val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path + "/UnifiedClothes/" + filename)

                val request = DownloadManager.Request(Uri.parse(imageUrl)).apply {
                    setTitle("Downloading")
                    setDescription("fact image downloading")
                    setAllowedOverMetered(true)
//                    setDestinationInExternalFilesDir(this@full_imageShow, Environment.DIRECTORY_PICTURES, filename)
                    setDestinationUri(Uri.fromFile(file))
                    setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)

                }
                 DM.enqueue(request)
            }

        }
    }

    private val STORAGE_PERMISSION_CODE = 101
    private fun requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,WRITE_EXTERNAL_STORAGE)) {
                AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("This permission is needed to write to external storage")
                    .setPositiveButton("Ok") { _, _ ->
                        ActivityCompat.requestPermissions(this, arrayOf(WRITE_EXTERNAL_STORAGE), STORAGE_PERMISSION_CODE)
                    }
                    .setNegativeButton("Cancel") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create().show()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(WRITE_EXTERNAL_STORAGE), STORAGE_PERMISSION_CODE)
            }
        } else {
            // Permission has already been granted
        }
    }



}













