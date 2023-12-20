package com.example.fitlife.models.resep

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("recipes")
	val recipes: List<RecipesItem?>? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("pageTotal")
	val pageTotal: Int? = null,

	@field:SerializedName("pageSize")
	val pageSize: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null
)