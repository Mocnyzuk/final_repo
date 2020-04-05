package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static model.ParticipantListModifications.*;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantListModificationsTest {

    @Test
    void sortNamesAsc() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 1950),
                new Participant("Agata", "Zak", 1998));
        List<Participant> expectedList = List.of(
                new Participant("Agata", "Zak", 1998),
                new Participant("Zara", "Amina", 1950));
        //when
        List<Participant> returnedList = sortNames(participantList, true);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    void sortNamesDesc() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Agata", "Zak", 1998),
                new Participant("Zara", "Amina", 1950));

        List<Participant> expectedList = List.of(
                new Participant("Zara", "Amina", 1950),
                new Participant("Agata", "Zak", 1998));

        //when
        List<Participant> returnedList = sortNames(participantList, false);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    void sortSurnamesAsc() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Agata", "Zak", 1998),
                new Participant("Zara", "Amina", 2010));

        List<Participant> expectedList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        //when
        List<Participant> returnedList = sortSurnames(participantList, true);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    void sortSurnamesDesc() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        List<Participant> expectedList = List.of(
                new Participant("Agata", "Zak", 1998),
                new Participant("Zara", "Amina", 2010));
        //when
        List<Participant> returnedList = sortSurnames(participantList, false);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    void sortAgeAsc() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Agata", "Zak", 1998),
                new Participant("Zara", "Amina", 2010));

        List<Participant> expectedList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        //when
        List<Participant> returnedList = sortAge(participantList, true);
        //then
        assertEquals(expectedList, returnedList);

    }

    @Test
    void sortAgeDesc() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        List<Participant> expectedList = List.of(
                new Participant("Agata", "Zak", 1998),
                new Participant("Zara", "Amina", 2010));
        //when
        List<Participant> returnedList = sortSurnames(participantList, false);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    @DisplayName("A -> Agata")
    void filterNameStartsWith() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        String firstLetter = "A";
        List<Participant> expectedList = List.of(
                new Participant("Agata", "Zak", 1998));
        //when
        List<Participant> returnedList = ParticipantListModifications.filterNameStartsWith(participantList, firstLetter);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    @DisplayName("A -> Amina")
    void filterSurnameStartsWith() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        String firstLetter = "A";
        List<Participant> expectedList = List.of(
                new Participant("Zara", "Amina", 2010));
        //when
        List<Participant> returnedList = ParticipantListModifications.filterSurnameStartsWith(participantList, firstLetter);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    @DisplayName("isAdult = true -> adults")
    void filterAdultsTrue() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        String firstLetter = "A";
        List<Participant> expectedList = List.of(
                new Participant("Agata", "Zak", 1998));
        //when
        List<Participant> returnedList = filterAdults(participantList, true);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    @DisplayName("isAdult = false -> not adults")
    void filterAdultsFalse() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        String firstLetter = "A";
        List<Participant> expectedList = List.of(
                new Participant("Zara", "Amina", 2010));
        //when
        List<Participant> returnedList = filterAdults(participantList, false);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    @DisplayName("bornIn90 = true -> 1998")
    void filterBorn90True() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        String firstLetter = "A";
        List<Participant> expectedList = List.of(
                new Participant("Agata", "Zak", 1998));
        //when
        List<Participant> returnedList = filterBorn90(participantList, true);
        //then
        assertEquals(expectedList, returnedList);
    }

    @Test
    @DisplayName("bornIn90 = false -> 2010")
    void filterBorn90False() {
        //given
        List<Participant> participantList = List.of(
                new Participant("Zara", "Amina", 2010),
                new Participant("Agata", "Zak", 1998));
        String firstLetter = "A";
        List<Participant> expectedList = List.of(
                new Participant("Zara", "Amina", 2010));
        //when
        List<Participant> returnedList = filterBorn90(participantList, false);
        //then
        assertEquals(expectedList, returnedList);
    }

}