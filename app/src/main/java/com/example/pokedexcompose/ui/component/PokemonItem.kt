package com.example.pokedexcompose.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedexcompose.ui.theme.PokedexComposeTheme
import com.example.pokedexcompose.ui.theme.Shapes

@Composable
fun PokemonItem(
    @DrawableRes
    image: Int,
    name: String,
    type: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(75.dp)
                    .clip(Shapes.medium)
                    .align(alignment = CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = name,
                modifier = Modifier.align(alignment = CenterHorizontally),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = type,
                modifier = Modifier
                    .align(alignment = CenterHorizontally)
                    .padding(2.dp),
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.secondary,
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    PokedexComposeTheme() {
        PokemonItem(
            image = 0,
            name = "Bulbasaur",
            type = "Grass"
        )
    }
}