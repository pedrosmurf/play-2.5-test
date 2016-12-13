package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models.Country


@Singleton
class MainController @Inject() extends Controller {

  def index = Action {
    Redirect(routes.MainController.query())
  }

  def query = Action {
    val countries:List[Country] = Nil
    Ok(views.html.query(countries))
  }

  def doQuery = Action {
    val countries:List[Country] = Nil
    Ok(views.html.query(countries))
  }

  def report = Action {
    Ok(views.html.report())
  }

}
