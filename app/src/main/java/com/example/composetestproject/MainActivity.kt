package com.example.composetestproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetestproject.ui.theme.ComposeTestProjectTheme

class MainActivity : ComponentActivity() {
    companion object {

        private val key = "text"

        fun create(context: Context, text:String? = null): Intent = Intent(context,MainActivity::class.java).putExtra(
            key,text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel:MainViewModel = hiltViewModel()
            ComposeTestProjectTheme {
                // A surface container using the 'background' color from the theme
                val navhostController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting(navhostController)
                    BuildRoute(navhostController)
                }
            }
        }
    }


}
@Composable
fun BuildRoute(navHostController: NavHostController){

    NavHost(navController =navHostController , startDestination = "greeting"){
        composable(route = "greeting"){
            Greeting(navHostController = navHostController)
        }
        composable(route = "second"){
            SecondPage(navHostController = navHostController)
        }
    }

}

@Composable
fun Greeting(
             navHostController: NavHostController,
             modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {

        val name = remember{
            mutableStateOf("there")
        }

        Text(
            text = "Hi ${name.value}!",
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            name.value = "Cognizant"
        }) {
            Text(text = "Say My name")
        }
        Button(onClick = {
            //go second page
                navHostController.navigate("second")
        }) {
            Text(text = "Second Page")

        }
    }

}

@Composable
fun SecondPage(navHostController: NavHostController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Page View")

        Button(onClick = { navHostController.navigate("greeting") }) {
            Text(text = "Greeting back")
        }
    }
}

