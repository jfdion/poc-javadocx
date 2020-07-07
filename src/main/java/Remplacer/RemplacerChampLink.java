package Remplacer;

import com.javadocx.CreateDocxFromTemplate;
import com.javadocx.WordFragment;

import java.util.ArrayList;

public class RemplacerChampLink extends RemplacerChampBase<WordFragment> {

    public RemplacerChampLink(String cle) {
        super(cle);
    }

    @Override
    public void remplacer(CreateDocxFromTemplate docx, WordFragment lien) {
        ArrayList<WordFragment> nouvelleValeur = new ArrayList<>();

        nouvelleValeur.add(lien);

        docx.replaceListVariable(this.getCle(), nouvelleValeur);
    }
}
