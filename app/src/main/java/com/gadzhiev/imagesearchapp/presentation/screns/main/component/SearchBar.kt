package com.gadzhiev.imagesearchapp.presentation.screns.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
) {
    val focusManager = LocalFocusManager.current

    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(15.dp)
        ,
    ) {
        TextField(
            value = query,
            onValueChange = {
                onQueryChanged(it)
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = {
                    onQueryChanged("")
                }) {
                    Icon(
                        Icons.Default.Clear, contentDescription = "Clear search"
                    )
                }
            },
            label = if (label != null) {
                {
                    Text(label)
                }
            } else {
                null
            },
            keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                imeAction = ImeAction.Search,
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    focusManager.clearFocus()
                },
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.large),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Prew() {
    SearchBar(query = "Search", onQueryChanged = {})
}