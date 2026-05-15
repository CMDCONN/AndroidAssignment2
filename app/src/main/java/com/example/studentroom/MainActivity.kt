package com.example.studentroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bento
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentroom.screens.Awards
import com.example.studentroom.screens.Campus
import com.example.studentroom.screens.Events
import com.example.studentroom.screens.Food
import com.example.studentroom.screens.Profile
import com.example.studentroom.screens.Socs
import com.example.studentroom.ui.theme.StudentRoomTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentRoomTheme {
                val navController: NavHostController = rememberNavController()
                val currentScreen = remember { mutableStateOf<Page>(Page.Awards) }
                Scaffold(
                    topBar = {
                        TopAppBar({ Text(currentScreen.value.title, textAlign = TextAlign.Center) })
                    },
                    bottomBar = {
                        BottomAppBar {
                            BottomNavigationBar(navController, currentScreen)
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        MainContent(navController)
                    }
                }
            }
        }
    }
}
sealed class Page(
    val route: String,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
){
    object Awards : Page("awards", "Awards", Icons.Default.ThumbUp)
    object Campus : Page("campus", "Campus", Icons.Default.Bento)
    object Events : Page("events", "Events", Icons.Default.Bento)
    object Food : Page("food", "Food", Icons.Default.Bento)
    object Socs : Page("socs", "Socs", Icons.Default.Bento)
    object Profile : Page("profile", "Profile", Icons.Default.Bento)

}


@Composable
fun BottomNavigationBar(navController: NavHostController, currentScreen: MutableState<Page>) {
    val items = listOf(
        Page.Awards,
        Page.Campus,
        Page.Events,
        Page.Food,
        Page.Socs,
        Page.Profile
    )
    NavigationBar {
        items.forEach { page ->
            val isSelected = page == currentScreen.value
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (navController.currentDestination?.route != page.route) {
                        navController.navigate(page.route)
                        currentScreen.value = page
                    }
                },
                icon = {
                    Icon(page.icon, contentDescription = page.title)
                },
                label = { Text(page.title) }
            )
        }
    }
}
@Composable
fun MainContent(navController: NavHostController) {
    NavHost(navController, startDestination = Page.Awards.route) {
        composable(Page.Awards.route) { AwardsScreen() }
        composable(Page.Campus.route) { CampusScreen() }
        composable(Page.Events.route) { EventsScreen() }
        composable(Page.Food.route) { FoodScreen() }
        composable(Page.Socs.route) { SocsScreen() }
        composable(Page.Profile.route) { ProfileScreen() }


    }
}



@Composable
fun ProfileScreen(){
    Profile()
}

@Composable
fun CampusScreen() {
    Campus()
}

@Composable
fun AwardsScreen() {
    Awards()
}

@Composable
fun EventsScreen(){
    Events()
}

@Composable
fun FoodScreen(){
    Food()
}

@Composable
fun SocsScreen(){
    Socs()
}

@Preview
@Composable
fun MainContentPreview() {
    val navController: NavHostController = rememberNavController()
    MainContent(navController)
}


