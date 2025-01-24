# 🃏 Spanish Deck Card Game 🃏

This project is a Java implementation of a simple card game based on the Spanish deck of 40 cards. The main goal of this game is to provide an opportunity to **practice and reinforce Java concepts** such as:

- Working with collections (`ArrayList`, `HashMap`)
- Control flow (conditionals, loops)
- Input and exception handling
- The creation and manipulation of classes and objects

## Description

In this game, the player is dealt 10 random cards from a Spanish deck, and the objective is to calculate the total score of the player's hand based on the values of the cards. 
The entire interaction occurs through the console, where the user will receive prompts and feedback directly in the terminal or command prompt.

The player interacts with the game via a simple console menu, with the following options:

- **Play**: Starts the game, generates a random hand of cards, displays them, and calculates the score.
- **Exit**: Ends the program.

## Features

- **Deck Generation**: The 40-card Spanish deck is dynamically created with 4 suits (`oros`, `copas`, `espadas`, `bastos`) and 10 different figures per suit (`as`, `dos`, `tres`, ..., `rey`).
  
- **Random Card Selection**: The player is dealt 10 random cards from the deck, with no duplicates in the hand.
  
- **Score Calculation**: Cards have assigned values based on their figures:
  - `"as"` is worth 11 points
  - `"tres"` is worth 10 points
  - `"sota"` is worth 2 points
  - `"caballo"` is worth 3 points
  - `"rey"` is worth 4 points
  The hand's total score is calculated based on the player's cards.

- **Input Handling**: The program ensures the user enters valid integers to navigate the menu and make choices.

## Requirements

- **JDK 8 or later** to compile and run the Java code.

