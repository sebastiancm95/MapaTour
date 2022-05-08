package com.example.moviltours

class TourProvider {
    companion object {
        val tourList = listOf<Tour>(
            Tour(
                name = "Tamarindo",
                coordinate = "",
                price = "15000",
                photo = "https://photo620x400.mnstatic.com/6857fd135eb711eab3ce08b20e3791d6/playas-del-pacifico-de-costa-rica.jpg"
            ),
            Tour(
                name = "Volcán Arenal",
                coordinate = "10000",
                price = "",
                photo = ""
            ),
            Tour(
                name = "Crater la Olla",
                coordinate = "7000",
                price = "",
                photo = ""
            ),
            Tour(
                name = "Laguna Don Fernando",
                coordinate = "5000",
                price = "",
                photo = ""
            ),
            Tour(
                name = "Puerto Viejo",
                coordinate = "12000",
                price = "",
                photo = ""

            ),
            Tour(
                name = "Cataratas de Nauyaca",
                coordinate = "11000",
                price = "",
                photo = ""
            )
        )
    }
}