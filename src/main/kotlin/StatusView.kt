import javafx.scene.control.Label
import javafx.scene.layout.HBox

class StatusView(gmodel: Model) : IView, HBox() {
    val model: Model = gmodel;
    val selectedLabel = Label();
    val counterLabel = Label();
    init {
        // add stuff
    }

    override fun update() {
        // react to updates from model
    }
}