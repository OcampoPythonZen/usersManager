plugins {
    id("java")
}

group = "edo.mex.gob"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    implementation("org.postgresql:postgresql:42.5.0")
    implementation("org.jdatepicker:jdatepicker:1.3.4")
    implementation("com.sun.mail:javax.mail:1.6.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}