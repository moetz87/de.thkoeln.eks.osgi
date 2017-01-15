# OSGi-Beispiel

Beispiel für...

* ... die Erzeugung von OSGi-Bundles mittels des auf den [BND-Tools](http://bndtools.org/) basierenden [Apache Felix Maven Bundle Plugin](http://felix.apache.org/documentation/subprojects/apache-felix-maven-bundle-plugin-bnd.html)
* ... die Ausführung von OSGi-Bundles mittels der [Apache Felix Framework Distribution](http://felix.apache.org/downloads.cgi#framework)



## Erzeugung von Bundles

Einbinden des Maven Bundle Plugins in die `pom.xml`:

```xml
<groupId>org.apache.felix</groupId>
<artifactId>maven-bundle-plugin</artifactId>
<version>3.2.0</version>
```

Die Erzeugung des Bundles geschieht mittels des Goals `bundle` und wird in nachfolgender Konfiguration in der Buildphase `install` ausgeführt:

```xml
<executions>
    <execution>
        <phase>install</phase>
        <goals>
            <goal>bundle</goal>
        </goals>
    </execution>
</executions>
```

Die eigentliche OSGi-spefzifische Konfiguration ist umfangreich möglich. Hier sei auf die oben verlinkte offizielle Wiki-Seite verwiesen. Besonders interessant ist hier die Möglichkeit der Verwendung von Wildcards für `Import-Package` und `Export-Package`. Nachfolgend die beispielhafte Konfiguration des Autovermietung-Core-Bundles.

```xml
<configuration>
    <instructions>
        <Bundle-Activator>de.thkoeln.eks.osgi.autovermietung.core.Activator</Bundle-Activator>
        <Bundle-Name>Autovermietung-Core</Bundle-Name>
        <Bundle-SymbolicName>Autovermietung-Core</Bundle-SymbolicName>
        <Bundle-Version>1.0.0</Bundle-Version>
        <Export-Package>
            !*
        </Export-Package>
        <Import-Package>
            org.osgi.framework
        </Import-Package>
    </instructions>
</configuration>
```

Der Build geschieht, passend zur konfigurieren Phase, über folgenden Befehl:

```bash
mvn clean install
```



## Ausführen von Bundles

### Installation der Apache Distribution

* Felix Distribution herunterladen und entpacken
* Ausführen der Distribution aus dem Hauptverzeichnis: `java -jar bin/felix.jar`
* Es öffnet sich die Felix Gogo Shell

### Kommandos auf der Apache Gogo Shell

Nachfolgend einige Kommendos der Felix Gogo Shell:

| Kommando   | Bedeutung
|---   |---   |
| `lb`   | Auflisten aller Bundles
| `install file://<path-to-file>`   | Installieren eines Bundles
| `start <bundle-id>`   | Starten eines Bundles
| `update file://<path-to-file>`   | Aktualisieren eines Bundles
| `stop <bundle-id>`   | Stoppen eines Bundles
| `uninstall <bundle-id>`   | Deinstallieren eines Bundles

Die erzeugten `*.jar`-Dateien liegen im `target`-Verzeichnis eines jeden Bundles. Ein Bundle wird zunächst mittels `install`-Befehl installiert und anschließend mittels des `start`-Befehls gestartet.







