# Drum Machine App

A simple Java Drum Machine App developed for my DevOps CA at Atlantic Technological University (ATU).

The project focuses on using good DevOps practices, including GitHub Projects, branching, pull requests, automated testing and build tools.

## Technologies

- Java 26 / Java Swing
- JUnit 5
- Apache Maven
- Visual Studio Code
- Git, GitHub and GitHub Projects

## Current Features

- Six clickable drum pads (Kick, Snare, Hi-Hat, Clap, Tom, Cymbal)
- Console feedback when pads are clicked
- DrumPad class with four JUnit unit tests
- Maven build and testing support

Audio playback and additional controls are still in development.

## Running the App

1. Clone the repository.
2. Open the project in VS Code with Java extensions installed.
3. Run `DrumMachineApp.java`.

## Maven Commands

| Command | Purpose |
|---|---|
| `mvn test` | Run all tests |
| `mvn test -Dtest=DrumPadTest` | Run one test class |
| `mvn test -Dtest=DrumPadTest#testPadName` | Run one specific test |
| `mvn package` | Build and package the app |

All four JUnit tests have passed using Maven.

Requires Java JDK 21+ and Apache Maven. Maven must be available on PATH, or commands can be run using its full executable path.

## Branching Strategy

I use a feature branch workflow. The `main` branch contains merged changes, while new work is completed on separate branches.

Examples:
- `feature/2-drum-pads`
- `test/10-drum-pad-unit-tests`
- `build/17-maven-setup`
- `docs/10-readme-cleanup`

**Workflow:** Issue → Branch → Commit → Pull Request → Review → Merge

Each update goes through a pull request before being merged into `main`.

## Commit Conventions

- `feat:` New feature
- `fix:` Bug fix
- `test:` Unit tests
- `build:` Build configuration
- `docs:` Documentation

## Project Management

GitHub Projects is used to manage the backlog, sprints, milestones and issues. Issues include acceptance criteria, DoR and DoD.

## Contact

**Availability:** 4–10 pm (Ireland time)

For questions or bugs, please open a GitHub issue.

**Repository:** https://github.com/JamesClearyATU/Drum_Machine_WebApp
