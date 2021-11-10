import javafx.geometry.Insets
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.FlowPane
import javafx.scene.layout.Pane
import javafx.scene.shape.Rectangle


class GridView(gmodel: Model) : IView, FlowPane() {
    private var model: Model? = gmodel;


    init {
        this.padding = Insets(10.0, 10.0, 10.0, 10.0);
        for (item in model?.images!!) {
            this.getChildren().add(ImageView(item));
        }

    }

    private fun addPatternMouseEvent(e: MouseEvent) {
        val eventSource = e.source as Rectangle
        println(e)
        println(e.source)
        println(model)
        //model?.addPattern(eventSourceRow, eventSourceCol)
    }

    fun handleKeyEvents(keyEvent: KeyEvent) {
        if (keyEvent.code == KeyCode.P) {
            println("Play pressed")
            keyEvent.consume()
            //model?.play()
        }
        if (keyEvent.code == KeyCode.S) {
            println("Stop pressed")
            keyEvent.consume()
            //model?.pause()
        }
        if (keyEvent.code == KeyCode.F) {
            println("Space pressed")
            keyEvent.consume()
            //model?.step()
        }
    }

    fun addImage() {
        for (item in model?.images!!) {
            var imageView = ImageView(item);
            imageView.setFitHeight(100.0);
            imageView.setFitWidth(100.0);
            imageView.setPreserveRatio(true);
            this.getChildren().add(imageView);
            imageView.setOnMouseClicked { event ->
                println(event)
                model!!.updateSelectedImage() }
        }
    }

    override fun update() {
        println("Refreshing the pane")
        addImage()
    }
}