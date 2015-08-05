package web

import play.api.libs.json.Json

case class TodoForm(content: String)

object TodoForm {
  implicit val formReader = Json.reads[TodoForm]
}