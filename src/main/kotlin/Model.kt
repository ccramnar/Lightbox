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

    fun notifyDeleteView() {
        for (view in views) {
            view.deleteImageUpdate()
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
        --imageCounter;
        notifyDeleteView();
    }

    fun rotateLeft() {
        println("Rotating left" + imageSelected?.getRotate())
        imageSelected?.setRotate(imageSelected?.getRotate()!!.minus(10) );

    }

    fun rotateRight() {
        println("Rotating Right")
        imageSelected?.setRotate(imageSelected?.getRotate()!!.plus(10) );

    }

    fun zoomIn() {
        this.imageSelected?.scaleX = imageSelected?.scaleX!!.plus(0.25);
        this.imageSelected?.scaleY = imageSelected?.scaleY!!.plus(0.25);
    }

    fun zoomOut() {
        this.imageSelected?.scaleX = imageSelected?.scaleX!!.minus(0.25);
        this.imageSelected?.scaleY = imageSelected?.scaleY!!.minus(0.25);
    }

    fun reset() {
        this.imageSelected?.scaleX = 1.0;
        this.imageSelected?.scaleY = 1.0;
        imageSelected?.setRotate(0.0);
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
                rotateLeft();
            }
            selectedAction.RIGHT -> {
                rotateRight();
            }
            selectedAction.ZOOM_IN -> {
                zoomIn();
            }
            selectedAction.ZOOM_OUT -> {
                zoomOut()
            }
            selectedAction.RESET -> {
                reset()
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