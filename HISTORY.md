# History
The version history of this library presents:
 * The version of maryTTS used to pruduce the library
 * The version of the build (the implementation)

## maryTTS 5.2.1
## build 1
 - Port the build system to ant
 - Fix the javadoc
 - Extract the dependencies to external jars. Note that github projects for [Jampack](https://github.com/hervegirod/JampackSaved) and [sgt](https://github.com/hervegirod/sgt) had to be created
 - Add a Main-Class property to the client and runtime manifests to show the maryTTS and build (implementation) versions
 - Update [slf4j-api](https://mvnrepository.com/artifact/org.slf4j/slf4j-api/1.7.30) version from 1.6.1 to 1.7.30
 - Update [slf4j-log4j12](https://mvnrepository.com/artifact/org.slf4j/slf4j-log4j12/1.7.26) version from 1.6.1 to 1.7.26
 - Update [httpcore](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore/4.4.12) version from 4.1 to 4.4.12
 - Update [commons-lang 2.6](https://mvnrepository.com/artifact/commons-lang/commons-lang/2.6) to [commons-lang3 3.3.10](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.13.0)

Note that for this build only the French and English languages are ported. The other languages are not available yet.
