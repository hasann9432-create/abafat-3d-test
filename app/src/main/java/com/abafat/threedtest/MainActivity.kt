package com.abafat.threedtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import io.github.sceneview.SceneView
import io.github.sceneview.math.Position

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

                SceneView(
                    modifier = Modifier.fillMaxSize()
                ) {

                    // بدنه اصلی کیسه
                    CylinderNode(
                        radius = 0.22f,
                        height = 0.95f
                    )

                    // قسمت گرد بالای کیسه
                    SphereNode(
                        radius = 0.22f,
                        position = Position(y = 0.475f)
                    )

                    // قسمت گرد پایین کیسه
                    SphereNode(
                        radius = 0.22f,
                        position = Position(y = -0.475f)
                    )

                    // محل اتصال کیسه به زنجیر
                    CylinderNode(
                        radius = 0.07f,
                        height = 0.20f,
                        position = Position(y = 0.62f)
                    )

                    // زنجیر بالای کیسه
                    CylinderNode(
                        radius = 0.025f,
                        height = 0.45f,
                        position = Position(y = 0.95f)
                    )

                }
            }
        }
    }
}