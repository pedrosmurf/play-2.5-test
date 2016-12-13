package models

object Runway {

  def apply(parts: Array[String]): Runway = {
    Runway(parts(0),
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
      parts(18),
      parts(19)
    )
  }

}

case class Runway(id: String,
                  airportRef: String,
                  airportIdent: String,
                  lengthFeet: String,
                  widthFeet: String,
                  surface: String,
                  lighted: String,
                  closed: String,
                  leIdent: String,
                  leLatitudeDeg: String,
                  leLongitudeDeg: String,
                  leElevationFeet: String,
                  leHeadingDegT: String,
                  leDisplacedThresholdFeet: String,
                  heIdent: String,
                  heLatitudeDeg: String,
                  heLongitudeDeg: String,
                  heElevationFeet: String,
                  heHeadingDegT: String,
                  heDisplacedThresholdFeet: String)

