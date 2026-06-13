package builder;
class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String monitor;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.monitor = builder.monitor;
    }

    public void show() {
        System.out.println(cpu);
        System.out.println(ram);
        System.out.println(storage);
        System.out.println(gpu);
        System.out.println(monitor);
    }

 public static class Builder {

        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private String monitor;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder setMonitor(String monitor) {
            this.monitor = monitor;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Computer pc =
            new Computer.Builder()
                .setCpu("Intel i7")
                .setRam("16GB")
                .setStorage("1TB SSD")
                .setGpu("RTX 4060")
                .setMonitor("24 Inch")
                .build();

        pc.show();
    }
}