package ir.ac.iust.mnc.carino.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.ac.iust.mnc.carino.CarListAdapter
import ir.ac.iust.mnc.carino.R
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.utils.InjectorUtils
import ir.ac.iust.mnc.carino.viewmodels.CarViewModel
import kotlinx.android.synthetic.main.activity_main.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var listCar: RecyclerView
    private lateinit var btnAbout: Button
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        listCar = view.findViewById(R.id.list_car)
        btnAbout = view.findViewById(R.id.btn_about)


        val carList: List<Car> = emptyList();
        val factory = InjectorUtils.provideCarViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(CarViewModel::class.java)
        listCar.layoutManager = LinearLayoutManager(context)
        listCar.adapter = CarListAdapter(carList) {
            Log.i("TEST", "Car " + it + " Clicked")
            val carDetailFragment = CarDetailFragment();
            val bundle: Bundle = Bundle();
            carDetailFragment.arguments = bundle;

            bundle.putInt("car_id", it);
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if (transaction != null) {
                transaction.replace(R.id.nav_host_fragment, carDetailFragment)
                transaction.addToBackStack(null)
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                transaction.commit()
            }
        };

        viewModel.getCars().observe(viewLifecycleOwner, Observer { cars ->
            if (cars != null) {
                if (listCar.adapter != null)
                    (listCar.adapter as CarListAdapter).setCars(cars = cars)
            }
        });

        btnAbout.setOnClickListener {
            Log.i("TEST", "About Us Clicked!")
            val aboutUsFragment = AboutUsFragment();
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if (transaction != null) {
                transaction.replace(R.id.nav_host_fragment, aboutUsFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}