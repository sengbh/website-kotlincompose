import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.*
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
        property("font-family", "Noble, Helvetica, Arial, sans-serif")
        property("font-size", 14.px)
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
fun Column (content: @Composable () -> Unit) {
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
        Row {
            Column {
                Column {
                    Img(
                        "https://cdn.pixabay.com/photo/2017/08/22/11/56/linked-in-2668696_960_720.png",
                        attrs = {
                            style {
                                borderRadius(100.percent)
                                width(100.px)
                                height(100.px)
                            }
                        }
                    )
                    Text("Link 1    ")
                    Text("Link 2    ")
                    Text("link 3")
                }
            }
        }
        Row {
            Column { Text("Column 1: This column should be on the left. This column should be on the left This column should be on the left ") }
            Column { Text("Column 2: This column should be on the right. This column should be on the right. This column should be on the left") }
        }
        Row {
            //First column on the left
            Column {
                Text("Column 1")
                H1 {
                    Text("David S")
                }
                Span(
                    attrs = {
                        style {
                            color(Color.gray)
                            paddingBottom(10.px)
                            paddingTop(0.px)
                        }
                    }
                ) {
                    Text("Android Dev, Web3 Research, Software Dev, Aspired to build")
                }
                //body description here
                Div(
                    attrs = {
                        style {
                            fontWeight("bold")
                            textAlign("left")
                            paddingTop(0.px)
                            paddingBottom(10.px)
                            textDecoration("underline")
                        }
                    }
                ) {
                    Text("About:")
                }
                //This is description under ABOUT
                Div(
                    attrs = {
                        style {
                            textAlign("left")
                        }
                    }
                ){
                   Text("Results-driven developer with expertise in Web3, Blockchain community management, Android development, and project management. \n")
                    Br(null)
                    Br(null)
                    Text("Skilled in delivering exceptional software solutions, fostering community engagement, and effectively managing projects.\n")
                    Br(null)
                    Br(null)
                    Text("As a Blockchain community manager, I drive engagement, host events, manage social media, and provide educational resources to promote blockchain adoption and collaboration.\n")
                    Br(null)
                    Br(null)
                    Text("In Android development, I build user-friendly applications using Kotlin and Jetpack Compose, while continually expanding my skills in this area.")
                    Br(null)
                    Br(null)
                    Text("With project management expertise, I lead cross-functional teams, set goals, manage resources, and ensure timely delivery through effective communication and collaboration. Passionate about technology, blockchain innovation, and community building, I thrive in dynamic environments and adapt quickly to emerging trends")
                }

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
                ) {
                    Text("Web3 Research and SmartContract Experience")
                }
                Div(
                        attrs = {
                            style {
                                textAlign("left")
                                paddingTop(10.px)
                            }
                        }
                ){
                    Text("Description: I have over a year of technical experience and still learning in Ethereum Smart Contracts and Binance Smart Chain (BSC) implementation utilizing frameworks such as Truffle and Hardhat etc.")
                }
                Ul(
                    attrs = {
                        style {
                            textAlign("left")
                        }
                    }
                ){
                    Li {
                        Text("Over 3+ years of experience in trading on Decentralized Exchanged such as IDEX, Switcheo(DEMEX), Uniswap, and more.")
                    }
                    Li {
                        Text("Over 3+ years of experience in the community moderator/admin and web3 project management utilzing tools such Telegrap, Discord, Reddit, Facebook groups and more")
                    }
                    Li {
                        Text("Over 1+ year in technical development in smart contracts utilizing tools such as Truffle/Hardhat and language such as Node.js and Web3.js")
                    }
                }
            }

            //Second column on the right
            Column {
                Text("Column 2")
                Span(
                    attrs = {
                        style {
                            textAlign("left")
                            paddingTop(10.px)
                        }
                    }
                ) {
                    Div(
                        attrs = {
                            style {
                                fontWeight("bold")
                                textAlign("center")
                                paddingTop(0.px)
                                paddingBottom(10.px)
                                textDecoration("underline")
                            }
                        }
                    ) {
                        Text("Web2 and Development Experience")
                    }
                    Div(
                        attrs = {
                            style {
                                fontWeight("bold")
                                textAlign("left")
                                paddingTop(0.px)
                                paddingBottom(10.px)
                                textDecoration("underline")
                            }
                        }
                    ) {
                        Text("Project Name: Global Customer Hierarchy at Verizon")
                    }
                    Div(
                        attrs = {
                            style {
                            }
                        }
                    ){
                        Text("Description: The objective of this project is to implement a unified hierarchy model for business customer master data, establishing associations between customers and their internal billing accounts, provisioning accounts, business segments, sales staff, service teams, and online entitlements.")
                    }
                    Ul(
                        attrs = {
                            style {
                            }
                        }
                    ) {
                        Li {
                            Text("Evaluated existing complex systems to identify areas of improvement, focusing on debugging issues for production and how it would help sharing and retrieving data from ups and downstream systems.")
                        }
                        Li {
                            Text(
                                "Utilized the HP Fortify Software tool to perform security fixes and address security vulnerabilities in the application (GCH)"
                            )
                        }
                        Li {
                            Text("Applied expertise in analyzing data using statistical techniques, providing support for tasks such as Elastic/Solr indexing and application regression in various environments; Production, UAT/STG, QAs. ")
                        }
                        Li {
                            Text("Developed and implemented Apigee APIs for the Oracle Cloud Infrastructure (OCI)")
                        }
                    }

                    Div(
                        attrs = {
                            style {
                                fontWeight("bold")
                                textAlign("left")
                                paddingTop(0.px)
                                paddingBottom(10.px)
                                textDecoration("underline")
                            }
                        }
                    ) {
                        Text("Project Name: Master Data Management at Verizon")
                    }
                    Div(
                        attrs = {
                            style {  }
                        }
                    ){
                        Text("Description: The MDM portal is an application that provides a single point of entry for all Master Data Management applications such as Global Product Hierarchy (GPH), Global Product Reference (GPR), Monthly Revenue Values (MRV), Internal Account Repository (IAR) and more.")
                    }
                    Ul(
                        attrs = {
                            style {

                            }
                        }
                    ) {
                        Li {
                            Text("Proactively monitored and maintained production issues, resolving issues promptly to ensure it meets client’s expectation")
                        }
                        Li {
                            Text(
                                "Conducted thorough regression testing, including automation, performance, and functional testing, ensuring high-quality software deliverables."
                            )
                        }
                        Li {
                            Text("Demonstrated expertise in Agile methodology, actively participating in Daily Stand-ups, Sprint Retrospectives, Sprint Reviews, Sprint Planning, and Backlog grooming sessions.")
                        }
                    }
                    //put here
                    Div(
                        attrs = {
                            style {
                                fontWeight("bold")
                                textAlign("left")
                                paddingTop(0.px)
                                paddingBottom(10.px)
                                textDecoration("underline")
                            }
                        }
                    ) {
                        Text("Project Name: Fullstack Developer at Infosys")
                    }
                    Ul(
                        attrs = {
                            style {

                            }
                        }
                    ) {
                        Li {
                            Text("Developed the front end UI application utilizing the Angular Framework")
                        }
                        Li {
                            Text(
                                "Developed backend using springtool and hibernate frameworks"
                            )
                        }
                        Li {
                            Text("Created data utilizing oracle database SQL")
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
        
        A(
            attrs = {
                href("https://cloudpdf.io/view/DsNEgC0el")
                target(ATarget.Blank)
                hreflang("en")
                download("https://www.embedpdf.com/org/7170/document/fa67d5cd-fdd7-4b01-a4b3-138d1d2a6f43/analytics")
            }
        ) {
            Text("link")
        }
        Div(attrs = { style { padding(100.px) } }) {

        }
        //this is for footer
        Div({style {
            position(position = Position.Relative)
            padding(70.px)
            bottom(0.px)
            left(0.px)
            right(0.px)
            textAlign("center")
            background("lightgray")
            //test test
        }})
        {

            Text("Made with \uD83E\uDD70 from scratch with Kotlin Compose")
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

