import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import javafx.scene.image.Image
import javafx.stage.FileChooser
import javafx.stage.Stage


class ToolbarView( gmodel: Model) : IView, ToolBar() {
    val model:Model = gmodel;
    var deleteButton:Button;
    var rotateleftButton:Button;
    var rotaterightButton:Button;
    var zoominButton:Button;
    var zoomoutButton:Button;
    var resetButton:Button;
    public var f: FileChooser =  FileChooser();
    init {
        // add buttons to toolbar
        val addButton = Button("Add Image")
        addButton.setOnMouseClicked {
            var file = f.showOpenDialog(Stage());
            var img  = Image(file.toURI().toString());
            model.addImage(img);
            model.activateMode(selectedAction.ADD);
        }
        val addImageView = javafx.scene.image.ImageView((Image("add-image.jpg")))
        addButton.graphic = (addImageView)
        addImageView.fitWidthProperty().bind(addButton.widthProperty().divide(5))
        addImageView.isPreserveRatio = true
        addButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(addButton)

        deleteButton = Button("Del Image")
        deleteButton.setOnMouseClicked { model.activateMode(selectedAction.DELETE) }
        val deleteImageView = javafx.scene.image.ImageView((Image("delete-image.jpg")))
        deleteButton.graphic = (deleteImageView)
        deleteImageView.fitWidthProperty().bind(deleteButton.widthProperty().divide(5))
        deleteImageView.isPreserveRatio = true
        deleteButton.setMaxWidth(Double.MAX_VALUE)
        deleteButton.setDisable(true)
        this.items.add(deleteButton)

        rotateleftButton = Button("Rotate Left")
        rotateleftButton.setOnMouseClicked { model.activateMode(selectedAction.LEFT) }
        val rotateleftImageView = javafx.scene.image.ImageView((Image("rotate-left.jpg")))
        rotateleftButton.graphic = (rotateleftImageView)
        rotateleftImageView.fitWidthProperty().bind(rotateleftButton.widthProperty().divide(5))
        rotateleftImageView.isPreserveRatio = true
        rotateleftButton.setMaxWidth(Double.MAX_VALUE)
        rotateleftButton.setDisable(true)
        this.items.add(rotateleftButton)

        rotaterightButton = Button("Rotate Right")
        rotaterightButton.setOnMouseClicked { model.activateMode(selectedAction.RIGHT) }
        val rotaterightImageView = javafx.scene.image.ImageView((Image("rotate-right.jpg")))
        rotaterightButton.graphic = (rotaterightImageView)
        rotaterightImageView.fitWidthProperty().bind(rotaterightButton.widthProperty().divide(5))
        rotaterightImageView.isPreserveRatio = true
        rotaterightButton.setMaxWidth(Double.MAX_VALUE)
        rotaterightButton.setDisable(true)
        this.items.add(rotaterightButton)

        zoominButton = Button("Zoom In")
        zoominButton.setOnMouseClicked { model.activateMode(selectedAction.ZOOM_IN) }
        val zoominImageView = javafx.scene.image.ImageView((Image("zoom-in.jpg")))
        zoominButton.graphic = (zoominImageView)
        zoominImageView.fitWidthProperty().bind(zoominButton.widthProperty().divide(5))
        zoominImageView.isPreserveRatio = true
        zoominButton.setMaxWidth(Double.MAX_VALUE)
        zoominButton.setDisable(true)
        this.items.add(zoominButton)

        zoomoutButton = Button("Zoom Out")
        zoomoutButton.setOnMouseClicked { model.activateMode(selectedAction.ZOOM_OUT) }
        val zoomoutImageView = javafx.scene.image.ImageView((Image("zoom-out.jpg")))
        zoomoutButton.graphic = (zoomoutImageView)
        zoomoutImageView.fitWidthProperty().bind(zoomoutButton.widthProperty().divide(5))
        zoomoutImageView.isPreserveRatio = true
        zoomoutButton.setMaxWidth(Double.MAX_VALUE)
        zoomoutButton.setDisable(true)
        this.items.add(zoomoutButton)

        resetButton = Button("Reset")
        resetButton.setOnMouseClicked { model.activateMode(selectedAction.ZOOM_OUT) }
        val resetImageView = javafx.scene.image.ImageView((Image("zoom-out.jpg")))
        resetButton.graphic = (resetImageView)
        resetImageView.fitWidthProperty().bind(resetButton.widthProperty().divide(5))
        resetImageView.isPreserveRatio = true
        resetButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(resetButton)

        val cascadeButton = Button("Cascade")
        cascadeButton.setOnMouseClicked { model.activateMode(selectedAction.ZOOM_OUT) }
        val cascadeImageView = javafx.scene.image.ImageView((Image("zoom-out.jpg")))
        cascadeButton.graphic = (cascadeImageView)
        cascadeImageView.fitWidthProperty().bind(cascadeButton.widthProperty().divide(5))
        cascadeImageView.isPreserveRatio = true
        cascadeButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(cascadeButton)

        val tileButton = Button("Tile")
        tileButton.setOnMouseClicked { model.activateMode(selectedAction.ZOOM_OUT) }
        val tileImageView = javafx.scene.image.ImageView((Image("zoom-out.jpg")))
        tileButton.graphic = (tileImageView)
        tileImageView.fitWidthProperty().bind(tileButton.widthProperty().divide(5))
        tileImageView.isPreserveRatio = true
        tileButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(tileButton)

    }

    fun updateButtons() {
        if (model.imageSelected != null) {
            deleteButton.setDisable(false)
            rotateleftButton.setDisable(false)
            rotaterightButton.setDisable(false)
            zoominButton.setDisable(false)
            zoomoutButton.setDisable(false)
            resetButton.setDisable(false)
        } else {
            deleteButton.setDisable(true)
            rotateleftButton.setDisable(true)
            rotaterightButton.setDisable(true)
            zoominButton.setDisable(true)
            zoomoutButton.setDisable(true)
            resetButton.setDisable(true)
        }
    }

    override fun update() {
        updateButtons()
    }

    override fun addImageUpdate(image:Image) {

    }
}