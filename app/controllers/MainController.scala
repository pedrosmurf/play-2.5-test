package controllers

import javax.inject._
import play.api._
import play.api.mvc._


@Singleton
class MainController @Inject() extends Controller {

  def index = Action {
    Redirect(routes.MainController.query())
  }

  def query = Action {
    Ok(views.html.query())
  }

  def report = Action {
    Ok(views.html.report())
  }

}
