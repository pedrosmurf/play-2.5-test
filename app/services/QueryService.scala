package services

import javax.inject._
import models._

@Singleton
class QueryService @Inject()(data: DataLoader) {
  def findCountries(query: String): List[Country] = {
    query match {
      case "" => Nil
      case _ => data.countries.filter { country =>
        country.code.toLowerCase.contains(query.toLowerCase) || country.name.toLowerCase.contains(query.toLowerCase)
      }
    }
  }
}