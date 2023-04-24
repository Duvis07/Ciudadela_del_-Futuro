package sura.com.constructores.s.a.s.models

sealed trait EstadoOrden

  case class Pendiente() extends EstadoOrden

  case class Terminado() extends EstadoOrden

  case class EnProgreso() extends EstadoOrden


