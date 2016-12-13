package models

object Airport {

  def apply(parts: Array[String], possibleRunways: List[Runway]): Airport = {
    val airportId = parts(0)
    val runways = possibleRunways.filter(_.airportRef == airportId)
    Airport(parts(0),
      parts(1),
      parts(2),
      parts(3),
      parts(4),
      parts(5),
      parts(6),
      parts(7),
      parts(8),
      parts(9),
      parts(10),
      parts(11),
      parts(12),
      parts(13),
      parts(14),
      parts(15),
      parts(16),
      parts(17),
      runways
    )
  }

}

case class Airport(id: String,
                   ident: String,
                   airportType: String,
                   name: String,
                   latitudeDeg: String,
                   longitudeDeg: String,
                   elevationFeet: String,
                   continent: String,
                   isoCountry: String,
                   isoRegion: String,
                   municipality: String,
                   scheduledService: String,
                   gpsCode: String,
                   iataCode: String,
                   localCode: String,
                   homeLink: String,
                   wikipediaLink: String,
                   keywords: String,
                   runways: List[Runway])

