package com.aiglepub.marvelcompose.data.network.entities

data class ApiThumbnail(
    val extension: String,
    val path: String
)

fun ApiThumbnail.asString() = "$path.$extension".replace("http", "https")