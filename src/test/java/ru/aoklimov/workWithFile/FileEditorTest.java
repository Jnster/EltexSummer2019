package ru.aoklimov.workWithFile;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.aoklimov.organization.Developer;
import ru.aoklimov.organization.Manager;
import ru.aoklimov.organization.Sales;
import ru.aoklimov.organization.User;

import java.io.File;
import java.util.List;

public class FileEditorTest {

    private Developer developer;
    private Manager manager;

    @Before
    public void before() {
        String[] lang = {"lang1", "lang2"};
        String[] items = {"Rt", "rt", "RT"};
        Sales[] sales = {new Sales(3L, items, 50.2), new Sales(4L, items, 568.1)};
        manager = new Manager(1L, "foi", "phone", "email", sales);
        developer = new Developer(2L, "foi", "phone", "email", lang);
    }

    @Test
    public void simpleTest() {
        String managersFile = "mTEST.csv";
        String developersFile = "dTEST.csv";

        FileEditor.write(managersFile, manager);
        FileEditor.write(developersFile, developer);
        List<User> managers = FileEditor.read(managersFile);
        List<User> developers = FileEditor.read(developersFile);

        new File(managersFile).delete();
        new File(developersFile).delete();

        Assert.assertEquals(1, managers.size());
        Assert.assertEquals(1, developers.size());
        Assert.assertEquals(manager, managers.get(0));
        Assert.assertEquals(developer, developers.get(0));
    }
}
