package service

import domain.Todo
import repository.Db
import sorm.Persisted

class TodoService(db: Db) {
  type PersistedTodo = Todo with Persisted

  def create(content: String): Unit = {
    db.save(Todo(content))
  }

  def findAll: List[PersistedTodo] = db.query[Todo]
    .fetch()
    .toList

  def findOne(id: Long): Option[PersistedTodo] = db.query[PersistedTodo]
    .whereEqual("id", id)
    .fetchOne()

  def remove(id: Long): Unit = findOne(id) match {
    case None => throw new IllegalArgumentException("Non existing Todo id")
    case Some(todo) => db.delete(todo)
  }

}
