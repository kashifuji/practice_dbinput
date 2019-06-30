package com.example.dbsample

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.dbsample.adapters.CarAdapter
import com.example.dbsample.data.AppDatabase
import com.example.dbsample.data.Car
import com.example.dbsample.data.CarRepository
import com.example.dbsample.databinding.FragmentCarListBinding
import com.example.dbsample.utilities.InjectorUtils
import com.example.dbsample.viewmodels.CarListViewModel

import kotlinx.android.synthetic.main.fragment_car_list.*
import kotlin.concurrent.thread


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CarListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CarListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CarListFragment : Fragment() {

    private val carListlViewModel: CarListViewModel by viewModels {
        InjectorUtils.provideCarListViewModelFactory(requireActivity())
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var cars: List<Car>? = null

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

        carListlViewModel.cars.observe(this, Observer<List<Car>> { cars ->
            this.cars = cars
            if (!cars.isNullOrEmpty()) {
                Log.v(ContentValues.TAG, "hoge : " + cars.toString())
            }
        })

        val binding = FragmentCarListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = CarAdapter()
        binding.plantList.adapter = adapter
        carListlViewModel.cars.observe(this, Observer<List<Car>> { cars ->
            if (!cars.isNullOrEmpty()) {
                adapter.submitList(cars)
            }
        })

        setHasOptionsMenu(true)
        return binding.root

//        return inflater.inflate(R.layout.fragment_car_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button1.setOnClickListener(){
            Log.v(ContentValues.TAG, "clicked")
            carListlViewModel.addCar(input1.text.toString())
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }


    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
