package inheritance

interface OnClickListener {

    fun onClick()
}

interface OnLongClickListener {

    fun onLongClick()
}

interface CombinedClickListener : OnClickListener, OnLongClickListener

class CustomListener : CombinedClickListener {

    override fun onClick() {
        // Implement
    }

    override fun onLongClick() {
        // Implement
    }
}

