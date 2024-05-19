package com.example.casa.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Pantalla Principal Casa")})
        }
    ) {padding ->


        val state = viewModel.state
        Column(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
                .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Nombre: Cristhina Michell Parrales Solórzano", modifier = Modifier.padding(10.dp))
            Text(text = "Curso: 7A", modifier = Modifier.padding(8.dp))
            TextField(value = state.nombre, onValueChange = { viewModel.onNameChange(it) })
            TextField(value = state.descripcion, onValueChange = { viewModel.onDescriptionChange(it) })
            TextField(value = state.año, onValueChange = {viewModel.onStorageChange(it)})
            TextField(value = state.categoria, onValueChange = {viewModel.onProcessorChange(it)})
            Button(onClick = { viewModel.saveLaptop() }, modifier = Modifier.padding(13.dp)) {
                Text(text = "Guardar", fontSize = 18.sp)
            }

            Button(onClick = { navController.navigate("lista") }) {
                Text(text = "ver lista")
            }
        }
    }
}