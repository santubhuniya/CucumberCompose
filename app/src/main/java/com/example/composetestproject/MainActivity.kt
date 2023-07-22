package com.example.composetestproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
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
        fun create(context: Context, text: String? = null): Intent =
            Intent(context, MainActivity::class.java).putExtra(
                key, text
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel: MainViewModel = hiltViewModel()
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
fun BuildRoute(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = "greeting") {
        composable(route = "greeting") {
            Greeting(navHostController = navHostController)
        }
        composable(route = "second") {
            SecondPage(navHostController = navHostController)
        }
    }

}

@Composable
fun Greeting(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val name = remember {
            mutableStateOf("Compose Cucumber")
        }

        Image(
            painter = painterResource(id = R.drawable.cucumber),
            contentDescription = "Cucumber",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .fillMaxWidth()

        )
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = "Hi ${name.value}!",
            modifier = modifier.testTag("greeting_test"),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                name.value = "Cucumber"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(text = "Greet Cucumber")
        }
        Button(
            onClick = {
                //go second page
                navHostController.navigate("second")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(text = "Greet Espresso")

        }
    }

}

@Composable
fun SecondPage(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.coffee_compose),
            contentDescription = "espresso",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .fillMaxWidth()

        )
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = "Hello Espresso",
            modifier = Modifier.testTag("greet_espresso"),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            onClick = { navHostController.navigate("greeting") }) {
            Text(text = "Greet Cucumber")
        }
    }
}

