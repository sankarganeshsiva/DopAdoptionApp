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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Adoption
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.petTypeBG
import com.example.androiddevchallenge.ui.theme.petTypeBG2
import com.example.androiddevchallenge.ui.theme.petTypeBG3
import com.example.androiddevchallenge.ui.theme.petTypeIcon
import com.example.androiddevchallenge.ui.theme.petTypeIcon2
import com.example.androiddevchallenge.ui.theme.petTypeIcon3
import dev.chrisbanes.accompanist.coil.CoilImage

class AdoptionDetailsActivity : AppCompatActivity() {

    private lateinit var adoption: Adoption
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adoption = intent.getSerializableExtra("data") as Adoption
        setContent {
            MyTheme {
                DetailPage()
            }
        }
    }

    @Composable
    private fun DetailPage() {
        Column {
            AddTopAppBar()
            Box {
                CoilImage(
                    data = adoption.dog.image,
                    contentDescription = "My content description",
                    fadeIn = true,
                    loading = {
                        Box(Modifier.fillMaxSize()) {
                            CircularProgressIndicator(
                                Modifier.align(Alignment.Center),
                                color = MaterialTheme.colors.primary
                            )
                        }
                    },
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.height(300.dp)
                )
                ConstructCard()
            }
        }
    }

    @Composable
    private fun ConstructCard() {
        Card(
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 280.dp),
            elevation = 16.dp
        ) {
            Box {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 32.dp, top = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = { }) {
                        // below line is use to
                        // specify navigation icon.
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "",
                            tint = MaterialTheme.colors.onSurface
                        )
                    }
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = adoption.dog.name,
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.body2
                    )

                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Text(
                            text = adoption.dog.gender,
                            modifier = Modifier,
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = stringResource(R.string.seperator),
                            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = adoption.dog.age,
                            modifier = Modifier,
                            style = MaterialTheme.typography.caption
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Surface(
                            color = petTypeBG,
                            shape = RoundedCornerShape(8.dp),
                            elevation = 4.dp,
                            modifier = Modifier.size(100.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Icon(
                                    imageVector = Icons.Filled.Pets,
                                    contentDescription = "",
                                    tint = petTypeIcon
                                )
                                Text(
                                    text = "Hunting",
                                    modifier = Modifier.padding(top = 16.dp),
                                    style = MaterialTheme.typography.caption,
                                    color = petTypeIcon,
                                )
                            }
                        }

                        Surface(
                            color = petTypeBG2,
                            shape = RoundedCornerShape(8.dp),
                            elevation = 4.dp,
                            modifier = Modifier.size(100.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Icon(
                                    imageVector = Icons.Filled.Psychology,
                                    contentDescription = "",
                                    tint = petTypeIcon2
                                )
                                Text(
                                    text = "Intelligent",
                                    modifier = Modifier.padding(top = 16.dp),
                                    style = MaterialTheme.typography.caption,
                                    color = petTypeIcon2
                                )
                            }
                        }

                        Surface(
                            color = petTypeBG3,
                            shape = RoundedCornerShape(8.dp),
                            elevation = 4.dp,
                            modifier = Modifier.size(100.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Icon(
                                    imageVector = Icons.Filled.Thermostat,
                                    contentDescription = "",
                                    tint = petTypeIcon3
                                )
                                Text(
                                    text = "Hot Climate",
                                    modifier = Modifier.padding(top = 16.dp),
                                    style = MaterialTheme.typography.caption,
                                    color = petTypeIcon3
                                )
                            }
                        }
                    }
                    Text(
                        text = "Description",
                        modifier = Modifier.padding(top = 16.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.body2
                    )
                    Text(
                        text = stringResource(R.string.description_text),
                        modifier = Modifier.padding(top = 8.dp),
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Justify
                    )

                    Surface(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .clickable { }
                            .padding(16.dp)
                            .offset(y = 25.dp)
                    ) {
                        Text(
                            text = "500$ - Adopt  me",
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.button,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun AddTopAppBar() {
        TopAppBar(
            // in below line we are
            // adding title to our top bar.
            title = {
                // inside title we are
                // adding text to our toolbar.
                Text(
                    text = adoption.dog.nickName,
                    // below line is use
                    // to give text color.
                    color = MaterialTheme.colors.onSurface
                )
            },
            navigationIcon = {
                // navigation icon is use
                // for drawer icon.
                IconButton(onClick = { onBackPressed() }) {
                    // below line is use to
                    // specify navigation icon.
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
            },
            // below line is use to give background color
            backgroundColor = MaterialTheme.colors.background,

            // content color is use to give
            // color to our content in our toolbar.
            contentColor = MaterialTheme.colors.onSurface,

            // below line is use to give
            // elevation to our toolbar.
            elevation = 0.dp,
            actions = {
                IconButton(onClick = { }) {
                    // below line is use to
                    // specify navigation icon.
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                IconButton(onClick = { }) {
                    // below line is use to
                    // specify navigation icon.
                    Icon(
                        imageVector = Icons.Outlined.Call,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
            }
        )
    }

    @Composable
    private fun Header() {
        Spacer(
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colors.background,
                            MaterialTheme.colors.background
                        )
                    )
                )
        )
    }

    @ExperimentalFoundationApi
    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreviewDetailScreen() {
        MyTheme {
            DetailPage()
        }
    }

    @ExperimentalFoundationApi
    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkPreviewDetailScreen() {
        MyTheme(darkTheme = true) {
            DetailPage()
        }
    }
}
