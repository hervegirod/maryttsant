/**
 * Copyright 2000-2006 DFKI GmbH.
 * All Rights Reserved.  Use is subject to license terms.
 *
 * This file is part of MARY TTS.
 *
 * MARY TTS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package marytts;

import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;

/**
 * Provide Version information for the Mary server and client.
 *
 * @version 5.2.1
 *
 */
public class Version {
   private static Version version = null;
   private String specificationVersion;
   private String implementationVersion;

   private Version() {
      URL url = Thread.currentThread().getContextClassLoader().getResource("marytts/specification-version.txt");
      try {
         PropertyResourceBundle prb = new PropertyResourceBundle(url.openStream());
         specificationVersion = prb.getString("version");
         implementationVersion = prb.getString("build-version");
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   public static String specificationVersion() {
      if (version == null) {
         version = new Version();
      }
      return version.specificationVersion;
   }

   public static String implementationVersion() {
      if (version == null) {
         version = new Version();
      }
      return version.implementationVersion;
   }

   public static void main(String[] args) {
      if (version == null) {
         version = new Version();
      }
      System.out.println("maryTTS version " + version.specificationVersion);
      System.out.println("maryTTS implementation version " + version.implementationVersion);
      System.out.println("Distributed under the MaryTTS license");
   }

}
