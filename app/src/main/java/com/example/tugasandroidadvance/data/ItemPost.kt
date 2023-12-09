package com.example.tugasandroidadvance.data

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ItemPost(
    val imageUrl: String,
    val txtTitle: String,
    val txtSubtitle: String,
    val txtDetail: String,

    val isTrend: Boolean,
    val insight: String,

    val showExplore : Boolean,
    val showGadgets: Boolean,
    val showSeries : Boolean
) : Parcelable