# API Versioning Dokumentation

---

## 1. Übersicht

Diese Dokumentation beschreibt die Strategie und Implementierung der API-Versionierung für die To-Do-List-Anwendung. Eine saubere Versionierung ist entscheidend, um die Stabilität des Frontends bei zukünftigen Änderungen am Backend zu gewährleisten und die API-Struktur klar und wartbar zu halten.

---

## 2. Implementierte Strategie: URL-Pfad-Versionierung

Wir haben uns für die **URL-Pfad-Versionierung** entschieden, eine der gängigsten und verständlichsten Methoden zur Versionierung von REST-APIs.

### 2.1. Aufbau des Basispfads

Alle Endpunkte der API sind unter einem versionierten Basispfad zusammengefasst. Für die erste stabile Version der Anwendung lautet dieser Pfad:

```
/api/v1/
```

- **/api**: Kennzeichnet den Pfad als API-Endpunkt und trennt ihn von möglichen zukünftigen Web-Routen.
- **/v1**: Steht für "Version 1". Bei grundlegenden Änderungen, die die bestehende Funktionalität beeinträchtigen würden (Breaking Changes), wird eine neue Version (z.B. `/v2`) eingeführt.

--- 

## 3. Umsetzung im Backend (Spring Boot)

Die Versionierung wurde direkt in der Controller-Klasse `DemoApplication.java` durch die Anpassung der `@RequestMapping`-Annotationen umgesetzt.

### 3.1. Code-Beispiele

Jeder Endpunkt wurde explizit mit dem `/api/v1/`-Präfix versehen.

**Beispiel 1: Abrufen aller Tasks**
```java
// Gibt die Liste aller Aufgaben zurück
@GetMapping("/api/v1/")
public List<Task> getTasks() {
    System.out.println("GET /api/v1/ aufgerufen");
    return tasks;
}
```

**Beispiel 2: Hinzufügen einer neuen Aufgabe**
```java
// Fügt eine neue Aufgabe hinzu und gibt die aktualisierte Liste zurück
@PostMapping("/api/v1/tasks")
public List<Task> addTask(@RequestBody String taskdescription) {
    // ... Logik ...
    return tasks;
}
```

**Beispiel 3: Löschen einer Aufgabe**
```java
// Löscht eine Aufgabe und gibt die aktualisierte Liste zurück
@PostMapping("/api/v1/delete")
public List<Task> delTask(@RequestBody String taskdescription) {
    // ... Logik ...
    return tasks;
}
```

--- 

## 4. Vorteile dieser Methode

1.  **Eindeutigkeit:** Die API-Version ist direkt aus der URL ersichtlich. Entwickler im Frontend-Team sehen sofort, welche Version sie ansprechen.
2.  **Stabilität:** Das Frontend, das für `v1` entwickelt wurde, wird nicht durch zukünftige Änderungen in `v2` beeinträchtigt.
3.  **Wartbarkeit:** Der Code ist sauber strukturiert. Alle API-Pfade folgen einem einheitlichen und vorhersehbaren Muster.
4.  **Einfache Testbarkeit:** Die Endpunkte sind klar definiert und können leicht in automatisierten Tests oder mit Tools wie Postman angesprochen werden.
