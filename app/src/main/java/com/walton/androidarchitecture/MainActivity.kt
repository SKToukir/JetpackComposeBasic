package com.walton.androidarchitecture

import SampleData
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.walton.androidarchitecture.ui.theme.AndroidArchitectureTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }

}

@Composable
private fun MainApp() {
    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    if (screenWidth > screenHeight) {
        AppLandscape()
    } else {
        AppProtrait()
    }
}

@Composable
fun AppLandscape() {
    AndroidArchitectureTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                HomeScreen()
            }
        }
    }

}

@Composable
fun AppProtrait() {
    AndroidArchitectureTheme(darkTheme = false) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .background(color = colorResource(id = R.color.card_background))
        ) {
            Scaffold(bottomBar = { SootheBottomNavigation() }) { paddingValues ->
                HomeScreen(Modifier.padding(paddingValues))
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = colorResource(id = R.color.card_background))
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(R.string.align_body_title) {
            BodyItems(bodyItems = SampleData.bodyItemList)
        }
        HomeSection(R.string.favorite_item) {
            FavoriteItems(
                modifier = Modifier,
                favoriteItems = SampleData.favoriteItems
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Card {
            var expanded by remember {
                mutableStateOf(false)
            }

            var clickCount by remember {
                mutableIntStateOf(0)
            }

            var clickC : Int = 0

            Column(modifier = Modifier.clickable {
                expanded = !expanded
                clickCount += 1
                clickC +=1
                Log.d("TAG", "HomeScreen: $clickCount\n$clickC")
            }) {
                Image(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                AnimatedVisibility(visible = expanded) {
                    Text(text = "Hello WALTON",
                        style = MaterialTheme.typography.labelLarge)
                }
            }
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column {
        Text(
            text = stringResource(id = title),
            modifier
                .padding(start = 16.dp)
                .paddingFromBaseline(top = 40.dp)
                .padding(bottom = 16.dp)
        )
        content()
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Surface(shape = CircleShape, modifier = Modifier.padding(8.dp), shadowElevation = 8.dp) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            placeholder = {
                Text(text = stringResource(id = R.string.search))
            }
        )
    }
}

@Composable
fun AlignBodyItem(@DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = Modifier
                .width(255.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun BodyItems(modifier: Modifier = Modifier, bodyItems: List<Body>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(bodyItems) { item ->
            AlignBodyItem(
                drawable = item.icon, text = item.title,
                modifier
                    .background(
                        color = colorResource(
                            id = R.color.card_background
                        )
                    )
                    .clickable {
                        Log.d("TAG", "BodyItems: ${item.title}")
                    }
            )
        }
    }
}

@Composable
fun FavoriteItems(modifier: Modifier, favoriteItems: List<FavoriteItem>) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteItems) { item ->
            FavoriteCollectionCard(drawable = item.icon, text = item.title, modifier.clickable {
                Log.d("TAG", "FavoriteItems: ${item.title}")
            })
        }
    }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(selected = true, onClick = { }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null
            )
        }, label = {
            Text(text = stringResource(id = R.string.home))
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null
            )
        }, label = {
            Text(text = stringResource(id = R.string.profile))
        })
    }
}

@Composable
fun SootheNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(selected = true, onClick = { /*TODO*/ }, icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }, label = {
                Text(text = stringResource(id = R.string.home))
            })
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
            }, label = {
                Text(text = stringResource(id = R.string.profile))
            })
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    AndroidArchitectureTheme(darkTheme = false) {
        Scaffold(bottomBar = { SootheBottomNavigation() }) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

