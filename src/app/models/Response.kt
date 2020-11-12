package app.models

data class Response(val status: Int, val message: String? = null, val data: Any? = null)