# robocode-awsp-awbot
Re-imported as Google Code is shutting down.

------------------
### University of Hawaii - ISC 413 Software Engineering School Project

Write AI to control robot to fight each other.



How to use Awbot

- 1.0 Download
    - Download the latest version at here
    - Extract the package using WinRaR, WinZip, etc.

- 2.0 Installation
    -Look for asw.aswbot_{version}.jar, extract it. Copy the folder asw to Robocode's folder, under /robot/
    - Start Robocode and you will see Awbot from the menu.


This develop guide is to help developers how to modify and improve awbot.

= Table of Content =
 * [#1.0_Prerequisites 1.0 Prerequisites]
 * [#2.0_Installation 2.0 Installation]
   * [#2.1_Preparation 2.1 Preparation]
   * [#2.2_Verify_Package 2.2 Verify Package]
 * [#3.0_Development_Guidelines 3.0 Development Guidelines]

## 1.0 Prerequisites =

Robocode requires [JAVA 5.0](http://java.com/en/download) to run.

In order to build and verify the system you modify, it is recommended to use [http://ant.apache.org/ Ant 1.8]


## 2.0 Installation

#### 2.1 Preparation
  * Check out Awbot from [http://code.google.com/p/robocode-asw-awbot/source/checkout]
  * To begin installation, switch to the directory where you downloaded awbot in command line and type the following command. This will allow ivy to download all necessary libraries you need.
  ```
  $ ant
  ```


#### 2.2 Verify Package
  * Once all necessary packages are downloaded, type the following command.
  ```
  $ ant -f verify.build.xml
  ```

  If for some reasons, you get an error in this process, please contact [me](anthonyspwu@gmail.com).

= 3.0 Development Guidelines =
  * Awbot is developed fully under eclipse followed by the standard coding format of JAVA. If you found that your version of eclipse is using different format, please apply the following format, [http://ics-software-engineering.googlecode.com/svn/trunk/configfiles/eclipse.format.xml Eclipse Format for Robocode]
  * When committing changes to the trunk, please comment as detail as possible so that other people know what is changed.
  * Robocode has a rich API and can be found [http://robocode.sourceforge.net/docs/robocode here]
  * Please develop JUnit tests when you have new feature developed.
  * Perform ant -f verify.build.xml right before committing your work.
  * Commit only small portion at a time if possible to avoid losing your precious work.