package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job jobOne;
    Job jobTwo;
    Job jobThree;
    Job jobFour;

//    @Before
//    public void init() {
//        jobOne = new Job();
//        jobTwo = new Job();
//    }

    @Test
    public void testSettingJobId() {
        jobOne = new Job();
        jobTwo = new Job();
        assertEquals(1, jobOne.getId());
        assertEquals(2, jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
        jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobFour = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobFour.equals(jobThree));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertEquals('\n', jobThree.toString().split("")[0].charAt(0));
        Assert.assertEquals('\n', jobThree.toString().split("")[jobThree.toString().length() - 1].charAt(0));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
        jobFour = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
