package export;

import models.StudentAccount;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;

public class JsonExport implements StudentExporter {

    @Override
    public void export(Collection<StudentAccount> accounts, File file) throws IOException {
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
            out.println("[");
            Iterator<StudentAccount> it = accounts.iterator();
            while (it.hasNext()) {
                StudentAccount a = it.next();
                out.println("  {");
                out.println("    \"id\": " + str(a.getid()) + ",");
                out.println("    \"name\": " + str(a.getfullName()) + ",");
                out.println("    \"level\": " + str(a.getlevel()) + ",");
                out.println("    \"status\": \"PENDING\"");
                out.println(it.hasNext() ? "  }," : "  }");
            }
            out.println("]");
        }
    }

    private String str(String s) {
        if (s == null) return "null";
        return "\"" + s.trim().replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }
}
