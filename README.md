# OpenTDB4j
 A Simple Wrapper for the OpenTDB API in Java Maven.
 
 # Get Question
 ```java
 public static void main(String[] Args) throws LoginException {
        OpenTDB obj = new OpenTDB();
        obj.getCategory = 32;
        obj.getDifficulty = "easy";

        System.out.println(obj.getQuestion().question);
        System.out.println(obj.getQuestion().correctAnswer);

        for (int i = 0; i < obj.getQuestion().incorrectAnswers.length ; i++) {
            System.out.println(obj.getQuestion().incorrectAnswers[i]);
        }

        System.out.println(obj.getQuestion().category);
        System.out.println(obj.getQuestion().difficulty);

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
 
 You can now read out the API Response by using ``obj.getQuestion()`` as follows
 ```java
System.out.println(obj.getQuestion().question);
      System.out.println(obj.getQuestion().correctAnswer);

      for (int i = 0; i < obj.getQuestion().incorrectAnswers.length ; i++) {
          System.out.println(obj.getQuestion().incorrectAnswers[i]);
      }

      System.out.println(obj.getQuestion().category);
      System.out.println(obj.getQuestion().difficulty);
```
