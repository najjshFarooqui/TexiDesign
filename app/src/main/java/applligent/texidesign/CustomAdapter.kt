package applligent.texidesign

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val userList: ArrayList<Countries>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var imageFlag: ImageView
        lateinit var textCountry: TextView
        lateinit var textViewCode: TextView

        fun bindItems(countries: Countries) {
            imageFlag = itemView.findViewById(R.id.countryIcon)

            textCountry = itemView.findViewById(R.id.tvCountry)
            textViewCode = itemView.findViewById(R.id.tvCode)
            textCountry.text = countries.name
            textViewCode.text = countries.code
            when (textViewCode.text) {
                "+91" -> imageFlag.setBackgroundResource(R.drawable.india)
                "+92" -> imageFlag.setBackgroundResource(R.drawable.pakistan)
                "+08" -> imageFlag.setBackgroundResource(R.drawable.australia)
                "+02" -> imageFlag.setBackgroundResource(R.drawable.canada)
            }


        }
    }
}