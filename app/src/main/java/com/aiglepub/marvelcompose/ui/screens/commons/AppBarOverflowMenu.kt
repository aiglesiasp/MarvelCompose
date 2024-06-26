package com.aiglepub.marvelcompose.ui.screens.commons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalUriHandler
import com.aiglepub.marvelcompose.data.entities.Url

@Composable
fun AppBarOverflowMenu(urls: List<Url>) {
    if(urls.isEmpty()) return

    var showMenu by remember { mutableStateOf(false) }
    val uriHandler = LocalUriHandler.current

    IconButton(onClick = { showMenu = !showMenu }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More Actions"
        )
        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            urls.forEach {
                DropdownMenuItem(
                    text = { ListItem({ Text(text = it.type) }) },
                    onClick = {
                        uriHandler.openUri(it.destination)
                        showMenu = false
                    }
                )
            }
        }
    }
}