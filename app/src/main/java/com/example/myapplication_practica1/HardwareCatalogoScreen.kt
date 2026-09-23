package com.example.myapplication_practica1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HardwareCatalogoScreen(
    lista: List<Hardware>,
    onVolver: () -> Unit,
    onItemClick: (Hardware) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Componentes") },
                navigationIcon = {
                    IconButton(onClick = onVolver) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding).padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(lista) { item ->

                HardwareItemCard(hardware = item, onClick = { onItemClick(item) })
            }
        }
    }
}


@Composable
fun HardwareItemCard(hardware: Hardware, onClick: () -> Unit) {
    Card(modifier = Modifier.clickable(onClick = onClick)) {
        Image(
            painter = painterResource(id = hardware.imagenResId),
            contentDescription = "Imagen de ${hardware.nombre}",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(hardware.nombre, style = MaterialTheme.typography.titleMedium)
            Text("$${hardware.precio}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HardwareItemCardPreview() {
    val muestra = Hardware(1, "Placa", "Motherboard", 120.0, "Soporte PCIe 4.0, socket AM4.", R.drawable.placa)
    HardwareItemCard(hardware = muestra, onClick = {})
}