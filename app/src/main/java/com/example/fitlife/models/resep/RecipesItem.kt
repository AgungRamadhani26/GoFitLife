package com.example.fitlife.models.resep

import com.google.gson.annotations.SerializedName

data class RecipesItem(

	@field:SerializedName("duration")
	val duration: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("energy")
	val energy: Int? = null
)