package com.armin.hw15_1_city.data

import com.armin.hw15_1_city.data.model.City

object CityData {
    val city_1 = City(
        1,
        "Tehran",
        false
    )
    val city_2 = City(
        2,
        "Tokyo",
        true
    )
    val city_3 = City(
        3,
        "Paris",
        false
    )
    val city_4 = City(
        4,
        "Rome",
        false
    )
    val city_5 = City(
        5,
        "Washington D.C.",
        false
    )
    val city_6 = City(
        6,
        "Berlin",
        false
    )

    val city_7 = City(
        7,
        "Buenos Aires",
        false
    )
    val city_8 = City(
        8,
        "Bangkok",
        false
    )
    val city_9 = City(
        9,
        "Wellington",
        false
    )
    val city_10 = City(
        10,
        "Cape Town",
        false
    )

    fun cityList() = listOf<City>(
        city_1,
        city_2,
        city_3,
        city_4,
        city_5,
        city_6,
        city_7,
        city_8,
        city_9,
        city_10
    )
}
