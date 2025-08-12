# 🔧 Spring Boot Turn-based Idle RPG 2D Service

This repository contains modules built with Spring Boot, serving as a backend service for managing turn-based idle RPG game logic and data.

## 📁 Projects

- [Game Service](./game-service) – Provides the core turn-based idle RPG gameplay mechanics, including battle handling, quest progression, reward calculation, and in-game event logic.

- [Profile Service](./profile-service) – Handles the storage, retrieval, and management of player profiles, character stats, achievements, and other persistent game-related information.

Each module is independently runnable and documented in its own **README.md** file.

### 🔗 Related Repositories
- [`Spring Boot Microservice Platform`](https://github.com/phnam2301/spring-boot-microservice-platform)
- [`Unity TBIRPG2D Client`](https://github.com/phnam2301/unity-tbirpg2d-client)

---

### 🛠 Contribute

If you’d like to contribute or share your code, **do not commit directly to 'main'**

Please create a new branch using the allowed proper prefixes: **feature/** , **bugfix/** , **hotfix/** , **dev/** , **release/**

#### ⚠️ If you don’t use a proper prefix, your branch might not be protected and could be modified by others

#### 💡 Before committing:
Make sure to run **spotlessApply** to auto-format your code using **palantirJavaFormat()** and avoid unnecessary formatting conflicts

You can run it with:
```bash
./gradlew spotlessApply
```

You can also view the formatter rules in the [checkstyle](./checkstyle.xml) file

Then open a Pull Request (PR) to merge into 'main'

#### ➡️ All changes will be reviewed before merging, use meaningful branch names and commit messages

---

### ⚖️ License:
This repository is licensed under the **MIT** License

---

### 🧑‍💻 Author:
[William Phan](https://github.com/phnam2301)

---

### 📫 Contact:
`phnam230197@gmail.com`

