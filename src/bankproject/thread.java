package bankproject;

public class thread {
private String name;

public thread(String name) {
    this.name = name;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return name;
}}