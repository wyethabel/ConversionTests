plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.conversiontests"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.conversiontests"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.conversiontests.HiltTestRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Android core
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.12.0")

    // Compose
    implementation("androidx.compose.ui:ui:1.9.0")
    implementation("androidx.compose.material:material:1.9.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.9.0")
    implementation(libs.androidx.runner)
    debugImplementation("androidx.compose.ui:ui-tooling:1.9.0")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.material3:material3-window-size-class:1.2.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.57.1")
    kapt("com.google.dagger:hilt-compiler:2.57.1")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.57.1")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.57.1")

    // Testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")
    androidTestImplementation("androidx.test:core:1.7.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.9.0")
    // For Robolectric tests.
    testImplementation("com.google.dagger:hilt-android-testing:2.56.2")
    // ...with Kotlin.
    kaptTest("com.google.dagger:hilt-android-compiler:2.56.2")
    // ...with Java.
    testAnnotationProcessor("com.google.dagger:hilt-android-compiler:2.56.2")


    // For instrumented tests.
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.56.2")
    // ...with Kotlin.
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.56.2")
    // ...with Java.
    androidTestAnnotationProcessor("com.google.dagger:hilt-android-compiler:2.56.2")
}