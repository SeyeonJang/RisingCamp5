package com.example.risingcamp5

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp5.databinding.ItemHomeRvBinding

class HomeRvAdapter : RecyclerView.Adapter<HomeRvAdapter.HomeRvViewHolder>() {
    private var dataList = mutableListOf<DataHomeRv>()

    inner class HomeRvViewHolder(val binding : ItemHomeRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item : DataHomeRv) {
            binding.imageProduct.setImageResource(item.image)
            binding.titleProduct.text = item.text
            Log.d("log", "bind: $item")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRvViewHolder {
        val layoutinflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeRvBinding.inflate(layoutinflater, parent, false)
        return HomeRvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRvViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }



    fun getData(list : MutableList<DataHomeRv>) {
        Log.d("data log", "$list")
        dataList = list
        notifyDataSetChanged()
    }
}

