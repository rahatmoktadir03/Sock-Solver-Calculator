plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Removed: alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.animalsockcalculator"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.animalsockcalculator"
        minSdk = 24
        targetSdk = 35
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

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true      // ✅ Enabled ViewBinding
        // compose = false       // ✅ Omit or comment this out if previously added
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.appcompat)
    implementation("com.google.android.material:material:1.11.0") // ✅ Material Components

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // 🚫 Removed Compose-related dependencies
}
