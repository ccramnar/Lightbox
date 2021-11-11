import javafx.geometry.Insets
import javafx.scene.effect.DropShadow
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.FlowPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle


class GridView(gmodel: Model) : IView, FlowPane() {
    private var model: Model? = gmodel;


    init {
        this.padding = Insets(10.0, 10.0, 10.0, 10.0);
        for (item in model?.images!!) {
            this.getChildren().add(ImageView(item));
        }
        this.toBack()
       this.setOnMouseClicked {
            println("clicking the grid")
            if (model?.imageSelected != null) {
                model?.imageSelected?.clip = null;
                model?.imageSelected?.effect = null;
                model?.imageSelected = null
                model?.notifyView();
            }
           it.consume()
        }

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

    override fun addImageUpdate(item: Image) {
            var imageView = ImageView(item);
            imageView.setFitHeight(100.0);
            imageView.setFitWidth(100.0);
            imageView.setPreserveRatio(true);
             imageView.toFront()
            imageView.setOnMouseClicked {
                if (model?.imageSelected != null) {
                    model?.imageSelected?.clip = null;
                    model?.imageSelected?.effect = null;
                    model?.imageSelected = null
                }
                println("clicking the image")
                val clip = Rectangle(
                    imageView.fitWidth, imageView.fitHeight
                )
                clip.arcWidth = 20.0
                clip.arcHeight = 20.0
                imageView.clip = clip
                imageView.effect = DropShadow(20.0, Color.BLACK)
                model?.imageSelected = imageView
                model?.notifyView();
                it.consume()
            }
        this.getChildren().add(imageView);
    }

    override fun update() {
        println("Refreshing the pane")
    }
}