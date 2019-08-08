# Money Control Automation Framework
## Introduction
This document helps to configure MoneyControl automation framework in Windows machine.
## Pre-requisites
The following list of software need to be installed as part of Money Control automation set-up:

|Software Name|Versions|
|---------------|---------|
|[Java SDK](#java-sdk) |8 or later|
|[Eclipse IDE](#eclipse-ide)|Oxygen or later|
|testNG|6.10 or later|
|[jenkins](https://jenkins.io/download/)|2.121.3 or later|
   
### Java SDK
Refer [link](https://docs.oracle.com/javase/7/docs/webnotes/install/windows/jdk-installation-windows.html) for detailed steps to set-up Java SDK in Microsoft Windows machine.
### GitHub Desktop
 - [Download](https://desktop.github.com/) and install GitHub Desktop
 - Once the installation is done go to GitHub Desktop root folder(usually resides at C:/Users/*YourUserName*/AppData/Local/GitHubDesktop) and run *GitHubDesktop.exe* as administrator
 
**Note:** You have to fork [main repo]( https://github.com/txpertsmc/TXMCFramework.git) to your account from web browser before proceeding with the next step.
 - Click on **Clone a repository** button and login with your git credentials and select your forked version of MoneyControl Automation framework repo(Something looks like *<yourID>/TXMCFramework.git*)
 - Select appropriate local path(e.g., D:/git/) to where you want to clone the repository and click on **clone** button.

### Eclipse IDE
- From Eclipse [download page](https://www.eclipse.org/downloads), under "Get Eclipse Photon" ⇒ Click "Download Packages"
- Choose the 4th(Eclipse IDE for Java Developers) and select appropriate system architecture version 32-bit/64-bit (e.g., "eclipse-java-photon-R-win32-x86_64.zip" 195MB) ⇒ Download
 - To install Eclipse, simply unzip the downloaded file into a directory of your choice (e.g., "C:\Eclipse")
 - To run Eclipse, double-click *eclipse.exe* file under Eclipse root folder(C:\Eclipse)

### Maven and testNG configuration
Maven will be available by default in latest eclipse versions if not then 
Go to : Help --> Eclipse Marketplace and search for Maven and testNG and install(Eclipse may be asked to restart).

### Framework setup in Eclipse IDE
 - Open Eclipse IDE and go to workbench
 - In eclipse workbench, right-click in the leftpage(Package Explorer pane) and click on **Import**
 - In Import window, Expand *Maven* and select **Existing Maven Projects** and click on **Next**
 - In Import Maven Projects window, Browse for the framework root directory(e.g., D:/git/TXMCframework) to where you have cloned the repository and click on **Finish**
 - In case if there are any errors related to multi-cath, change java compiler to Java 1.8 or later(Right-click on project --> Properties --> Java Compiler --> select latest version of *Compiler compliance level* --> **Apply and Close**)

### Running a test suite
You can execute any test suite using any of the following ways:
 - In project root folder, customize the testng.xml file and run it as testNG suite file
 - Execute the pom.xml as maven test
 - Configure jenkins and execute from there (Work in progress for jenkins use)

### Framework folder structure 
 |Folder Path/Pattern|Description|
 |---------------|---------|
 |`TO-BE`|`DISCUSSED`|
 |`reports/`|Contains reports generated during execution.|
 |`pom.xml`|Project build file.|
 
### Coding Standards
**1.Format the code before pulling code from main repo.**
 - Ctrl+Shift+O -> for auto-import dependencies
 - Ctrl+Shift+F -> for formatting-> for formatting (except ConstUtil.java)
 
**2.Standards to follow :**
 - Classes should start with Caps
 - Methods should start with small letter
 - Objects/variables should start with small
 - Constants need to be ALL_CAPS with _ as separator
 - No need to create object to call methods within the same class
 - Any method should not throw any exception
 - Every exception need to be handled within the scope
 
 ### Common Errors and possible fixes
**Not able to execute scripts in IE**
 - Make sure that browser zoom level is set to 100%; IE browser View menu --> Zoom --> 100%
 - Make sure that "protection mode" is enabled for all the zones; IE browser Tools menu --> Internet Options --> Security tab --> navigate to Internet, Local intranet, Trusted sites and Restricted site and check Protection Mode checkbox is checked

### Setup and usage of HubConfigManager
 - [Download](https://nodejs.org/en/download/) and install npm
 - Install appium CLI through npm using command 
 `npm install -g appium`
 - Call main method of HubConfigManager class in your runner class
