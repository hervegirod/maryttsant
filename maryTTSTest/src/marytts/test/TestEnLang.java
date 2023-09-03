/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marytts.test;

import java.io.File;
import java.util.Locale;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineEvent;
import static javax.sound.sampled.LineEvent.Type.CLOSE;
import javax.sound.sampled.LineListener;
import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.util.data.audio.AudioPlayer;

/**
 *
 * @author scdsahv
 */
public class TestEnLang implements LineListener {
   static {
      File userdir = new File(System.getProperty("user.dir"));
      File file = new File(userdir, "config");
      System.setProperty("mary.base", file.getPath());
   }   
   private LocalMaryInterface maryI;
   
   public static void main(String[] args) throws MaryConfigurationException {
      TestEnLang frlang = new TestEnLang();
      frlang.talk("This is a test");
   }

   public TestEnLang() throws MaryConfigurationException {
      Thread.currentThread().setContextClassLoader(TestEnLang.class.getClassLoader());
      maryI = new LocalMaryInterface();
      maryI.setLocale(Locale.US);
      maryI.setVoice("cmu-slt-hsmm");
   }
   
   public void talk(String sentence) {
      try ( AudioInputStream stream = maryI.generateAudio(sentence)) {
         AudioPlayer player = new AudioPlayer(stream, this);
         player.start();
      } catch (Exception ex) {
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
