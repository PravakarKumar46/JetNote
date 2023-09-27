package com.example.jetnote.util

import java.text.SimpleDateFormat
import java.util.*

fun formateDate(time: Long): String{

    val date = Date(time)
    val formate = SimpleDateFormat("EEE, d, MMM, hh:mm aaa", Locale.getDefault())

    return formate.format(date)
}