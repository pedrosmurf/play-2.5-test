package models

case class Report(topCountries: List[(String, Int)],
                  lowerCountries: List[(String, Int)],
                  runwaysTypes: List[(String, String)],
                  topIdentifications: List[String])