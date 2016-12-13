package models

import scala.io.Source
import javax.inject._

trait DataLoader



@Singleton
class DataLoaderClass extends DataLoader {

  initialize

  def initialize = {
//    val runwaysLines = readFile("resources/runways.csv")
//    val runways = runwaysLines.map(line => Runway(line.split(",", -1)))
//
//    val airportsLines = readFile("resources/airports.csv")
//    val airports = airportsLines.map { line =>
//      Airport(line.split(",", -1), runways)
//    }
//
//    val countriesLines = readFile("resources/countries.csv")
//    val countries = countriesLines.map { line =>
//      Country(line.split(",", -1), airports)
//    }
  }

  def readFile(fileName: String): List[String] = {
    val lines = Source.fromFile(fileName, "UTF-8").getLines.toList
    lines.tail.map(_.replaceAll(""""""", ""))
  }
}