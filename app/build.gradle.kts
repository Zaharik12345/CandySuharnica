
plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("com.google.gms.google-services")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
    id ("androidx.navigation.safeargs.kotlin")
}


android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.zakdroid.candysuharnica"
        minSdk = 24
        targetSdk = 30
        versionCode = 2
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        }
    

    buildTypes {
        release {
            isMinifyEnabled=  false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        isEnabled = true
    }
}


dependencies {

    // Import the Firebase
    implementation (platform(libs.firebase.bom))
    implementation (libs.firebase.database)
    implementation (libs.firebase.auth)

    // Add the dependency for the Firebase SDK for Google Analytics
    implementation (libs.firebase.analytics)

    //KTX
    implementation (libs.coroutines.android)
    implementation (libs.coroutines.play.services)

    //livedata
    implementation (libs.livedata)

    //coil
    implementation (libs.coil)

    //Room
    implementation(libs.room)
    implementation (libs.room.common)
    kapt (libs.room.compiler)
    implementation (libs.room.runtime) //for coroutines and flows

    implementation (libs.core)
    implementation (libs.appcompat)
    implementation (libs.material)
    implementation (libs.constraint.layout)
    implementation (libs.fragment)

    implementation (libs.navigation.fragment)
    implementation (libs.navigation.ui)

    testImplementation (libs.junit)
    androidTestImplementation (libs.test.junit)
    androidTestImplementation (libs.espresso.core)

}