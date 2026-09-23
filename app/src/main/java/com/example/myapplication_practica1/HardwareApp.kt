package com.example.myapplication_practica1
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

enum class Pantalla {
    INICIO,
    CATALOGO,
    DETALLE
}

@Composable
fun HardwareApp() {

    var pantallaActual by remember { mutableStateOf(Pantalla.INICIO) }
    var hardwareSeleccionado by remember { mutableStateOf<Hardware?>(null) }


    when (pantallaActual) {
        Pantalla.INICIO -> {
            HardwareHomeScreen(

                onIrCatalogo = { pantallaActual = Pantalla.CATALOGO }
            )
        }
        Pantalla.CATALOGO -> {
            HardwareCatalogoScreen(
                lista = listaHardwareDummy,
                onVolver = { pantallaActual = Pantalla.INICIO },
                onItemClick = { item ->

                    hardwareSeleccionado = item
                    pantallaActual = Pantalla.DETALLE
                }
            )
        }
        Pantalla.DETALLE -> {
            hardwareSeleccionado?.let { item ->
                HardwareDetalleScreen(
                    hardware = item,
                    onVolver = { pantallaActual = Pantalla.CATALOGO }
                )
            }
        }
    }
}



