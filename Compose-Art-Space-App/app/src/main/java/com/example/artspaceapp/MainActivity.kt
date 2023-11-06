package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var currentPage: Int by remember {
        mutableIntStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        MyPicture(
            modifier = Modifier.weight(0.7f)
        )
        PictureArtistAndName(
            modifier = Modifier.weight(0.2f)
        )
        NextAndPreviousButton(
            onNextClick = {
                currentPage = currentPageUpdate(isNext = true, currentPage)
            },
            onPreviousClick = {
                currentPage = currentPageUpdate(isNext = false, currentPage)
            },
            modifier = Modifier.weight(0.1f)
        )
    }
}

@VisibleForTesting
internal fun currentPageUpdate(isNext: Boolean, currentPage: Int): Int {
    var newCurrentPage = currentPage
    if (isNext) {
        newCurrentPage++
        newCurrentPage %= 3
    } else {
        if (currentPage == 0) {
            newCurrentPage = 2
        } else {
            newCurrentPage--
            newCurrentPage %= 3
        }
    }
    return newCurrentPage
}

@Composable
fun MyPicture(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.puppy),
            contentDescription = stringResource(R.string.puppy),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(CenterHorizontally)
                .weight(0.9f)
                .border(width = 3.dp, color = Color.LightGray)
                .shadow(elevation = 10.dp)
                .background(Color.White)
                .padding(horizontal = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.puppy_source),
            modifier = Modifier
                .weight(0.1f)
                .padding(horizontal = 20.dp)
        )
    }
}

@Composable
fun PictureArtistAndName(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp)
            .background(Color.LightGray)
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.puppy),
            fontSize = 28.sp
        )

        Row {
            Text(
                text = stringResource(id = R.string.puppy_artist),
                fontWeight = FontWeight.Bold,
            )
            Text(text = " (" + stringResource(id = R.string.puppy_year) + ")")
        }

    }
}


@Composable
fun NextAndPreviousButton(
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(20.dp)
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(0.5f)
        ) {
            Text(
                text = stringResource(R.string.previous)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(0.5f)
        ) {
            Text(
                text = stringResource(R.string.next)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        MyGallery()
    }
}