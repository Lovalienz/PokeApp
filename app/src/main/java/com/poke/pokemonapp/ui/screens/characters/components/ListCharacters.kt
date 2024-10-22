package com.poke.pokemonapp.ui.screens.characters.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.poke.pokemonapp.R
import com.poke.pokemonapp.core.Config
import com.poke.pokemonapp.domain.model.Abilities
import com.poke.pokemonapp.domain.model.Ability
import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.FrontDefault
import com.poke.pokemonapp.domain.model.Pokemon
import com.poke.pokemonapp.ui.screens.characters.CircularPhoto

@Composable
fun ListCharacters(
    characters: LazyPagingItems<Pokemon>,
    onClickPokemon: (Int) -> Unit

) {
    LazyColumn(
        Modifier.background(color = colorResource(R.color.list_backgroung).copy(alpha = 0.5f))
    ) {
        items(Config.pokemonInfo.size) { index ->
            characters[index]?.let { characterModel ->
                PokemonItem(
                    characterModel,
                    index,
                    onClickPokemon ={ index ->
                        onClickPokemon(index)
                    }
                )
            }
        }
    }
}

@Composable
fun PokemonItem(
    characterModel: Pokemon,
    index: Int,
    onClickPokemon: (Int) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .height(105.dp)
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                onClickPokemon(index)
            }
            .padding(horizontal = 20.dp)
    ) {

        val (boxFirst, boxSecond, _) = createRefs()
        Row(modifier = Modifier
            .fillMaxSize()
            .constrainAs(boxFirst) {
                end.linkTo(parent.end)
            }
            .padding(top = 15.dp, bottom = 15.dp, start = 10.dp, end = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clip(
                        RoundedCornerShape(15.dp)
                    )
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Row {
                    Spacer(modifier = Modifier.padding(horizontal = 40.dp))
                    Spacer(modifier = Modifier.padding(vertical = 3.dp))
                    Text(
                        text = capitalizeFirstLetter(characterModel.name),
                        fontSize = 17.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.align(
                            Alignment.CenterVertically
                        )
                    )

                }
            }
        }
       CircularPhoto(
           backGround = Color.Red,
           placeHolder = R.drawable.placeholder,
           url = Config.pokemonInfo[index].sprites.photo,
           name = characterModel.name
       )
    }
}


val mockAbility = Ability(name = "overgrow", isHidden = true)
val mockAbilities: List<Abilities> = listOf(
    Abilities(
        ability = mockAbility
    )
)

// Mock of FrontDefault
val mockSprites = FrontDefault(photo = "https://pokeapi.co/media/sprites/pokemon/1.png")

// Mock de CharacterModel
val mockCharacter = CharacterModel(
    id = 1,
    name = "Bulbasaur",
    height = 7,
    weight = 69,
    abilities = mockAbilities,
    sprites = mockSprites,
    isFavorite = true
)


fun capitalizeFirstLetter(input: String): String {
    return input.replaceFirstChar { it.uppercase() }
}
