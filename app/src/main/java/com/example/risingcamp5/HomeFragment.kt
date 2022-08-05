package com.example.risingcamp5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.risingcamp5.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    private val rvAdapter by lazy {
        HomeRvAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        setRv()

        return binding.root
    }

    private fun setRv() {
        binding.homeRv.adapter = rvAdapter
        rvAdapter.getData(returngetData())
    }

    fun returngetData() : MutableList<DataHomeRv> {
        var list = mutableListOf<DataHomeRv>()

        for (i in 0 until 10) {
            Log.d("test log", "$i 로그")
            list.add(DataHomeRv(R.drawable.ic_launcher_background, "$i 번째"))
        }

        return list
    }
}