# Dating App

Benvenuto nella nostra **Dating App**.

---

## Panoramica del funzionamento

Questo è un progetto lavorativo backend di gruppo basato principalmente su Spring Boot. Di seguito verranno mostrati i punti salienti del funzionamento dell'app.

1. Questa dating app funge espone delle REST API per fungere da base per eventuali framework front end o per altri utilizzi.
2. Utilizza un sistema di autenticazione basato su JWT per validare le richieste.
3. Il JWT viene legato alla persona registrata. È necessario quindi effettuare registrazione e login.
4. L'utente può aggiungere le sue preferenze tramite l'apposita API.
5. L'app non è distribuita, ma è possibile esercitarsi con un database di prova allegato nella directory `scripts/db/populate_database.sql` oppure nella stessa cartella vi è il dump.
6. L'utente può eseguire uno swipe verso un altro utente.
7. Se entrambi hanno uno swipe di tipo `LIKE` o `SUPERLIKE`, verrà creato un match e sarà possibile chattare tra di loro.
8. I messaggi utilizzano un sistema basato su Firebase per i servizi, ma i messaggi sono salvati localmente nel database.

---

## Aspetti tecnici

L'applicazione utilizza le seguenti tecnologie interne quali:

- Spring Web per esporre le REST API
- Swagger UI accessibile alla rotta swagger/index.html
- Lombok
- MySQL
- Spring JPA
- Spring Validation
- Spring Security, principalmente per usare il JWT
- Firebase

>Ognuna di queste funzionalità è accessibile e analizzabile all'interno del codice, posto principalmente in src/ per il codice Java, e nella cartella scripts/ per dati, esempi di utilizzo per API, ed esercitazioni veloci.

---

# Registrazione account e login

## Registrazione utente

Nella registrazione dell'utente l'importante è definire i campi obbligatori quali `email` e `password`.

Durante la registrazione dell'utente è possibile passare altri dati per le preferenze, ma sono tutti opzionali ed è possibile aggiornarli in seguito.

```http
POST /auth/register

{
    "name": "Tester",
    "password": "test1234",
    "email": "receive@test2.it",
    "birthday": "1975-04-15",
    "bio": "testo messaggi 2",
    "genres": [
        "Male"
    ]
}
```

---

## Login

Nel login è importante passare soltanto `email` e `password` salvati nel database.

```http
POST /auth/login

{
    "email": "test@sender.com",
    "password": "test1234"
}
```

Il server ci risponderà con il token JWT da salvare lato client. Sarà fondamentale inserirlo ad ogni altra richiesta HTTP per autenticarsi.

Esempio di risposta:

```json
{
    "token": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ0ZXN0QHNlbmRlci5jb20iLCJpYXQiOjE3NDU0MDEzMjcsImV4cCI6MTgwNTg4MTMyN30.QLDJdF_xr41QnYzabbqW7Ej6YhCDqG-2mwNSBNGtvtKpQplKyVivJCTFfeTHu2x2",
    "email": "test@sender.com",
    "tokenType": "Bearer"
  }
```

---

# Utenti

## Ricerca tutti gli utenti

```http
GET /api/users/
```

---

## Ricerca singolo utente

```http
GET /api/users/{id}
```

>Se l'utente cercato è lo stesso autenticato (verifica tramite JWT), verrà renderizzato alla rotta seguente dove verranno mostrate anche le sue **preferenze**.

```http
GET /api/users/me
```

---

## Aggiornamento preferenze

È possibile aggiornare le preferenze tramite endpoint. Tramite l'autenticazione JWT, l'aggiornamento influirà solo sul proprio account.

```HTTP
PATCH /api/preferences
```

---

# Logica di dating

## Vedere tutti i propri swipe

```http
GET /api/swipes
```

---

## Eseguire uno swipe verso un utente

- Dovremmo fornire l'id dell'utente target tramite `targetId` dove creare uno swipe.
- il `type` può essere solo `LIKE`, `SUPERLIKE` e `PASS`. Il case è insensitive.
- Se entrambi gli utenti hanno messo uno swipe che non sia `PASS`, verrà creato un match e sarà possibile chattare.

```http
POST /api/swipes

{
    "userId": 7,
    "targetId": 6,
    "type": "like"
}
```

---

# Messaggi

L'applicazione espone degli endpoint per la messaggistica tra dispositivi basata su Firebase.

- Ogni passaggio successivo necessita che l'utente sia registrato e autenticato tramite **token JWT**.
- I messaggi sono salvati in un database locale, non in cloud.
- Per messaggiare sarà necessario prima registrare un dispositivo (in quest'app sarà possibile aggiungere un solo dispositivo per persona).

---

## Registrazione dispositivo

Ogni utente può registrare un solo dispositivo usando questo endpoint:

```http
POST /api/users/device-token

{
    "fmcToken": "test_fmc_token_1"
}
```

Nella richiesta JSON è necessario inviare il campo `fmcToken` con un identificativo del proprio dispositivo.

---

## Invio messaggi

Per inviare un messaggio bisogna interfacciarsi all'endpoint seguente:

```http
POST /api/messages

{
  "receiverId": id,
  "content": "Messaggio qui..."
}
```

- È necessario indicare l'id del destinatario nel campo `receiverID`.
- Il contenuto del messaggio testuale va inserito in `content`.

---
