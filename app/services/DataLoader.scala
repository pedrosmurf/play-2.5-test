package services

import scala.io.Source
import javax.inject._
import models._

trait DataLoader {
  def countries:List[Country]
}


@Singleton
class DataLoaderClass extends DataLoader {

  private val runwaysLines = readFile("resources/runways.csv")
  lazy val runways = runwaysLines.map(line => Runway(line.split(",", -1)))

  private val airportsLines = readFile("resources/airports.csv")
  lazy val airports = airportsLines.map { line =>
    Airport(line.split(",", -1), runways)
  }

  private val countriesLines = readFile("resources/countries.csv")
  override lazy val countries = countriesLines.map { line =>
    Country(line.split(",", -1), airports)
  }


  private def readFile(fileName: String): List[String] = {
    val lines = Source.fromFile(fileName, "UTF-8").getLines.toList
    lines.tail.map(_.replaceAll(""""""", ""))
  }
}