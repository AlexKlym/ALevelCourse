import java.util.Objects;

public class BF {
    String bf;

    public BF(String bf) {
        this.bf = bf;
    }

    public String getBf() {
        return bf;
    }

    public void setBf(String bf) {
        this.bf = bf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BF bf1 = (BF) o;
        return Objects.equals(bf, bf1.bf);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bf);
    }


}
