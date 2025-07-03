# Genereller Ablauf des Moduls 
## Sidequest Überblick

### Inhaltsverzeichniss
|  | Sidequest | Tag | Beschreibung | Wichtigkeit | Schwierigkeit |
|---|----------------|--------|------|--------|-----------|
| 1 | Sidequest 1A | Tag 1 | Vorteile von DevOps | 4/5 | 2/5 |
| 2 | Sidequest 1B | Tag 1 | Recherche über DevOps | 4/5 | 1/5 |
| 3 | Sidequest 1C | Tag 1 | CI vs. Nightly Builds | 3/5 | 2/5 |
| 4 | Sidequest 1D | Tag 1 | Info zur Reflexionspresentation | 3/5 | 2/5 |
| 5 | Sidequest 2A | Tag 1 | Fork der To-Do App | 5/5 | 2/5 |
| 6 | Sidequest 2B | Tag 1 | User Stories überlegen | 4/5 | 2/5 |
| 7 | Sidequest 3A | Tag 2 | Refresh Git | 3/5 | 3/5 |
| 8 | Sidequest 3B | Tag 2 | User Stories mit Issue Template machen | 4/5 | 3/5 |
| 9 | Sidequest 4A | Tag 2 | TDD Grundlgen | 4/5 | 4/5 |
| 10| Sidequest 4B | Tag 3 | Frontend Testing | 3/5 | 4/5 |
| 11| Sidequest 5A | Tag 3 | Pipline mit Git Actions | 4/5 | 4/5 |
| 12| Sidequest 5B | Tag 3 | Artefakte Deployen | 4/5 | 3/5 |
| 13| Sidequest 6A | Tag 3 | Branching Strategien | 4/5 | 4/5 |
| 14| Sidequest 8A | Tag 4 | Container Image in CI Pipeline integrieren | 4/5 | 4/5 |


## Sidequest 1A

###### Wir haben die Folgenden Fragen recherchiert und dann im Plenum besprochen:
1. Was ist notwendig, um eine Software auszuliefern? (10 Minuten) 
    1. Klärt gemeinsam anhand der oben angegeben Webseiten die folgenden Begriffe (lest die Webseiten arbeitsteilig). 
    2. Danach stellt ihr die richtige Reihenfolge her. 
    . Bestimmt, welches Team (Entwickler, Tester oder Operations) für jede Aufgabe zuständig ist. 
        •  Unit-Test 
        • Systemintegrationstest 
        • Software-Build
        • Rollback 
        • Deployment in Testumgebung 
        • Deployment und Konfiguration im Produktivsystem 
        • Überwachung und Monitoring 
        • Compilieren der einzelnen Klassen bzw. Komponenten 

2. Was versteht man unter CI/CD? (15 Minuten) 
Recherchiert gemeinsam, was diese Abkürzung bedeutet. 
3. Welche Aufgaben haben IT-Operations Teams im Kontext von SW-Deployment? (10 Minuten) 
Recherchiert gemeinsam, welche Aufgaben die IT-Operation - Teams haben. 
4. DevOps (15 Minuten) 
Recherchiert gemeinsam: 
1. was die Abkürzung DevOps bedeutet 
2. was welche Vorteile DevOps bietet 
3. welche Probleme mit DevOps gelöst werden 

## Sidequest 1B

###### Wir haben die Folgenden Fragen recherchiert und dann im Plenum besprochen:-
Recherchiere mit deinen Sparing-Partner den Begriff DevOps und beantworte die folgenden Fragen: 
    1. Welche Säulen machen DevOps aus? 
    2. Wie sind die Säulen gewichtet? 
    3. Warum sind die ersten beiden Säulen so wichtig? 
Welcher Zusammenhang besteht zwischen DevOps und Agile?

## Sidequest 1C


###### Wir haben die Folgenden Fragen recherchiert und dann im Plenum besprochen:-
    • Worin unterscheiden sich klassische NightlyBuilds vom Continous-Integration-Ansatz?  
    • Welche Probleme treten bei Nightly Builds auf?  
    • Welche Vorteile ergeben sich durch den Einsatz von CI/CD Tools wie Jenkins? 


###### und wir haben ein sie folgendermassen beantwortet:
    • Worin unterscheiden sich klassische NightlyBuilds vom Continous-Integration-Ansatz?  
        ○ Nightly Builds werden einmal täglich automatisch erstellt. CI-Builds dagegen laufen bei jedem Commit – also fortlaufend.
        ○ CI zielt darauf ab, Fehler sofort nach dem Einchecken zu finden, statt sie erst am nächsten Morgen zu entdecken.
    • Welche Probleme treten bei Nightly Builds auf?  
        ○ Zeitverzögerung bei Feedback: Entwickler müssen bis zum nächsten Tag warten und verlieren wertvolle Zeit. 
        ○ Hoher Aufwand: Nightly Builds laufen oft mit allen Tests (auch langfristigen), was lange dauert und Ressourcen verbraucht
        ○ Bug-Lokalisierung schwierig: Wenn viele Änderungen gesammelt werden, ist nicht klar, welcher Commit den Fehler verursacht hat. 
    • Welche Vorteile ergeben sich durch den Einsatz von CI/CD Tools wie Jenkins? 
        ○ Frühes und häufiges Feedback
        ○ Schneller Fehler Sehen
        ○ Konsistenz & Automatisierung


###### Wir hatten dieses Video als Rescource:
 Video https://youtu.be/LFDrDnKPOTg bis ca. 10 Minuten 

## Sidequest 1D

Die Aufgabe erklärt einfach, dass wir uns gedanken machen sollten, über was wir eine Presentation machen wollen, am Ende des Moduls.

## Sidequest 2A

Ali und ich haben beide das Projekt geforked und dann hat Ali mich eingeladen und ich ihn auch. 

Schlussendlich haben wir dann aber doch auf seiner Fork gearbeitet.

Wir haben es so gemacht wie in der Aufgabe beschrieben und hatten keine Probleme damit.

## Sidequest 2B

###### Wir haben folgende User Stories erarbeitet:

## User Story 1
### 🧑‍🤝‍🧑 Rolle  

*Als* Benutzer 

### 🎯 Ziel / Wunsch  

*möchte ich* eine übersichtliche und moderne UI und UX

### 💡 Nutzen  

*damit* Ich meine To-Do Einträge übersichtlich einsehen kann

---

### ✅ Teilaufgaben  

- [ ] Alte Elemente herausnahmen

- [ ] Das Textfeld und die Buttons anpassen

- [ ]  ... 

---

## User Story 2
### 🧑‍🤝‍🧑 Rolle  
Als Benutzer
### 🎯 Ziel / Wunsch  
Möchte ich ausführlichere Tasks (Beschreibungen) haben.
### 💡 Nutzen  
Damit ich eine bessere Übersicht habe.
---
### ✅ Teilaufgaben  
- [ ] Datum
- [ ] Kategorie  
- [ ] Priorität  
---

## User Story 3
### 🧑‍🤝‍🧑 Rolle  

Ich als Entwickler 

### 🎯 Ziel / Wunsch  

*möchte* eine Datenbankverbindung 

### 💡 Nutzen  

*damit* User ihre To-do-Listen abspeichern können

---

### ✅ Teilaufgaben  

- [ ] Datenbankverbindung

- [ ] Automatisches Speichern

- [ ] Möglichkeiten zur skalierung 

---


## Sidequest 3A

Ich habe das gefühl wir haben diese Aufgabe nicht so gemacht, wie sie geschrieben ist. 

Wir haben einfach das Projekt normal geforked.

## Sidequest 3B

Hier haben wir die User Stories, die wir in *'Sidequest 2B'* gemacht haben mit templates auf Git hub als Issues registriert.


Dokumentation für die Issue Templates sind im One-Note unter: *Modul324/Loreno Biffi/Kursnotizen/Sidequest 3B*

## Sidequest 4A

Test driven develpment:
Wir haben noch keine neuen Features nach TDD implementiert, aber wir haben zu den bereits bestehenden Funktionen Unit Tests gemacht und mit Workflows führen wir Sie bei jedem Push aus. 

Wenn wir die weiteren Features implementieren, können wir TDD richtig anwenden, da wir die Grundlagen kennengelernt und verstanden haben.

## Sidequest 4B

Wir haben den bestehenden Frontend Test entsprechend der Aufgabe angepasst und dann die weiteren Tests hinzugefügt.

## Sidequest 5A

Pipeline mit Workflows gemacht.

Es hat auch ältere Versionen im 'github\archived_workflows' Ordner

## Sidequest 5B

Wir haben unsere Actions so angepasst, sodass wir Artefakte auf Git Hub herunterladen können und diese dann Deployed

## Sidequest 6A

Wir haben im Unterrricht verschiedene Branching Strategien angeschaut und uns dagegen entschieden einen Development Branch einzurichten.

Wir arbeiten lieber mit Feature Branches, wenn wir eine speziefische Funktion implementieren wollen und arbeiten dabei auch mit den Issues bsp. #1. 

## Sidequest 8A

Siehe: 

*Modul324/Ali Sürmeli/Kursnotizen/8A*