## Universal Scheduler

Is a lib for java minecraft plugins for simplify realisation their Folia support.
> Just for information: Folia doesn't support any of `Bukkit.getScheduler().*` and `Bukkit.getServer().getScheduler().*`
> scheduling methods

### Supported:

- Folia
- Paper
- Spigot

### How to use scheduler?

1. To your plugin Main add:

```java
private static TaskScheduler SCHEDULER;
        ...
@Override
public void onEnable() {
        //if your already have onEnable() just add next line to it
        SCHEDULER = UniversalScheduler.getScheduler(this);
}
        ...
public static TaskScheduler getScheduler() {
        return SCHEDULER;
}
```

2. Call it just like

```java
Main.getScheduler().runTaskLater(() -> { //Main there is your plugin Main
        Bukkit.broadcastMessage("Wow, it was scheduled")
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
    <version>0.1.3</version>
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
<!--                                 Don't forget to replace -->
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
    ...
    maven { url 'https://jitpack.io' }
}
```
```groovy
dependencies {
    ...
    implementation 'com.github.Anon8281:UniversalScheduler:0.1.3'
}
```
Shading:
```groovy
shadowJar {
    //Don't forget to replace
    relocate 'com.github.Anon8281.universalScheduler', '[YOUR_PLUGIN_PACKAGE].universalScheduler' 
}
```
