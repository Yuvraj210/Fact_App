package social.fact.yuvi_factsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fact_row.view.*

class factAdepter(private val context: Context, val imageUrls: ArrayList<FactModal>):RecyclerView.Adapter<factAdepter.ViewHolder>() {
    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val factImage=item.factImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.fact_row,parent,false))
    }

    override fun getItemCount(): Int {
     return imageUrls.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl=imageUrls[position]
       Glide.with(context).load(imageUrl.url)
           .apply(RequestOptions().placeholder(R.drawable.loading)).into(holder.factImage)
        holder.itemView.setOnClickListener {

            val intent=Intent(it.context,full_imageShow::class.java)
            intent.putExtra("image",imageUrls[position].url  )
            intent.putExtra("position",position)

            it.context.startActivity(intent)
        }



    }
}