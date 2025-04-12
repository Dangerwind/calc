plugins {
    id("application")
    id("io.freefair.lombok") version "8.13"
}
application { mainClass.set("dangerwind.code.App") }

group = "dangerwind"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    //implementation("org.projectlombok:lombok:1.18.38")
}

tasks.test {
    useJUnitPlatform()
}