## Universal Scheduler
Is a lib for java minecraft plugins for simplify realisation their Folia support 
> Just for information: Folia doesn't support any of `Bukkit.getScheduler().*` and `Bukkit.getServer().getScheduler().*` scheduling methods
### Supported:
- Folia
- Paper
- Spigot

### How to use scheduler?

1. To your plugin Main add:

```java
    @Getter
    private static TaskScheduler scheduler;
                     ...
    @Override
    public void onEnable() {
            //if your already have onEnable() just add next line to it
            scheduler = UniversalScheduler.getScheduler(this);
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
    <groupId>com.github.Anon8281.UniversalScheduler</groupId>
    <artifactId>UniversalScheduler</artifactId>
    <version>0.1.0</version>
    <scope>provided</scope>
</dependency>
 ```
