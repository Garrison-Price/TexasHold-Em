/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPack;

/**
 *
 * @author Garrison Price -- NO STEALING!!
 */
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class TexasHoldEm extends JFrame implements ActionListener
{
     String faces[] = new String[8];
     String suits[] = new String[8];
     int score[] = new int[6];
     int totalPlayers;//get number of players input
     int totalPot = 0;
     int action = 0;
     Scanner keyboard;//create sacanner for inputs
     DeckOfCards myDeck = new DeckOfCards();//create a new deck
     Card onTable[] = new Card[400];//create array to hold cards on table

    public int WIDTH = 800;
    public int HEIGHT = 400;
    private JTextArea text;
    private JTextField jtf = new JTextField(20);
    static boolean playing = false;
    static TexasHoldEm run;
    private int xLoc;
    private int yLoc;


    public TexasHoldEm()
    {
        super("Texas Hold'Em");

        center();
        System.out.println(WIDTH+","+HEIGHT);
        setSize(WIDTH,HEIGHT);

        totalPot = 0;

        JPanel main = new JPanel();
        JPanel top = new JPanel();
        JPanel bot = new JPanel();

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));

        text = new JTextArea();
	text.setText("Welcome to Texas Hold'Em\nCreated By: Garrison Price\n\nPlease enter the number of players - ");
        top.add(text);
        bot.add(jtf, BorderLayout.CENTER);
        jtf.setHorizontalAlignment(JTextField.LEFT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtf.addActionListener(this);
        main.add(top);
        main.add(bot);
        getContentPane().add(main);
        this.setLocation(xLoc,yLoc);
        System.out.println((jtf.getWidth()));
        jtf.setColumns((int)((WIDTH*0.55/8)));
	setVisible(true);

        playing = true;
        while(playing == true)
        {
            //reset
            text.setText("Welcome to Texas Hold'Em\nCreated By: Garrison Price\n\nPlease enter the number of players - ");
            totalPlayers = 0;
            totalPot = 0;
            action = 0;
            for(int x = 0;x<score.length;x++)
            {
                score[x] = 0;
            }
            while(totalPlayers == 0)
            {
            
            }

            if(totalPlayers > 6)//limit amount of players to 6
                totalPlayers = 6;

            text.setText("Number of players set to "+totalPlayers);

            myDeck.shuffle();//shuffle the deck

            for(int i = 0;i<totalPlayers;i++)//deal to players
            {
                onTable[i+100] = myDeck.dealCard();//adding cards on the 100 plateu
                onTable[i+200] = myDeck.dealCard();//second cards on the 200 plateu
                text.setText("\nPlayer "+ (i+1) + " has: "+ onTable[i+100] +", "+onTable[i+200]);
                action = 2;//looking at cards
                while(action == 2)
                {

                }
            }

            //first bet
            for(int i = 0;i<totalPlayers;i++)//get player bets
            {
                text.setText("\nPlayer "+ (i+1) + " has: "+ onTable[i+100] +", "+onTable[i+200]+"\n\nPlayer "+ (i+1) + " place bet: ");
                action = 1;//betting
                while(action == 1)
                {

                }
            }

            //deal to table
            onTable[1] = myDeck.dealCard();//table cards on base plateu
            onTable[2] = myDeck.dealCard();
            onTable[3] = myDeck.dealCard();
            text.setText("\nOn the table: "+ onTable[1] +", "+ onTable[2]+", "+ onTable[3]+"\n\nTotal Pot: "+ totalPot);

            //second bet
            for(int i = 0;i<totalPlayers;i++)//get player bets
            {
                text.setText("\nOn the table: "+ onTable[1] +", "+ onTable[2]+", "+ onTable[3]+"\n\nTotal Pot: "+ totalPot+"\nPlayer "+ (i+1) + " has: "+ onTable[i+100] +", "+onTable[i+200]+"\n\nPlayer "+ (i+1) + " place bet: ");
                action = 1;//betting
                while(action == 1)
                {

                }
            }

            onTable[4] = myDeck.dealCard();//new card on table
            text.setText("\nOn the table: "+ onTable[1] +", "+ onTable[2]+", "+ onTable[3]+", "+ onTable[4]+"\n\nTotal Pot: "+ totalPot);


            //thrid bet

            for(int i = 0;i<totalPlayers;i++)//get player bets
            {
                text.setText("\nOn the table: "+ onTable[1] +", "+ onTable[2]+", "+ onTable[3]+", "+ onTable[4]+"\n\nTotal Pot: "+ totalPot+"\nPlayer "+ (i+1) + " has: "+ onTable[i+100] +", "+onTable[i+200]+"\n\nPlayer "+ (i+1) + " place bet: ");
                action = 1;//betting
                while(action == 1)
                {

                }
            }

            onTable[5] = myDeck.dealCard();//new card on table
            for(int i = 0;i<totalPlayers;i++)//print player cards again to players
            {
                text.setText("\nPlayer "+ (i+1) + " has: "+ onTable[i+100] +", "+onTable[i+200]);
            }
            //print cards on table and pot
            text.setText("\nOn the table: "+ onTable[1] +", "+ onTable[2]+", "+ onTable[3]+", "+ onTable[4]+", "+ onTable[5]+"\n\nTotal Pot: "+ totalPot);

            this.findWinner();

            //find winner
            if(score[0] > score[1] && score[0] > score[2] && score[0] > score[3] && score[0] > score[4] && score[0] > score[5])
            {
                text.setText("Player 1 wins! With a score of: "+ score[0]);
            }
            else if(score[1] > score[0] && score[1] > score[2] && score[1] > score[3] && score[1] > score[4] && score[1] > score[5])
            {
                text.setText("Player 2 wins! With a score of: "+ score[1]);
            }
            else if(score[2] > score[0] && score[2] > score[1] && score[2] > score[3] && score[2] > score[4] && score[2] > score[5])
            {
                text.setText("Player 3 wins! With a score of: "+ score[2]);
            }
            else if(score[3] > score[0] && score[3] > score[1] && score[3] > score[2] && score[3] > score[4] && score[3] > score[5])
            {
                text.setText("Player 4 wins! With a score of: "+ score[3]);
            }
            else if(score[4] > score[0] && score[4] > score[1] && score[4] > score[3] && score[4] > score[2] && score[4] > score[5])
            {
                text.setText("Player 5 wins! With a score of: "+ score[4]);
            }
            else if(score[5] > score[0] && score[5] > score[1] && score[5] > score[3] && score[5] > score[4] && score[5] > score[2])
            {
                text.setText("Player 6 wins! With a score of: "+ score[5]);
            }
            else
            {
                text.setText("Tie! With a score of: "+ score[0]+ " "+ score[1]+ " "+ score[2]+" "+ score[3]+" "+ score[4]+" "+ score[5]);
            }
            action = 2;
            while(action == 2)
            {

            }
            text.setText("Would you like to play again?\nEnter y to play again, and n to quit.");
            action = 3;//rematch?
            while(action == 3)
            {

            }

        }
        text.setText("Thanks for playing!\n\nClose window to exit.");

    }

    public void findWinner()
    {
        //Scoring loop, its big, I know... end at line 2194... over 2000 lines long!

        for(int i = 0;i<totalPlayers;i++)//input cards into hands for checking
        {
            Card playerOne = onTable[i+100];
            Card playerTwo = onTable[i+200];
            Card tableOne = onTable[1];
            Card tableTwo = onTable[2];
            Card tableThree = onTable[3];
            Card tableFour = onTable[4];
            Card tableFive = onTable[5];

            faces[1] = playerOne.getFace();
            suits[1] = playerOne.getSuit();
            faces[2] = playerTwo.getFace();
            suits[2] = playerTwo.getSuit();
            faces[3] = tableOne.getFace();
            suits[3] = tableOne.getSuit();
            faces[4] = tableTwo.getFace();
            suits[4] = tableTwo.getSuit();
            faces[5] = tableThree.getFace();
            suits[5] = tableThree.getSuit();
            faces[6] = tableFour.getFace();
            suits[6] = tableFour.getSuit();
            faces[7] = tableFive.getFace();
            suits[7] = tableFive.getSuit();


            for(int x =0;x<score.length;x++)
            {
                score[i] = 0;
            }
            int aceCount = 0;
            int kingCount = 0;
            int queenCount = 0;
            int jackCount = 0;
            int tenCount = 0;
            int nineCount = 0;
            int eightCount = 0;
            int sevenCount = 0;
            int sixCount = 0;
            int fiveCount = 0;
            int fourCount = 0;
            int threeCount = 0;
            int twoCount = 0;



            //
            //
            //High Card
            //
            //
            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            for(int x = 0;x<faces.length;x++)
            {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    if(aceCount == 2)
                    {
                        score[i] = 13;
                    }
                    else if(kingCount == 2)
                    {
                        score[i] = 12;
                    }
                    else if(queenCount == 2)
                    {
                        score[i] = 11;
                    }
                    else if(jackCount == 2)
                    {
                        score[i] = 10;
                    }
                    else if(tenCount == 2)
                    {
                        score[i] = 9;
                    }
                    else if(nineCount == 2)
                    {
                        score[i] = 8;
                    }
                    else if(eightCount == 2)
                    {
                        score[i] = 7;
                    }
                    else if(sevenCount == 2)
                    {
                        score[i] = 6;
                    }
                    else if(sixCount == 2)
                    {
                        score[i] = 5;
                    }
                    else if(fiveCount == 2)
                    {
                        score[i] = 4;
                    }
                    else if(fourCount == 2)
                    {
                        score[i] = 3;
                    }
                    else if(threeCount == 2)
                    {
                        score[i] = 2;
                    }
                    else if(twoCount == 2)
                    {
                        score[i] = 1;
                    }
            //End High Card
            //
            //Pair
            //
            //
            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            int pair = 0;
            for(int x = 0;x<faces.length;x++)
            {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    if(aceCount == 2)
                    {
                        pair = 13;
                    }
                    else if(kingCount == 2)
                    {
                        pair = 12;
                    }
                    else if(queenCount == 2)
                    {
                        pair = 11;
                    }
                    else if(jackCount == 2)
                    {
                        pair = 10;
                    }
                    else if(tenCount == 2)
                    {
                        pair = 9;
                    }
                    else if(nineCount == 2)
                    {
                        pair = 8;
                    }
                    else if(eightCount == 2)
                    {
                        pair = 7;
                    }
                    else if(sevenCount == 2)
                    {
                        pair = 6;
                    }
                    else if(sixCount == 2)
                    {
                        pair = 5;
                    }
                    else if(fiveCount == 2)
                    {
                        pair = 4;
                    }
                    else if(fourCount == 2)
                    {
                        pair = 3;
                    }
                    else if(threeCount == 2)
                    {
                        pair = 2;
                    }
                    else if(twoCount == 2)
                    {
                        pair = 1;
                    }
            if(pair == 1)
            {
                score[i] = 101;
            }
            else if(pair == 2)
            {
                score[i] = 102;
            }
            else if(pair == 3)
            {
                score[i] = 103;
            }
            else if(pair == 4)
            {
                score[i] = 104;
            }
            else if(pair == 5)
            {
                score[i] = 105;
            }
            else if(pair == 6)
            {
                score[i] = 106;
            }
            else if(pair == 7)
            {
                score[i] = 107;
            }
            else if(pair == 8)
            {
                score[i] = 108;
            }
            else if(pair == 9)
            {
                score[i] = 109;
            }
            else if(pair == 10)
            {
                score[i] = 110;
            }
            else if(pair == 11)
            {
                score[i] = 111;
            }
            else if(pair == 12)
            {
                score[i] = 112;
            }
            else if(pair == 13)
            {
                score[i] = 113;
            }



            //End Pair
            //
            //Two Pair
            //
            //
            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            pair = 0;
            int secPair = 0;
            for(int x = 0;x<faces.length;x++)
            {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    if(aceCount == 2)
                    {
                        pair = 13;
                    }
                    if(kingCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 12;
                        }
                        else
                        {
                            pair = 12;
                        }

                    }
                    if(queenCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 11;
                        }
                        else
                        {
                            pair = 11;
                        }
                    }
                    if(jackCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 10;
                        }
                        else
                        {
                            pair = 10;
                        }
                    }
                    if(tenCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 9;
                        }
                        else
                        {
                            pair = 9;
                        }
                    }
                    if(nineCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 8;
                        }
                        else
                        {
                            pair = 8;
                        }
                    }
                    if(eightCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 7;
                        }
                        else
                        {
                            pair = 7;
                        }
                    }
                    if(sevenCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 6;
                        }
                        else
                        {
                            pair = 6;
                        }
                    }
                    if(sixCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 5;
                        }
                        else
                        {
                            pair = 5;
                        }
                    }
                    if(fiveCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 4;
                        }
                        else
                        {
                            pair = 4;
                        }
                    }
                    if(fourCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 3;
                        }
                        else
                        {
                            pair = 3;
                        }
                    }
                    if(threeCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 2;
                        }
                        else
                        {
                            pair = 2;
                        }
                    }
                    if(twoCount == 2)
                    {
                        if(pair > 0)
                        {
                            secPair = 1;
                        }
                        else
                        {
                            pair = 1;
                        }
                    }
            if(pair == 1 && secPair > 0)
            {
                score[i] = 201;
            }
            else if(pair == 2&& secPair > 0)
            {
                score[i] = 202;
            }
            else if(pair == 3&& secPair > 0)
            {
                score[i] = 203;
            }
            else if(pair == 4&& secPair > 0)
            {
                score[i] = 204;
            }
            else if(pair == 5&& secPair > 0)
            {
                score[i] = 205;
            }
            else if(pair == 6&& secPair > 0)
            {
                score[i] = 206;
            }
            else if(pair == 7&& secPair > 0)
            {
                score[i] = 207;
            }
            else if(pair == 8&& secPair > 0)
            {
                score[i] = 208;
            }
            else if(pair == 9&& secPair > 0)
            {
                score[i] = 209;
            }
            else if(pair == 10&& secPair > 0)
            {
                score[i] = 210;
            }
            else if(pair == 11&& secPair > 0)
            {
                score[i] = 211;
            }
            else if(pair == 12&& secPair > 0)
            {
                score[i] = 212;
            }
            else if(pair == 13&& secPair > 0)
            {
                score[i] = 213;
            }
            //End Two Pair
            //
            //Three Kind
            //
            //

            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            int threeKind = 0;

            for(int x = 0;x<faces.length;x++)
            {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    if(aceCount == 3)
                    {
                        threeKind = 13;
                    }
                    else if(kingCount == 3)
                    {
                        threeKind = 12;
                    }
                    else if(queenCount == 3)
                    {
                        threeKind = 11;
                    }
                    else if(jackCount == 3)
                    {
                        threeKind = 10;
                    }
                    else if(tenCount == 3)
                    {
                        threeKind = 9;
                    }
                    else if(nineCount == 3)
                    {
                        threeKind = 8;
                    }
                    else if(eightCount == 3)
                    {
                        threeKind = 7;
                    }
                    else if(sevenCount == 3)
                    {
                        threeKind = 6;
                    }
                    else if(sixCount == 3)
                    {
                        threeKind = 5;
                    }
                    else if(fiveCount == 3)
                    {
                        threeKind = 4;
                    }
                    else if(fourCount == 3)
                    {
                        threeKind = 3;
                    }
                    else if(threeCount == 3)
                    {
                        threeKind = 2;
                    }
                    else if(twoCount == 3)
                    {
                        threeKind = 1;
                    }
            if(threeKind == 1)
            {
                score[i] = 301;
            }
            else if(threeKind == 2)
            {
                score[i] = 302;
            }
            else if(threeKind == 3)
            {
                score[i] = 303;
            }
            else if(threeKind == 4)
            {
                score[i] = 304;
            }
            else if(threeKind == 5)
            {
                score[i] = 305;
            }
            else if(threeKind == 6)
            {
                score[i] = 306;
            }
            else if(threeKind == 7)
            {
                score[i] = 307;
            }
            else if(threeKind == 8)
            {
                score[i] = 308;
            }
            else if(threeKind == 9)
            {
                score[i] = 309;
            }
            else if(threeKind == 10)
            {
                score[i] = 310;
            }
            else if(threeKind == 11)
            {
                score[i] = 311;
            }
            else if(threeKind == 12)
            {
                score[i] = 312;
            }
            else if(threeKind == 13)
            {
                score[i] = 313;
            }
            //End Three Kind
            //
            //Straight
            //
            //
            //
            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            for(int x = 0;x<faces.length;x++)
            {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    if(aceCount > 1 && kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1)
                    {
                        score[i] = 413;
                    }
                    else if(kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1)
                    {
                        score[i] = 412;
                    }
                    else if(queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1 && eightCount > 1)
                    {
                        score[i] = 411;
                    }
                    else if(jackCount > 1 && tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 )
                    {
                        score[i] = 410;
                    }
                    else if(tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 )
                    {
                        score[i] = 409;
                    }
                    else if(nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 )
                    {
                        score[i] = 408;
                    }
                    else if(eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1)
                    {
                        score[i] = 407;
                    }
                    else if(sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1)
                    {
                        score[i] = 406;
                    }
                    else if(sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1)
                    {
                        score[i] = 405;
                    }
                    else if(fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1 && aceCount > 1)
                    {
                        score[i] = 404;
                    }

            //End Straight
            //
            //Full House
            //
            //
            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            threeKind = 0;
            pair = 0;
            for(int x = 0;x<faces.length;x++)
            {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    if(aceCount == 3)
                    {
                        threeKind = 13;
                    }
                    else if(kingCount == 3)
                    {
                        threeKind = 12;
                    }
                    else if(queenCount == 3)
                    {
                        threeKind = 11;
                    }
                    else if(jackCount == 3)
                    {
                        threeKind = 10;
                    }
                    else if(tenCount == 3)
                    {
                        threeKind = 9;
                    }
                    else if(nineCount == 3)
                    {
                        threeKind = 8;
                    }
                    else if(eightCount == 3)
                    {
                        threeKind = 7;
                    }
                    else if(sevenCount == 3)
                    {
                        threeKind = 6;
                    }
                    else if(sixCount == 3)
                    {
                        threeKind = 5;
                    }
                    else if(fiveCount == 3)
                    {
                        threeKind = 4;
                    }
                    else if(fourCount == 3)
                    {
                        threeKind = 3;
                    }
                    else if(threeCount == 3)
                    {
                        threeKind = 2;
                    }
                    else if(twoCount == 3)
                    {
                        threeKind = 1;
                    }


                    if(aceCount == 2)
                    {
                        pair = 13;
                    }
                    else if(kingCount == 2)
                    {
                        pair = 12;
                    }
                    else if(queenCount == 2)
                    {
                        pair = 11;
                    }
                    else if(jackCount == 2)
                    {
                        pair = 10;
                    }
                    else if(tenCount == 2)
                    {
                        pair = 9;
                    }
                    else if(nineCount == 2)
                    {
                        pair = 8;
                    }
                    else if(eightCount == 2)
                    {
                        pair = 7;
                    }
                    else if(sevenCount == 2)
                    {
                        pair = 6;
                    }
                    else if(sixCount == 2)
                    {
                        pair = 5;
                    }
                    else if(fiveCount == 2)
                    {
                        pair = 4;
                    }
                    else if(fourCount == 2)
                    {
                        pair = 3;
                    }
                    else if(threeCount == 2)
                    {
                        pair = 2;
                    }
                    else if(twoCount == 2)
                    {
                        pair = 1;
                    }
            if(threeKind == 1 && pair > 0 )
            {
                score[i] = 601;
            }
            else if(threeKind == 2&& pair > 0 )
            {
                score[i] = 602;
            }
            else if(threeKind == 3&& pair > 0 )
            {
                score[i] = 603;
            }
            else if(threeKind == 4&& pair > 0 )
            {
                score[i] = 604;
            }
            else if(threeKind == 5&& pair > 0 )
            {
                score[i] = 605;
            }
            else if(threeKind == 6&& pair > 0 )
            {
                score[i] = 606;
            }
            else if(threeKind == 7&& pair > 0 )
            {
                score[i] = 607;
            }
            else if(threeKind == 8&& pair > 0 )
            {
                score[i] = 608;
            }
            else if(threeKind == 9&& pair > 0 )
            {
                score[i] = 609;
            }
            else if(threeKind == 10&& pair > 0 )
            {
                score[i] = 610;
            }
            else if(threeKind == 11&& pair > 0 )
            {
                score[i] = 611;
            }
            else if(threeKind == 12&& pair > 0 )
            {
                score[i] = 612;
            }
            else if(threeKind == 13&& pair > 0 )
            {
                score[i] = 613;
            }
            //End Full House




            //Four of a Kind
            //
            //
            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            for(int x = 0;x<faces.length;x++)
                    {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    if(aceCount == 4)
                    {
                        score[i] = 713;
                    }
                    else if(kingCount == 4)
                    {
                        score[i] = 712;
                    }
                    else if(queenCount == 4)
                    {
                        score[i] = 711;
                    }
                    else if(jackCount == 4)
                    {
                        score[i] = 710;
                    }
                    else if(tenCount == 4)
                    {
                        score[i] = 709;
                    }
                    else if(nineCount == 4)
                    {
                        score[i] = 708;
                    }
                    else if(eightCount == 4)
                    {
                        score[i] = 707;
                    }
                    else if(sevenCount == 4)
                    {
                        score[i] = 706;
                    }
                    else if(sixCount == 4)
                    {
                        score[i] = 705;
                    }
                    else if(fiveCount == 4)
                    {
                        score[i] = 704;
                    }
                    else if(fourCount == 4)
                    {
                        score[i] = 703;
                    }
                    else if(threeCount == 4)
                    {
                        score[i] = 702;
                    }
                    else if(twoCount == 4)
                    {
                        score[i] = 701;
                    }
            //End Four of a Kind
            //
            //
            //Spades
            //
            //
            int spadeCount = 0;
            int cardNum = 0;
            int spades[] = new int[8];
            for(int x = 1;x<suits.length;x++)
            {
                if(suits[x] == "Spades")
                {
                    spadeCount++;
                    spades[cardNum] = x;
                    cardNum++;
                }
            }


            switch(spadeCount)
            {
                case 7:
                case 6:
                case 5:
                {
                    for(int x = 0;x<spades.length;x++)
                    {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    //
                    //Flush
                    //
                    if(aceCount > 1)
                    {
                        if(score[i]>513)
                            score[i] = 513;
                    }
                    else if(kingCount > 1)
                    {
                        if(score[i]>512)
                            score[i] = 512;
                    }
                    else if(queenCount > 1)
                    {
                        if(score[i]>511)
                            score[i] = 511;
                    }
                    else if(jackCount > 1 )
                    {
                        if(score[i]>510)
                            score[i] = 510;
                    }
                    else if(tenCount > 1 )
                    {
                        if(score[i]>509)
                            score[i] = 509;
                    }
                    else if(nineCount > 1 )
                    {
                        if(score[i]>508)
                            score[i] = 508;
                    }
                    else if(eightCount > 1)
                    {
                        if(score[i]>507)
                            score[i] = 507;
                    }
                    else if(sevenCount > 1)
                    {
                        if(score[i]>506)
                            score[i] = 506;
                    }
                    else if(sixCount > 1)
                    {
                        if(score[i]>505)
                            score[i] = 505;
                    }
                    else if(fiveCount > 1)
                    {
                        if(score[i]>504)
                            score[i] = 504;
                    }
                    else if(fourCount > 1)
                    {
                        if(score[i]>503)
                            score[i] = 503;
                    }
                    else if(threeCount > 1)
                    {
                        if(score[i]>502)
                            score[i] = 502;
                    }
                    else if(twoCount > 1)
                    {
                        if(score[i]>501)
                            score[i] = 501;
                    }
                    //
                    //Straight Flush
                    //
                    if(aceCount > 1 && kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1)
                    {
                        score[i] = 900;
                    }
                    else if(kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1)
                    {
                        score[i] = 812;
                    }
                    else if(queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1 && eightCount > 1)
                    {
                        score[i] = 811;
                    }
                    else if(jackCount > 1 && tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 )
                    {
                        score[i] = 810;
                    }
                    else if(tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 )
                    {
                        score[i] = 809;
                    }
                    else if(nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 )
                    {
                        score[i] = 808;
                    }
                    else if(eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1)
                    {
                        score[i] = 807;
                    }
                    else if(sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1)
                    {
                        score[i] = 806;
                    }
                    else if(sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1)
                    {
                        score[i] = 805;
                    }
                    else if(fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1 && aceCount > 1)
                    {
                        score[i] = 804;
                    }



                }
            }

            //
            //
            //Clubs
            //
            //
            int clubCount = 0;
            cardNum = 0;
            int clubs[] = new int[8];
            for(int x = 1;x<suits.length;x++)
            {
                if(suits[x] == "Clubs")
                {
                    clubCount++;
                    clubs[cardNum] = x;
                    cardNum++;
                }
            }

            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            switch(clubCount)
            {
                case 7:
                case 6:
                case 5:
                {
                    for(int x = 0;x<clubs.length;x++)
                    {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    //
                    //Flush
                    //
                    if(aceCount > 1)
                    {
                        if(score[i]>513)
                            score[i] = 513;
                    }
                    else if(kingCount > 1)
                    {
                        if(score[i]>512)
                            score[i] = 512;
                    }
                    else if(queenCount > 1)
                    {
                        if(score[i]>511)
                            score[i] = 511;
                    }
                    else if(jackCount > 1 )
                    {
                        if(score[i]>510)
                            score[i] = 510;
                    }
                    else if(tenCount > 1 )
                    {
                        if(score[i]>509)
                            score[i] = 509;
                    }
                    else if(nineCount > 1 )
                    {
                        if(score[i]>508)
                            score[i] = 508;
                    }
                    else if(eightCount > 1)
                    {
                        if(score[i]>507)
                            score[i] = 507;
                    }
                    else if(sevenCount > 1)
                    {
                        if(score[i]>506)
                            score[i] = 506;
                    }
                    else if(sixCount > 1)
                    {
                        if(score[i]>505)
                            score[i] = 505;
                    }
                    else if(fiveCount > 1)
                    {
                        if(score[i]>504)
                            score[i] = 504;
                    }
                    else if(fourCount > 1)
                    {
                        if(score[i]>503)
                            score[i] = 503;
                    }
                    else if(threeCount > 1)
                    {
                        if(score[i]>502)
                            score[i] = 502;
                    }
                    else if(twoCount > 1)
                    {
                        if(score[i]>501)
                            score[i] = 501;
                    }
                    //
                    //Straight Flush
                    //
                    if(aceCount > 1 && kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1)
                    {
                        score[i] = 900;
                    }
                    else if(kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1)
                    {
                        score[i] = 812;
                    }
                    else if(queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1 && eightCount > 1)
                    {
                        score[i] = 811;
                    }
                    else if(jackCount > 1 && tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 )
                    {
                        score[i] = 810;
                    }
                    else if(tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 )
                    {
                        score[i] = 809;
                    }
                    else if(nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 )
                    {
                        score[i] = 808;
                    }
                    else if(eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1)
                    {
                        score[i] = 807;
                    }
                    else if(sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1)
                    {
                        score[i] = 806;
                    }
                    else if(sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1)
                    {
                        score[i] = 805;
                    }
                    else if(fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1 && aceCount > 1)
                    {
                        score[i] = 804;
                    }



                }
            }
            //
            //
            //Hearts
            //
            //
            int heartCount = 0;
            cardNum = 0;
            int hearts[] = new int[8];
            for(int x = 1;x<suits.length;x++)
            {
                if(suits[x] == "Hearts")
                {
                    heartCount++;
                    hearts[cardNum] = x;
                    cardNum++;
                }
            }

            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            switch(heartCount)
            {
                case 7:
                case 6:
                case 5:
                {
                    for(int x = 0;x<hearts.length;x++)
                    {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }
                    //
                    //Flush
                    //
                    if(aceCount > 1)
                    {
                        if(score[i]>513)
                            score[i] = 513;
                    }
                    else if(kingCount > 1)
                    {
                        if(score[i]>512)
                            score[i] = 512;
                    }
                    else if(queenCount > 1)
                    {
                        if(score[i]>511)
                            score[i] = 511;
                    }
                    else if(jackCount > 1 )
                    {
                        if(score[i]>510)
                            score[i] = 510;
                    }
                    else if(tenCount > 1 )
                    {
                        if(score[i]>509)
                            score[i] = 509;
                    }
                    else if(nineCount > 1 )
                    {
                        if(score[i]>508)
                            score[i] = 508;
                    }
                    else if(eightCount > 1)
                    {
                        if(score[i]>507)
                            score[i] = 507;
                    }
                    else if(sevenCount > 1)
                    {
                        if(score[i]>506)
                            score[i] = 506;
                    }
                    else if(sixCount > 1)
                    {
                        if(score[i]>505)
                            score[i] = 505;
                    }
                    else if(fiveCount > 1)
                    {
                        if(score[i]>504)
                            score[i] = 504;
                    }
                    else if(fourCount > 1)
                    {
                        if(score[i]>503)
                            score[i] = 503;
                    }
                    else if(threeCount > 1)
                    {
                        if(score[i]>502)
                            score[i] = 502;
                    }
                    else if(twoCount > 1)
                    {
                        if(score[i]>501)
                            score[i] = 501;
                    }
                    //
                    //Straight Flush
                    //
                    if(aceCount > 1 && kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1)
                    {
                        score[i] = 900;
                    }
                    else if(kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1)
                    {
                        score[i] = 812;
                    }
                    else if(queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1 && eightCount > 1)
                    {
                        score[i] = 811;
                    }
                    else if(jackCount > 1 && tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 )
                    {
                        score[i] = 810;
                    }
                    else if(tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 )
                    {
                        score[i] = 809;
                    }
                    else if(nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 )
                    {
                        score[i] = 808;
                    }
                    else if(eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1)
                    {
                        score[i] = 807;
                    }
                    else if(sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1)
                    {
                        score[i] = 806;
                    }
                    else if(sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1)
                    {
                        score[i] = 805;
                    }
                    else if(fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1 && aceCount > 1)
                    {
                        score[i] = 804;
                    }



                }
            }
            //
            //
            //Diamonds
            //
            //
            int diamondCount = 0;
            cardNum = 0;
            int diamonds[] = new int[8];
            for(int x = 1;x<suits.length;x++)
            {
                if(suits[x] == "Diamonds")
                {
                    clubCount++;
                    clubs[cardNum] = x;
                    cardNum++;
                }
            }

            aceCount = 0;
            kingCount = 0;
            queenCount = 0;
            jackCount = 0;
            tenCount = 0;
            nineCount = 0;
            eightCount = 0;
            sevenCount = 0;
            sixCount = 0;
            fiveCount = 0;
            fourCount = 0;
            threeCount = 0;
            twoCount = 0;
            switch(diamondCount)
            {
                case 7:
                case 6:
                case 5:
                {
                    for(int x = 0;x<diamonds.length;x++)
                    {
                        if(faces[x] == "Ace")
                        {
                            aceCount++;
                        }
                        else if(faces[x] == "King")
                        {
                            kingCount++;
                        }
                        else if(faces[x] == "Queen")
                        {
                            queenCount++;
                        }
                        else if(faces[x] == "Jack")
                        {
                            jackCount++;
                        }
                        else if(faces[x] == "Ten")
                        {
                            tenCount++;
                        }
                        else if(faces[x] == "Nine")
                        {
                            nineCount++;
                        }
                        else if(faces[x] == "Eight")
                        {
                            eightCount++;
                        }
                        else if(faces[x] == "Seven")
                        {
                            sevenCount++;
                        }
                        else if(faces[x] == "Six")
                        {
                            sixCount++;
                        }
                        else if(faces[x] == "Five")
                        {
                            fiveCount++;
                        }
                        else if(faces[x] == "Four")
                        {
                            fourCount++;
                        }
                        else if(faces[x] == "Three")
                        {
                            threeCount++;
                        }
                        else if(faces[x] == "Two")
                        {
                            twoCount++;
                        }
                    }

                    //
                    //Flush
                    //
                    if(aceCount > 1)
                    {
                        if(score[i]>513)
                            score[i] = 513;
                    }
                    else if(kingCount > 1)
                    {
                        if(score[i]>512)
                            score[i] = 512;
                    }
                    else if(queenCount > 1)
                    {
                        if(score[i]>511)
                            score[i] = 511;
                    }
                    else if(jackCount > 1 )
                    {
                        if(score[i]>510)
                            score[i] = 510;
                    }
                    else if(tenCount > 1 )
                    {
                        if(score[i]>509)
                            score[i] = 509;
                    }
                    else if(nineCount > 1 )
                    {
                        if(score[i]>508)
                            score[i] = 508;
                    }
                    else if(eightCount > 1)
                    {
                        if(score[i]>507)
                            score[i] = 507;
                    }
                    else if(sevenCount > 1)
                    {
                        if(score[i]>506)
                            score[i] = 506;
                    }
                    else if(sixCount > 1)
                    {
                        if(score[i]>505)
                            score[i] = 505;
                    }
                    else if(fiveCount > 1)
                    {
                        if(score[i]>504)
                            score[i] = 504;
                    }
                    else if(fourCount > 1)
                    {
                        if(score[i]>503)
                            score[i] = 503;
                    }
                    else if(threeCount > 1)
                    {
                        if(score[i]>502)
                            score[i] = 502;
                    }
                    else if(twoCount > 1)
                    {
                        if(score[i]>501)
                            score[i] = 501;
                    }
                    //
                    //Straight Flush
                    //
                    if(aceCount > 1 && kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1)
                    {
                        score[i] = 900;
                    }
                    else if(kingCount > 1 && queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1)
                    {
                        score[i] = 812;
                    }
                    else if(queenCount > 1 && jackCount > 1 && tenCount > 1 && nineCount > 1 && eightCount > 1)
                    {
                        score[i] = 811;
                    }
                    else if(jackCount > 1 && tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 )
                    {
                        score[i] = 810;
                    }
                    else if(tenCount > 1 && nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 )
                    {
                        score[i] = 809;
                    }
                    else if(nineCount > 1&& eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 )
                    {
                        score[i] = 808;
                    }
                    else if(eightCount > 1 && sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1)
                    {
                        score[i] = 807;
                    }
                    else if(sevenCount > 1 && sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1)
                    {
                        score[i] = 806;
                    }
                    else if(sixCount > 1 && fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1)
                    {
                        score[i] = 805;
                    }
                    else if(fiveCount > 1 && fourCount > 1 && threeCount > 1 && twoCount > 1 && aceCount > 1)
                    {
                        score[i] = 804;
                    }



                }
            }
            //End Flush
        }
    }

    public static void main(String args[])
    {
        run = new TexasHoldEm();
    }

    public void center()
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = ge.getMaximumWindowBounds();
        WIDTH = (int)(bounds.width*0.55);
        HEIGHT = (int)(bounds.height*0.44);
        xLoc = Math.abs(bounds.width/2 - (WIDTH/2));
        yLoc = Math.abs(bounds.height/2 - (HEIGHT/2));
        
    }



    public void actionPerformed(ActionEvent e) {
        if(totalPlayers == 0)
        {
            totalPlayers = Integer.parseInt(jtf.getText().trim());
            jtf.setText("");
        }
        if(action == 1)
        {
            totalPot += Integer.parseInt(jtf.getText().trim()); //add bet to pot
            action = 0;
            jtf.setText("");
        }
        else if(action == 2)
        {
            action = 0;
        }
        else if(action == 3)
        {
            if(jtf.getText().trim().charAt(0) == 'y')
            {
                action = 0;
                jtf.setText("");
            }
            else if(jtf.getText().trim().charAt(0) == 'n')
            {
                text.setText("Thanks for playing!\n\nClose window to exit.");
                jtf.setText("");
            }
        }
    }
}