package applligent.texidesign

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class TaxiSelectAdapter(val taxiList: ArrayList<Taxies>) : RecyclerView.Adapter<TaxiSelectAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaxiSelectAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.taxi_adapter, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: TaxiSelectAdapter.ViewHolder, position: Int) {
        holder.bindItems(taxiList[position])

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return taxiList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var imageVehicle: ImageView
        lateinit var textVehicle: TextView
        lateinit var textTime: TextView

        fun bindItems(taxies: Taxies) {
            imageVehicle = itemView.findViewById(R.id.taxi_icon)
            textVehicle = itemView.findViewById(R.id.taxi_name)
            textTime = itemView.findViewById(R.id.taxi_time)



            textVehicle.text = taxies.name
            textTime.text = taxies.time.toString()
            when (textVehicle.text) {
                "mini" -> imageVehicle.setBackgroundResource(R.drawable.india)
                "micro" -> imageVehicle.setBackgroundResource(R.drawable.pakistan)
                "sedan" -> imageVehicle.setBackgroundResource(R.drawable.australia)
                "auto" -> imageVehicle.setBackgroundResource(R.drawable.canada)

            }


        }
    }
}

