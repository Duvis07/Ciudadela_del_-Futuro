package sura.com.constructores.s.a.s.controller

import sura.com.constructores.s.a.s.controller.AdministradorCiudadela.calcularPlazoCiudadela
import sura.com.constructores.s.a.s.models.{Ciudadela, OrdenConstruccion}


//La función guardarSolicitud recibe dos parámetros: una instancia de OrdenConstruccion y otra de Ciudadela, y retorna una nueva instancia de Ciudadela.
//  El objetivo de la función es agregar la ordenConstruccion a la lista de solicitudes de órdenes de
//construcción de la ciudadela, y calcular el nuevo plazo de entrega de la misma.


//En Scala, el método copy es una función de las
//case classes que permite crear una nueva instancia de la case class con algunas de sus propiedades actualizadas.

trait RegistrarSolicitud {
  def guardarSolicitud(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Ciudadela= {
    ciudadela.copy( solicitudesOrdenes = ciudadela.solicitudesOrdenes:+ordenConstruccion, plazoEntrega = calcularPlazoCiudadela(ciudadela))
  }
}
object RegistrarSolicitud extends RegistrarSolicitud
