package org.launchcode.techjobs.oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job jobOne;
    Job jobTwo;
    Job jobThree;
    Job jobFour;

    @Before
    public void initJob() {
        jobOne = new Job();
        jobTwo = new Job();
        jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobFour = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, jobOne.getId());
        assertEquals(2, jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(jobThree.getName() instanceof String);
        assertEquals("Product tester", jobThree.getName());

        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertEquals("ACME", jobThree.getEmployer().getValue());

        assertTrue(jobThree.getLocation() instanceof Location);
        assertEquals("Desert", jobThree.getLocation().getValue());

        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertEquals("Quality control", jobThree.getPositionType().getValue());

        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", jobThree.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(jobFour.equals(jobThree));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        assertEquals("\n", jobThree.toString().split("")[0]);
        assertEquals("\n", jobThree.toString().split("")[jobThree.toString().length() - 1]);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        assertEquals("\n" +
                "ID: " + jobThree.getId() + "\n" +
                "Name: " + jobThree.getName() + "\n" +
                "Employer: " + jobThree.getEmployer() + "\n" +
                "Location: " +  jobThree.getLocation() + "\n" +
                "Position Type: " +  jobThree.getPositionType() + "\n" +
                "Core Competency: " + jobThree.getCoreCompetency()
                + "\n", jobThree.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        assertEquals("\n" +
                "ID: " + jobFour.getId() + "\n" +
                "Name: " + jobFour.getName() + "\n" +
                "Employer: " + jobFour.getEmployer() + "\n" +
                "Location: " +  "Data not available" + "\n" +
                "Position Type: " +  jobFour.getPositionType() + "\n" +
                "Core Competency: " + jobFour.getCoreCompetency()
                + "\n", jobFour.toString());
    }

}
