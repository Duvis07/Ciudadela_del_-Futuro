package sura.com.constructores.s.a.s.view

import sura.com.constructores.s.a.s.controller.EstadoCiudadela
import sura.com.constructores.s.a.s.models.{Ciudadela, OrdenConstruccion}

trait Imprimir {

  //El método "imprimirMateriales" se utiliza para imprimir una lista de materiales en la consola.
  def imprimirMateriales(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Any = {
    println("\n << Materiales >>")
    println(s"\n Madera: ${ciudadela.material.madera}  \n Adobe = ${ciudadela.material.adobe}  \n Arena = ${ciudadela.material.arena}\n Grava = ${ciudadela.material.grava} \n Cemento = ${ciudadela.material.cemento} \n")
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  //El método "imprimirRecargaExitosa" se utiliza para imprimir un mensaje de éxito al recargar los materiales.
  def imprimirRecargaExitosa(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Any = {
    println("\n ___ Se recargaron los materiales con éxito ___")
    println(s"\n Madera: ${ciudadela.material.madera}  \n Adobe = ${ciudadela.material.adobe}  \n Arena = ${ciudadela.material.arena}\n Grava = ${ciudadela.material.grava} \n Cemento = ${ciudadela.material.cemento} \n")
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  //El método "imprimirErrorValidacion" se utiliza para imprimir un mensaje de error si no hay suficientes materiales para construir o si ya existe una construcción en las coordenadas especificadas.
  def imprimirErrorValidacion(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit = {
    println("\n No hay materiales suficientes para la construcción o ya existe una construcción en esas coordenadas \n")
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  //El método "imprimirOrden" se utiliza para imprimir un mensaje de éxito al insertar una orden de construcción en la ciudadela, junto con detalles sobre el tipo de construcción, el estado de la construcción y las coordenadas de la construcción.
  def imprimirOrden(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela) = {
    println(s"\n ___ Orden de Construcción insertada con Exito ___ \n\n Tipo de Construcción: ${ordenConstruccion.tipoConstruccion}___ " +
      s"Estado de la Construcción: ${ordenConstruccion.estadoOrden}___" +
      s" Coordenadas de la Construcción: EjeX => ${ordenConstruccion.coordenada.get.ejeX}, EjeY => ${ordenConstruccion.coordenada.get.ejeY}\n")
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

//El método "mostrarFechaCulminación" se utiliza para imprimir la fecha de culminación del proyecto si ya se inició la construcción, o un mensaje de que aún no se ha iniciado.
  def mostrarFechaCulminacion(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela) = {
    EstadoCiudadela.estadoCiudadela(ciudadela) match {
      case true => println("\nAún no  ha iniciado la construcción de la Ciudadela\n")
      case false => println(s"\n La fecha de culminación del proyecto es: ${ciudadela.fechaFin} \n")
    }
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  //El método "mostrarSolicitudOrdenes" se utiliza para imprimir una lista de todas las órdenes de construcción que se han insertado en la ciudadela.
  def mostrarSolicitudOrdenes(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela) = {
    println("\n___ Ordenes de Construcción ___")
    EstadoCiudadela.estadoCiudadela(ciudadela) match {
      case true => println("\nAún no ha insertado ninguna orden\n")
      case false => ciudadela.solicitudesOrdenes.map(ordConstruccion => println(s"\n Tipo de Construcción: ${ordConstruccion.tipoConstruccion}___ " +
        s"Estado de la Construcción: ${ordConstruccion.estadoOrden}___" +
        s" Coordenadas de la Construcción: EjeX => ${ordConstruccion.coordenada.get.ejeX}, EjeY => ${ordConstruccion.coordenada.get.ejeY}\n"))
    }
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  //El método "imprimirEstadosAct" se utiliza para imprimir un mensaje de éxito después de actualizar todos los estados de
  // construcción, seguido de una lista actualizada de todas las órdenes de construcción con sus estados actuales.
  def imprimirEstadosAct(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela) = {
    EstadoCiudadela.estadoCiudadela(ciudadela) match {
      case true => println("\nAún no ha insertado ninguna orden\n")
      case false => println("\n ___ Todos los estados fueron actualizados con éxito ___\n")
        ciudadela.solicitudesOrdenes.map(ordConstruccion => println(s"\n Tipo de Construcción: ${ordConstruccion.tipoConstruccion}___ " +
          s"Estado de la Construcción: ${ordConstruccion.estadoOrden}___" +
          s" Coordenadas de la Construcción: EjeX => ${ordConstruccion.coordenada.get.ejeX}, EjeY => ${ordConstruccion.coordenada.get.ejeY}\n"))
    }
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  //El método "imprimirBienvenida" se utiliza para imprimir un mensaje de bienvenida al programa de construcción de la ciudadela,
  // junto con información sobre el arquitecto encargado del proyecto.
  def imprimirBienvenida(ciudadela: Ciudadela): Unit = {
    println("\n ___ Bienvenido al programa de construcción de la Ciudadela ___ \n")
    println(s"\n El arquitecto encargado del proyecto es: ${ciudadela.arquitecto.nombre} \n Su número de indentificación es: ${ciudadela.arquitecto.identificacion} \n")
  }

}

object Imprimir extends Imprimir

