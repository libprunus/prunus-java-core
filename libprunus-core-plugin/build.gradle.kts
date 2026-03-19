plugins {
    id("org.libprunus.build-logic")

    `java-gradle-plugin`
    `maven-publish`
}

dependencies {
    implementation(libs.spotless.plugin)
}

gradlePlugin {
    plugins {
        create("libprunusCorePlugin") {
            id = "org.libprunus.libprunus-core-plugin"
            implementationClass = "org.libprunus.core.plugin.LibprunusCorePlugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}
