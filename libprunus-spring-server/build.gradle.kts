plugins {
    id("org.libprunus.build-logic")
}

dependencies {
    api(project(":libprunus-spring-core"))
    api(libs.spring.boot.starter.web)

    testImplementation(libs.spring.boot.starter.test)
}
