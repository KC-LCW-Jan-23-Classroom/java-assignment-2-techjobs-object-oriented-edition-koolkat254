package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester",job1.getName());
        assertTrue(job1.getName() instanceof String);
        assertEquals("ACME",job1.getEmployer().getValue());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals("Desert",job1.getLocation().getValue());
        assertTrue(job1.getLocation() instanceof Location);
        assertEquals("Quality control",job1.getPositionType().getValue());
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals("Persistence",job1.getCoreCompetency().getValue());
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.toString().endsWith("\n"));
        assertTrue(job.toString().startsWith("\n"));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String expectedOutput = "\nID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(expectedOutput,job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        String expectedOutput = "\nID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available\n";
        Job job = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals(expectedOutput,job.toString());
    }

    @Test
    public void testToStringHandlesEmptyJob(){
        String expectedOutput = "\nOOPS! This job does not seem to exist.\n";
        Job job = new Job();
        assertEquals(expectedOutput,job.toString());
    }
}
