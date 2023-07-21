import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
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
        backgroundColor(MyVariables.contentBackgroundColor.value(Color("#66cc66")))
    }

    val contentWithDefaultBgColor by style {
        // default value can be provided as well
        // default value is used when the value is not previously set
        backgroundColor(MyVariables.contentBackgroundColor.value(Color("#66cc66")))
    }
}

object AppStylesheet : StyleSheet() {
    val containerColumn by style { // container is a class
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Stretch)
        padding(100.px)
        textAlign("center")


        // custom property (or not supported out of a box)
        property("font-family", "Arial, Helvetica, sans-serif")
    }
    val containerRow by style {// container is a class
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Stretch)
        padding(100.px)
        textAlign("center")

    }
}

@Composable
fun Row (content: @Composable () -> Unit){
    Div (
        attrs = {classes(AppStylesheet.containerRow)}
    ){
        content()
    }
}


@Composable
fun Container(content: @Composable () -> Unit) {
    Div(
        attrs = { classes(AppStylesheet.containerColumn) }
    ) {
        content()
    }
}



fun main() {
    renderComposable(rootElementId = "root") {
        /*var count by remember { mutableStateOf(0) }
        LaunchedEffect(Unit){
            while (true){
                count++
                delay(500)
            }
        }*/
        Style(AppStylesheet)
        Style(MyStyleSheet)
        Row{
            Container {
                Img(
                    "https://avatars.githubusercontent.com/u/6810041?v=4",
                    attrs = {
                        style {
                            borderRadius(100.percent)
                        }
                    }
                )
                Div(attrs = {
                    classes(MyStyleSheet.content)
                }) {
                    Text("Column 1")
                }
            }
            Container {
                Text("Column 2")
            }
        }
    }
}