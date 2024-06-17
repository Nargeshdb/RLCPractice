This repository has some simple Java code to help practice in running the
[Resource Leak Checker](https://checkerframework.org/manual/#resource-leak-checker). Follow the steps below to get
started.

### Background

The Resource Leak Checker is a static analysis tool that checks for resource leaks in Java programs.
A resource leak occurs when a program fails to close a resource, such as a file or a socket. Resource leaks can lead
to bugs, security vulnerabilities, and performance problems. You can see a couple of small examples of resource leaks
in [this blog post](https://aws.amazon.com/blogs/devops/resource-leak-detection-in-amazon-codeguru/) but you should also
search for other background resources.

The Resource Leak Checker is part of the [Checker Framework](https://checkerframework.org/), which is a collection of
pluggable type checkers. To learn more about pluggable type checking in general, read Chapters 1 and 2 in
the [Checker Framework manual](https://checkerframework.org/manual/). Then,
read [Chapter 8](https://checkerframework.org/manual/#resource-leak-checker) to learn specifically about the Resource
Leak Checker and its features. You can also read the [FSE 2021 paper](https://manu.sridharan.net/files/FSE21Leaks.pdf)
for more details, background, and evaluation.

### Running the Resource Leak Checker on this repository

To run the Resource Leak Checker on the code in this repository, follow these steps:

1. Create a fork of this repository, and clone your fork to your local machine.  (Creating a fork is helpful so you can
   back up your changes on a branch.)
2. Create a new branch for your changes. For example, you could name the branch `add-resource-leak-checker`.
3. Add the [Checker Framework Gradle Plugin](https://github.com/kelloggm/checkerframework-gradle-plugin) to the
   `build.gradle` file in this repository, and enable the Resource Leak Checker as described in the plugin
   documentation (the fully-qualified name of the checker
   is `org.checkerframework.checker.resourceleak.ResourceLeakChecker`).
4. Run the Resource Leak Checker on the code in this repository by running the following command:
   ```
   ./gradlew compileJava
   ```
   If everything is configured correctly, you should see 2 reported errors.

Once you have successfully run the Resource Leak Checker on this repository, you can try fixing the reported errors.