package com.abafat.threedtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.remember

import io.github.sceneview.SceneView
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberMaterialLoader
import io.github.sceneview.math.Position
import io.github.sceneview.math.Size

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

                val engine = rememberEngine()
                val materialLoader = rememberMaterialLoader(engine)

                val blackMaterial = remember(materialLoader) {
                    materialLoader.createColorInstance(
                        Color(0xFF101010)
                    )
                }

                val greenMaterial = remember(materialLoader) {
                    materialLoader.createColorInstance(
                        Color(0xFF39FF88)
                    )
                }

                SceneView(
                    modifier = Modifier.fillMaxSize(),
                    engine = engine,
                    materialLoader = materialLoader
                ) {

                    // بدنه اصلی کیسه
                    CylinderNode(
                        radius = 0.22f,
                        height = 0.95f,
                        materialInstance = blackMaterial
                    )

                    // قسمت گرد بالای کیسه
                    SphereNode(
                        radius = 0.22f,
                        position = Position(y = 0.475f),
                        materialInstance = blackMaterial
                    )

                    // قسمت گرد پایین کیسه
                    SphereNode(
                        radius = 0.22f,
                        position = Position(y = -0.475f),
                        materialInstance = blackMaterial
                    )

                    // نوار سبز بالایی
                    CylinderNode(
                        radius = 0.228f,
                        height = 0.06f,
                        position = Position(y = 0.38f),
                        materialInstance = greenMaterial
                    )

                    // نوار سبز پایینی
                    CylinderNode(
                        radius = 0.228f,
                        height = 0.06f,
                        position = Position(y = -0.38f),
                        materialInstance = greenMaterial
                    )

                    // محل اتصال کیسه
                    CylinderNode(
                        radius = 0.07f,
                        height = 0.20f,
                        position = Position(y = 0.62f),
                        materialInstance = greenMaterial
                    )

                    // زنجیر بالای کیسه
                    CylinderNode(
                        radius = 0.025f,
                        height = 0.45f,
                        position = Position(y = 0.95f),
                        materialInstance = greenMaterial
                    )

                    // نشان شیر
                    ImageNode(
                        imageResId = R.drawable.lion_emblem,
                        size = Size(
                            x = 0.32f,
                            y = 0.32f
                        ),
                        position = Position(
                            x = 0f,
                            y = 0f,
                            z = 0.23f
                        )
                    )
                }
            }
        }
    }
}