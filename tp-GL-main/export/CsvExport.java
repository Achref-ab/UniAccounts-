package export;

import models.StudentAccount;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class CsvExport implements StudentExporter {

    @Override
    public void export(Collection<StudentAccount> accounts, File file) throws IOException {
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
            out.write('\uFEFF');
            out.println("id,name,level,status");
            
            for (StudentAccount a : accounts) {
                out.println(String.join(",",
                        esc(a.getid()),
                        esc(a.getfullName()),
                        esc(a.getlevel()),
                        esc("PENDING")
                ));
            }
        }
    }

    private String esc(String s) {
        if (s == null) return "";
        s = s.trim();
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}
