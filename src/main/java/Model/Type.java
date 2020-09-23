package Model;

public enum Type {
    Entity,
    Twitter,
    Link,
    UsualText;

    public boolean isEmpty(){
        return this.toString().isEmpty();
    }
}
