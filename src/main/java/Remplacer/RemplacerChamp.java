package Remplacer;

import com.javadocx.CreateDocxFromTemplate;

public interface RemplacerChamp<T> {

    void remplacer(CreateDocxFromTemplate docx, T valeur);
    String getCle();
}
