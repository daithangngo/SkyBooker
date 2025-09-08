package com.skybooker.SkyBooker.enums;

public enum City {
    //UK
    LONDON(Country.UK),
    BIRMINGHAM(Country.UK),

    //USA
    MIAMI(Country.USA),
    DALLAS(Country.USA),

    //GERMANY
    BERLIN(Country.GERMANY),
    MUNICHE(Country.GERMANY);


    private final Country country;

    City(Country country) {
        this.country = country;
    }

}
