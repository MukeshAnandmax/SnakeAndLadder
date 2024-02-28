package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dice {
    private  int count;
    public  int roll(){
        int min= count;
        int max = count*6;
        int range = max-min+1;
        return (int)(Math.random()*range)+min;
    }
}
