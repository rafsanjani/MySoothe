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
package com.example.androiddevchallenge.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun Home() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {}, backgroundColor = MaterialTheme.colors.primary) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play Button",
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomNavigation(
                elevation = 0.dp,
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.background
            ) {
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Spa,
                                contentDescription = null,
                            )
                            Text(
                                text = "HOME",
                                style = MaterialTheme.typography.caption.copy(
                                    color = MaterialTheme.colors.onBackground
                                ),
                                modifier = Modifier.padding(start = 6.dp)
                            )
                        }
                    }
                )

                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                            )
                            Text(
                                text = "PROFILE",
                                style = MaterialTheme.typography.caption.copy(
                                    color = MaterialTheme.colors.onBackground
                                ),
                                modifier = Modifier.padding(start = 6.dp)
                            )
                        }
                    }
                )
            }
        }
    ) {
        Content()
    }
}

@Composable
fun Content() {
    var searchQuery by remember { mutableStateOf("") }
    val activities by remember {
        mutableStateOf(
            listOf(
                Activity(
                    name = "Short mantras",
                    image = R.drawable.aroma_therapy,
                    type = ActivityType.FAVORITE
                ),
                Activity(
                    name = "Stress and anxiety",
                    image = R.drawable.stress_and_anxiety,
                    type = ActivityType.FAVORITE
                ),
                Activity(
                    name = "Overwhelmed",
                    image = R.drawable.overwhelmed,
                    type = ActivityType.FAVORITE
                ),
                Activity(
                    name = "Nature meditations",
                    image = R.drawable.nature_meditations,
                    type = ActivityType.FAVORITE
                ),
                Activity(
                    name = "Self-massage",
                    image = R.drawable.self_massage,
                    type = ActivityType.FAVORITE
                ),
                Activity(
                    name = "Nightly wind",
                    image = R.drawable.aroma_therapy,
                    type = ActivityType.FAVORITE
                ),
                Activity(
                    name = "Inversions",
                    image = R.drawable.inversions,
                    type = ActivityType.ALIGN_YOUR_BODY
                ),
                Activity(
                    name = "Quick yoga",
                    image = R.drawable.quick_yoga,
                    type = ActivityType.ALIGN_YOUR_BODY
                ),
                Activity(
                    name = "Stretching",
                    image = R.drawable.stretching,
                    type = ActivityType.ALIGN_YOUR_BODY
                ),
                Activity(
                    name = "Tabata",
                    image = R.drawable.tabata,
                    type = ActivityType.ALIGN_YOUR_BODY
                ),
                Activity(
                    name = "HIIT",
                    image = R.drawable.hiit,
                    type = ActivityType.ALIGN_YOUR_BODY
                ),
                Activity(
                    name = "Pre-natal yoga",
                    image = R.drawable.pre_natal_yoga,
                    type = ActivityType.ALIGN_YOUR_BODY
                ),
                Activity(
                    name = "HIIT",
                    image = R.drawable.hiit,
                    type = ActivityType.ALIGN_YOUR_BODY
                ),
                Activity(
                    name = "Meditate",
                    image = R.drawable.meditate,
                    type = ActivityType.ALIGN_YOUR_MIND
                ),
                Activity(
                    name = "With kids",
                    image = R.drawable.with_kids,
                    type = ActivityType.ALIGN_YOUR_MIND
                ),
                Activity(
                    name = "Aromatherapy",
                    image = R.drawable.aroma_therapy,
                    type = ActivityType.ALIGN_YOUR_MIND
                ),
                Activity(
                    name = "On the go",
                    image = R.drawable.on_the_go,
                    type = ActivityType.ALIGN_YOUR_MIND
                ),
                Activity(
                    name = "With pets",
                    image = R.drawable.with_kids,
                    type = ActivityType.ALIGN_YOUR_MIND
                ),
                Activity(
                    name = "High stress",
                    image = R.drawable.high_stress,
                    type = ActivityType.ALIGN_YOUR_MIND
                ),
            )
        )
    }

    Column(modifier = Modifier.padding(top = 56.dp), verticalArrangement = Arrangement.Center) {
        SearchBar(
            query = searchQuery,
            onQueryChanged = {
                searchQuery = it
            }
        )
        Text(
            text = "FAVORITE COLLECTIONS",
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp)
                .padding(start = 16.dp),
            style = MaterialTheme.typography.h2
        )

        FavoriteCollections(
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp),
            activities = activities.filter { it.type == ActivityType.FAVORITE }
        )

        CircularActivityList(
            modifier = Modifier.padding(start = 16.dp),
            activities = activities.filter { it.type == ActivityType.ALIGN_YOUR_BODY },
            title = "ALIGN YOUR BODY"
        )

        CircularActivityList(
            modifier = Modifier.padding(start = 16.dp),
            activities = activities.filter { it.type == ActivityType.ALIGN_YOUR_MIND },
            title = "ALIGN YOUR MIND"
        )
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (query: String) -> Unit
) {
    TextField(
        modifier = Modifier
            .requiredHeight(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = query,
        onValueChange = {
            onQueryChanged(it)
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.requiredSize(18.dp),
                imageVector = Icons.Default.Search,
                contentDescription = "Search Button"
            )
        },
        placeholder = {
            Text(text = "Search")
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
    )
}

@Composable
fun FavoriteCollections(modifier: Modifier = Modifier, activities: List<Activity>) {
    val chunked = activities.chunked(2)
    LazyRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = chunked) { column ->
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                column.forEach { activity ->
                    RectActivityCard(activity = activity)
                }
            }
        }
    }
}

@Composable
fun CircularActivityList(modifier: Modifier = Modifier, activities: List<Activity>, title: String) {
    Column(modifier = modifier) {
        Text(
            text = title,
            modifier = Modifier
                .paddingFromBaseline(48.dp),
            style = MaterialTheme.typography.h2
        )

        Column {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(activities) { activity ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .requiredSize(88.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = activity.image),
                            contentDescription = activity.name,
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            modifier = Modifier
                                .paddingFromBaseline(24.dp),
                            text = activity.name,
                            style = MaterialTheme.typography.h3
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RectActivityCard(activity: Activity) {
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .requiredWidth(192.dp)
            .requiredHeight(56.dp),
        shape = shapes.small,
    ) {
        Row {
            Image(
                modifier = Modifier
                    .requiredSize(56.dp),
                painter = painterResource(id = activity.image),
                contentDescription = activity.name,
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.requiredWidth(16.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = activity.name,
                style = MaterialTheme.typography.h3
            )
        }
    }
}

@Composable()
@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
fun HomePreviewLight() {
    MySootheTheme {
        Home()
    }
}

@ExperimentalAnimationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomePreviewDark() {
    MySootheTheme(darkTheme = true) {
        Home()
    }
}

data class Activity(
    val name: String,
    @DrawableRes val image: Int,
    val type: ActivityType
)

enum class ActivityType {
    FAVORITE,
    ALIGN_YOUR_BODY,
    ALIGN_YOUR_MIND
}
