package memory;

public class Memory {

    private long max;
    private long used;

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public Memory(long max, long used) {
        this.max = max;
        this.used = used;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "max=" + max +
                ", used=" + used +
                '}';
    }
}
