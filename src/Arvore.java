public abstract class Arvore {
    public TipoNo raiz;
    public Info dados;

    protected static int REGIAO = 0;
    protected static int ESTADO = 1;
    protected static int MUNICIPIO = 2;
    protected static int CODUF = 3;
    protected static int CODMUN = 4;
    protected static int DATA = 5;
    protected static int CASOSACUMULADO = 6;
    protected static int CASOSNOVOS = 7;
    protected static int OBITOSACUMULADO = 8;
    protected static int OBITOSNOVOS = 9;

    public int contadorPesquisa = 1;

    protected abstract void Insere(Info dados);
    protected abstract TipoNo Insere(TipoNo raiz, Info dados, TipoNo pai);
    protected abstract void InserirBIN(String[][] matriz, int i, int j);
    protected abstract void InserirAVL(String[][] matriz, int i, int j);

    public Arvore() {
        raiz = null;
    }

    public TipoNo Pesquisa(String dados) {
        return Pesquisa(raiz, dados);
    }

    private TipoNo Pesquisa(TipoNo no, String chave) {
        if (no == null) {
            return null;
        } else {
            if (no.dados.chave.compareToIgnoreCase(chave) == 0) {
                return no;
            } else {
                if (chave.compareToIgnoreCase(no.dados.chave) < 0) {
                    no = Pesquisa(no.filhoEsq, chave);
                } else if (chave.compareToIgnoreCase(no.dados.chave) > 0) {
                    no = Pesquisa(no.filhoDir, chave);
                }
            }
        }
        return no;
    }

    public int Consultas(String dados) {
        return Consultas(raiz, dados);
    }

    private int Consultas(TipoNo no, String chave) {
        if (no == null) {
            return 1;
        } else {
            if (no.dados.chave.compareToIgnoreCase(chave) == 0) {
                return contadorPesquisa;
            } else {
                contadorPesquisa++;
                if (chave.compareToIgnoreCase(no.dados.chave) < 0) {
                    Consultas(no.filhoEsq, chave);
                } else if (chave.compareToIgnoreCase(no.dados.chave) > 0) {
                    Consultas(no.filhoDir, chave);
                }
            }
        }
        return contadorPesquisa;
    }
}
