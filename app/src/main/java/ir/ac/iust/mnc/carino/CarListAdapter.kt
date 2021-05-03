package ir.ac.iust.mnc.carino

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import ir.ac.iust.mnc.carino.data.Car

class CarListAdapter(private var carList: List<Car>): RecyclerView.Adapter<CarListAdapter.ViewHolder>() {

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

    @SuppressLint("StaticFieldLeak")
    @Suppress("DEPRECATION")
    private inner class DownloadImageFromInternet(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
            }
            catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
            return image
        }
        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
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
        holder.carYear.text = carList[position].year.toString()
        DownloadImageFromInternet(holder.carImage).execute(carList[position].image_path)
    }

    fun setCars(cars: List<Car>){
        this.carList = cars;
        notifyDataSetChanged()
    }

}