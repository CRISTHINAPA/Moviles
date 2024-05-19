package com.example.casa

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController, texto:String?, texto2: String?, texto3:String?, texto4: String?){

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center

        ) {

            Text(
                text = "Nombre: ${texto}",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Descripcion: ${texto2}",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Año: ${texto3}",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Categoria: ${texto4}",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

