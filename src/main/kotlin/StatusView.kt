import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.layout.HBox

class StatusView(gmodel: Model) : IView, HBox() {
    val model: Model = gmodel;
    val actionLabel = Label();
    val counterLabel = Label();
    init {
        actionLabel.text = "No action has been completed"
        counterLabel.text = "Number of images: " + model.imageCounter;
        setSpacing(100.0);
        setMargin(actionLabel, Insets(5.0, 20.0, 5.0, 20.0))
        setMargin(counterLabel, Insets(5.0, 5.0, 5.0, 20.0))
        getChildren().addAll(actionLabel, counterLabel);
    }

    override fun update() {
        counterLabel.text = "Number of images: " + model.imageCounter;
        if (model.action == selectedAction.ADD) {
            actionLabel.text = "Game has begun, No action has been performed"
        } else if (model.action == selectedAction.NO_ACTION) {
            actionLabel.text = "Clear Action was performed"
        } else {
            actionLabel.text = (model.action).toString() + " pattern was added to the grid"
        }
    }

    override fun addImageUpdate(image: Image) {
        counterLabel.text = "Number of images: " + model.imageCounter;
        actionLabel.text = "Image has been added"
    }
}