package Remplacer;

import com.javadocx.CreateDocxFromTemplate;

import java.util.ArrayList;

public class RemplacerChampString extends RemplacerChampBase<String> {

    public RemplacerChampString(String cle) {
        super(cle);
    }

    public void remplacer(CreateDocxFromTemplate docx, String valeur) {
        ArrayList<String> nouvelleValeur = new ArrayList<>();
        nouvelleValeur.add(valeur);

        docx.replaceListVariable(this.getCle(), nouvelleValeur);
    }
}
