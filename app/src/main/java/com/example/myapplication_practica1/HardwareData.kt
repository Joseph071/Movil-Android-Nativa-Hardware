package com.example.myapplication_practica1


data class Hardware(
    val id: Int,
    val nombre: String,
    val tipo: String,
    val precio: Double,
    val especificaciones: String,
    val imagenResId: Int
)

val listaHardwareDummy = listOf(
    Hardware(1, "Procesador Ryzen 5", "CPU", 250.0, "6 núcleos, 12 hilos, 3.6 GHz base.", R.drawable.procer),
    Hardware(2, "Gráfica RTX 3060", "GPU", 350.0, "12GB GDDR6, ideal para 1080p.", R.drawable.grafica),
    Hardware(3, "Memoria RAM 16GB", "RAM", 60.0, "DDR4 a 3200MHz, RGB.", R.drawable.memoria),
    Hardware(4, "Disco SSD 1TB", "Almacenamiento", 85.0, "NVMe M.2, lectura 3500MB/s.", R.drawable.disco),
    Hardware(5, "Placa Base ", "Motherboard", 120.0, "Soporte PCIe 4.0, socket AM4.", R.drawable.placa),
    Hardware(6, "Fuente de Poder ", "PSU", 75.0, "Certificación 80+ Bronze.", R.drawable.fuente)
)