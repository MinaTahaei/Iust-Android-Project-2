package ir.ac.iust.mnc.carino

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.utils.DownloadImageFromInternet

class CarListAdapter(private var carList: List<Car>, private val onItemClicked: (Int) -> Unit): RecyclerView.Adapter<CarListAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val carTitle: TextView
        val carYear: TextView
        val carImage: ImageView

        init {
            Log.i("TEST", "TEST: " + view)
            carTitle = view.findViewById(R.id.txt_title)
            carYear = view.findViewById(R.id.txt_year)
            carImage = view.findViewById(R.id.img_car)
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
        val car: Car = carList[position];
        holder.carTitle.text = car.name
        holder.carYear.text = car.year.toString()
        DownloadImageFromInternet(holder.carImage).execute(car.image_path)
        holder.itemView.setOnClickListener {
            onItemClicked(position)
        }
    }

    fun setCars(cars: List<Car>){
        this.carList = cars;
        notifyDataSetChanged()
    }

}