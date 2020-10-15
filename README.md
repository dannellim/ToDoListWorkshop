# ToDoListWorkshop
To Do List Workshop for Essential Practices for Agile Teams NUS ISS

Institute of Systems Science
National University of Singapore

NICF – Essential Practices for Agile Teams
Continuous Integration Work-
shop with Jenkins and Git

Copyright 2013 -20 NUS. The contents contained in this document may not be reproduced in any form or by
any means, without the written permission of ISS and NUS, other than for the purpose for which it has been
supplied.

Contents

        Overview
        Setup GitHub Project
        Working in Teams
            Suggested steps for working in team .............................................................
        Eclipse (Java) Instructions
        Sharing an Eclipse project to GitHub (by GitHub Admin)
        Importing Eclipse project from GitHub (by Member)
        Pushing your change to GitHub with Eclipse (by Member and GitHub Admin)
        Creating build.xml and modifying build.xml (by GitHub Admin)
        Reference Jenkins Instructions for Java (by Jenkins Admin)
        Setup a new project in Jenkins
        Configure Jenkins to automatically build the project
        Configure Jenkins to publish the test result

1. Overview

The following diagram sets the context for this workshop.

GitHub

Jenkins

GitHub Admin

Members

Jenkins Admin

Pull

There are three roles. You may customize it to suit your preference if necessary.

    Member: All the team members play this role.
    GitHub Admin: One member/pair is assigned to administer the GitHub repository.
    This member/pair also sets up the Unit Testing build/batch file.
    Jenkins Admin: One member/pair is assigned to administer the team project in Jen-
    kins.

The following diagram illustrates the overall flow of this workshop.
2. Setup GitHub Project

Setup a group GitHub Project for your Todo List application as started from Day 1.
Working in Teams

Your team will need to use a source code management software to support team collabora-
tion for this workshop. The recommended SCM to be used is Git on GitHub.
Suggested steps for working in team .............................................................

    The GitHub Admin creates the project template and shares it to GitHub. Refer to the in-
    structions in section 3 on Eclipse’s integration with Git.
    The GitHub Admin makes the repository publicly accessible. This would simplify the ac-
    cess from the Jenkins Server.

a. Go to GitHub page for your project e.g. https://github.com/<user>/Todo-
ListJava and click Settings - Manage access.

b. Configure the access so that it is publicly accessible.

    The GitHub Admin grants read-write access to all the Members to access the repository

a. Go to GitHub page for your project e.g. https://github.com/<user>/Todo-
ListJava and click Settings - Manage access.

b. Invite the teammates (with their usernames) as the collaborators for this pro-
ject.

    Each Member creates a working copy (clone) of the project into his/her workstation –
    refer to section 3 for Java instructions.

a. Clone the project to local machine.

b. Open the solution in your IDE.

    Each Member continues with development. Whenever changes are done locally, per-
    form the following.

a. Run the unit tests, and make sure they pass.

b. Pull the latest code from GitHub.

c. Run the unit tests to make sure that they still pass.

d. Commit the change.

e. Push the change to GitHub.

f. Trigger Jenkins to perform build if it’s not configured to do so automatically.

3. Eclipse (Java) Instructions
Sharing an Eclipse project to GitHub (by GitHub Admin)

    Select Help > About Eclipse IDE to check that Eclipse EGit is one of the installed features.
    Otherwise, select Help > Eclipse Marketplace to i nstall EGit - Git Integration for Eclipse.
    Right click on your project in Package Explorer window, select Team > Share Project****.
    If prompted to select a repository type, c hoose Git , select Next.
    If there is an existing Git repository to use, choose it and select Finish. Otherwise, select
    Create to first create a new repository at a desirable location and then select Finish.

    Right click on your project in Package Explorer window, select Team > Commit to per-
    form the initial commit. Enter the commit message, and add the files that you want to
    include as part of Staged Changes. For a simple Java program, you probably would se-
    lect all of them excluding the generated files (e.g. .class). Select Commit to commit the
    staged files.

    The next step is to push the committed files to GitHub.
    Create a new empty repository in GitHub. Let the repository be publicly accessible. Do
    not opt to create any file in the repository like Readme.md, etc.
    Right click on your project in Package Explorer window in Eclipse, select Team > Re-
    mote > Push. Enter the URI of your new GitHub repository and the authentication details
    and then select Next. Note: Do not use the sample URI below.

    Select master from both Source ref and Destination ref , select Add Spec and then Fin-
    ish. Note the message acknowledging the completion of the remote push.

Importing Eclipse project from GitHub (by Member)

Note: The GitHub Admin should not perform the steps in this section as he/she has already
the local Git repository.

    In Eclipse, select File > Import> Git > Projects from Git and then Next.
    Select Clone URI and then Next.

    Enter the URI of your team repository (not the repository of ISS-EPAT). Otherwise, you
    will not be able to push to the latter repository. Select Next.
    Select the master branch and then Next.

    Enter the directory where you want the local Git repository to reside and select Next.
    Choose to import the existing Eclipse projects and select Next.

    Make sure that the project is ticked and then select Finish.
    In the event that you somehow mess up the local Git repository and/or the Eclipse work-
    space, you may want to purge both directories and start over again.

Pushing your change to GitHub with Eclipse (by Member and GitHub Admin)
min)

    Once you are done with your changes, commit your changes to your local repository us-
    ing the Team > Commit menu.
    Push the changes to GitHub using the Team > Push to Upstream menu.

Creating build.xml and modifying build.xml (by GitHub Admin)

    Right click on your Eclipse project and select Export.
    Select General > Ant Buildfiles. The default settings are generally OK. Select Next and
    then Finish. File build.xml should be created and added to the project.
    To allow Jenkins to build the project, you need to include the jUnit related jar files in
    GitHub. To do this, right click on your project and select New > Folder to create a new
    folder (e.g. lib ) at the same level as src. Select Finish. A folder should be created and
    added to the project.

    Look for locations of the jUnit and Hamcrest jar files of the project. You can copy and
    paste or drag and drop them from a file explorer to Eclipse. You can also look for the lo-
    cations from build.xml.

    Update the locations of jUnit jar files in build.xml to use relative paths instead of abso-
    lute paths.
    Update build.xml to run the jUnit tests and generate report. The following line needs to
    be modified:

<target depends=”build-subprojects, build-project” name=”build”/>

The above line specifies that build target depends on 2 other targets. This is how we can
combine targets (tasks) in Ant. There is no unit testing included here, so we can look for
the target names of our jUnit tests & report generation and include them as the de-
pendencies of “build” target. Note: If you have JUnit tests created before you generate
build.xml, your build.xml would include targets that run your JUnit tests.

For the above target names, the line should look like the following:

<target depends=”build-subprojects, build-project, ToDoListTest,
junitreport” name=”build”/>

    This step is optional! If you wish to test out build.xml, it can be performed in Eclipse as
    follows. Select build.xml of the project and then Run > External Tools. If there is an exist-
    ing run configuration for Ant, use it. Otherwise, select Run > External Tools > External
    Tool Configurations > Ant Build and then the New launch configuration icon. Enter Ant
    Build as name and select Run. Ensure that the jUnit targets are successfully run. Check
    the jUnit test results as well as the generated filename for the jUnit report (needed f or
    the configuration of Jenkins project).

    Stage the changes (build.xml, jUnit jar file and Hamcrest jar file). Commit and push them
    to GitHub.

4. Reference Jenkins Instructions for Java (by Jenkins Admin)
min)
Setup a new project in Jenkins

    Browse to Jenkins at http://13.228.193.3 and login using username: epat and pass-
    word epat
    After you login, create a new project by clicking on “New Item” on the left sidebar
    Name your project, and choose Freestyle project. Replace YOURNAME with your
    chosen name to differentiate your project from everyone else’s.
    Your project name will be automatically populated. You can still change it if you want
    to.
    Choose Git as your source code management. Enter the repository URL for your Tod-
    oList project. The following example uses repository URL https://github.com/ISS-
    EPAT/StackAnnotation.git. For public projects in GitHub (like the one we use for this
    exercise), everyone has the right to download the source code, so you can choose
    any existing credentials in the system.
    Click on Save, and then build the project using the “Build Now” menu on the left
    sidebar. You should see the project get built and make sure that the project can be
    successfully built. From the project page you can click on the build number and then

Console Output to see the output of the build process. If you face problems that you
cannot troubleshoot, get your instructor’s assistance.

Configure Jenkins to automatically build the project

    Once you’ve successfully build using the previous configuration, we are going to en-
    hance the configuration to build the project. From the sidebar in your project,
    choose “Configure” to edit the configuration of your project.
    Look for “Add build step” under Build category that looks like the button below.
    Choose “Invoke Ant” from the drop-down option. Configure it following the screen-
    shot below. Make sure that you chose Ant Installation as the Ant version otherwise
    the b uild will fail.

Ant is one of the build tools commonly used in Java. It depends on a configuration
file with the name build.xml located at the root of your project folder. The tasks in
Ant is called as “target” and we have just configured Jenkins to run a task called build
in our configuration file. This task will perform the compilation, build and finally run
all the test cases in our project; all of this configured in build.xml. Based on the con-
figuration file, a test report will be generated in the junit folder.

    Save the configuration and rebuild. Make sure that the project can be successfully
    built before you move on to the next step. Remember that you can click on the build
    number to see the details of that particular build and see the console output by click-
    ing on “Console Output” link on the sidebar.

Configure Jenkins to publish the test result

    Now we’re going to enhance the configuration again to get Jenkins to publish the
    test result generated by the previous step. Look for the button below and c hoose
    “Publish JUnit test result report” from the drop-down option.

    Configure the options like the screenshot below. To get the test report XML location,
    you can browse the workspace accessible from the Jenkins job main page.
    Save and build the project again. You should be able to see a new link “Latest Test
    Result” on the project page.

- THE END -

