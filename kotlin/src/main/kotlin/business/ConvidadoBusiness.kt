package business

class ConvidadoBusiness {

    fun tipoValido( tipo: String ) = ( tipo == "comum" || tipo == "premium" || tipo == "luxo" )

    fun codigoValido( codigo: String, tipo: String ): Boolean {

        return (tipo == "comum" && codigo.startsWith("xt")) || (tipo == "premium" || tipo == "luxo") && codigo.startsWith("xl")

    }


}