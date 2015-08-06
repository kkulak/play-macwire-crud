package web

import domain.Todo
import play.api.libs.json.{JsError, Json}
import play.api.mvc._
import service.TodoService
import TodoForm._
import Todo._

class TodoController(todoService: TodoService) extends Controller {

  def findAll = Action {
    Ok(Json.toJson(todoService.findAll))
  }

  def findOne(id: Long) = Action {
    todoService.findOne(id) match {
      case None => BadRequest
      case Some(todo) => Ok(Json.toJson(todo))
    }
  }

  def create = Action(parse.json) { request =>
    val f = request.body.validate[TodoForm]
    f.fold(
      errors => BadRequest(JsError.toJson(errors)),
      form => { todoService.create(form.content); Ok }
    )
  }

  def remove(id: Long) = Action {
    todoService.remove(id)
    NoContent
  }

}
