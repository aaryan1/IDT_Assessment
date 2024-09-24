package com.tks.idt.repository

import com.tks.idt.model.State

class StateRepository {
    private val mockData = listOf(
        State("Alabama", 4833722, 67),
        State("Alaska", 735132, 29),
        State("Arizona", 6626624, 15),
        State("Arkansas", 2959373, 75),
        State("California", 38332521, 58),
        State("Colorado", 5268367, 64),
        State("Connecticut", 3596080, 8),
        State("Delaware", 925749, 3),
        State("District of Columbia", 646449, 1),
        State("Florida", 19552860, 67), State("Georgia", 9992167, 159),
        State("Hawaii", 1404054, 5),
        State("Idaho", 1612136, 44),
        State("Illinois", 12882135, 102),
        State("Indiana", 6570902, 92),
        State("Iowa", 3090415, 99),
        State("Kansas", 2893957, 105),
        State("Kentucky", 4395295, 120),
        State("Louisiana", 4625470, 64),
        State("Maine", 1328302, 16),
        State("Maryland", 5928814, 24),
        State("Massachusetts", 6692824, 14),
        State("Michigan", 9895622, 83),
        State("Minnesota", 5420380, 87),
        State("Mississippi", 2991207, 82),
        State("Missouri", 6044171, 115),
        State("Montana", 1015165, 56),
        State("Nebraska", 1868516, 93),
        State("Nevada", 2790136, 17),
        State("New Hampshire", 1323459, 10),
        State("New Jersey", 8899339, 21),
        State("New Mexico", 2085287, 33),
        State("New York", 19651127, 62),
        State("North Carolina", 9848060, 100),
        State("North Dakota", 723393, 53),
        State("Ohio", 11570808, 88),
        State("Oklahoma", 3850568, 77),
        State("Oregon", 3930065, 36),
        State("Pennsylvania", 12773801, 67),
        State("Rhode Island", 1051511, 5),
        State("South Carolina", 4774839, 46),
        State("South Dakota", 844877, 66),
        State("Tennessee", 6495978, 95),
        State("Texas", 26448193, 254),
        State("Utah", 2900872, 29),
        State("Vermont", 626630, 14),
        State("Virginia", 8260405, 134),
        State("Washington", 6971406, 39),
        State("West Virginia", 1854304, 55),
        State("Wisconsin", 5742713, 72),
        State("Wyoming", 582658, 23)
    )


    fun getStates(): List<State> {
        return mockData
    }
}
