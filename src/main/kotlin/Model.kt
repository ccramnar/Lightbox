import javafx.scene.image.Image
import javafx.scene.image.ImageView

enum class selectedAction {
    ADD, DELETE, LEFT, RIGHT, ZOOM_IN, ZOOM_OUT, RESET, TILE, CASCADE, NO_ACTION
}

class Model {
    // represent my board
    private val sizeOuter = 80
    private val sizeInner = 75
    public var action:selectedAction = selectedAction.NO_ACTION

    private val views = ArrayList<IView>()
    public var images = ArrayList<Image>()
    var imageSelected: ImageView? = null;
    var imageCounter:Int = 0;

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

    fun notifyAddView(image: Image) {
        for (view in views) {
            view.addImageUpdate(image)
        }
    }

    fun addImage(image: Image) {
        println("Adding an image")
        ++imageCounter;
        this.images.add(image)
        notifyAddView(image);
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
        this.action = action;
        when(action) {
            selectedAction.ADD -> {
                //addImage(image)
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
        this.action = selectedAction.NO_ACTION;

    }
}