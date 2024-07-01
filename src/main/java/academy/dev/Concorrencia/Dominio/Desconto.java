package academy.dev.Concorrencia.Dominio;

public class Desconto {
    public enum Code{
        NONE(0), SUPER_SAYADIN(5), SUPER_SAYADIN2(10), SUPER_SAYADIN3(15);
        private final int porcentagem;

        Code(int porcentagem) {
            this.porcentagem = porcentagem;
        }

        public int getPorcentagem() {
            return porcentagem;
        }
    }
}
