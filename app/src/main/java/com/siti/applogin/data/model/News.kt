package com.siti.applogin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val nama_wisata: String =" ",
    val lokasi_wisata: String= " ",
    val keterangan: String= " ",
    val gambar: String=" "



) : Parcelable
