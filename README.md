# OpenTDB4j
 A Simple Wrapper for the OpenTDB API in Java Maven.
 
# Download

### Maven

```xml
      <dependencies>
        <dependency>
            <groupId>com.github.shinixsensei-dev</groupId>
            <artifactId>opentdb4j</artifactId>
            <version>1.0.2</version>
        </dependency>
      </dependencies>
```
 
 # Get Question
 ```java
 public static void main(String[] Args) throws LoginException {
         OpenTDB obj = new OpenTDB();
         obj.getCategory = 32;
         obj.getDifficulty = "easy";
 
         obj.getQuestion();
 
         System.out.println(obj.question);
         System.out.println(obj.correctAnswer);
 
         for (int i = 0; i < obj.incorrectAnswers.length ; i++) {
             System.out.println(obj.incorrectAnswers[i]);
         }
 
         System.out.println(obj.category);
         System.out.println(obj.difficulty);
 
     }
 ```
 
 # Configuration
 First, create a new OpenTDB Object
 ```java
      OpenTDB obj = new OpenTDB();
 ```
 
 After that, you can set a category and a difficulty (optional (Will be random if none is set))
 ```java
      obj.getCategory = 29;
      obj.getDifficulty = "hard";
 ```

Now run the method by using
```java
      obj.getQuestion();
```
 
 You can now read out the API Response by using ``obj`` as follows
 ```java
      System.out.println(obj.question);
      System.out.println(obj.correctAnswer);

      for (int i = 0; i < obj.incorrectAnswers.length ; i++) {
          System.out.println(obj.incorrectAnswers[i]);
      }

      System.out.println(obj.category);
      System.out.println(obj.difficulty);
```
