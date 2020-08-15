package com.example.urbandictionaryandroid

import com.google.gson.annotations.SerializedName

data class DefineTermResponse(
    @SerializedName("list")
    val terms: List<Term>
)