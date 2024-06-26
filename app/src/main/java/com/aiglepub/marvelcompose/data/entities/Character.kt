package com.aiglepub.marvelcompose.data.entities

import com.aiglepub.marvelcompose.data.network.entities.ApiUrl

data class Character(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val thumbnail: String,
    override val references: List<ReferenceList>,
    override val urls: List<Url>
): MarvelItem