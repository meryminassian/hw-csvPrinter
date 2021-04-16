import com.github.javafaker.Faker;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PdfService {

    private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    private static Faker faker = new Faker();
    private static Random r = new Random();

    private static List<Person> generatePeople(){
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String id = String.valueOf(faker.number().digits(2));
            String date = sdf.format(faker.date().birthday());
            String mail = faker.internet().emailAddress(firstName.toLowerCase() + id);
            //String phoneNumber = faker.numerify("0##-###-###");
            String phoneNumber = faker.phoneNumber().cellPhone();
            people.add(new Person(firstName, lastName, date,
                    Arrays.asList(Race.values()).get(r.nextInt(5)),
                    phoneNumber, mail));
        }
        return people;
    }

    private static List<Person> people = generatePeople();

    public static File file = new File("people.csv");

    public static void generate(){

        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(file),
                CSVFormat.DEFAULT.withHeader("Name", "Last name", "Date of Birth", "Race", "Phone Number", "Email"))) {

            for (int i = 0; i < people.size(); i++) {
                csvPrinter.printRecord(people.get(i).getName(),
                        people.get(i).getSurname(),
                        people.get(i).getDate(),
                        people.get(i).getRace().toString().toLowerCase(),
                        people.get(i).getPhoneNumber(),
                        people.get(i).getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
