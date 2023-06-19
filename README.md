## Universal Scheduler
> Please be patient, i have autism

**It's enough to replace `Bukkit.getScheduler()` with `UniversalScheduler.getScheduler()` to make old plugins work with Folia.**

But may be you should refactor plugins neat and right. ¯\_(ツ)_/¯

### Maven information
Now you have to add .jar file to your project (to `src/libs` folder)
```xml
<dependency>
    <groupId>sevastjan</groupId>
    <artifactId>UniversalScheduler</artifactId>
    <version>1.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/src/libs/UniversalScheduler-1.0.jar</systemPath>
</dependency>
 ```