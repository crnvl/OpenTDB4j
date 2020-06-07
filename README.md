# OpenTDB4j
 A Simple Wrapper for the OpenTDB API in Java Maven.
 
# Download

### Maven

```xml
<dependency>
  <groupId>com.github.shinixsensei-dev</groupId>
  <artifactId>OpenTDB4j</artifactId>
  <version>1.0.4</version>
</dependency>
```
 
 # Usage
 ```java
 public static void main(String[] Args) throws LoginException {
         OpenTDB obj = new OpenTDB();
                 obj.setCategory = 32;
                 obj.setDifficulty = "easy";
         
                 obj.getQuestion();
         
                 System.out.println(obj.getQuestion);
                 System.out.println(obj.getCorrectAnswer);
         
                 for (int i = 0; i < obj.getIncorrectAnswers.length ; i++) {
                     System.out.println(obj.getIncorrectAnswers[i]);
                 }
         
                 System.out.println(obj.getCategory);
                 System.out.println(obj.getDifficulty);
 
     }
 ```
 
 # Configuration
 First, create a new OpenTDB Object
 ```java
      OpenTDB obj = new OpenTDB();
 ```
 
 After that, you can set a category and a difficulty (optional (Will be random if none is set))
 ```java
      obj.setCategory = 29;
      obj.setDifficulty = "hard";
 ```
 
# Get Response
Now run the method by using
```java
      obj.getQuestion();
```
 
 You can now read out the API Response by using ``obj`` as follows
 ```java
      System.out.println(obj.getQuestion);
      System.out.println(obj.getCorrectAnswer);

      for (int i = 0; i < obj.getIncorrectAnswers.length ; i++) {
          System.out.println(obj.getIncorrectAnswers[i]);
      }

      System.out.println(obj.getCategory);
      System.out.println(obj.getDifficulty);
```
