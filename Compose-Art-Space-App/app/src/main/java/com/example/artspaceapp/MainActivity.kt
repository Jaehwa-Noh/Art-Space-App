package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyGallery()
                }
            }
        }
    }
}

@Composable
fun MyGallery() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyPicture(
            modifier = Modifier.weight(0.7f)
        )
        PictureArtistAndName(
            modifier = Modifier.weight(0.2f)
        )
        NextAndPreviousButton(
            modifier = Modifier.weight(0.1f)
        )
    }
}

@Composable
fun MyPicture(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.puppy),
        contentDescription = stringResource(R.string.puppy),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .padding(20.dp)
            .shadow(elevation = 10.dp)
    )
}

@Composable
fun PictureArtistAndName(modifier: Modifier = Modifier) {

}

@Composable
fun NextAndPreviousButton(
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        MyGallery()
    }
}