package domain

import play.api.libs.json.Json

case class Todo(id: String, content: String)

object Todo {
  implicit val todoWriter = Json.writes[Todo]
}