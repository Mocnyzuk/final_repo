package model;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantListModifications {
    public static List<Participant> sortNames(List<Participant> participantList, boolean alphabeticalOrder) {
        if (alphabeticalOrder)
            return participantList
                    .stream()
                    .sorted(Participant.nameSort)
                    .collect(Collectors.toList());
        else
            return participantList
                    .stream()
                    .sorted(Participant.nameSort.reversed())
                    .collect(Collectors.toList());
    }

    public static List<Participant> sortSurnames(List<Participant> participantList, boolean alphabeticalOrder) {
        if (alphabeticalOrder)
            return participantList
                    .stream()
                    .sorted(Participant.surnameSort)
                    .collect(Collectors.toList());
        else
            return participantList
                    .stream()
                    .sorted(Participant.surnameSort.reversed())
                    .collect(Collectors.toList());
    }

    public static List<Participant> sortAge(List<Participant> participantList, boolean ascendingOrder) {
        if (ascendingOrder)
            return participantList
                    .stream()
                    .sorted(Participant.birthSort.reversed())
                    .collect(Collectors.toList());
        else
            return participantList
                    .stream()
                    .sorted(Participant.birthSort)
                    .collect(Collectors.toList());
    }

    public static List<Participant> filterNameStartsWith(List<Participant> listOfParticipants, String letter) {
        return listOfParticipants
                .stream()
                .filter(Participant.nameStartsWith(letter))
                .collect(Collectors.toList());
    }

    public static List<Participant> filterSurnameStartsWith(List<Participant> listOfParticipants, String letter) {
        return listOfParticipants
                .stream()
                .filter(Participant.surnameStartsWith(letter))
                .collect(Collectors.toList());
    }

    public static List<Participant> filterAdults(List<Participant> listOfParticipants, boolean isAdult) {
        if (isAdult)
            return listOfParticipants.stream()
                    .filter(p -> (2020 - p.yearOfBirth) >= 18)
                    .collect(Collectors.toList());
        else
            return listOfParticipants.stream()
                    .filter(p -> (2020 - p.yearOfBirth) < 18)
                    .collect(Collectors.toList());
    }

    public static void showParticipantsWithAgeAsc(List<Participant> listOfParticipants) {
        listOfParticipants
                .stream()
                .forEach(p -> System.out.printf("%s, %s: %d%n", p.getSurname(), p.getName(), (2020 - p.getYearOfBirth())));

    }

    public static List<Participant> filterBorn90(List<Participant> listOfParticipants, boolean bornIn90) {
        if (bornIn90)
            return listOfParticipants
                    .stream()
                    .filter(Participant.bornIn90)
                    .collect(Collectors.toList());
        else
            return listOfParticipants
                    .stream()
                    .filter(Participant.bornIn90.negate())
                    .collect(Collectors.toList());

    }

    public static void showSurnameName(List<Participant> participantList) {
        participantList
                .stream()
                .forEach(p -> System.out.printf("%s, %s%n", p.getSurname(), p.getName()));
    }


}
