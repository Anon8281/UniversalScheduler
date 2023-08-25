# Universal Scheduler [![](https://jitpack.io/v/Anon8281/UniversalScheduler.svg)](https://jitpack.io/#Anon8281/UniversalScheduler)

Is a lib for java minecraft plugins to simplify Folia support implementation
> Just for your information: Folia doesn't support any of `Bukkit.getScheduler().*` and `Bukkit.getServer().getScheduler().*`
> scheduling methods

### Java version: 8 or above

### Supported:

- Folia
- Paper
- Spigot

## Plugins using UniversalScheduler

|           **Name**           |                           **Link**                            |
|:----------------------------:|:-------------------------------------------------------------:|
|        Brewery (Fork)        |         [GitHub](https://github.com/Anon8281/Brewery)         |
| InventoryRollbackPlus (Fork) | [GitHub](https://github.com/Anon8281/Inventory-Rollback-Plus) |
|       CraftBook (Fork)       |        [GitHub](https://github.com/Anon8281/CraftBook)        |
|    PlaceholderAPI (Fork)     |     [GitHub](https://github.com/Anon8281/PlaceholderAPI)      |
|      ImageOnMap (Fork)       |       [GitHub](https://github.com/Anon8281/ImageOnMap)        |
|       BigDoors (Fork)        |        [GitHub](https://github.com/Anon8281/BigDoors)         |
| WorldGuardExtraFlags (Fork)  |  [GitHub](https://github.com/Anon8281/WorldGuardExtraFlags)   |
|     HorseTpWithMe (Fork)     |      [GitHub](https://github.com/Anon8281/HorseTpWithMe)      |
|    BetterTridents (Fork)     |     [GitHub](https://github.com/Anon8281/BetterTridents)      |
|  HolographicDisplays (Fork)  |   [GitHub](https://github.com/Anon8281/HolographicDisplays)   |
|     Lucko helper (Fork)      |         [GitHub](https://github.com/Anon8281/helper)          |
|           HexNicks           |        [GitHub](https://github.com/MajekDev/HexNicks)         |
|  WorldEdit (Unstable Fork)   |        [GitHub](https://github.com/Anon8281/WorldEdit)        |
|      SuperVanish (Fork)      |   [GitHub](https://github.com/ewof/SuperVanish/tree/folia)    |
|    TownyWaypoints (Fork)     |       [GitHub](https://github.com/ewof/TownyWaypoints)        |

## How to use scheduler?

1. To your plugin Main add:

```java
private static TaskScheduler scheduler;
```

```java 
@Override
public void onEnable() {
        //if your already have onEnable() just add next line to it
        scheduler = UniversalScheduler.getScheduler(this);
}
```

```java
public static TaskScheduler getScheduler() {
        return scheduler;
}
```

2. Call it just like

```java
Main.getScheduler().runTaskLater(() -> { //Main there is your plugin Main
        Bukkit.broadcastMessage("Wow, it was scheduled");
});
```

3. If you need to get the scheduled task for some reason

```java
MyScheduledTask task = Main.getScheduler().runTaskLater(() -> { //Main there is your plugin Main
        Bukkit.broadcastMessage("Wow, it was scheduled");
}, 10L);
```

### Maven information

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

```xml
<dependency>
    <groupId>com.github.Anon8281</groupId>
    <artifactId>UniversalScheduler</artifactId>
    <version>[VERSION]</version>
    <scope>compile</scope>
</dependency>
 ```

Shading:

```xml
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.5.0</version>
        <executions>
            <execution>
                <phase>package</phase>
                <goals>
                    <goal>shade</goal>
                </goals>
                <configuration>
                    <artifactSet>
                        <includes>
                            <include>com.github.Anon8281:UniversalScheduler</include>
                        </includes>
                    </artifactSet>
                    <relocations>
                        <relocation>
                            <pattern>com.github.Anon8281.universalScheduler</pattern>
                            <!-- Don't forget to replace -->
                            <shadedPattern>[YOUR_PLUGIN_PACKAGE].universalScheduler</shadedPattern>
                        </relocation>
                    </relocations>
                </configuration>
            </execution>
        </executions>
    </plugin>
</plugins>
```

### Gradle information

```groovy
repositories {
    //...
    maven { url 'https://jitpack.io' }
}
```

```groovy
dependencies {
    //...
    implementation 'com.github.Anon8281:UniversalScheduler:[VERSION]'
}
```

Shading:

```groovy
shadowJar {
    //Don't forget to replace
    relocate 'com.github.Anon8281.universalScheduler', '[YOUR_PLUGIN_PACKAGE].universalScheduler' 
}
```
