import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.FlexDirection.Companion.Column
import org.jetbrains.compose.web.css.GridAutoFlow.Column
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable


object MyVariables {
    // declare a variable
    val contentBackgroundColor by variable<CSSColorValue>()
}

object MyStyleSheet: StyleSheet() {

    val container by style {
        //set variable's value for the `container` scope
        MyVariables.contentBackgroundColor(Color("gray"))
    }

    val content by style {
        // get the value
        backgroundColor(MyVariables.contentBackgroundColor.value())
    }

    val contentWithDefaultBgColor by style {
        // default value can be provided as well
        // default value is used when the value is not previously set
        backgroundColor(MyVariables.contentBackgroundColor.value(Color("#66cc66")))
    }
}

object AppStylesheet : StyleSheet() {
    val container by style { // container is a class
        display(DisplayStyle.Table)
        padding(80.px)
        textAlign("right")
        gridColumn(start = 19, end = 20)

        // custom property (or not supported out of a box)
        property("font-family", "Arial, Helvetica, sans-serif")
    }
}

@Composable
fun Container(content: @Composable () -> Unit) {
    Div(
        attrs = { classes(AppStylesheet.container) }
    ) {
        content()
    }
}


fun main() {
    renderComposable(rootElementId = "root") {
        Div({

        }) {
            Style(AppStylesheet)
            Container {
                Text("Stuff here to see")
            }
        }
    }
}