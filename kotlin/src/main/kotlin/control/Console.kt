package control

class Console private constructor() {

    companion object {

        fun readInt( msg: String ) : Int {

            var ret: Int? = null

            do {

                print( msg )

                val info = readLine()

                if( info != null && info != "" ) {

                    ret =  info.toIntOrNull()

                    if( ret == null || ret <= 0) {
                        println("Valor inválido.")
                    }

                }

            }while ( ret == null || ret <= 0)

            return ret

        }

        fun readString( msg: String ): String {

            var ret: String? = null

            do {

                print( msg )
                val info = readLine()

                if( info != null && info != "" ) {

                    ret =  info.lowercase()

                } else {
                    println( "Valor inválido." )
                }

            }while ( ret == null )

            return ret

        }


    }
}