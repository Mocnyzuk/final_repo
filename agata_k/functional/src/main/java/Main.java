import model.Participant;

import static model.ParticipantListModifications.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Participant> listOfParticipants = List.of(
                new Participant("Ala", "Zar", 2001),
                new Participant("Basia", "Bela", 2016),
                new Participant("Adam", "Berek", 1998),
                new Participant("Zara", "Lok", 1923),
                new Participant("Kamila", "Beza", 1972),
                new Participant("Artur", "Rak", 1986),
                new Participant("Laura", "Ad", 1965),
                new Participant("Laura", "Koala", 1995),
                new Participant("Ola", "Bela", 1963),
                new Participant("Kora", "Berek", 1993),
                new Participant("Ala", "Bala", 2006),
                new Participant("Lamila", "Beza", 1967),
                new Participant("Artur", "Anaś", 1993),
                new Participant("Ania", "Zoler", 1995)
        );

        System.out.println("Alphabetically sorted names of participants, whose names stats with \"A\" and who were not born in 90':"
                .toUpperCase());
        showSurnameName(sortNames(filterNameStartsWith(filterBorn90(listOfParticipants, false), "A"), true));

        printBreak();

        System.out.println("List of participants born in 90', sorted by surnames reversed".toUpperCase());
        showSurnameName(sortSurnames(filterBorn90(listOfParticipants, true), false));

        printBreak();

        System.out.println("Age of participants whose name starts with L sorted by age".toUpperCase());
        showParticipantsWithAgeAsc(filterNameStartsWith(listOfParticipants, "L"));

        printBreak();

        System.out.println("List of adult participants with age, sorted by age".toUpperCase());
        showParticipantsWithAgeAsc(sortAge(filterAdults(listOfParticipants, true), true));
    }

    static void printBreak() {
        System.out.println("____________________");
    }

}
