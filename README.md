
# 🍫 ChocolateFactory

**ChocolateFactory** je full-stack web aplikacija koja simulira rad fabrike čokolade. Omogućava registraciju korisnika, kreiranje i upravljanje fabrikama, kao i dodavanje različitih vrsta čokolada za svaku fabriku.

Ovaj projekat je razvijen kao edukativni rad koristeći REST tehnologiju, bez klasične baze podataka – podaci se čuvaju u **CSV fajlovima**.

---

## 🧩 Tehnologije

### 🎯 Backend
- **Java**
- **REST API**
- **CSV fajlovi** za čuvanje i učitavanje podataka
- **Razvojno okruženje:** Eclipse IDE

### 🌐 Frontend
- **Vue.js** – JavaScript framework za izradu korisničkog interfejsa
- **Axios** – HTTP klijent za komunikaciju sa serverom
- **Razvojno okruženje:** Visual Studio Code

---

## ✨ Funkcionalnosti

- 🧑 Registracija i prijava korisnika
- 🏭 Dodavanje i upravljanje fabrikama čokolade
- 🍫 Dodavanje i prikaz raznih čokolada po fabrikama
- 🔗 Komunikacija frontenda i backend-a putem REST API-ja
- 💾 Čuvanje podataka u CSV fajlovima (bez baze podataka)

---

## 🚀 Pokretanje projekta

### 🔧 Backend (Java)

1. Otvori backend folder u **Eclipse**.
2. Pokreni aplikaciju kao **Java Application**.
3. Aplikacija će biti dostupna na:
   ```
   http://localhost:8080
   ```

> Backend koristi CSV fajlove za čuvanje podataka – oni se nalaze u folderu `data/` unutar backend projekta.

---

### 🌐 Frontend (Vue.js)

1. Otvori frontend folder u **VS Code**.
2. Instaliraj zavisnosti:
   ```bash
   npm install
   ```
3. Pokreni frontend aplikaciju:
   ```bash
   npm run serve
   ```
4. Pregledaj u browseru:
   ```
   http://localhost:3000
   ```

---

## 🗂️ Struktura projekta

```
/frontend         → Vue.js aplikacija
/backend          → Java REST aplikacija
/backend/data     → CSV fajlovi sa korisnicima, fabrikama i čokoladama
/README.md        → Ovaj fajl 😄
```

---

## 👩‍💻 Autori

- Kristina Todorović – [GitHub](https://github.com/kikaaat5)
- Anastasija Djurić - [GitHub](https://github.com/anastasijadjuric) 
---

## 📄 Licenca

Projekat je razvijen u edukativne svrhe. 
