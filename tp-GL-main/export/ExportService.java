package export;

import models.StudentAccount;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class ExportService {
    private StudentExporter strategy;

    public ExportService(StudentExporter strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(StudentExporter strategy) {
        this.strategy = strategy;
    }

    public void executeExport(Collection<StudentAccount> accounts, File file) throws IOException {
        if (strategy == null) {
            throw new IllegalStateException("لم يتم تحديد صيغة التصدير!");
        }
        strategy.export(accounts, file);
    }
}
