import javafx.scene.image.Image

enum class selectedAction {
    ADD, DELETE, LEFT, RIGHT, ZOOM_IN, ZOOM_OUT, RESET, TILE, CASCADE, NO_ACTION
}

class Model {
    // represent my board
    private val sizeOuter = 80
    private val sizeInner = 75

    private val views = ArrayList<IView>()
    public var images = ArrayList<Image>()
    var imageSelected:Boolean = false;

    init {
    }

    // view management
    fun addView(view: IView) {
        views.add(view)
    }

    fun removeView(view: IView) {
        views.remove(view)
    }

    fun notifyView() {
        for (view in views) {
            view.update()
        }
    }

    fun addImage() {
        println("Adding an image")
        notifyView();
    }

    fun deleteImage() {
        println("Deleting an image");
        notifyView();
    }

    fun updateSelectedImage() {
        println("Updating selected image")

        notifyView();
    }

    fun activateMode(action: selectedAction) {
        when(action) {
            selectedAction.ADD -> {
                addImage()
            }
            selectedAction.DELETE -> {
                deleteImage();
            }
            selectedAction.LEFT -> {

            }
            selectedAction.RIGHT -> {

            }
            selectedAction.ZOOM_IN -> {

            }
            selectedAction.ZOOM_OUT -> {

            }
            selectedAction.RESET -> {

            }
            selectedAction.CASCADE -> {

            }
            selectedAction.TILE -> {

            }
            else -> println("NOT VALID");

        }

    }
}