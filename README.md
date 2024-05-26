### LOTR ASCII Adventure Game with Java & GPT

Welcome to the ASCII adventure game set in the world of Lord of the Rings! 🧝‍♂️🌋🗡️

This project is a text-based adventure game where players can immerse themselves in the world of Lord of the Rings and make decisions that will affect the course of their journey. The game's storyline is generated by GPT, a natural language processing AI, which means each gameplay experience can be unique. 🎮📜

⚠️ Game texts and prompts are in Spanish. Feel free to change them if you want to. 🌍️

##### Important Note

For the story to be generated by GPT, ensure that the OpenAI API is correctly configured in the project. You can find the relevant configuration in `com.guuri11.lotrascii.helpers.Network.NetworkManager#sendToGPT`. If you don't have access to the OpenAI API, you can modify this part of the code to suit your needs or simply skip the text generation and define your own storyline.

### Installation

To install and run the game, follow these simple steps:

1. **Clone the Repository**: Clone this repository to your local machine.

    ```bash
    git clone https://github.com/Guuri11/lotr-ascii.git
    ```

2. **Compile the Project**: Navigate to the project directory and compile it using Maven.

    ```bash
    cd lotr-ascii
    mvn clean package
    ```

3. **Run the Game**: Once the project is compiled, run the game with the following command.

    ```bash
    java -jar target/lotr-ascii-1.0-SNAPSHOT.jar
    ```
### ASCII Art
All ASCII art are from here https://www.asciiart.eu/books/lord-of-the-rings

### How to Play

Once the game is up and running, follow the on-screen instructions to progress through the story. At different points in the game, you'll be presented with decisions that will affect the direction of your journey. Simply select the option you desire to continue the story.

Enjoy exploring Middle-earth in this thrilling ASCII adventure game! 🧙‍♂️✨🏰

### Demo

https://github.com/Guuri11/lotr-ascii/assets/48799796/f4f12dd2-0855-49eb-8647-26c3fa18173a

