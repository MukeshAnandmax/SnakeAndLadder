package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Dice {
    private  int count;
    public int roll(){
        int min= count;
        int max = count*Constants.DICE_MAX_VALUE;
        int range = max-min+1;
        return (int)(Math.random()*range)+min;
    }
}
