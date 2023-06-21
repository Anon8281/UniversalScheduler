## Universal Scheduler

> Please be patient, i have autism

**It's enough to replace `Bukkit.getScheduler()` with `UniversalScheduler.getScheduler()` to make old plugins work with
Folia.**

But may be you should refactor plugins neat and right. ¯\_(ツ)_/¯

### How to use scheduler?

1. In your plugin Main add:

```java
    @Getter
    private static TaskScheduler scheduler;
                     ...
    @Override
    public void onEnable() {
            scheduler = UniversalScheduler.getScheduler(this);
    }
```

2. Call it just like 
```java
    Main.getScheduler().runTaskLater(() -> {
        Bukkit.broadcastMessage("Wow, it was scheduled")
    }, 10L);
```
>**_Main_ there is your plugin Main**

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
    <version>0.0.8</version>
</dependency>
 ```
