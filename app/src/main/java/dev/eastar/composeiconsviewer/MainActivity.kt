package dev.eastar.composeiconsviewer

import android.log.Log
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.eastar.composeiconsviewer.ui.theme.AppTheme
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberExtensionProperties
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.staticProperties

object Iconsx {
    object Filled
}

val Iconsx.Filled.Test : String
    get() = "s"


@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // val ss : Icons.Filled =  Icons.Filled::class.createInstance()
        // Icons.Filled::class.staticProperties.forEach {
        //      Log.e(it.name)
        // }
        Log.e("=========================",Iconsx.Filled.Test)
        Iconsx.Filled::class.memberExtensionProperties.forEach {
             Log.e(it.name)
        }
        Log.e("=========================")
        Icons.Filled::class.typeParameters.forEach {
             Log.e(it.name)
        }
        Icons.Filled::class.sealedSubclasses.forEach {
             Log.e(it.simpleName)
        }
        Icons.Filled::class.nestedClasses.forEach {
             Log.e(it.simpleName)
        }
        Log.e("=========================")


        setContent {
            MainApp()
        }
    }
}



@ExperimentalFoundationApi
@Composable
fun MainApp() {
    AppTheme {
        // val list = (1..10).map { it.toString() }

        LazyVerticalGrid(
            cells = GridCells.Adaptive(96.dp),
            content = {

                items(10) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(4.dp),
                    ) {
                        Icon(
                            Icons.Filled.CalendarToday,
                            contentDescription = null,
                        )
                    }
                    // Card(
                    //     backgroundColor = Color.Red,
                    //     modifier = Modifier
                    //         .padding(4.dp)
                    //         .fillMaxWidth(),
                    //     elevation = 8.dp,
                    // ) {
                    //     Icon(Icons.Filled.CalendarToday,
                    //         contentDescription = null,
                    //     )
                    // }
                }
            }
        )
    }
}


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        MainApp()
    }
}