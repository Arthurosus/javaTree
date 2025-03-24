
package arvore;

public class BArvore {
    private BIntNo raiz;

    private BIntNo inserir(BIntNo no, int valor) {
        if (no == null) {
            return new BIntNo(valor);
        } else if (valor < no.valor) {
            no.esq = inserir(no.esq, valor);
        } else {
            no.dir = inserir(no.dir, valor);
        }
        return no;
    }

    public void inserirNo(int valor) {
        raiz = inserir(raiz, valor);
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(BIntNo no, int valor) {
        if (no == null) return false;
        if (valor == no.valor) return true;
        if (valor < no.valor) return buscar(no.esq, valor);
        else return buscar(no.dir, valor);
    }

    public void excluirNo(int valor) {
        raiz = excluir(raiz, valor);
    }

    private BIntNo excluir(BIntNo no, int valor) {
        if (no == null) return null;
        if (valor < no.valor) {
            no.esq = excluir(no.esq, valor);
        } else if (valor > no.valor) {
            no.dir = excluir(no.dir, valor);
        } else {
            if (no.esq == null) return no.dir;
            if (no.dir == null) return no.esq;
            BIntNo temp = encontrarMenor(no.dir);
            no.valor = temp.valor;
            no.dir = excluir(no.dir, temp.valor);
        }
        return no;
    }

    private BIntNo encontrarMenor(BIntNo no) {
        while (no.esq != null) {
            no = no.esq;
        }
        return no;
    }

    public BIntNo getRaiz() {
        return raiz;
    }
}
