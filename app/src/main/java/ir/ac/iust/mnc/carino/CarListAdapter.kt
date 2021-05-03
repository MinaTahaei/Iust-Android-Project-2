package ir.ac.iust.mnc.carino

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.ac.iust.mnc.carino.data.Car

class CarListAdapter(private val carList: List<Car>): RecyclerView.Adapter<CarListAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val carTitle: TextView
        val carYear: TextView

        init {
            Log.i("TEST", "TEST: " + view)
            carTitle = view.findViewById(R.id.txt_title)
            carYear = view.findViewById(R.id.txt_year)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carTitle.text = carList[position].name
        holder.carYear.text = carList[position].price.toString()
    }

}