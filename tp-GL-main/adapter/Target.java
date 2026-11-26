package adapter;

import models.StudentAccount;
import java.util.List;

// Pattern: Adapter - Role: Target
public interface Target {
    List<StudentAccount> getStudents();
}