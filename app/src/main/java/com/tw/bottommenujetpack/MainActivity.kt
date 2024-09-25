package com.tw.bottommenujetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.tw.bottommenujetpack.ui.theme.BottomMenuJetpackTheme

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomMenuJetpackTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.mediumTopAppBarColors(
                                containerColor = Color(
                                    ContextCompat.getColor(applicationContext,
                                        R.color.teal_200))
                            ),
                            title = {
                                Text(text = "Jetpack Toolbar", fontSize = 14.sp, fontStyle = FontStyle.Italic)
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    Toast.makeText(this@MainActivity, "Menu Clicked", Toast.LENGTH_SHORT).show()
                                }) {
                                    Icon(Icons.Filled.Menu, contentDescription = "menu")
                                }
                            },
                            actions = {
                                IconButton(onClick = {
                                    Toast.makeText(this@MainActivity, "Notification Clicked", Toast.LENGTH_SHORT).show()
                                }) {
                                    Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                                }

                                IconButton(onClick = {
                                    Toast.makeText(this@MainActivity, "Search Clicked", Toast.LENGTH_SHORT).show()
                                }) {
                                    Icon(Icons.Filled.Search, contentDescription = "Search")
                                }
                            }
                        )
                    },
                    floatingActionButton = { FloatingActionButton(onClick = { }) {
                        IconButton(onClick = {
                            Toast.makeText(this@MainActivity, "FAB Clicked", Toast.LENGTH_SHORT).show()
                        }) {
                            Icon(Icons.Filled.Add, contentDescription = "Add")
                        }
                    } },
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigation()
                    },
                    ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }




    @Composable
    fun BottomNavigation() {

        val items = listOf(
            BottomNavItem.Home,
            BottomNavItem.List,
            BottomNavItem.Analytics,
            BottomNavItem.Profile
        )

        NavigationBar {
            items.forEach { item ->
                AddItem(
                    screen = item
                )
            }
        }
    }

    @Composable
    fun RowScope.AddItem(
        screen: BottomNavItem
    ) {
        NavigationBarItem(
            // Text that shows bellow the icon
            label = {
                Text(text = screen.title)
            },

            // The icon resource
            icon = {

                Icon(
                    painterResource(id = screen.icon),
                    contentDescription = screen.title,
                    Modifier.clickable {
                        Toast.makeText(this@MainActivity, screen.title, Toast.LENGTH_SHORT).show()
                    }
                )
            },

            // Display if the icon it is select or not
            selected = true,

            // Always show the label bellow the icon or not
            alwaysShowLabel = true,

            // Click listener for the icon
            onClick = { /*TODO*/ },

            // Control all the colors of the icon
            colors = NavigationBarItemDefaults.colors()
        )
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomMenuJetpackTheme {
        Greeting("Android")
    }
}


