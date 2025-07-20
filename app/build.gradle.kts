plugins {
    alias(libs.plugins.android.application)
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.moneytracker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.moneytracker"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // HILT/DAGGER FOR DI
    implementation("com.google.dagger:hilt-android:2.56.2")
    androidTestImplementation(libs.core.testing)
    annotationProcessor("com.google.dagger:hilt-compiler:2.56.2")

    // ARCHITECTURE MVVM
    val lifecycleVersion = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata:$lifecycleVersion")

    //NAVIGATION COMPONENT
    val navVersion = "2.7.7" // Используем переменную, как мы делали раньше
    implementation("androidx.navigation:navigation-fragment:$navVersion")
    implementation("androidx.navigation:navigation-ui:$navVersion")

    testImplementation("junit:junit:4.13.2")

    // Mockito - для создания "моков" (объектов-заглушек)
    testImplementation("org.mockito:mockito-core:5.12.0")

    // Arch Core Testing - для тестирования компонентов с LiveData
    testImplementation("androidx.arch.core:core-testing:2.2.0")


    // ROOM DB
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}