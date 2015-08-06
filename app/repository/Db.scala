package repository

import domain.Todo
import sorm._

class Db extends Instance(
  entities = Set(Entity[Todo]()),
  url = "jdbc:h2:mem:test",
  user = "",
  password = "",
  initMode = InitMode.DropAllCreate
)