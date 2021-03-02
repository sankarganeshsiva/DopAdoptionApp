package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.data.Adoption
import com.example.androiddevchallenge.data.AdoptionData
import com.example.androiddevchallenge.data.Breed
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.banner
import dev.chrisbanes.accompanist.coil.CoilImage

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                SetupHomePage()
            }
        }
    }

    @Composable
    private fun SetupHomePage() {

        Column {
            AddTopBar()
            Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp), content = {
                    item { AddBanner() }
                    item { AddBreedListSection() }
                    item { AddNearMeSection() }
                    item { AddSuggestedSection() }
                })
            }

        }

    }

    @Composable
    private fun AddBreedListSection() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "Explore by breed type",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterStart),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2,
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp), content = {
            AdoptionData.breedList.forEachIndexed { _, breed ->
                item {
                    BuildBreedHomeItem(breed = breed)
                }
            }
        })
    }

    @Composable
    private fun AddBanner() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(banner)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dog_1),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .offset(x = 25.dp)
                    .align(Alignment.BottomEnd)
            )
            Column(modifier = Modifier.align(Alignment.CenterStart)) {
                Text(
                    text = "Your Pet meet has been scheduled at\n\nTuesday, 2 March 2021",
                    modifier = Modifier
                        .padding(24.dp),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.body1
                )

                Surface(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .clickable { }
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    border = BorderStroke(1.dp, MaterialTheme.colors.onPrimary)) {

                    Text(
                        text = "Reschedule",
                        modifier = Modifier
                            .padding(8.dp),
                        style = MaterialTheme.typography.button,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }


        }
    }

    @Composable
    private fun AddNearMeSection() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "Near me",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterStart),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2,
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )

            Text(
                text = "View all",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        redirectToList("Near me")
                    },
                style = MaterialTheme.typography.caption,
                fontSize = 12.sp,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.End
            )


        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AdoptionData.adoptionsAvailable.take(5).forEach { adoption ->
                item {
                    BuildAdoptionHomeItem(adoption = adoption)
                }
            }
        }
    }

    @Composable
    private fun AddSuggestedSection() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "Most wishlisted",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterStart),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2,
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )

            Text(
                text = "View all",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        redirectToList("Most wishlisted")
                    },
                style = MaterialTheme.typography.caption,
                fontSize = 12.sp,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.End
            )


        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AdoptionData.adoptionsAvailable.take(5).forEach { adoption ->
                item {
                    BuildAdoptionHomeItem(adoption = adoption)
                }
            }
        }
    }

    @Composable
    private fun BuildAdoptionHomeItem(adoption: Adoption) {
        Box(modifier = Modifier
            .size(150.dp, 200.dp)
            .clickable { redirectToDetails(adoption) }) {
            Card(
                modifier = Modifier
                    .size(150.dp, 200.dp)
                    .offset(y = 50.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 32.dp)
                ) {
                    Text(
                        text = adoption.dog.name,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
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
                        text = adoption.distance,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Center
                    )
                }
            }
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
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }


    private fun redirectToDetails(adoption: Adoption) {
        val intent = Intent(this, AdoptionDetailsActivity::class.java)
        intent.putExtra("data", adoption)
        startActivity(intent)
    }

    @Composable
    private fun BuildBreedHomeItem(breed: Breed) {
        Box(modifier = Modifier
            .size(150.dp, 200.dp)
            .clickable { redirectToList(breed.name) }) {
            Card(
                modifier = Modifier
                    .size(150.dp, 200.dp)
                    .offset(y = 50.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 32.dp)
                ) {
                    Text(
                        text = breed.name,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body2
                    )
                    Text(
                        text = breed.description,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = breed.count,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Center
                    )
                }
            }
            CoilImage(
                data = breed.image,
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
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }

    private fun redirectToList(title: String) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        intent.putExtra("title", title)
        startActivity(intent)
    }

    @Composable
    private fun AddTopBar() {
        TopAppBar(
            // in below line we are
            // adding title to our top bar.
            title = {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "Mountain View, California",
                        // below line is use
                        // to give text color.
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                    Icon(
                        imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                            .padding(start = 8.dp)
                    )
                }

            },
            // below line is use to give background color
            backgroundColor = MaterialTheme.colors.surface,

            // content color is use to give
            // color to our content in our toolbar.
            contentColor = MaterialTheme.colors.onSurface,

            // below line is use to give
            // elevation to our toolbar.
            elevation = 2.dp
        )
    }


    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @ExperimentalFoundationApi
    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        MyTheme {
            SetupHomePage()
        }
    }

    @ExperimentalFoundationApi
    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkPreview() {
        MyTheme(darkTheme = true) {
            SetupHomePage()
        }
    }
}