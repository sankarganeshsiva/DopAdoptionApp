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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.data.Adoption
import com.example.androiddevchallenge.data.AdoptionData
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage


class MainActivity : AppCompatActivity() {
    private lateinit var title:String
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title= intent.getStringExtra("title")?:"Featured"
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }


    // Start building your app here!
    @ExperimentalFoundationApi
    @Composable
    fun MyApp() {
        Column {
            TopAppBar(
                // in below line we are
                // adding title to our top bar.
                title = {
                    // inside title we are
                    // adding text to our toolbar.
                    Text(
                        text = title,
                        // below line is use
                        // to give text color.
                        color = MaterialTheme.colors.onSurface
                    )
                },
                navigationIcon = {
                    // navigation icon is use
                    // for drawer icon.
                    IconButton(onClick = {onBackPressed() }) {
                        // below line is use to
                        // specify navigation icon.
                        Icon(imageVector = Icons.Filled.ArrowBack,contentDescription = "",tint =  MaterialTheme.colors.onSurface)
                    }
                },
                // below line is use to give background color
                backgroundColor = MaterialTheme.colors.background,

                // content color is use to give
                // color to our content in our toolbar.
                contentColor = MaterialTheme.colors.onSurface,

                // below line is use to give
                // elevation to our toolbar.
                elevation = 0.dp
            )
            AddGridLayout()

        }

    }

    @ExperimentalFoundationApi
    @Composable
    fun AddGridLayout() {
        Surface(color = MaterialTheme.colors.background) {
            AddDogsGrid(AdoptionData.adoptionsAvailable)
        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun AddDogsGrid(adoptions: List<Adoption>) {
        Column {
            LazyVerticalGrid(cells = GridCells.Fixed(2)) {
                items(adoptions.size) { photo ->
                    DogListItemCard(adoptions[photo])
                }
            }
        }
    }

    @Composable
    fun DogListItemCard(adoption: Adoption) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clickable { redirectToDetails(adoption) }, elevation = 2.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                IconButton(modifier = Modifier.then(
                    Modifier
                        .size(24.dp)
                        .align(Alignment.End)
                ),
                    onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                CoilImage(
                    data = adoption.dog.image,
                    contentDescription = "My content description",
                    loading = {
                        Box(Modifier.fillMaxSize()) {
                            CircularProgressIndicator(
                                Modifier.align(Alignment.Center),
                                color = MaterialTheme.colors.primary
                            )
                        }
                    },
                    requestBuilder = {
                        transformations(CircleCropTransformation())
                    },
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(75.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = adoption.dog.name,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    fontWeight = Bold,
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = adoption.dog.gender + " , " + adoption.dog.age,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = adoption.location,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center
                )

            }
        }
    }

    private fun redirectToDetails(adoption: Adoption) {
        val intent = Intent(this, AdoptionDetailsActivity::class.java)
        intent.putExtra("data", adoption)
        startActivity(intent)
    }


    @ExperimentalFoundationApi
    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        MyTheme {
            MyApp()
        }
    }

    @ExperimentalFoundationApi
    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkPreview() {
        MyTheme(darkTheme = true) {
            MyApp()
        }
    }

}

