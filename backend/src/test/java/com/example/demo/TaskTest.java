package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void defaultConstructor_shouldCreateEmptyTask() {
        Task task = new Task();
        assertNull(task.getTaskdescription());
    }

    @Test
    void setTaskdescription_shouldStoreValueExactly() {
        Task task = new Task();
        
        // Test mit normalem String
        task.setTaskdescription("Einkaufen gehen");
        assertEquals("Einkaufen gehen", task.getTaskdescription());
        
        // Test mit leerem String
        task.setTaskdescription("");
        assertEquals("", task.getTaskdescription());
        
        // Test mit null
        task.setTaskdescription(null);
        assertNull(task.getTaskdescription());
        
        // Test mit Sonderzeichen
        String specialChars = "!@#$%^&*()_+ 123";
        task.setTaskdescription(specialChars);
        assertEquals(specialChars, task.getTaskdescription());
    }

    @Test
    void getTaskdescription_shouldReturnExactValue() {
        Task task = new Task();
        
        // Initial null check
        assertNull(task.getTaskdescription());
        
        // Wert setzen und prüfen
        String testValue = "Genau dieser Wert";
        task.setTaskdescription(testValue);
        assertSame(testValue, task.getTaskdescription()); // Prüft Referenzgleichheit
    }

    @Test
    void beanCompatibility_shouldWorkWithStandardNaming() {
        Task task = new Task();
        
        // Testet explizit die Bean-Kompatibilität
        task.setTaskdescription("Bean-Test");
        assertEquals("Bean-Test", task.getTaskdescription());
        
        // Prüft Methodennamen (falls das wichtig ist)
        assertDoesNotThrow(() -> {
            Task.class.getMethod("getTaskdescription");
            Task.class.getMethod("setTaskdescription", String.class);
        });
    }

    @Test
    void edgeCases_shouldHandleCorrectly() {
        Task task = new Task();
        
        // Sehr langer String
        String longString = "A".repeat(10000);
        task.setTaskdescription(longString);
        assertEquals(longString, task.getTaskdescription());
        
        // Whitespace-Strings
        task.setTaskdescription("   ");
        assertEquals("   ", task.getTaskdescription());
        
        // Unicode-Zeichen
        String unicodeStr = "中文 Español Français 日本語";
        task.setTaskdescription(unicodeStr);
        assertEquals(unicodeStr, task.getTaskdescription());
    }
}