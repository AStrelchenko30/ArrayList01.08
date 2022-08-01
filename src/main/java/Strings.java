import java.util.Objects;

public class Strings {
    private String item;

    public Strings(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Strings strings = (Strings) o;
        return Objects.equals(item, strings.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "Strings{" +
                "item='" + item + '\'' +
                '}';
    }
}
