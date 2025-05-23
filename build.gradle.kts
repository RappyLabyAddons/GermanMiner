plugins {
    id("net.labymod.labygradle")
    id("net.labymod.labygradle.addon")
}

val versions = providers.gradleProperty("net.labymod.minecraft-versions").get().split(";")

group = "de.germanminer"
version = providers.environmentVariable("VERSION").getOrElse("1.0.0")

labyMod {
    defaultPackageName = "de.germanminer.addon"

    addonInfo {
        namespace = "germanmineraddon"
        displayName = "GermanMinerAddon"
        author = "GermanMinerDE, Funboyy, JensausNGL"
        description = "Offizielles Addon zur Verbesserung von diversen Spielbereichen auf dem Real-Life-Server GermanMinerDE"
        minecraftVersion = "1.21<1.21.3"
        version = rootProject.version.toString()
    }

    minecraft {
        registerVersion(versions.toTypedArray()) {
            runs {
                getByName("client") {
                    devLogin = true
                }
            }
        }
    }
}

subprojects {
    plugins.apply("net.labymod.labygradle")
    plugins.apply("net.labymod.labygradle.addon")

    group = rootProject.group
    version = rootProject.version
}