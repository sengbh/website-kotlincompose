import AppStylesheet.attr
import AppStylesheet.attrContains
import AppStylesheet.containerBackground
import AppStylesheet.style
import MyStyleSheet.style
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.fetch.Body


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
        backgroundColor(MyVariables.contentBackgroundColor.value(Color("green")))
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
        padding(50.px)
        justifyContent(justifyContent = JustifyContent.Center)
    }

    val containerBackground by style {
        display(DisplayStyle.Flex)
        style{
            MyStyleSheet.content
        }

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
            //First column on the left
            Container {
                Text("Column 1")
                H1 {
                    Text("David S")
                }
                Span (
                    attrs = {
                        style {
                            color(Color.gray)
                            paddingBottom(10.px)
                            paddingTop(0.px)
                        }
                    }
                ){
                    Text("Android Dev, Web3 Research, Aspired to build")
                }
                //body description here
                Div (
                    attrs = {
                        style {
                            fontWeight("bold")
                            textAlign("left")
                            paddingTop(0.px)
                            paddingBottom(10.px)
                            textDecoration("underline")
                        }
                    }
                ){
                    Text("About:")
                }
                //next line
                Text("Hello, my name BB. I am a developer of android development. " +
                        "This is some text to check out the description part"+
                        "Just writng to fill in text to see more paragraph and how it looks on the UI front end.")

                Div(
                    attrs = {
                        style {
                            fontWeight("bold")
                            textAlign("left")
                            paddingTop(10.px)
                            paddingBottom(5.px)
                            textDecoration("underline")
                        }
                    }
                ){
                    Text("Technology")
                }
            }

            //Second column on the right
            Container {
                    Text("Column 2")
                    Span(
                        attrs = {
                            style {
                                textAlign("left")
                                paddingTop(10.px)
                            }
                        }
                    ){
                        Text("Making a list here below")
                        Ul(
                            attrs = {
                                style {

                                }
                            }
                        ){
                            Li{
                                Text("This is a list number 1 and I want to fill in more text to see how it aligns with the left column")
                            }
                            Li{
                                Text("This is a list number 2 and I want to fill in more text to see how it aligns with the left column"+
                                "So far it looks pretty good. This is fine let's move on to the next task")
                            }
                            Li{
                                Text("one")
                            }
                            Li{
                                Text("one")
                            }
                        }
                    }
            }
        }
        Hr(null)
        //let's make a second row after description. Let's get in some contact here
        Row {
            Text("Testing the row on the bottom of the description")
        }
        /*Row{
            Container {
                Img(
                    "https://avatars.githubusercontent.com/u/6810041?v=4",
                    attrs = {
                        style {
                            borderRadius(100.percent)
                            padding(16.px)
                            width(150.px)
                            height(150.px)
                            marginLeft(50.percent)
                            marginRight(50.percent)
                        }
                    }
                )
                Div(attrs = {
                    classes(MyStyleSheet.content)
                }) {
                    Text("[./kotlin/androidx-runtime.js] 1.21 MiB {main} [built] [109 warnings]\n" +
                            "[./kotlin/kotlin-kotlin-stdlib-js-ir.js] 746 KiB {main} [built] [161 warnings]\n" +
                            "[./kotlin/sengbh.js] 57.2 KiB {main} [built] [6 warnings]\n" +
                            "[./kotlin/web-internal-web-core-runtime.js] 21.5 KiB {main} [built] [10 warnings]\n" +
                            "[./kotlin/web-web-core.js] 289 KiB {main} [built] [55 warnings]")
                }
            }
            Container {
                Text("Build your UIs with customizable widgets that you can use on all of your target platforms. " +
                        "Use premade themes to get started quickly, or create your own visual style down to the very pixel.")
            }
        }*/
    }
}