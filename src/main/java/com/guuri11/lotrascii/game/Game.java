package com.guuri11.lotrascii.game;

import com.guuri11.lotrascii.ascii.Emojis;
import com.guuri11.lotrascii.ascii.Farewell;
import com.guuri11.lotrascii.ascii.characters.*;
import com.guuri11.lotrascii.console.Console;
import com.guuri11.lotrascii.game.menu.Menu;
import com.guuri11.lotrascii.helpers.Network.NetworkManager;
import com.guuri11.lotrascii.helpers.StringHelper.StringHelper;
import dev.ai4j.openai4j.chat.AssistantMessage;
import dev.ai4j.openai4j.chat.Message;
import dev.ai4j.openai4j.chat.SystemMessage;
import dev.ai4j.openai4j.chat.UserMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Game
 */
public class Game {
    private final Menu menu = new Menu();

    public static List<Message> messages = new ArrayList<>();
    private static final String systemMessage = """
            Eres un narrador de historias en un juego de texto interactivo sobre El señor de los anillos. El objetivo del
            juego es contar una historia emocionante y ofrecer al jugador varias opciones en momentos clave para que elija
            cómo continuar la historia. La historia debe tener un tono de aventura y misterio, con desafíos y sorpresas en el camino.
            Cada sección de la historia debe terminar con al menos dos opciones para que el jugador elija.
            Ahora al principio da a elegir al jugador un personaje para jugar. Después de narrar cada parte de la historia,
            debes escoger un valor de la siguiente lista de enum:
            {ARWEN, ENT, ENTRANCE_OF_MORIA, FRODO, GANDALF, GIMLI, GOLLUM, HOBBIT, HOBBIT_IN_MOUNTAINS, HOBBITTON, LEGOLAS, MINAS_TIRITH}.
            Este valor será utilizado para mostrar ese personaje. Por ejemplo, si la última palabra de tu narración es "HOBBIT_IN_MOUNTAINS",
            se generará ese personaje en el juego.

            Aquí tienes un ejemplo:

            "El viaje es largo y está lleno de desafíos. Mientras avanzas por senderos desconocidos, te encuentras con un viajero en una encrucijada. Es un hombre de aspecto severo, con una capa oscura y un aire de misterio.

            'Hola, joven hobbit,' dice. 'Soy Doran, un vagabundo de estas tierras. Parece que tienes un propósito en mente. ¿Te diriges al Bosque de Fangorn? Puedo ayudarte a llegar más rápido, pero a cambio necesitaré tu ayuda para resolver un problema en el camino.'

            Tienes una decisión que tomar. ¿Confías en este extraño y aceptas su ayuda, o decides seguir solo y mantenerte en tu camino?\n
            Opción 1: Aceptar la ayuda de Doran y seguir su camino.\n
            Opción 2: Agradecer a Doran pero continuar tu viaje solo.\n

            HOBBIT_IN_MOUNTAINS"
""";
    private String loading = "Cargando...";
    private String introduction = """
                                                         _______________________
               _______________________-------------------                       `\\
             /:--__                                                              |
            ||< > |                                   ___________________________/
            | \\__/_________________-------------------                         |
            |                                                                  |
             |                       THE LORD OF THE RINGS                      |
             |                                                                  |
             |      "Tres anillos para los reyes elfos bajo el cielo,             |
              |        Siete para los Señores Enanos en palacios de piedra,      |
              |      Nueve para los Hombres Mortales condenados a morir,         |
              |        Uno para el Señor Oscuro, sobre el trono oscuro           |
              |      en la Tierra de Mordor donde se extienden las Sombras        |
               |  Un Anillo para gobernarlos a todos. Un Anillo para encontrarlos |
               |    un Anillo para atraerlos a todos y atarlos en las tinieblas   |
               |     en la Tierra de Mordor donde se extienden las Sombras."     |
              |                                              ____________________|_
              |  ___________________-------------------------                      `\\
              |/`--_                                                                 |
              ||[ ]||                                            ___________________/
               \\===/___________________--------------------------
            """;

    public Menu getMenu() {
        return this.menu;
    }

    ;

    public void exit() {
        Farewell.getFarewell();
        Console.clearConsole(4000);
    }

    public void play() {
        System.out.println(loading);
        Console.clearConsole(1500);

        // New game
        System.out.println(introduction);
        Console.clearConsole(5000);

        NetworkManager networkManager = new NetworkManager();
        developHistory(networkManager, SystemMessage.from(systemMessage));

    }

    private static void developHistory(NetworkManager networkManager, Message message) {
        messages.add(message);
        networkManager.sendToGPT(messages, new NetworkManager.NetworkCallback() {
            @Override
            public void onCommandSuccess(String response) {
                String character = StringHelper.getLastWord(response);
                System.out.println("\n" + StringHelper.removeLastWord(response));
                System.out.println(getCharacter(character));
                messages.add(AssistantMessage.from(response));
                Scanner scanner = new Scanner(System.in);
                System.out.print(Emojis.ARROW_RIGHT);
                String message = scanner.nextLine();

                developHistory(networkManager, UserMessage.from(message));
            }

            @Override
            public void onCommandError(String error) {
                System.out.println("error");
                System.out.println(error);
            }
        });
    }

    private static String getCharacter(final String characterName) {
        Characters character;
        try {
            character = Characters.valueOf(characterName);
        } catch (IllegalArgumentException e) {
            // No character matching with Characters Enum
            return "";
        }

        return switch (character) {
            case ARWEN -> Arwen.getCharacter();
            case ENT -> Ent.getCharacter();
            case ENTRANCE_OF_MORIA -> EntranceOfMoria.getCharacter();
            case FRODO -> Frodo.getCharacter();
            case GANDALF -> Gandalf.getCharacter();
            case GIMLI -> Gimli.getCharacter();
            case GOLLUM -> Gollum.getCharacter();
            case HOBBIT -> Hobbit.getCharacter();
            case HOBBIT_IN_MOUNTAINS -> HobbitInMountains.getCharacter();
            case HOBBITTON -> Hobbiton.getCharacter();
            case LEGOLAS -> Legolas.getCharacter();
            case MINAS_TIRITH -> MinasTirith.getCharacter();
        };
    }
}
