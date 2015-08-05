package web

import domain.Todo
import play.api.libs.json.{JsError, Json}
import play.api.mvc._
import service.TodoService
import TodoForm._
import Todo._

class TodoController extends Controller {

  def findAll = Action {
    Ok(Json.toJson(TodoService.findAll))
  }

  def findOne(id: String) = Action {
    TodoService.findOne(id) match {
      case None => BadRequest
      case Some(todo) => Ok(Json.toJson(todo))
    }
  }

  def create = Action(parse.json) { request =>
    val f = request.body.validate[TodoForm]
    f.fold(
      errors => BadRequest(JsError.toJson(errors)),
      form => {
        TodoService.create(form.content)
        Ok
      }
    )
  }

  def remove(id: String) = Action {
    TodoService.remove(id)
    NoContent
  }

}
