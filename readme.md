| di framework | startup cpu | startup memory | startup time    | jar size | startup time 1_000 bin | cpu 1_000 bin |
|--------------|-------------|----------------|-----------------|----------|------------------------|---------------|
| spring-boot  | 10%         | 30 mb          | 1.021 / 1.495 s | 14.4 mb  | 1.9 / 2.4 s            | 27%           |
| spring       | 9%          | 20 mb          | 0.8 s           | 9.5 mb   | 0.9 s                  | 11.8%         |
| koin         | 1%          | 16 mb          | 0.02 s          | 5.4 mb   | 0.03 s                 | 1.5%          |
| kodein       | 3.1%        | 16 mb          | 0.12 s          | 5.4 mb   | 0.12 s                 | 2.8%          |



startup 100 bin


example build  
cd spring-boot
./gradlew  clean  build -x test

example run
cd build/libs/
java -jar demo-0.0.1-SNAPSHOT.jar


