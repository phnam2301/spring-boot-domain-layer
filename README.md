# 🔧 Turn-based Idle RPG 2D Service

This repository contains modular Spring Boot API projects forming the backend infrastructure for an upcoming 2D online turn-based idle RPG game. The architecture is designed for scalability, modularity, and future public release.

## 📁 Projects

- [Authentication Service](./auth-service) – Stateless service responsible for processing login requests (via social providers), generating access/refresh tokens, and delegating credential verification to external services.

- [Game Core](./game-core) – Contains core logic and mechanics of the game, such as turn-based combat resolution, skill effects, character states, and PVE/PVP simulations.

- [Game Service](./game-service) – A Spring Boot module that serves as the interface between the game logic and the data layer. It encapsulates business workflows, delegates core logic execution to **Game Core**, and handles data interaction through internal services.

- [Chat Service](./chat-service) – Manages real-time player chat, private messaging, and channel subscriptions. Built with WebSocket or Redis pub/sub for scalable delivery.

- [Redis Cache](./redis-cache) – Provides in-memory caching for frequently accessed data like player sessions, leaderboard, or temporary game states. Intended to reduce DB load and latency.

Each module is independently runnable and documented in its own README.md file.

### 🔗 Related Repositories
- [`Spring Boot API`](https://github.com/phnam2301/spring-boot-api)
- [`Turn-based Idle RPG 2D Unity Client`](https://github.com/phnam2301/turnbased-irpg-2d-unity-client)

---

### 📝 License

This repository is currently **not licensed**. All rights reserved by the author.  
Use, reproduction, and distribution of the code are **not permitted** without explicit permission.  
If you'd like to use or contribute, please [contact the author](mailto:phnam230197@gmail.com).

---

### 🧑‍💻 Author:
[William Phan](https://github.com/phnam2301)

---

### 📫 Contact:
`phnam230197@gmail.com`

