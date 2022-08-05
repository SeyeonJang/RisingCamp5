package com.example.risingcamp5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.risingcamp5.databinding.ActivityMainBinding
import com.example.risingcamp5.databinding.FragmentHomeBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        setRv()
    }

    private fun setRv() {
        val adapter = HomeRvAdapter()

        /*
        val linearLayoutManager = LinearLayoutManager(requireActivity())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding!!.homeRv.setLayoutManager(linearLayoutManager) */

        binding?.homeRv?.adapter = adapter
        adapter.getData(returngetData())
    }

    fun returngetData() : MutableList<DataHomeRv> {
        var list = mutableListOf<DataHomeRv>()

        for (i in 0 until 10) {
            Log.d("test log", "$i 로그")
            list.add(DataHomeRv(R.drawable.ic_launcher_background, "$i 번째"))
        }

        return list
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //_binding = FragmentHomeBinding.inflate(inflater)
        // return binding.getRoot()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
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