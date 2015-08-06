package service

import repository.DbModule
import com.softwaremill.macwire._

trait ServiceModule extends DbModule {
  lazy val todoService: TodoService = wire[TodoService]
}
