plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.enes.rickandmorty"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.enes.rickandmorty"
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
    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    sourceSets{
        getByName("debug").res.srcDirs("$rootDir/navigation/src/main/sharedRes")
    }
}

dependencies {
    implementation(projects.navigation)
    implementation(projects.common.presentation)
    implementation(projects.feature.login.data)
    implementation(projects.feature.login.presentation)
    implementation(projects.feature.login.domain)
    implementation(projects.feature.home.presentation)
    implementation(projects.feature.home.data)
    implementation(projects.feature.home.domain)
    implementation(projects.feature.detail.domain)
    implementation(projects.feature.detail.presentation)
    implementation(projects.feature.detail.data)
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.dagger:hilt-android:2.50")
    ksp("com.google.dagger:hilt-android-compiler:2.50")
    val nav_version = "2.7.6"
    api("androidx.navigation:navigation-fragment-ktx:$nav_version")
    api("androidx.navigation:navigation-ui-ktx:$nav_version")
}