package classes

sealed class HomeScreenState

object Initial : HomeScreenState()

data class Loading(val progress: Float) : HomeScreenState()

data class Ready(val data: List<String>) : HomeScreenState()

data class Error(
    val exception: Exception,
    val message: String
) : HomeScreenState()
