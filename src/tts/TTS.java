/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
package TTS;
import com.sun.speech.freetts.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;
import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer
/**
 *
 * @author Sumit Suthar
 */
 
 
public class TTS {
  private String speakText;
    public  void doSpeak(String speak,String voice)
    {
        speakText=speak;
        FreeTTS freetts;
        SingleFileAudioPlayer sfap;
        System.setProperty("com.sun.speech.freetts.voice.defaultAudioPlayer", "com.sun.speech.freetts.audio.SingleFileAudioPlayer");
        try{
        VoiceManager vm = VoiceManager.getInstance();
        Voice v = vm.getVoice(voice);
        Voice sp=null;
        if(v!=null)
        {
            sp=v;
            System.out.println(speak);
        }
        else
            System.out.println("No text found");
        sp.allocate();
        freetts = new FreeTTS(sp);
        byte b[] = speakText.getBytes();
        try
        {
        sfap = (SingleFileAudioPlayer)sp.getDefaultAudioPlayer();
        sfap.write(b);
        }
        catch(Exception e)
        {
        }
      sp.speak(speakText);
     
        sp.deallocate();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }

    public static void main(String[] args)throws Exception  
    {
        TTS obj = new TTS();
        try{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        obj.doSpeak(line, "kevin16");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }
    
}
