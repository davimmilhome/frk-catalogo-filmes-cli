package main.java.cli.filmes.catalogo.ui;

import main.java.cli.filmes.catalogo.Catalogo;
import main.java.cli.filmes.catalogo.models.Filme;


public class CatalogoUI extends PagedListUI<Filme> {
    private final AddItem<Filme> addItem;

    public CatalogoUI(PagedList<Filme> pageSource, AddItem<Filme> addItem) {
        super("Catálogo de Filmes", pageSource);
        this.addItem = addItem;
    }


    protected void showItem(Filme item) {
        FilmeUI ui = new FilmeUI("", item, new EditItemCallback<Filme>() {
            @Override
            public void remove(Filme item) {

            }

            @Override
            public void add(Filme item) {

            }

            @Override
            public boolean isNew(Filme ref) {
                if (ref.equals(item)) {
                    return false;
                } else {
                    return true;
                }
            }
        });
        ui.show();
    }

    protected void addItem() {
        Filme newFilme = new Filme("Teste");
        FilmeUI ui = new FilmeUI("Novo Filme", newFilme, new EditItemCallback<>() {
            @Override
            public void remove(Filme item) {
                System.out.println(item.getNomeFilme());
            }

            @Override
            public void add(Filme item) {
                addItem.addItem(item);
            }

            @Override
            public boolean isNew(Filme ref) {
                if (ref.equals(newFilme)) {
                    return false;
                } else {
                    return true;
                }
            }
        });


        ui.show();
        addItem.addItem(newFilme);
    }

}
