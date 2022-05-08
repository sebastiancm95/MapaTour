package com.example.moviltours

class TourProvider {
    companion object {
        val tourList = listOf<Tour>(
            Tour(
                name = "Tamarindo",
                coordinate = "",
                price = "15000",
                photo = "https://upload.wikimedia.org/wikipedia/commons/c/cc/Costa_Rica_Playa_Tamarindo_and_Rivermouth_2007_Aerial_Photograph_Tamarindowiki_01.JPG"
            ),
            Tour(
                name = "Volcán Arenal",
                coordinate = "",
                price = "10000",
                photo = "https://upload.wikimedia.org/wikipedia/commons/d/d7/Volcan_Arenal_Costa_Rica_0065.JPG"
            ),
            Tour(
                name = "Crater la Olla",
                coordinate = "",
                price = "7000",
                photo = "https://www.tec.ac.cr/hoyeneltec/sites/default/files/media/uploads/irina-grajales-navarrete/crater_la_olla.jpeg"
            ),
            Tour(
                name = "Tortuguero",
                coordinate = "",
                price = "5000",
                photo = "https://sfo2.digitaloceanspaces.com/elpaiscr/2019/05/Tortuguero-Limon-costa-rica.jpg"
            ),
            Tour(
                name = "Puerto Viejo",
                coordinate = "",
                price = "12000",
                photo = "https://h8r3x6j3.rocketcdn.me/wp-content/uploads/2021/11/puerto-viejo-costa-rica-1200x674.jpg"

            ),
            Tour(
                name = "Cataratas de Nauyaca",
                coordinate = "",
                price = "11000",
                photo = "https://www.larepublica.net/storage/images/2019/06/21/20190621111008.nauyaca.jpg"
            )
        )
    }
}