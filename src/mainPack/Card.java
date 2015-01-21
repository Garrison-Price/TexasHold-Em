/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPack;

/**
 *
 * @author Garrison Price -- NO STEALING!
 */
public class Card
{
    private String face;
    private String suit;

    public Card(String cardFace, String cardSuit)
    {
        face = cardFace;
        suit = cardSuit;
    }

    public String toString()
    {
        return face + " of "+ suit;
    }

    public String getFace()
    {
        return face;
    }

    public String getSuit()
    {
        return suit;
    }

}
