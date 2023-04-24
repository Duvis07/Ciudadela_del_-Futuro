package sura.com.constructores.s.a.s

import sura.com.constructores.s.a.s.clases.construcciones._
import sura.com.constructores.s.a.s.clases.coordenadas.Coordenada
import sura.com.constructores.s.a.s.clases.ordenes.OrdenConstruccion
import sura.com.constructores.s.a.s.clases.solicitud.Solicitud

import java.time.LocalDateTime


object Main {
  def main(args: Array[String]): Unit = {

    //Se crea la lista de solicitudes de construcción con sus respectivos datos y coordenadas
    println()
    println("..:: Lista de solicitudes de construcción ::..")

    val lista: List[Solicitud] = List(
      Solicitud(Casa(111, 22, 70, 90, 90), Coordenada(1, 4)),
      Solicitud(Lago(111, 111, 41, 55, 90), Coordenada(2, 4)),
      Solicitud(Edificio(200, 100, 1080, 100, 200), Coordenada(3, 4)),
      Solicitud(CanchaDeFutbol(100, 100, 100, 100, 100), Coordenada(3, 4)),
      Solicitud(Gimnasio(111, 232, 400, 505, 600), Coordenada(1, 4)),

    )


    //Se filtran las solicitudes que no tienen orden de construcción y se retorna la lista de solicitudes con orden de construcción
    try {
      val listaNueva = test2(lista)
      println()
//      println("..:: Lista de solicitudes con orden de construcción ::..")
//      listaNueva.foreach(a => println(a))
    } catch {
      case e: Exception => println(s"ERROR: ${e.getMessage}")
    }

  }


  //Se crea el método test2 para probar la creación de solicitudes de construcción y se retorna la lista de solicitudes con orden de construcción creada
  def test2(lista: List[Solicitud]) = {
    lista.filter(item => item.empezarConstruccion().isDefined)
      .map(solicitud => {
        solicitud.empezarConstruccion().get
      })
  }

//  //Se crea el método test1 para probar la creación de solicitudes de construcción
//  def test1(): Unit = {
//    val lista = List(
//      Casa(111, 22, 4, 55, 90),
//      Casa(11, 332, 40, 5, 90),
//      Casa(100, 100, 100, 100, 100),
//      Lago(100, 100, 100, 100, 100),
//      Edificio(100, 100, 100, 100, 100)
//    )
//
//    //  se crea la solicitud de construcción con los datos de la lista y se crea la orden de construcción con la solicitud y la fecha de inicio de la construcción
//    //Se imprime la orden de construcción
//    for (item <- lista) {
//      val solicitud: Solicitud = Solicitud(item, Coordenada(1, 2))
//      val orden: Option[OrdenConstruccion] = solicitud.empezarConstruccion()
//      val orden2: Option[OrdenConstruccion] = solicitud.empezarConstruccion(LocalDateTime.of(2022, 7, 15, 7, 0))
//
//      println(orden)
//      println(orden2)
//
//    }
//
//  }
//
}

