plugins {
    base
}

tasks.named("assemble") {
    dependsOn(":backend:assemble")
}
