package com.ozerbayraktar.jetpackcomposenavigation.view.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ozerbayraktar.jetpackcomposenavigation.R
import androidx.navigation.NavController
import com.ozerbayraktar.jetpackcomposenavigation.data.Dogs


@Composable
fun DetailScreen(
    dogs: Dogs,
    id:String,
    title:String,
    sex:String,
    age: Int,
    description:String,
    imageId: Int,
    navController: NavController
) {

    val scrollState= rememberScrollState()
    
    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface() {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    DetailHeader(dogs = dogs, containerHeight = this@BoxWithConstraints.maxHeight)
                    DetailContent(dogs = dogs, containerHeight = this@BoxWithConstraints.maxHeight)

                }

            }
            
        }
        
    }
}

//en üstteki resim
@Composable
private fun DetailHeader(
    dogs: Dogs,
    containerHeight: Dp
) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter= painterResource(id = dogs.dogImageId),
        contentScale= ContentScale.Crop,
        contentDescription = null
    )
}

//resimin altındaki kısım
@Composable
private fun DetailContent(
    dogs: Dogs,
    containerHeight: Dp
) {

    Column() {
        Title(dogs = dogs)
        DetailProperty(label = stringResource(id = R.string.sex), value = dogs.sex)
        DetailProperty(label = stringResource(id = R.string.age), value = dogs.age.toString())
        DetailProperty(label = stringResource(id = R.string.personality), value = dogs.description)

        //Bazı içerikleri en üstte bırakmak için, cihazdan bağımsız olarak bu şekilde ayırıcı eklenebilir.
        Spacer(modifier=Modifier.height((containerHeight-320.dp).coerceAtLeast(0.dp)))


    }

}
//contentin başlığı
@Composable
private fun Title(dogs: Dogs) {
    Column(modifier=Modifier.padding(16.dp)) {
        Text(
            text = dogs.title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }

}

//contentin label-value bölümü
@Composable
private fun DetailProperty(label: String, value: String) {
    Column(modifier=Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier=Modifier.padding(bottom = 4.dp))  //labeller arası ince çizgi
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
            )
        
    }
    
}
