
import com.softwaremill.macwire._
import controllers.Assets
import play.api.BuiltInComponents
import play.api.routing.Router
import repository.DbModule
import router.Routes
import service.ServiceModule
import web.TodoController

trait Application extends BuiltInComponents with ServiceModule with DbModule {
  lazy val assets: Assets = wire[Assets]
  lazy val router: Router = wire[Routes] withPrefix "/"
  lazy val todoCtrl: TodoController = wire[TodoController]
}
