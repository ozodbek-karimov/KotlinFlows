plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}

android {
    namespace = "pl.ozodbek.kotlinflows"
    compileSdk = 34

    defaultConfig {
        applicationId = "pl.ozodbek.kotlinflows"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0") // Retrofit Kotlinx Serialization Converter

    //KotlinxSerialization implementation
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1") // Kotlinx Serialization
    implementation("com.squareup.okhttp3:okhttp:4.10.0") // OkHttp3

    //ViewModelScope implementation
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //FlowCallAdapterFactory implementation
    implementation("tech.thdev:flow-call-adapter-factory:1.0.0")

    //ViewModel delegation implementation
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.activity:activity-ktx:1.7.2")





}