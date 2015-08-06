
import play.api.ApplicationLoader.Context
import play.api._

class Loader extends ApplicationLoader {

  override def load(context: Context): play.api.Application = {
    Logger.configure(context.environment)
    (new BuiltInComponentsFromContext(context) with Application).application
  }

}
