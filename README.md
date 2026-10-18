# Drum Machine App

## Project Overview 
This project is a simple Machine application developed in Java as a part of my DevOps CA at ATU.

The aim is to create a working drum machine while also demonstrating good DevOps practices such as version control, branching, pull requests, issue tracking and unit testing.

The application use Java Swing for its graphical interface.

## Technologies Used
- Java 26 for the main programming language
- Java Swing for the graphical user interface
- JUnit 5 for unit testing
- Git and Github for version control
- Github Projects for project planning and issue tracking

## Current Features
The following features have been implemented:

- Basic drum machine interface
- Six clickable drum pads (Kick, Snare, Hi-Hat, Clap, Tom and Cymbal)
- Console feedback when a drum pad is clicked
- DrumPad class to store drum pad information
- Four JUnit unit tests for the DrumPad class

Audio playback and additional controls are planned for future development

## How to run the Application

1. Install Java JDK 26.
2. Install Visual Studio Code with the Extension Pack for Java
3. Clone this Repo
4. Open the project folder in VS Code
5. Navigate to src/main/java/com/drummachine/DrumMachineApp.java
6. Click Run above the main method

The Drum Machine window should open with six clickable drum pads

## Unit Testing

JUnit 5 is used to test the DrumPad class

The test suite contains four tests:

- Check that the correct drum pad name is stored
- Check that the correct sound filename is stored
- Check that a pad with a sound file returns true
- Check that a pad without a sound file returns false

To run the tests open DrumPadTest.java in VS Code and select Run Test or use the Testing panel. The JUnit library is included in the lib folder

## Project Management
Github Projects is used to plan and track development

The project currently includes

- An initial backlog of 10 issues
- Two development milestones
- Sprint planning
- Priority labels
- Issue descriptions, acceptance criteria, Definition of Read (DoR) and Definition of Done (DoD)

Each feature or update is developed on a separate branch and submitted through a pull request

## Project Status 

The project is currently in development 

Completed work includes the basic user interface, drum pads and initial unit testing. Future work includes adding audio playback, keyboard controls and further improvements. Progress can be followed through the Github Issues and Projects sections.

## Git Branching Strategy 

For this project, I am using a feature branch workflow to keep my work organised. 
The main branch contains the working version of the application. When adding a new feature, fixing a bug or making other changes, I create a separate branch instead of working directly on main.

My branch naming follows this format:

- feature/1-user-interface – Creating the main interface
- feature/2-drum-pads – Adding the drum pad buttons
- test/10-drum-pad-unit-tests – Adding unit tests
- docs/10-update-readme – Updating documentation

## Development Process

1. Create a new branch from the latest main
2. Make and test the changes
3. Commit the changes with a clear commit message
4. Push the branch to GitHub
5. Create a Pull Request linked to the related issue
6. Review the changes before merging into main

## Commit messages 

I am using Conventional Commits to make it easier to understand what each change does. 

- feat: New feature
- fix: bug fixes
- test: adding or updating tests
- docs: documentation changes
- refactor: improving existing code without changing its behaviour

This approach helps me track the development of the Drum Machine App and keeps the GitHub history organized.


## Contact and Support
Working hours 4-10pm 
Contact times 4-10pm 
Preferred method of contact: Discord jamesC2342 

For questions, suggestions or bugs please open an issue in this github repo.
