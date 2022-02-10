package org.launchcode.techjobs.oo.test;

import org.junit.Before;
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
    Job testEmptyJobOne;
    Job testEmptyJobTwo;

    @Before
    public void setup(){
        testEmptyJobOne = new Job();
        testEmptyJobTwo = new Job();
    }

    @Test
    public void testSettingJobId(){
        assertEquals((testEmptyJobTwo.getId() - 1), testEmptyJobOne.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job constructorTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(constructorTestJob.getEmployer() instanceof Employer);
        assertTrue(constructorTestJob.getLocation() instanceof Location);
        assertTrue(constructorTestJob.getPositionType() instanceof PositionType);
        assertTrue(constructorTestJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester",constructorTestJob.getName());
        assertEquals("ACME",constructorTestJob.getEmployer().toString());
        assertEquals("Desert",constructorTestJob.getLocation().toString());
        assertEquals("Quality control",constructorTestJob.getPositionType().toString());
        assertEquals("Persistence",constructorTestJob.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        Job equalityJobTestOne = new Job("Artist", new Employer("Myself"), new Location("A Basement"), new PositionType("Metalsmith"), new CoreCompetency("Creativity"));

        Job equalityJobTestTwo = new Job("Artist", new Employer("Myself"), new Location("A Basement"), new PositionType("Metalsmith"), new CoreCompetency("Creativity"));

        assertFalse(equalityJobTestOne.equals(equalityJobTestTwo));
    }

}
