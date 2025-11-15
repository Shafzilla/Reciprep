package com.example.reciprep

import android.R
import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.reciprep.ui.theme.ReciprepTheme
import kotlin.getValue
import androidx.room.Room
import com.example.reciprep.data.AppDatabase
import com.example.reciprep.data.Recipe
import com.example.reciprep.data.RecipeDAO
import com.example.reciprep.model.RecipeViewModel
import com.example.reciprep.screen.ViewRecipes
import com.example.reciprep.ui.theme.PurpleGrey40
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {


    private val db by lazy {

        Room.databaseBuilder(
            applicationContext,
            klass = AppDatabase::class.java,
            name = "recipes.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    private val recipeVm: RecipeViewModel by viewModels { RecipeViewModel.factory(db) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



//        recipeVm.addRecipe(name = "Cookies",
//            prepTime = 15,
//            cookTime =20,
//            servings = 8,
//            ingredients = "1 cup flour\n1 stick butter\n1/2 cup sugar",
//            steps = "1. preheat oven to 350F\n2. mix ingredients\n3. bake for 20 minutes",
//            photoPath = "")







        enableEdgeToEdge()
        setContent {


            ReciprepTheme {

                val modifer = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
                    .padding(16.dp)
                // A surface container using the 'background' color from the theme

                ViewRecipes(recipeVm, modifer)


            }


        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Text(text = "Yellow submarine",
        modifier = modifier.padding(100.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReciprepTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Recipes")

                }

            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    text = "Bottom bar content",


                )
            }


        }





    ) { innerPadding ->


        Text(text = "Yellow Helicopter", modifier = Modifier.padding(innerPadding))



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(innerPadding),


            horizontalAlignment = Alignment.CenterHorizontally,


        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .background(Color.Magenta, shape = RoundedCornerShape(15.dp))

                    .padding(50.dp)



            ){            Text(text = "Inside the Box")
            };

            Box(

                modifier = Modifier
                    .background(Color.Green, shape = RoundedCornerShape(15.dp))

                    .padding(16.dp),

                contentAlignment = Alignment.Center

            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),


                ) {





                    item {
                        Text(
                            text = "Item A",
                            color = Color.White,
                            modifier = Modifier
                            .size(150.dp)
                        )




                    }



                }
            }




            Text(
                text = "Yelow Submarine",
                modifier = Modifier.padding(50.dp)


            )

            Text(
                text = "Item 1",


            )
            Text("Item 2")
        }


    }

}

@Composable
fun ScrollContent(x0: PaddingValues) {
    TODO("Not yet implemented")
}

@Composable
fun VerticalDiv() {

    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Item 1")
        Text("Item 2")
    }

}

@Composable
fun VerticalDiv2() {

    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .padding(30.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Item 3")
        Text("Item 4")
    }

}






