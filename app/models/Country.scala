package models

object Country {

  def apply(parts: Array[String], possibleAirports: List[Airport]): Country = {
    val countryCode = parts(1)
    val airports = possibleAirports.filter(_.isoCountry == countryCode)
    Country(parts(0),
      parts(1),
      parts(2),
      parts(3),
      parts(4),
      parts(5),
      airports
    )
  }

}

case class Country(id: String,
                   code: String,
                   name: String,
                   continent: String,
                   wikipediaLink: String,
                   keywords: String,
                   airports: List[Airport])

