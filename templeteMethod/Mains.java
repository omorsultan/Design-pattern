package templeteMethod;
// ডিজাইন প্যাটার্ন ছাড়া CSV ফাইল প্রসেস করার ক্লাস

abstract class dataMinerTemplate{
    private String filePath;
    public final void mineFille(String filePath){
        this.filePath = filePath;
        open();
        perse();
        generateReport();
    }
    private void open(){
         System.out.println("STREAM: Opening file connection from path: " + filePath);
        System.out.println("STREAM: Allocating memory buffer...");
    }
    private void generateReport(){
        System.out.println("REPORT: Analyzing extracted data patterns...");
        System.out.println("REPORT: Statistics report generated successfully.\n");
    }
    protected abstract void perse();
}


class CSVDataMiner extends dataMinerTemplate{
        @Override
        protected void perse(){
        System.out.println("PARSER: Reading rows separated by commas (',').");
        System.out.println("PARSER: Converting CSV rows into raw text segments.");
        }
    
}

// ডিজাইন প্যাটার্ন ছাড়া PDF ফাইল প্রসেস করার ক্লাস
class PDFDataMiner extends dataMinerTemplate{
    @Override 
    protected void perse(){
        System.out.println("PARSER: Initializing PDF font-byte stream reader.");
        System.out.println("PARSER: Extracting text elements from PDF pages layout.");
    }       
}

// Execution (Main Class)
public class Mains {
    public static void main(String[] args) {
        System.out.println("--- Mining CSV File ---");
        dataMinerTemplate csvMiner = new CSVDataMiner();
        csvMiner.mineFille("data.csv");

        System.out.println("--- Mining PDF File ---");
        dataMinerTemplate pdfMiner = new PDFDataMiner();
        pdfMiner.mineFille("report.pdf");
    }
}