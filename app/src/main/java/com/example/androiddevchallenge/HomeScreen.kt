/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

val collection1 = listOf(
    "Short mantras" to R.drawable.pexels_ruvim,
    "Stress and anxiety" to R.drawable.pexels_jim,
    "Overwhelmed" to R.drawable.pexels_ruvim
)
val collection2 = listOf(
    "Nature meditations" to R.drawable.pexels_nothing_ahead,
    "Self-massage" to R.drawable.pexels_scott_webb,
    "Nightly wind down" to R.drawable.pexels_jakub_novacek
)
val body = listOf(
    "Inversions" to R.drawable.pexels_chevanon_photography,
    "Quick yoga" to R.drawable.pexels_agung_pandit_wiguna,
    "Stretching" to R.drawable.pexels_cliff_booth,
    "Tabata" to R.drawable.pexels_elly_fairytale_variant,
    "HIIT" to R.drawable.pexels_the_lazy_artist_gallery,
    "Pre-natal yoga" to R.drawable.pexels_freestocksorg
)
val mind = listOf(
    "Meditate" to R.drawable.pexels_elly_fairytale,
    "With kids" to R.drawable.pexels_valeria_ushakova,
    "Aromatherapy" to R.drawable.pexels_karolina_grabowska,
    "On the go" to R.drawable.pexels_suraphat_nueaon,
    "With pets" to R.drawable.pexels_cottonbro,
    "High stress" to R.drawable.pexels_nathan_cowley
)

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(top = 56.dp, start = 16.dp)
            .verticalScroll(scrollState)
    ) {
        TextField(
            value = search,
            onValueChange = { search = it },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
            leadingIcon = { Icon(Icons.Default.Search, null, Modifier.size(18.dp)) },
            label = { Text("Search", style = MaterialTheme.typography.body1) },
            modifier = Modifier
                .padding(end = 16.dp)
                .height(56.dp)
                .fillMaxWidth()
        )
        Text(
            text = "FAVORITE COLLECTIONS",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(collection1) { collection ->
                Surface(
                    shape = MaterialTheme.shapes.small
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = collection.second),
                            contentDescription = null,
                            modifier = Modifier.size(56.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = collection.first, style = MaterialTheme.typography.h3, modifier = Modifier.width(112.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(collection2) { collection ->
                Surface(
                    shape = MaterialTheme.shapes.small
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = collection.second),
                            contentDescription = null,
                            modifier = Modifier.size(56.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = collection.first, style = MaterialTheme.typography.h3, modifier = Modifier.width(112.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Text(
            text = "ALIGN YOUR BODY",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(body) { collection ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = collection.second),
                        contentDescription = null,
                        modifier = Modifier
                            .size(88.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = collection.first, style = MaterialTheme.typography.h3, modifier = Modifier.paddingFromBaseline(top = 24.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Text(
            text = "ALIGN YOUR MIND",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(mind) { collection ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = collection.second),
                        contentDescription = null,
                        modifier = Modifier
                            .size(88.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = collection.first, style = MaterialTheme.typography.h3, modifier = Modifier.paddingFromBaseline(top = 24.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}
