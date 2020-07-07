package Remplacer;

import com.javadocx.CreateDocxFromTemplate;

abstract public class RemplacerChampBase<T> implements RemplacerChamp<T> {

    private String cle;

    RemplacerChampBase(String cle) {
        this.cle = cle;
    }

    public String getCle() {
        return cle;
    }

    abstract public void remplacer(CreateDocxFromTemplate docx, T valeur);
}
