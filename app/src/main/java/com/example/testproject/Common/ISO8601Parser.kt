package com.example.testproject.Common

import android.annotation.SuppressLint
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

object ISO8601Parser {
        @SuppressLint("SimpleDateFormat")
        fun parse(params: String): Date {
            var input = params

            val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz")

            input = if (input.endsWith("2"))
                input.substring(0, input.length - 1) + "GMT-00:00"
            else {
                val inset = 6
                val startText = input.subSequence(0, input.length - inset)
                val endText = input.substring(input.length - inset, input.length)

                StringBuilder(startText).append("GMT").append(endText).toString()
            }
            return df.parse(input)
        }
}