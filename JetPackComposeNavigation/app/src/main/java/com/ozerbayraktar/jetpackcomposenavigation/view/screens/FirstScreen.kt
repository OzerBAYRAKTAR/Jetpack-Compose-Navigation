package com.ozerbayraktar.jetpackcomposenavigation.view.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ozerbayraktar.jetpackcomposenavigation.data.DataProvider
import com.ozerbayraktar.jetpackcomposenavigation.data.Dogs
import com.ozerbayraktar.jetpackcomposenavigation.view.screens.Screen


@Composable
fun MainScreen(navController: NavController){
    val dogs=remember{DataProvider.dogList}
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = dogs,
            itemContent = {
                DogItemRow(dogs =it,navController)

            }
        )
    }

}

@Composable
fun DogItemRow(dogs:Dogs,navController: NavController){
    Card(modifier= androidx.compose.ui.Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .clickable {
                   navController.navigate(
                       Screen.DetailScreen.route+
                               "/${dogs.id}/${dogs.title}/${dogs.sex}/${dogs.age}/${dogs.description}/${dogs.dogImageId}"
                   )
        },
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {
        Row{
            dogImage(dogs = dogs)
            Column( modifier = androidx.compose.ui.Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
            ) {
                Text(text = dogs.title,style=MaterialTheme.typography.h6)
                Text(text="Check Details",style=MaterialTheme.typography.caption)
            }
        }

    }

}
@Composable
private fun dogImage(dogs: Dogs){
    Image(
        painter = painterResource(id = dogs.dogImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = androidx.compose.ui.Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
    
}









