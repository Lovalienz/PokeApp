package com.poke.pokemonapp.ui.screens.characters

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.poke.pokemonapp.domain.model.Pokemon
import com.poke.pokemonapp.ui.screens.characters.components.Progressbar
import com.poke.pokemonapp.ui.screens.characters.components.SheetContent
import com.poke.pokemonapp.ui.screens.characters.components.SheetPaddingContent
import kotlinx.coroutines.launch

@Composable
fun CharactersScreen(viewModel: CharactersViewModel = hiltViewModel()){
    val characters = viewModel.characters.collectAsLazyPagingItems()
    when{
        characters.loadState.refresh is LoadState.Loading && characters.itemCount == 0 -> {
            Progressbar()
        }
        //Estado vacio

        characters.loadState.hasError -> {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ha ocurrido un error")
            }
        }
        else-> {
            CharactersContent(characters = characters)
            if (characters.loadState.append is LoadState.Loading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Progressbar()
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersContent(characters: LazyPagingItems<Pokemon>){
    val sheetState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    var selected by remember { mutableIntStateOf(0) }
    Log.i("sheetState", sheetState.bottomSheetState.hasExpandedState.toString())
    BottomSheetScaffold(
        sheetContent = {

            SheetContent(index = selected)
        },
        scaffoldState = sheetState,
        sheetPeekHeight = 0.dp
    ) {
        SheetPaddingContent(
            characters,
            onClickPokemon = {index ->
                selected = index
                coroutineScope.launch {
                    sheetState.bottomSheetState.expand()
                }
            }
        )
    }
}
