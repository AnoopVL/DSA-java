import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class fileHandle {
    public static void main(String[] args) {
        // Input stream reader
        // try(InputStreamReader isr= new InputStreamReader(System.in)) {
        //     System.out.println("Enter few letters: ");;
        //     int letters= isr.read();
        //     while (isr.ready()) {
        //         System.out.println((char) letters);
        //         letters = isr.read();
        //     }
        //     System.out.println();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

        // // file reader
        // try(FileReader fr= new FileReader("note.txt")) {
        //     System.out.println("Enter few letters: ");;
        //     int letters= fr.read();
        //     while (fr.ready()) {
        //         System.out.println((char) letters);
        //         letters = fr.read();
        //     }
        //     System.out.println();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

        // BufferReader
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("You typed: "+ br.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("note.txt"))){
            while (br.ready()) {
                br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
