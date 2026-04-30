package pl.uwm.sportclub.service;

import org.junit.jupiter.api.Test;
import pl.uwm.sportclub.manager.CoachRepository;
import pl.uwm.sportclub.model.Coach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CoachServiceTest {

    @Test
    void hireNewCoach_shouldAddCoachWhenDataIsValid() {
        //given
        CoachRepository coachRepository = new CoachRepository();
        CoachService coachService = new CoachService(coachRepository);

        Coach validCoach = new Coach(1,
                "Nikodem",
                "Kaczmarczyk",
                "nikodemkaczmarczyk@gmail.com",
                LocalDate.of(2005, 3, 19),
                "Kickboxing");

        //when
        coachService.hireNewCoach(validCoach);

        //then
        int repoSize = coachRepository.getAllItems().size();
        assertEquals(1, repoSize, "Repo should extend 1 coach after hire");
    }

    @Test
    void hireNewCoach_shouldThrowExceptionWhenFirstNameIsNull() {
        //given
        CoachRepository coachRepository = new CoachRepository();
        CoachService coachService = new CoachService(coachRepository);

        Coach invalidCoach = new Coach(1,
                null,
                "Kaczmarczyk",
                "nikodemkaczmarczyk@gmail.com",
                LocalDate.of(2005, 3, 19),
                "Kickboxing");

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            coachService.hireNewCoach(invalidCoach);
        }, "OmniSport should throw exception IllegalArgumentException when coach doesn't have first name");
    }

    @Test
    void verifyCoach_shouldReturnTrueWhenCoachWithGivenIDExistInRepo() {
        //GIVEN
        CoachRepository coachRepository = new CoachRepository();
        CoachService coachService = new CoachService(coachRepository);

        Coach existingCoach = new Coach(1,
                "Nikodem",
                "Kaczmarczyk",
                "nikodemkaczmarczyk@gmail.com",
                LocalDate.of(2005, 3, 19),
                "Kickboxing");

        coachRepository.add(existingCoach);

        //WHEN
        boolean decision = coachService.verifyCoach(1);

        //THEN
        assertTrue(decision, "OmniSport should return true when he find coach in repo with given ID");
    }

    @Test
    void verifyCoach_shouldReturnFalseWhenCoachWithGivenIDDidNotExistInRepo() {
        //GIVEN
        CoachRepository coachRepository = new CoachRepository();
        CoachService coachService = new CoachService(coachRepository);

        Coach existingCoach = new Coach(1,
                "Nikodem",
                "Kaczmarczyk",
                "nikodemkaczmarczyk@gmail.com",
                LocalDate.of(2005, 3, 19),
                "Kickboxing");

        coachRepository.add(existingCoach);

        //WHEN
        boolean decision = coachService.verifyCoach(2);

        //THEN
        assertFalse(decision, "OmniSport should return fakse when he didn't find coach in repo with given ID");
    }


    @Test
    void changeSection_ShouldChangeSectionOfCoach() {
        //GIVEN
        CoachRepository coachRepository = new CoachRepository();
        CoachService coachService = new CoachService(coachRepository);
        Coach coach = new Coach(1,
                "Nikodem",
                "Kaczmarczyk",
                "nikodemkaczmarczyk@gmail.com",
                LocalDate.of(2005, 3, 19),
                "Kickboxing");

        //WHEN
        coachService.changeSection(1, "Football");

        //THEN
        assertEquals("Football", coach.getSection(), "OmniSport should change section of coach with the same ID given in args");
    }

    @Test
    void changeSection_ShouldThrowNewExceptionWhenNewSectionIsNull() {
        //GIVEN
        CoachRepository coachRepository = new CoachRepository();
        CoachService coachService = new CoachService(coachRepository);
        Coach coach = new Coach(1,
                "Nikodem",
                "Kaczmarczyk",
                "nikodemkaczmarczyk@gmail.com",
                LocalDate.of(2005, 3, 19),
                "Kickboxing");
        coachRepository.add(coach);

        //WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> {
            coachService.changeSection(1, null);
        }, "OmniSport should throw new IllegalargumentException when new section is null");
    }

    @Test
    void changeSection_ShouldThrowNewExceptionCoachIsNull() {
        //GIVEN
        CoachRepository coachRepository = new CoachRepository();
        CoachService coachService = new CoachService(coachRepository);

        //WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> {
            coachService.changeSection(1, "Ping pong");
        }, "OmniSport should throw new IllegalArgumentException when changeSection() function don't find coach with given ID");
    }
}