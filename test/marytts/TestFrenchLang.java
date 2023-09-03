/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marytts;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineEvent;
import static javax.sound.sampled.LineEvent.Type.CLOSE;
import javax.sound.sampled.LineListener;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

/**
 *
 * @author scdsahv
 */
public class TestFrenchLang implements LineListener {
   static {
      File userdir = new File(System.getProperty("user.dir"));
      File file = new File(userdir, "dist");
      System.setProperty("mary.base", file.getPath());
   }   
   
   private LocalMaryInterface maryI;
   
   public static void main(String[] args) throws MaryConfigurationException {
      TestFrenchLang frlang = new TestFrenchLang();
      frlang.talk("Ceci est un test");
   }

   public TestFrenchLang() throws MaryConfigurationException {
      Thread.currentThread().setContextClassLoader(TestFrenchLang.class.getClassLoader());
      LocalMaryInterface maryI = new LocalMaryInterface();
      maryI.setVoice("enst-camille-hsmm");
   }
   
   public void talk(String sentence) {
      try ( AudioInputStream stream = maryI.generateAudio(sentence)) {
         AudioPlayer player = new AudioPlayer(stream, this);
         player.start();
      } catch (SynthesisException | IOException ex) {
         ex.printStackTrace();
      }      
   }
   
   @Override
   public void update(LineEvent event) {
      LineEvent.Type type = event.getType();
      if (type == CLOSE) {
         System.out.println("Done");
      }
   }   
}
