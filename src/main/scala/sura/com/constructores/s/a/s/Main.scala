package sura.com.constructores.s.a.s


import sura.com.constructores.s.a.s.models.{Ciudadela, OrdenConstruccion}
import sura.com.constructores.s.a.s.view.{Imprimir, MenuPrincipal}

import java.util.Calendar


object Main {
  def main(args: Array[String]): Unit = {

    val fechaInicioProyecto = Calendar.getInstance()
    val ordenConstruccion: OrdenConstruccion = OrdenConstruccion(None, None)
    val ciudadela: Ciudadela = Ciudadela(None, fechaInicio = fechaInicioProyecto)
    Imprimir.imprimirBienvenida(ciudadela)
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)

  }
}

//El código proporcionado crea una instancia de Calendar llamada fechaInicioProyecto que representa la fecha y hora actuales. Luego, crea dos instancias vacías de OrdenConstruccion y Ciudadela.
//Después, llama a la función Imprimir.imprimirBienvenida(ciudadela) que imprime un mensaje de bienvenida y muestra información sobre la Ciudadela recién creada.
//
//Finalmente, llama a la función MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela) para mostrar el menú principal de la aplicación y permitir que el usuario interactúe con ella. La función recibe como
// parámetros la OrdenConstruccion y Ciudadela creadas anteriormente, y se encarga de manejar la lógica de la aplicación y las interacciones del usuario.
//
//En resumen, este código establece las variables necesarias para crear una nueva Ciudadela y OrdenConstruccion, muestra un mensaje de bienvenida y luego muestra el menú principal de la aplicación para que
// el usuario pueda interactuar con ella.