package com.poke.pokemonapp.ui.screens.characters.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.poke.pokemonapp.R
import com.poke.pokemonapp.core.Config
import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.Pokemon
import com.poke.pokemonapp.ui.screens.characters.CircularPhoto
import com.poke.pokemonapp.ui.theme.PokeAppTheme

@Composable
fun SheetContent(
    index: Int
){
    val selectedPokemon = Config.pokemonInfo[index]
    var isFavorite by remember  { mutableStateOf(false) }
    val brush = Brush.verticalGradient(listOf( Color.Red, Color.White))

    Column(
        Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(brush),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularPhoto(
            backGround = Color.Black,
            placeHolder = R.drawable.placeholder,
            url = selectedPokemon.sprites.photo,
            name = selectedPokemon.name
        )
        Text(
            text = capitalizeFirstLetter(selectedPokemon.name),
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(30.dp))
        Text(
            text = "Altura: ${selectedPokemon.height}",
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Peso: ${selectedPokemon.weight}",
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium
        )
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopEnd
        ) {
            IconButton(
                onClick = {
                    isFavorite = !isFavorite
                    Config.pokemonInfo[index].isFavorite = isFavorite
                }
            ) {
                if (isFavorite && Config.pokemonInfo[index].isFavorite) {
                    Icon(
                        painter = painterResource(R.drawable.favorite_filled),
                        contentDescription = null,
                        tint = Color.Red
                    )
                }else{
                    Icon(
                        painter = painterResource(R.drawable.favorite),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewSheetContent(){
    PokeAppTheme {

    }
}
