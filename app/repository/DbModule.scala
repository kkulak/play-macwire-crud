package repository

trait DbModule {
  lazy val db: Db = new Db()
}
