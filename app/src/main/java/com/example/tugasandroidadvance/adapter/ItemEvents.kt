package com.example.tugasandroidadvance.adapter

import com.example.tugasandroidadvance.data.ItemPost

interface ItemEvents {

    fun onItemClicked(itemPost: ItemPost)

    fun onItemLongClicked(itemPost: ItemPost)

}