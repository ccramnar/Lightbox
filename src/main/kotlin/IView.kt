import javafx.scene.image.Image

interface IView {
    fun update()
    fun addImageUpdate(image:Image)
    fun deleteImageUpdate();
}