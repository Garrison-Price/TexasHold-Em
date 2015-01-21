/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPack;

/**
 *
 * @author Dastyruck
 */
import java.util.Scanner;

public class DeckOfCardsTest
{

    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);//create sacanner for inputs
        DeckOfCards myDeck = new DeckOfCards();//create a new deck

        System.out.println("Number of Players: ");//request number of players input
        int totalPlayers = keyboard.nextInt();//get number of players input
        int totalPot = 0;
        if(totalPlayers > 6)//limit amount of players to 6
            totalPlayers = 6;

        myDeck.shuffle();//shuffle the deck

        Card onTable[] = new Card[400];//create list to hold cards on table

        for(int i = 0;i<totalPlayers;i++)//deal to players
        {
            onTable[i+100] = myDeck.dealCard();//adding cards on the 100 plateu
            onTable[i+200] = myDeck.dealCard();//second cards on the 200 plateu
            System.out.println("\nPlayer "+ (i+1) + " has: "+ onTable[i+100] +", "+onTable[i+200]);
        }

        //deal to table
        onTable[1] = myDeck.dealCard();//table cards on base plateu
        onTable[2] = myDeck.dealCard();
        onTable[3] = myDeck.dealCard();
        System.out.println("\nOn the table: "+ onTable[1] +", "+ onTable[2]+", "+ onTable[3]);

        for(int i = 0;i<totalPlayers;i++)//get player bets
        {
            System.out.println("\nPlayer "+ (i+1) + " place bet: ");
            totalPot += keyboard.nextInt(); //add bet to pot
        }

        onTable[4] = myDeck.dealCard();//new card on table
        for(int i = 0;i<totalPlayers;i++)//print player cards again to players
        {
            System.out.println("\nPlayer "+ (i+1) + " has: "+ onTable[i+100] +", "+onTable[i+200]);
        }
        //print cards on table and pot
        System.out.println("\nOn the table: "+ onTable[1] +", "+ onTable[2]+", "+ onTable[3]+", "+ onTable[4]);

        System.out.println("\nTotal Pot: "+ totalPot);


        //new round

        for(int i = 0;i<totalPlayers;i++)//get player bets
        {
            System.out.println("\nPlayer "+ (i+1) + " place bet: ");
            totalPot += keyboard.nextInt(); //add bet to pot
        }

        onTable[5] = myDeck.dealCard();//new card on table
        for(int i = 0;i<totalPlayers;i++)//print player cards again to players
        {
            System.out.println("\nPlayer "+ (i+1) + " has: "+ onTable[i+100] +", "+onTable[i+200]);
        }
        //print cards on table and pot
        System.out.println("\nOn the table: "+ onTable[1] +", "+ onTable[2]+", "+ onTable[3]+", "+ onTable[4]+", "+ onTable[5]);

        System.out.println("\nTotal Pot: "+ totalPot);


        //determine winner later

    }

}
