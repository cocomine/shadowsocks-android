plugins {
    id("com.android.library")
    id("com.vanniktech.maven.publish") apply false
    kotlin("android")
    id("kotlin-parcelize")
}

if (providers.gradleProperty("enableMavenPublish").orNull == "true") {
    apply(plugin = "com.vanniktech.maven.publish")
}

setupCommon()

android {
    namespace = "com.github.shadowsocks.plugin"
    lint.informational += "GradleDependency"
}

dependencies {
    coreLibraryDesugaring(libs.desugar)
    api(libs.androidx.core.ktx)
    api(libs.androidx.fragment.ktx)
    api(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.espresso.core)
}
