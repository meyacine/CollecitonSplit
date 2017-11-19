This code is a simple maven project, that can be reused as dependency.

The main feature consists into splitting Lists into SubLists of <= n given elements.

The code is tested 100% using junit. You can run ```mvn clean test``` to execute tests.

## Sample code of usage
```
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
List<List<Integer>> result = ListSplitterUtil.split(list, 2);
```
## Alternative
You can use Apache Commons to get partition, example :

add dependecy in your pom.xml

```
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-collections4</artifactId>
    <version>4.0</version>
</dependency>
```

And then in your code you can the partitions using :
```
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
List<List<Integer>> result = ListUtils.partition(list, 2);
```

[See this article](http://www.baeldung.com/java-list-split)