package export;

import models.StudentAccount;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public interface StudentExporter {
    void export(Collection<StudentAccount> accounts, File file) throws IOException;
}
