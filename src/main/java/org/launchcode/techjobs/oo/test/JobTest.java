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
    Job constructorTestJobOne;
    Job constructorTestJobDuplicate;

    @Before
    public void setup(){
        testEmptyJobOne = new Job();
        testEmptyJobTwo = new Job();
        constructorTestJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        constructorTestJobDuplicate = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId(){
        assertEquals((testEmptyJobTwo.getId() - 1), testEmptyJobOne.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(constructorTestJobOne.getEmployer() instanceof Employer);
        assertTrue(constructorTestJobOne.getLocation() instanceof Location);
        assertTrue(constructorTestJobOne.getPositionType() instanceof PositionType);
        assertTrue(constructorTestJobOne.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester",constructorTestJobOne.getName());
        assertEquals("ACME",constructorTestJobOne.getEmployer().toString());
        assertEquals("Desert",constructorTestJobOne.getLocation().toString());
        assertEquals("Quality control",constructorTestJobOne.getPositionType().toString());
        assertEquals("Persistence",constructorTestJobOne.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(constructorTestJobOne.equals(constructorTestJobDuplicate));
    }

    @Test
    public void toStringHasNewLines(){
        assertTrue(constructorTestJobOne.toString().startsWith("\n"));
        assertTrue(constructorTestJobOne.toString().endsWith("\n"));
    }

    @Test
    public void toStringHasFieldLabels(){
        assertTrue(constructorTestJobOne.toString().contains("ID:"));
        assertTrue(constructorTestJobOne.toString().contains("Name:"));
        assertTrue(constructorTestJobOne.toString().contains("Employer:"));
        assertTrue(constructorTestJobOne.toString().contains("Location:"));
        assertTrue(constructorTestJobOne.toString().contains("Position Type:"));
        assertTrue(constructorTestJobOne.toString().contains("Core Competency:"));
    }

    @Test
    public void toStringSetsEmptyFields(){
        Location testLocation = new Location("basement");
        testEmptyJobOne.setLocation(testLocation);

        assertTrue(testEmptyJobOne.toString().contains("Name: Data not available"));
        assertTrue(testEmptyJobOne.toString().contains("Employer: Data not available"));
        assertTrue(testEmptyJobOne.toString().contains("Position Type: Data not available"));
        assertTrue(testEmptyJobOne.toString().contains("Core Competency: Data not available"));
    }

}
