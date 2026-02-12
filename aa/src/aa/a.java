package aa;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class a {
    public static void main(String[] args) {

        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Fecha y hora actual: " + ahora.format(formato));
    }
}
