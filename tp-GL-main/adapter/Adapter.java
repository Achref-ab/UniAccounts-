package adapter;

import legacy.LegacyStudentSystem;
import models.StudentAccount;
import java.util.ArrayList;
import java.util.List;

// Pattern: Adapter - Role: Adapter
public class Adapter implements Target {
    private LegacyStudentSystem adaptee;

    public Adapter(LegacyStudentSystem adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public List<StudentAccount> getStudents() {
        List<StudentAccount> result = new ArrayList<>();
        for (String line : adaptee.fetchRecords()) {
            String[] p = line.split(";");
            if (p.length < 5) continue; // سطر ناقص

            String id = p[0].trim();
            String fullName = p[2].trim() + " " + p[1].trim(); // الاسم ثم اللقب
            String email = p[3].replace(" ", "").trim();
            String level = p[4].trim().toUpperCase();

            result.add(new StudentAccount.StudentAccountBuilder(id, fullName, email)
                    .level(level)
                    .build());
        }
        return result;
    }
}