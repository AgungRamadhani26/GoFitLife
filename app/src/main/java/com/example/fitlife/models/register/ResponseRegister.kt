package com.example.fitlife.models.register

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)