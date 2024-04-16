# Mäkihyppykisa

```mermaid
sequenceDiagram
    participant A as Hyppääjä
    participant B as Mittaaja
    participant C as Tuomaristo
    participant D as Kisasihteeri
    participant E as Tulostaulu

    Note over C: List<Tuomari> tuomarit = ArrayList[6]
    Note over E: List<Tulosrivi> tulokset = ArrayList[]

    A->>B: sendMessage(string "mittauspyyntö")
    B->>A: sendMessage(string "pituus", int pituus)
    A->>C: sendMessage(string "tuomaristopyyntö")
    C->>A: sendMessage(string "pisteet", int pisteet)

    A->>D: sendMessage(this, Hypyt)

    D->>E: sendMessage(Tulosrivi tulos)
```

## Hyppääjä

Hyppääjä lähettää mittauspyynnön mittaajalle ja tuomaristopyynnön tuomaristolle. Hyppääjä saa mittauksen pituuden ja tuomaristolta pisteet jolla se luo Hyppy objektin. Kun hypyt lista on valmis, hyppääjä lähettää sen kisasihteerille.

## Mittaaja

Mittaaja saa mittauspyynnön hyppääjältä ja lähettää pituuden hyppääjälle.

## Tuomaristo

Tuomaristo saa tuomaristopyynnön hyppääjältä ja lähettää pisteet hyppääjälle.

## Kisasihteeri

Kisasihteeri saa hypyt listan hyppääjältä ja luo sen pohjalta tulostaulun rivin joka lähetetään tulostaululle.

## Tulostaulu

Tulostaulu saa tulosrivin kisasihteeriltä ja tulostaa sen.

## Luokka kaavio

```mermaid
---
title: Mäkihyppykisa
---
classDiagram
direction TB
    class Mediator{
    <<Interface>>
        +sendMessage(string message)
        +registerParticipant(Participant participant)
    }
    class Participant{
    <<Abstract>>
        -Mediator mediator
        +sendMessage()
        +recieveMessage()
    }

    class Staff{
        -title
        +getTitle()
    }

    class Hyppääjä{
        +sendMessage(string message, string title)
        +recieveMessage(string message, int pituus)

        -List<Hypyt> hypyt
        -string nimi
    }
    class Mittaaja{
        +sendMessage(string message, int pituus)
        +recieveMessage(string message)
        +getPituus()
    }
    class Tuomaristo{
        +sendMessage(string message, int pisteet)
        +recieveMessage(string message)
        +getPisteet()
    }
    class Kisasihteeri{
        +sendMessage(Tulosrivi tulos)
        +recieveMessage(Hyppääjä hyppääjä, List<Hypyt> hypyt)
    }
    class Tulostaulu{
        +recieveMessage(Tulosrivi tulos)
        +tulostaTaulu()
    }
    class ConcreteMediator {
        +sendMessage(string message, string title) 
        +registerParticipant(Participant participant)
        +registerStaff(Staff staff)

        -List<Participant> participants
        -List<Staff> staff
    }

    Mediator <|-- ConcreteMediator
    Mediator <.. Participant
    Participant <|-- Staff

    Hyppääjä --|> Participant
    Mittaaja --|> Staff
    Tuomaristo --|> Staff
    Kisasihteeri --|> Staff
    Tulostaulu --|> Staff
```
