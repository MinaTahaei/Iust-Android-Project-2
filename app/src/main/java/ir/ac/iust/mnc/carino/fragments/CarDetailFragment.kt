package ir.ac.iust.mnc.carino.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import ir.ac.iust.mnc.carino.CarListAdapter
import ir.ac.iust.mnc.carino.R
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.utils.DownloadImageFromInternet
import ir.ac.iust.mnc.carino.utils.InjectorUtils
import ir.ac.iust.mnc.carino.viewmodels.CarViewModel
import kotlinx.android.synthetic.main.fragment_car_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "car_id"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var car_id: Int = -1
    private var param2: String? = null
    private lateinit var carImage: ImageView
    private lateinit var carTitle: TextView
    private lateinit var carYear: TextView
    private lateinit var carKilometer: TextView
    private lateinit var carCompany: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            car_id = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_car_detail, container, false)
        carImage = view.findViewById(R.id.img_car)
        carTitle = view.findViewById(R.id.txt_title)
        carYear = view.findViewById(R.id.txt_year)
        carCompany = view.findViewById(R.id.manufacturerV)
        carKilometer = view.findViewById(R.id.distanceV)
        Log.i("TEST", "Car ID is " + this.car_id);
        val factory = InjectorUtils.provideCarViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(CarViewModel::class.java)
        val car: Car = viewModel.getCar(car_id)
        carTitle.text = car.name
        carYear.text = car.year.toString()
        carCompany.text = car.company
        carKilometer.text = car.kilometer.toString()
        DownloadImageFromInternet(carImage).execute(car.image_path)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}