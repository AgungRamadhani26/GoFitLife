package com.example.fitlife.models.resep

import com.google.gson.annotations.SerializedName

data class ResponseResep(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: Any? = null,

	@field:SerializedName("status")
	val status: String? = null
)