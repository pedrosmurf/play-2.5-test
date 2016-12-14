package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models.Country
import services.DataLoader


@Singleton
class MainController @Inject()(data: DataLoader) extends Controller {

  def index = Action {
    Redirect(routes.MainController.query(""))
  }

  def query(country:String) = Action {
    val countries: List[Country] = data.findCountries(country)
    Ok(views.html.query(countries))
  }

  def doQuery = Action {request =>
    val country = request.body.asFormUrlEncoded.get("country").headOption.getOrElse("")
    Redirect(routes.MainController.query(country))
  }

  def report = Action {
    Ok(views.html.report(data.report))
  }

}
