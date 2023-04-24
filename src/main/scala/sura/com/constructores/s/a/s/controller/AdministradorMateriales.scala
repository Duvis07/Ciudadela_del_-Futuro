package sura.com.constructores.s.a.s.controller

import sura.com.constructores.s.a.s.models.{Material, OrdenConstruccion}

object AdministradorMateriales {

  // : Esta función recibe un objeto Material y devuelve otro objeto Material con los valores de cada tipo de material incrementados en 500 unidades.
  def recargaMateriales(materiales: Material): Material = {
    materiales.copy(
      cemento = materiales.cemento + 500,
      grava = materiales.grava + 500,
      arena = materiales.arena + 500,
      madera = materiales.madera + 500,
      adobe = materiales.adobe + 500)
  }

  //  Esta función recibe una OrdenConstruccion y un objeto Material. Retorna un objeto Material con los
  //  valores de cada tipo de material decrementados en la cantidad correspondiente según la OrdenConstruccion dada.
  def descontarMaterial(ordenConstruccion: OrdenConstruccion, materiales: Material): Material = {
    materiales.copy(cemento = materiales.cemento - ordenConstruccion.tipoConstruccion.get.cemento,
      grava = materiales.grava - ordenConstruccion.tipoConstruccion.get.grava,
      adobe = materiales.adobe - ordenConstruccion.tipoConstruccion.get.adobe,
      madera = materiales.madera - ordenConstruccion.tipoConstruccion.get.madera,
      arena = materiales.arena - ordenConstruccion.tipoConstruccion.get.arena)
  }


}
