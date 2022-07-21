package com.example.water_drinking_whale.presentation.notice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.water_drinking_whale.data.notice.Time
import com.example.water_drinking_whale.databinding.NoticeBinding
import java.util.ArrayList

class NoticeAdapter : RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {
    var items = ArrayList<Time>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: NoticeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setItem(item: Time) {
            binding.ampmTv.text = item.am_pm
            binding.hourTv.text = item.hour.toString()
            binding.minuteTv.text = item.minute.toString()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
