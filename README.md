# ������ "������������� JUnit"

## ��������
� ���� ������� �������� ������ ����� � �������������� ���������� ��� ���������� ������������ **JUnit**  

�������� ���� ��� ������������� ����� ������� �������� �������, ������� �� ��� �������  
���������, ��� �� ����������� ��� ����������������� - ��������� ������ ��������� � ������� �����-�� ������ �������?  

� ������ �������� ��������� �����, ������� �������� ����������������� �������������.   
������ ������ ���� �� ����� ���.  

�.�. ����� ����, ��� ����� ����, �� ������ ����������� �������� (�������������) ��� �������� ���. 
��������, �� ������������ ��� �������� �������� ����������� � ���� ����! 
�, ������� ���-��, ������� � ����� ������ �� ���� ������ ���������, ��� �� ��-�������� ��������

## ����������
���������� ����������� � ������� ������� ������  
Maven:  
```xml
<dependency>
   <groupId>org.junit.jupiter</groupId>
   <artifactId>junit-jupiter-engine</artifactId>
   <version>5.1.0</version>
   <scope>test</scope>
</dependency>
```

��� Gradle:
```gradle
dependencies {
  // .. ������ �����������
  testImplementation('org.junit.jupiter:junit-jupiter:5.6.2')
}

test {
  useJUnitPlatform()
}
```

�������� ����� ��� ������ � ����� `src/test/java` (������ ����� ������� �������� � ������������ � package'�� ������, ������� �� ������ �����������)  

� ������ �������� ������ ����  
```java
@org.junit.jupiter.api.Test
public void testConcat_validArgument_success() {
  // given:
  ...

  // when:
  ...    

  // then:
    Assertions.***;
}
```
��� �� ����� `...` ���������� ��� ���������� � ������������, � ����� ������ �������� ������  
� ������ `Assertions.` �������� ���������� ����� �� ��������� IntelliJ IDEA.   
����� ������� (��������) ������ ������� ��������� � ����� ����������� ������


# ������ "JUnit + Hamcrest"

## ��������
���������� ��� Hamcrest ��� JUnit

���������� ���� ����� �� ������� ������� � ����� Hamcrest

�������� ��� ������� 2 �����, �������� ������������ �� ���� Hamcrest, ������� ��� � ����������� �������� JUnit

## ����������
���������� ����������� � ������� ������� ������  
Maven:  
```xml
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-all</artifactId>
    <version>1.3</version>
</dependency>
```
��� Gradle:
```gradle
      testImplementation 'org.hamcrest:hamcrest-all:1.3'
```

*������ ����� �� �����������:*
```java
@Test
public void contains() {
   List<String> list = List.of("hello", "netology", "world");

   assertThat(list, hasItems("hello", "netology"));
}
```

����� `assertThat` - ����������� ������ �� `org.hamcrest.MatcherAssert`  
� `hasItems` ������ ����� � `org.hamcrest.Matchers` - ��� �� �� ������ ������ ������ �������.   
����� ������� `Matchers.`, ������� ������ �� ����������� ���������, � ����� ��� �������� ������������ ������ ���������� IntelliJ