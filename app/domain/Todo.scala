package domain

import play.api.libs.json.Json
import sorm.Persisted

case class Todo(content: String)

object Todo {
  implicit val todoWriter = Json.writes[Todo]
}