package service

import java.util.UUID

import domain.Todo

object TodoService {
  var tmp: List[Todo] = Nil

  def create(content: String): Unit = {
    tmp = Todo(id, content) :: tmp
  }

  def findAll: List[Todo] = tmp

  def findOne(id: String): Option[Todo] = tmp find { _.id == id }

  def remove(id: String): Unit = findOne(id) match {
    case None => throw new IllegalArgumentException("Non existing Todo id")
    case Some(todo) => tmp = tmp filter { _ != todo }
  }

  private[this] def id: String = UUID.randomUUID().toString

}
