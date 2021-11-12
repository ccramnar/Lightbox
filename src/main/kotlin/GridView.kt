import javafx.geometry.Insets
import javafx.scene.control.ScrollPane
import javafx.scene.effect.DropShadow
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.DragEvent
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.FlowPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle


class GridView(gmodel: Model) : IView, ScrollPane() {
    private var model: Model? = gmodel;
    public var pane: FlowPane? = FlowPane();


    init {
        this.padding = Insets(10.0, 10.0, 10.0, 10.0);
        //this.hgap = 10.0;
       // this.vgap = 10.0;
        this.height = 700.0;
        this.width = 500.0;
        this.setPrefSize(595.0, 200.0);
        pane!!.toBack()
        pane!!.hgap = 10.0
        pane!!.vgap = 10.0;
        this.content = pane
        for (item in model?.images!!) {
            pane!!.getChildren().add(ImageView(item));
        }
        this.toBack()
       this.setOnMousePressed {
            println("clicking the grid")
            if (model?.imageSelected != null) {
                model?.imageSelected?.effect = null;
                model?.imageSelected = null
                model?.notifyView();
            }
           it.consume()
        }

    }

   fun imageClick(imageView: ImageView) {
       imageView.toFront()
       if (model?.imageSelected != null) {
           model?.imageSelected?.effect = null;
           model?.imageSelected = null
       }
       println("clicking the image")
       imageView.effect = DropShadow(20.0, Color.BLACK)
       model?.imageSelected = imageView
       model?.notifyView();
   }

    fun imageDrag(imageView: ImageView, event: MouseEvent) {
        imageView.toFront()
        if (model?.imageSelected != null) {
            model?.imageSelected?.effect = null;
            model?.imageSelected = null
        }
        model?.imageSelected = imageView
        imageView.x = event.x
        imageView.y = event.y
        println(event)
    }

    override fun addImageUpdate(item: Image) {
            var imageView = ImageView(item);
            imageView.setFitHeight(200.0);
            imageView.setFitWidth(200.0);
            imageView.setPreserveRatio(true);
             imageView.toFront()
            imageView.setOnMouseClicked {
                imageClick(imageView)
                it.consume()
            }
            imageView.setOnMouseDragged {event->
                imageDrag(imageView, event)
                event.consume()
            }
        println(imageView.x.toString() +"  " + imageView.y)
        println(imageView.layoutX.toString() +"  " + imageView.layoutY)
        println(imageView.x.toString() +"  " + imageView.y)
        this.getChildren()?.add(imageView);
    }

    override fun deleteImageUpdate() {
        this.getChildren()?.remove(model?.imageSelected);
    }

    override fun update() {
        println("Refreshing the pane")
    }
}