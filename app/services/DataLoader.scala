package services

import scala.io.Source
import javax.inject._
import models._

trait DataLoader {
  def findCountries(query: String): List[Country]

  def report: Report
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
  lazy val countries = countriesLines.map { line =>
    Country(line.split(",", -1), airports)
  }


  private def readFile(fileName: String): List[String] = {
    val lines = Source.fromFile(fileName, "UTF-8").getLines.toList
    lines.tail.map(_.replaceAll(""""""", ""))
  }


  override def findCountries(query: String): List[Country] = {
    query match {
      case "" => Nil
      case _ => countries.filter { country =>
        country.code.toLowerCase.contains(query.toLowerCase) || country.name.toLowerCase.contains(query.toLowerCase)
      }
    }
  }

  override def report: Report = {
    val orderedCountries = countries.sortBy(_.airports.length)

    val topCountries = orderedCountries.takeRight(10).reverse.map(country => (country.name, country.airports.length))
    val lowerCountries = orderedCountries.take(10).reverse.map(country => (country.name, country.airports.length))

    val surfaceTypes = countries.map { country =>
      val countrySurfaceTypes: List[String] = country.airports.flatMap(_.runways.map(_.surface)).distinct
      val surfaces: String = countrySurfaceTypes.fold("")((surfaceType, acc) => surfaceType + " - " + acc)
      (country.name, surfaces)
    }

    val identifiers = countries.flatMap { country =>
      country.airports.flatMap(_.runways.map(_.leIdent))
    }
    val identifiersWithCount = identifiers.map { id =>
      (id, identifiers.filter(_ == id).length)
    }.distinct

    val topIdentifiers = identifiersWithCount.sortBy(_._2).reverse.map(_._1).take(10)

    Report(topCountries, lowerCountries, surfaceTypes, topIdentifiers)
  }
}