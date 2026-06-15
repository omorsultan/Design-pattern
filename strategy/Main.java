package strategy;

interface CompressionStrategy{
    void compress(String archiveName);
}

class CompressByZIP implements CompressionStrategy{
    public void compress(String archiveName){
        System.out.println("Applying ZIP compression algorithm...");
        System.out.println("Step 1: Creating .zip container for " + archiveName);
        System.out.println("Step 2: Calculating DEFLATE checksum.");
        System.out.println("Files compressed successfully into " + archiveName + ".zip");
    }
}

class CompressByRAR implements CompressionStrategy{
    public void compress(String archiveName){

            System.out.println("Applying RAR compression algorithm...");
            System.out.println("Step 1: Header encryption initialized.");
            System.out.println("Step 2: Compressing blocks using PPMd variant.");
            System.out.println("Files compressed successfully into " + archiveName + ".rar");
    }
}

class CompressBY7ZIP implements CompressionStrategy{
    public void compress(String archiveName){
            System.out.println("Applying 7-Zip compression algorithm...");
            System.out.println("Step 1: Setting up LZMA2 dictionary size.");
            System.out.println("Step 2: Splitting metadata into solid blocks.");
            System.out.println("Files compressed successfully into " + archiveName + ".7z");
        
    }
}
class Compressoin{
    private CompressionStrategy compressionStrategy;
    private String file = "Design Pattern pdf";

    public void setCompressionStrategy(CompressionStrategy compressionStrategy){
        this.compressionStrategy = compressionStrategy;
    }

    public void compressing(){
        compressionStrategy.compress(file);
    }

    

    
}

// Execution (Main Class)
public class Main{
    public static void main(String[] args) {

        Compressoin cmp = new Compressoin();

        cmp.setCompressionStrategy(new CompressBY7ZIP());
        cmp.compressing();

        
    }
}