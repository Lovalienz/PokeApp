package com.poke.pokemonapp.ui.screens.characters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun CircularPhoto(
    backGround: Color,
    placeHolder: Int,
    url: String = "",
    name: String = ""
) {

    if (url != "") {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url).crossfade(true).build(),
            contentDescription = "",
            modifier = Modifier
                .size(85.dp)
                .border(
                    BorderStroke(2.dp, Color.Black),
                    CircleShape
                )
                .clip(CircleShape)
                .background(backGround)
                .padding(top = 10.dp),
            contentScale = ContentScale.Crop

        )
    } else if (name == "") {
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(2.dp, Color.Black),
                    CircleShape
                )
                .clip(CircleShape)

                .size(85.dp)
        ) {
            Image(

                painter = painterResource(placeHolder),
                contentDescription = null,

                contentScale = ContentScale.Crop
            )
        }
    }else{
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(2.dp, Color.Black),
                    CircleShape
                )
                .clip(CircleShape)
                .background(backGround)
                .size(85.dp),
            contentAlignment = Alignment.Center
        ) {
            val firstLetter = getFirstLetters(name)
            Text(
                text = if (name.contains(" ")) firstLetter else name.take(2),
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )
        }
    }
}


fun getFirstLetters(input: String): String {
    return input.split(" ") // Divide el string por espacios
        .filter { it.isNotEmpty() } // Filtra palabras vacías
        .map { it.first().uppercase() } // Obtén la primera letra de cada palabra en mayúscula
        .joinToString("") // Une todas las letras en un solo string
}