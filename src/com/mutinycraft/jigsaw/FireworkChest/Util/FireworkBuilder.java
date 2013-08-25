package com.mutinycraft.jigsaw.FireworkChest.Util;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

/**
 * User: Jigsaw
 * Date: 8/24/13
 * Time: 8:25 PM
 */

public class FireworkBuilder {

    public static FireworkEffect getRandomEffect(String color, String type) {
        return FireworkEffect.builder().with(getEffect(type)).withColor(getColor(color)).build();
    }

    private static Color getColor(String c){
        if(c.equalsIgnoreCase("white")){
            return Color.WHITE;
        }
        else if(c.equalsIgnoreCase("yellow")){
            return Color.YELLOW;
        }
        else if(c.equalsIgnoreCase("green")){
            return Color.GREEN;
        }
        else if(c.equalsIgnoreCase("aqua")){
            return Color.AQUA;
        }
        else if(c.equalsIgnoreCase("purple")){
            return Color.PURPLE;
        }
        else if(c.equalsIgnoreCase("orange")){
            return Color.ORANGE;
        }
        else{
            return Color.RED;
        }
    }

    private static FireworkEffect.Type getEffect(String t){
        if(t.equalsIgnoreCase("star")){
            return FireworkEffect.Type.STAR;
        }
        else if(t.equalsIgnoreCase("ball_large")){
            return FireworkEffect.Type.BALL_LARGE;
        }
        else if(t.equalsIgnoreCase("burst")){
            return FireworkEffect.Type.BURST;
        }
        else if(t.equalsIgnoreCase("aqua")){
            return FireworkEffect.Type.CREEPER;
        }
        else{
            return FireworkEffect.Type.BALL;
        }
    }


}
