import java.util.Properties

plugins {
    id(BuildPlugins.ANDROID_APPLICATION) version PluginVersions.AGP
    id(BuildPlugins.KOTLIN_ANDROID) version PluginVersions.KOTLIN
    id(BuildPlugins.COMPOSE_COMPILER) version PluginVersions.COMPOSE_COMPILER
    id(BuildPlugins.KOTLIN_KSP) version PluginVersions.KSP
    id(BuildPlugins.KTOR_SERIALIZATION) version PluginVersions.KTOR_SERIALIZATION
}

android {
    namespace = BuildConfig.APP_ID
    compileSdk = BuildConfig.COMPILE_SDK_VERSION

    val localPropertiesFile = project.rootProject.file("local.properties")
    val localProperties = Properties()
    localProperties.load(localPropertiesFile.inputStream())

    val baseUrl = localProperties.getProperty("base.url")?.replace("\"", "") ?: ""

    defaultConfig {
        applicationId = BuildConfig.APP_ID
        minSdk = BuildConfig.MIN_SDK_VERSION
        targetSdk = BuildConfig.TARGET_SDK_VERSION
        versionCode = ReleaseConfig.VERSION_CODE
        versionName = ReleaseConfig.VERSION_NAME

        testInstrumentationRunner = TestBuildConfig.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
        signingConfig = signingConfigs.getByName("debug")

    }

    buildTypes {
        getByName(BuildTypes.RELEASE) {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isMinifyEnabled = Build.Release.isMinifyEnabled
            enableUnitTestCoverage = Build.Release.enableUnitTestCoverage
            isDebuggable = Build.Release.isDebuggable
//            signingConfig = signingConfigs.getByName("release")
        }

        getByName(BuildTypes.DEBUG) {
            applicationIdSuffix = Build.Debug.applicationIdSuffix
            versionNameSuffix = Build.Debug.versionNameSuffix
            isMinifyEnabled = Build.Debug.isMinifyEnabled
            enableUnitTestCoverage = Build.Debug.enableUnitTestCoverage
            isDebuggable = Build.Debug.isDebuggable
        }

        create(BuildTypes.RELEASE_EXTERNAL_QA) {
            applicationIdSuffix = Build.ReleaseExternalQa.applicationIdSuffix
            versionNameSuffix = Build.ReleaseExternalQa.versionNameSuffix
            isMinifyEnabled = Build.ReleaseExternalQa.isMinifyEnabled
            enableUnitTestCoverage = Build.ReleaseExternalQa.enableUnitTestCoverage
            isDebuggable = Build.ReleaseExternalQa.isDebuggable
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
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.ANDROIDX_CORE_KTX)
    implementation(Dependencies.ANDROIDX_LIFECYCLE_RUNTIME_KTX)
    implementation(Dependencies.ANDROIDX_ACTIVITY_COMPOSE)
    implementation(platform(Dependencies.ANDROIDX_COMPOSE_BOM))
    implementation(Dependencies.ANDROIDX_UI)
    implementation(Dependencies.ANDROIDX_UI_GRAPHICS)
    implementation(Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    implementation(Dependencies.ANDROIDX_MATERIAL3)

    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(platform(TestDependencies.ANDROIDX_COMPOSE_BOM))
    androidTestImplementation(TestDependencies.ANDROIDX_UI_TEST_JUNIT4)

    debugImplementation(DebugDependencies.ANDROIDX_UI_TOOLING)
    debugImplementation(DebugDependencies.ANDROIDX_UI_TEST_MANIFEST)

    implementation(Dependencies.NAVIGATION_COMPOSE)

    implementation(Dependencies.ROOM_RUNTIME)
    implementation(Dependencies.ROOM_KTX)
    ksp(Dependencies.ROOM_COMPILER)

    implementation(Dependencies.GSON)

    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_COMPOSE)

    implementation(Dependencies.INDICATOR)

    implementation(Dependencies.DATASTORE)

    implementation(Dependencies.LOTTIE)

    implementation(Dependencies.KTOR_CLIENT_CORE)
    implementation(Dependencies.KTOR_CLIENT_ANDROID)
    implementation(Dependencies.KTOR_CLIENT_CONTENT_NEGOTIATION)
    implementation(Dependencies.KTOR_SERIALIZATION_KOTLINX_JSON)
    implementation(Dependencies.KTOR_CLIENT_LOGGING)
}