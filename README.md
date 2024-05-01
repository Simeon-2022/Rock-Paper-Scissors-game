# RockPaper-Scissors-game by Simeon
![image](https://github.com/Simeon-2022/Rock-Paper-Scissors-game/assets/114140968/81a39076-7501-40ca-95ae-73f7ec7feca9)

Rock - Paper - Scissors is a simple two player game where you and your opponent (the computer) simultaneously choose one of the following three options: "rock", "paper" or "scissors". The rules are as follows:

- Rock beats scissors (the scissors get broken by the rock)
- Scissors beats paper (the paper gets cut by the scissors)
- Paper beats rock (the paper covers the rock)
The winner is the player whose choice beats the choice of his opponent. If both players choose the same option (e.g. "paper"), the game outcome is "draw

## Project goals
The goal of the project is to implement a console-based game by using the learned material during the JAVA-Fundamentals course.
The project made use of associative containers Map<String, String> and List<String>.
The project made use of methods called repetitively during the game do-while loops.

# Solution
- A set of Map containers sustain all possible game situations:
  
![image](https://github.com/Simeon-2022/Rock-Paper-Scissors-game/assets/114140968/66dcb41a-d65d-46d5-a48c-aaecad1bcacd)

- Depending on the player's choice, the outcome is determined based on its association with the map-value-key:
  
![image](https://github.com/Simeon-2022/Rock-Paper-Scissors-game/assets/114140968/e064978c-4f0a-4528-bd99-11824028ff82)

## Scoring system and game exit
- The game stores the player's and computer scores in a List container which resets after each round of 10 games.
- The game can be interrupted at any point by the player, in which case the game ends immediately.

## Source code link:
https://github.com/Simeon-2022/Rock-Paper-Scissors-game/blob/main/RockPaperScissors.java

### Screenshots
- The User is prompted an input:

![image](https://github.com/Simeon-2022/Rock-Paper-Scissors-game/assets/114140968/cd6bed8d-eb58-4ef3-a251-827faff56c1b)
- The final result is printed out and a prompt for another round:

![image](https://github.com/Simeon-2022/Rock-Paper-Scissors-game/assets/114140968/c69788ea-9589-40f5-a8c7-bc5884802d6d)



