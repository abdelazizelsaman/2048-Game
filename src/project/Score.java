package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Score implements  Serializable{
    private int score ; 
    private int Hscore;
    
    public Score(int s, int hs){
        this.score = s;
        this.Hscore = hs;
    }
    
    protected void setHscore(){
        try{
            int tempScore = 0;
            File f = new File("Hscore.txt");
            FileReader fread = new FileReader(f);
            BufferedReader reader = new BufferedReader(fread);
            tempScore = Integer.parseInt(reader.readLine());
            if(tempScore > this.Hscore){
                this.Hscore = tempScore;
            }else{
                if(this.Hscore < this.score){
                    Hscore = score;
                }
            }
            
            reader.close();
            fread.close();
            
            FileWriter fwrite = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(fwrite);
            writer.write(Integer.toString(Hscore));
            writer.close();
            fwrite.close();
                
        }catch(FileNotFoundException e){
            try{
                this.Hscore = score;
                File f = new File("Hscore.txt");
                FileWriter fwrite = new FileWriter(f);
                BufferedWriter writer = new BufferedWriter(fwrite);
                writer.write(Integer.toString(Hscore));
                writer.close();
                fwrite.close();
                
            }catch(Exception f){f.printStackTrace();}
        }
        catch(IOException io){
            io.printStackTrace();
        } 
    }
    protected int getHscore(){
        return this.Hscore;
    } 
    
    public int getScore(){
        return this.score;
    }
    
    public void addScore(int s){
        score += s;
    }
    
    public void setScore(int s){
        score = s;
    }
    
}
