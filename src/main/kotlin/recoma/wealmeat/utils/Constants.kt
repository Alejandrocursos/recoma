package recoma.wealmeat.utils

class Constants {

    companion object{
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION

        //Base API endpoint
        const val URL_BASE_RECETAS = "$URL_BASE/recetas"
        const val URL_BASE_INGREDIENTES = "$URL_BASE/ingredientes"
    }
}