package Model;


import java.util.Objects;

public class MetaData implements Comparable<MetaData> {
    private Type type;
    private int start;
    private int end;

    public MetaData(Type type, int start, int end) {
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Wrong input parameter type");
        }
        if (start < 0 || start > end) {
            throw new IllegalArgumentException("Wrong input parameter start or end");
        }
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaData metaData = (MetaData) o;
        return start == metaData.start &&
                end == metaData.end &&
                type == metaData.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, start, end);
    }

    @Override
    public int compareTo(MetaData metaData) {
        if(start == metaData.start ){
            return 0;
        }
        return start > metaData.start ? 1 : -1;
    }
}
