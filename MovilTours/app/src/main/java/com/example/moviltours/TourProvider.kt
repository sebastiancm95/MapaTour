package com.example.moviltours

class TourProvider {
    companion object {
        val tourList = listOf<Tour>(
            Tour(
                name = "Tamarindo",
                latitude = 10.3003327,
                longitude = -85.8425934,
                price = "₡15000",
                photo = "https://upload.wikimedia.org/wikipedia/commons/c/cc/Costa_Rica_Playa_Tamarindo_and_Rivermouth_2007_Aerial_Photograph_Tamarindowiki_01.JPG",
                travel = listOf()
            ),
            Tour(
                name = "Volcán Arenal",
                latitude = 10.4626259,
                longitude = -84.7119342,
                price = "₡10000",
                photo = "https://upload.wikimedia.org/wikipedia/commons/d/d7/Volcan_Arenal_Costa_Rica_0065.JPG",
                travel = listOf()
            ),
            Tour(
                name = "Crater la Olla",
                latitude = 9.9339943,
                longitude = -83.8569498,
                price = "₡7000",
                photo = "https://www.tec.ac.cr/hoyeneltec/sites/default/files/media/uploads/irina-grajales-navarrete/crater_la_olla.jpeg",
                travel = listOf()
            ),
            Tour(
                name = "Tortuguero",
                latitude = 10.5445633,
                longitude = -83.5118866,
                price = "₡5000",
                photo = "https://sfo2.digitaloceanspaces.com/elpaiscr/2019/05/Tortuguero-Limon-costa-rica.jpg",
                travel = listOf()
            ),
            Tour(
                name = "Puerto Viejo",
                latitude = 9.6529404,
                longitude = -82.761823,
                price = "₡12000",
                photo = "https://h8r3x6j3.rocketcdn.me/wp-content/uploads/2021/11/puerto-viejo-costa-rica-1200x674.jpg",
                travel = listOf()
            ),
            Tour(
                name = "Cataratas de Nauyaca",
                latitude = 9.2732268,
                longitude = -83.8216322,
                price = "₡11000",
                photo = "https://www.larepublica.net/storage/images/2019/06/21/20190621111008.nauyaca.jpg",
                travel = listOf()
            )
        )
    }
}