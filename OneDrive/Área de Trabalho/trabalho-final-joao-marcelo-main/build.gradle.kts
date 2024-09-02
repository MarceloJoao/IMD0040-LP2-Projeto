plugins {
    id("java")
}

group = "br.ufrn.imd"
version = "1.2.0"
val mainClassName = "Main"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to("${project.group}.$mainClassName"))
    }
}