package service

import domain.Todo
import repository.Db
import sorm.Persisted

object TodoService {
  type PersistedTodo = Todo with Persisted

  def create(content: String): Unit = {
    Db.save(Todo(content))
  }

  def findAll: List[PersistedTodo] = Db.query[Todo]
    .fetch()
    .toList

  def findOne(id: Long): Option[PersistedTodo] = Db.query[PersistedTodo]
    .whereEqual("id", id)
    .fetchOne()

  def remove(id: Long): Unit = findOne(id) match {
    case None => throw new IllegalArgumentException("Non existing Todo id")
    case Some(todo) => Db.delete(todo)
  }

}
