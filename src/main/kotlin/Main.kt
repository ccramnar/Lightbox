import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage?) {
        val model = Model()

        // our layout is the root of the scene graph
        val root = BorderPane()

        // views are the children of the vbox
        val toolbar = ToolbarView( model)
        val grid = GridView(model)
        val status = StatusView(model)

        // register views with the model
        model.addView(toolbar)
        model.addView(status)
        model.addView(grid)


        // setup and display
        root.top = toolbar;
        root.center = grid;
        root.bottom = status;
        //root.children.addAll(toolbar, grid, status)
        stage?.scene = Scene(root)
        //stage?.isResizable = false
        stage?.width = 800.0
        stage?.height = 600.0
        stage?.title = "Lightbox ccramnar(20786590)"
        stage?.show()
    }
}