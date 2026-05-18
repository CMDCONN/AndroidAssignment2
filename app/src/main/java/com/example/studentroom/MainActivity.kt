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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bento
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Restaurant
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentroom.components.socApplyComponents.SocApplyViewModel
import com.example.studentroom.data.SocProfile
import com.example.studentroom.data.socList
import com.example.studentroom.screens.Awards
import com.example.studentroom.screens.Campus
import com.example.studentroom.screens.Events
import com.example.studentroom.screens.Food
import com.example.studentroom.screens.Profile
import com.example.studentroom.screens.SocApply
import com.example.studentroom.screens.Socs
import com.example.studentroom.screens.SocsDetailPage
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
                val socApplyViewModel: SocApplyViewModel = viewModel()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(currentScreen.value.title, textAlign = TextAlign.Center) },
                            actions = {
                                IconButton(onClick = {
                                    if (navController.currentDestination?.route != Page.Profile.route) {
                                        navController.navigate(Page.Profile.route)
                                        currentScreen.value = Page.Profile
                                    }
                                }) {
                                    Icon(Page.Profile.icon, contentDescription = Page.Profile.title)
                                }
                            }
                        )
                    },
                    // FROM LECTURE SLIDES | From Here ------------------------------------------------------------------
                    bottomBar = {
                        BottomAppBar {
                            BottomNavigationBar(navController, currentScreen)
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        MainContent(navController, socApplyViewModel)
                    }
                }
                //FROM LECTURE SLIDES | To Here -------------------------------------------------------------------------------------
            }
        }
    }
}
sealed class Page(
    val route: String,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
){
    object Awards : Page("awards", "Awards", Icons.Filled.EmojiEvents)
    object Campus : Page("campus", "Campus", Icons.Default.Business)
    object Events : Page("events", "Events", Icons.Default.Event)
    object Food : Page("food", "Food", Icons.Default.Restaurant)
    object Socs : Page("socs", "Socs", Icons.Default.Groups)
    object Profile : Page("profile", "Profile", Icons.Default.Face)

}



//FROM LECTURE SLIDES | From here -------------------------------------------------------------------------------------
@Composable
fun BottomNavigationBar(navController: NavHostController, currentScreen: MutableState<Page>) {
    val items = listOf(
        Page.Awards,
        Page.Campus,
        Page.Events,
        Page.Food,
        Page.Socs
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

// //FROM LECTURE SLIDES | To here  -------------------------------------------------------------------------------------

@Composable
fun MainContent(navController: NavHostController, socApplyViewModel: SocApplyViewModel) {
    NavHost(navController, startDestination = Page.Profile.route) {
        composable(Page.Awards.route) { Awards() }
        composable(Page.Campus.route) { Campus() }
        composable(Page.Events.route) { Events() }
        composable(Page.Food.route) { Food() }
        composable(Page.Socs.route) { Socs(socList, navController) }
        composable(Page.Profile.route) { Profile() }
        composable(route = "socDetailsPage/{id}") { backStackEntry ->
            val extractedID = backStackEntry.arguments?.getString("id")
            SocsDetailPage(id = extractedID, socListIn = socList, navController = navController)
        }
        composable(route = "socApply"){ SocApply(navController, socApplyViewModel = socApplyViewModel) }

    }
}

@Preview
@Composable
fun MainContentPreview() {
    val navController: NavHostController = rememberNavController()
    MainContent(navController, viewModel())
}


