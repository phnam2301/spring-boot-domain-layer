# 🔧 Spring Boot Domain Layer

This repository contains domains layer built with Spring Boot, serving as plugin modules that integrate core logic projects with external services.

## 📁 Projects

- [Game Domain](./game-domain) – Acts as an intermediary, coordinating different game logic/core projects and communicating with other backend services.

Each module is independently runnable and documented in its own **README.md** file.

### 🔗 Related Repositories
- [`Spring Boot Microservice Platform`](https://github.com/phnam2301/spring-boot-microservice-platform)
- [`Spring Boot Core Layer`](https://github.com/phnam2301/spring-boot-core-layer)
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

