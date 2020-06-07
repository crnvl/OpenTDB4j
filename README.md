# OpenTDB4j
 A Simple Wrapper for the OpenTDB API in Java Maven.
 
# Download

### Apache Maven

```xml
<dependency>
  <groupId>com.github.shinixsensei-dev</groupId>
  <artifactId>OpenTDB4j</artifactId>
  <version>VERSION</version>
</dependency>
```

# Gradle
### Kotlin DSL
```xml
implementation("com.github.shinixsensei-dev:OpenTDB4j:VERSION")
```
### Groovy DSL
```xml
implementation 'com.github.shinixsensei-dev:OpenTDB4j:VERSION'
```
It's recommended to use the newest Version in the [Release Tab](https://github.com/shinixsensei-dev/OpenTDB4j/releases).
 
 # Usage
 ```java
 public static void main(String[] Args) throws LoginException {
         OpenTDB obj = new OpenTDB();
                 obj.setCategory(29);
                 obj.setDifficulty("easy");
         
                 obj.getTrivia();
         
                 System.out.println(obj.getQuestion());
                 System.out.println(obj.getCorrectAnswer());
         
                 for (int i = 0; i < obj.getIncorrectAnswers().length ; i++) {
                     System.out.println(obj.getIncorrectAnswers()[i]);
                 }
         
                 System.out.println(obj.getCategory());
                 System.out.println(obj.getDifficulty());
 
     }
 ```
 View [OpenTDB](https://opentdb.com/api_config.php) to see available selections for ``.setCategory()`` and ``.setDifficulty()``.
 
 # Configuration
 First, create a new OpenTDB Object
 ```java
    OpenTDB obj = new OpenTDB();
 ```
 
 After that, you can set a category and a difficulty (optional (Will be random if none is set))
 ```java
    obj.setCategory(29);
    obj.setDifficulty("easy");
 ```
 
# Get Response
Now run the method by using
```java
    obj.getTrivia();
```
 
 You can now read out the API Response by using ``obj`` as follows
 ```java
    System.out.println(obj.getQuestion());
    System.out.println(obj.getCorrectAnswer());
               
    for (int i = 0; i < obj.getIncorrectAnswers().length ; i++) {
        System.out.println(obj.getIncorrectAnswers()[i]);
    }
               
    System.out.println(obj.getCategory());
    System.out.println(obj.getDifficulty());
```
