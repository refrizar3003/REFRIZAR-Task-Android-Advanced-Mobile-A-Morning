package com.example.tugasandroidadvance.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasandroidadvance.data.ItemPost
import com.example.tugasandroidadvance.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data: ArrayList<ItemPost>,private val itemEvents: ItemEvents) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {

    lateinit var binding: ItemTrendBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(itemPost: ItemPost) {

            Glide.with(itemView.context).load(itemPost.imageUrl).transform(
                RoundedCornersTransformation(32,8)
            ).into(binding.itemTrendImgMain)
            binding.itemTrendTxtTitle.text = itemPost.txtTitle
            binding.itemTrendTxtSubtitle.text = itemPost.txtSubtitle
            binding.itemTrendTxtInsight.text = itemPost.insight

            itemView.setOnClickListener {

                itemEvents.onItemClicked(itemPost)
            }

            itemView.setOnLongClickListener {
                itemEvents.onItemLongClicked(itemPost)
                true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {

        binding = ItemTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}