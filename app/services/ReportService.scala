package services

import javax.inject._
import models._

@Singleton
class ReportService @Inject()(data: DataLoader) {
  lazy val report: Report = {
    val orderedCountries = data.countries.sortBy(_.airports.length)

    val topCountries = orderedCountries.takeRight(10).reverse.map(country => (country.name, country.airports.length))
    val lowerCountries = orderedCountries.take(10).reverse.map(country => (country.name, country.airports.length))

    val surfaceTypes = data.countries.map { country =>
      val countrySurfaceTypes: List[String] = country.airports.flatMap(_.runways.map(_.surface)).distinct
      val surfaces: String = countrySurfaceTypes.fold("")((surfaceType, acc) => surfaceType + " - " + acc)
      (country.name, surfaces)
    }

    val identifiers = data.countries.flatMap { country =>
      country.airports.flatMap(_.runways.map(_.leIdent))
    }
    val identifiersWithCount = identifiers.map { id =>
      (id, identifiers.filter(_ == id).length)
    }.distinct

    val topIdentifiers = identifiersWithCount.sortBy(_._2).reverse.map(_._1).take(10)

    Report(topCountries, lowerCountries, surfaceTypes, topIdentifiers)
  }
}