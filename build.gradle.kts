plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.h2database:h2:2.3.232")
    implementation ("org.hibernate:hibernate-core:5.6.12.Final")
    implementation ("org.flywaydb:flyway-core:9.21.0")
    implementation("com.mchange:c3p0:0.9.5.5")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}